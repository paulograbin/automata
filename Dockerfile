#FROM maven:3.9-amazoncorretto-19 as build
#
#WORKDIR /opt/confirmation
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml /opt/confirmation
#COPY src src
#
#RUN mvn install -DskipTests



FROM paulograbin/automata_base as build

WORKDIR /opt/confirmation
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml /opt/confirmation
COPY src src

RUN mvn package -DskipTests
#RUN #mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

RUN mkdir target/extracted
RUN java -Djarmode=layertools -jar target/automata-0.0.1-SNAPSHOT.jar extract --destination target/extracted


FROM openjdk:19-rc-oracle as deploy

EXPOSE 3000

WORKDIR /opt/confirmation/
#
#COPY --from=build /opt/confirmation/target/dependency/BOOT-INF/lib /app/lib
#COPY --from=build /opt/confirmation/target/dependency/META-INF /app/META-INF
#COPY --from=build /opt/confirmation/target/dependency/BOOT-INF/classes /app
##ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"] #need to work o nthe entry point

COPY --from=build /opt/confirmation/target/extracted/dependencies/ ./
COPY --from=build /opt/confirmation/target/extracted/snapshot-dependencies/ ./
COPY --from=build /opt/confirmation/target/extracted/spring-boot-loader/ ./
COPY --from=build /opt/confirmation/target/extracted/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]


#COPY --from=build /opt/confirmation/target/automata-0.0.1-SNAPSHOT.jar .
#ENTRYPOINT ["java", "-cp", "app:app/lib/*", "org.springframework.boot.loader.JarLauncher"]
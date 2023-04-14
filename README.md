# automata
Automate the hell out of SAP CCv2 in your terminal or maybe in your browser


## Compiling to native binary format

Make sure you have GraalVM installed, if you have SDKMAN installed you can run a command like this 
>sdk use java 22.3.r19-grl

Compile app normally using maven, a jar will be generated in target directory/
>mvn clean package

Run the jar with GraalVM agent to capture runtime information on classes that are instanciated using Reflection
>java -agentlib:native-image-agent=config-output-dir=/home/paulograbin/Desktop/automata/reflect -jar target/automata-0.0.1-SNAPSHOT.jar

Copy the files generated under /reflect to /src/resources/META-INF so they will be picked up by GraalVM during native compilation

Finally compile app to native with the following command
>mvn -Pnative native:compile

To run app cd into target directory and run the binary as any other
>./automata

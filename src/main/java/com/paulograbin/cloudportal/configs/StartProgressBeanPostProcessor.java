package com.paulograbin.cloudportal.configs;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/*
  Copied from https://github.com/lwaddicor/spring-startup-analysis
 */
@Component
@ConditionalOnProperty(name = "measure.bean.creation", havingValue = "true")
public class StartProgressBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(StartProgressBeanPostProcessor.class);


    private Map<String, StopWatch> beanStopWatchMap = new HashMap<>();

    // Hopefully the logic to this makes sense. Some beans such as
    // tomcatEmbeddedServletContainerFactory seem to create beans inside them.
    // By having this, I can ignore any of these parent beans.
    private boolean inFactoryBean;

    /**
     * Called before a bean is constructed. Saves bean creation details.
     *
     * @param bean     The bean being created.
     * @param beanName The name of the bean being created.
     * @return The bean being created.
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        log.info("Processing {}", beanName);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        beanStopWatchMap.put(beanName, stopWatch);
        inFactoryBean = false;
        return bean;
    }

    /**
     * Called after a bean is constructed. Saves bean creation details.
     *
     * @param bean     The bean being created.
     * @param beanName The name of the bean being created.
     * @return The bean being created.
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        StopWatch stopWatch = beanStopWatchMap.get(beanName);
        if (stopWatch != null && stopWatch.isStarted()) {
            stopWatch.stop();

            if (!inFactoryBean) {
                long deltaT = stopWatch.getTime();

                if (deltaT > 10) {
                    log.info("creating bean {} took {} ms", beanName, deltaT);
                }
            }
        }

        inFactoryBean = true;
        return bean;
    }
}

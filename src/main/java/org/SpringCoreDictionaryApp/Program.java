package org.SpringCoreDictionaryApp;

import org.SpringCoreDictionaryApp.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Thread applicationThread = applicationContext.getBean("applicationThread", Thread.class);
        try {
            applicationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

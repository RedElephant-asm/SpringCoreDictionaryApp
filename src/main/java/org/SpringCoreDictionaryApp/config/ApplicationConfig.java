package org.SpringCoreDictionaryApp.config;

import org.SimpleDictionaryService.DictionaryService;
import org.SpringCoreDictionaryApp.runnable.Application;
import org.SpringCoreDictionaryApp.runnable.ConsoleListener;
import org.springframework.context.annotation.*;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

@Configuration
@ComponentScan("org.SpringCoreDictionaryApp")
public class ApplicationConfig {

    @Bean()
    public Application application(){
        return new Application(dictionaryService(), threadCounter());
    }

    @Bean
    public ConsoleListener consoleListener(){
        return new ConsoleListener(consoleScanner(), threadCounter());
    }

    @Bean
    public Scanner consoleScanner(){
        return new Scanner(System.in);
    }

    @Bean
    public DictionaryService dictionaryService(){
        return new DictionaryService();
    }

    @Bean
    @Scope(scopeName = "prototype")
    public AtomicBoolean threadCounter(){
        return new AtomicBoolean(true);
    }

    @Bean(name = "applicationThread")
    public Thread applicationThread(){
        Thread appThread = new Thread(application());
        appThread.start();
        return appThread;
    }
}

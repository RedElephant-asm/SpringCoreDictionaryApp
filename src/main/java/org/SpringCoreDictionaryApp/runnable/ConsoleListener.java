package org.SpringCoreDictionaryApp.runnable;

import org.SpringCoreDictionaryApp.Interruptible;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConsoleListener implements Runnable, Interruptible {

    private AtomicBoolean isActive = new AtomicBoolean(true);
    private Scanner scanner;
    private String currentCommand = "command";

    @Autowired
    private Application application;


    public ConsoleListener(Scanner scanner, AtomicBoolean isActive){
        this.scanner = scanner;
        this.isActive = isActive;
    }

    @Override
    public void run() {
        while(isActive.get()){
            if(scanner.hasNext() && !currentCommand.isEmpty()){
                currentCommand = scanner.nextLine();
                handledNotify();
                handledWait(application);
            }
        }
    }

    @Override
    public void closeThread() {
        isActive.getAndSet(false);
    }

    public String getCurrentCommand() {
        return currentCommand;
    }
}

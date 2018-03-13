package com.snilloc.springwebdemo.services;

public class WorkerThread extends Thread {

    private BracketService bracketService;

    public WorkerThread(BracketService bracketService) {
        this.bracketService = bracketService;
    }

    public void run() {
        try {
            System.out.println("Thread" + Thread.currentThread().getId() + "is running");
            bracketService.wait();
            boolean matchingBrackets = bracketService.check("[][]");
            System.out.println("Found: " + matchingBrackets);
        } catch (Exception ex) {

        }
    }


}

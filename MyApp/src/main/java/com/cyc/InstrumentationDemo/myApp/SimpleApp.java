package com.cyc.InstrumentationDemo.myApp;

public class SimpleApp {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            doSomething();
            Thread.sleep(1000);
        }
    }

    public static void doSomething(){
        System.out.println("Doing something");
    }
}

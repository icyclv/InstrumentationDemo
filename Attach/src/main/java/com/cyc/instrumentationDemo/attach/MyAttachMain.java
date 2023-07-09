package com.cyc.instrumentationDemo.attach;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

public class MyAttachMain {
    public static void main(String[] args) throws IOException, AttachNotSupportedException {
        System.out.printf("Attaching to VM with id: %s%n", args[0]);
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        try {
            vm.loadAgent("E:\\codespace\\java\\InstrumentatationDemo\\MainAgent\\target\\MainAgent-1.0-SNAPSHOT-jar-with-dependencies.jar");
            System.out.println("Finished loading Agent");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            vm.detach();
        }
    }
}

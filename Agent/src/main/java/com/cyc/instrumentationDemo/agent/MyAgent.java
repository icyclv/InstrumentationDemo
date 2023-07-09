package com.cyc.instrumentationDemo.agent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class MyAgent {
    public static void agentmain(String agentArgs, Instrumentation inst) throws UnmodifiableClassException {
        System.out.println("[Agent] In agentmain method");
        inst.addTransformer(new MyTransformer(), true);
        Class[] allLoadedClasses = inst.getAllLoadedClasses();
        for (Class allLoadedClass : allLoadedClasses) {
            if (allLoadedClass.getSimpleName().equals("SimpleApp")) {
                inst.retransformClasses(allLoadedClass);
                break;
            }
        }

    }

    public static void premain(String args, Instrumentation instr) {
        System.out.println("Inside premain.........");
        instr.addTransformer(new MyTransformer(),true);
    }
}

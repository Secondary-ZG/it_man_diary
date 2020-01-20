package com.secondary.springaopjdk;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 13:36
 */
public class PerfomanceMonitor {

    private static ThreadLocal<MethodPerformance> preformanceRecord = new ThreadLocal<MethodPerformance>();

    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        preformanceRecord.set(mp);
    }

    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance mp = preformanceRecord.get();

        mp.printPerformance();
    }

}

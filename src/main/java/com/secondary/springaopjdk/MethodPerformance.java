package com.secondary.springaopjdk;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 13:37
 */
public class MethodPerformance {

    private Long begin;
    private Long end;
    private String serviceMrthod;

    public MethodPerformance(String serviceMrthod) {
        this.serviceMrthod = serviceMrthod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        end = System.currentTimeMillis();
        long elapse = end - begin;

        System.out.println(serviceMrthod + "花费" + elapse + "毫秒");

    }

}

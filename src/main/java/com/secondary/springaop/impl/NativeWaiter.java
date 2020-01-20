package com.secondary.springaop.impl;

import com.secondary.springaop.Waiter;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 16:35
 * Description:
 */
public class NativeWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to " + name + "...");
    }
}

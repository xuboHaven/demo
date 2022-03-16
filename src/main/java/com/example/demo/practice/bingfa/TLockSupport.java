package com.example.demo.practice.bingfa;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport ,等同于Object.wait与notify
 */
public class TLockSupport {

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(()->{
            System.out.println("线程A开始执行");
            LockSupport.park();
            System.out.println("线程A结束");
        });
        a.start();
        Thread.sleep(5000L);
        new Thread(()->{
            System.out.println("线程B开始执行");
            LockSupport.unpark(a);
            System.out.println("线程B结束");
        }).start();
    }
}

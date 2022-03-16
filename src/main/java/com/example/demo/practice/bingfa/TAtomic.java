package com.example.demo.practice.bingfa;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic*类，为CAS原子操作类
 */
public class TAtomic {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger a = new AtomicInteger(0);
        AtomicInteger c = new AtomicInteger(0);
        Thread[] tArray = new Thread[100000];
       // CountDownLatch p = new CountDownLatch(tArray.length);
        final int[] b = {0};
        for(int i =0 ;i<tArray.length;i++){
            tArray[i]=new Thread(()->{
                b[0] = b[0] +1;
                a.addAndGet(1);
                c.incrementAndGet();
                //p.countDown();
            });
        }
        for (Thread thread : tArray) {
            thread.start();
        }
        for (Thread thread : tArray) {
            thread.join();
        }
        //p.await();
        //Thread.sleep(3000L);
        System.out.println(a.get());
        System.out.println(b[0]);
        System.out.println(c.get());
    }
}

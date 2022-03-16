package com.example.demo.practice.bingfa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition,AQS的内部类，必须依赖一个具现的锁来实现实例化。 await&signal等同于object的wait&notify
 */
public class TCondition {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        Condition co= lock.newCondition();
        Condition co1 = lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("A start");
                    lock.lock();
                    co.await();
                    System.out.println("A over");
                    co1.signal();
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(3000L);
        new Thread(()->{
            lock.lock();
            System.out.println("B start");
            co.signal();
            try {
                co1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B end");
            lock.unlock();
        }).start();
    }
}

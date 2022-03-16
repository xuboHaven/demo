package com.example.demo.practice.bingfa;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 测试学习并发编程之CountDownLatch
 * CountDownLatch.await ,等待多个线程执行完成（countDownLatch降低为0）后再往下执行
 * 解题 ： 20个人来抢4个苹果，每人能拿一个，拿完后就宣布结束
 * 缺点 ： 4个人拿了之后，其他的16个人不会暂停等待而是会继续运行 .如果再来苹果将不能实现等待通知效果
 */
public class TCountDownLatch {

    public static void main(String args[]) throws InterruptedException {

        CountDownLatch cdt = new CountDownLatch(4);
        Thread[] arr = new Thread[20];
        int jb = 0 ;

        for(int i=0;i<20;i++){
            arr[i] = new Thread(new Runnable() {
                @Override
                public void run() {
//                    System.out.println("Thread is -->"+Thread.currentThread().getName());
                    cdt.countDown();
                    System.out.println("count left -->"+cdt.getCount()+",Thread is -->"+Thread.currentThread().getName());
                }
            },i+"_");
        }
        AtomicBoolean flag = new AtomicBoolean(true);
        Thread watcher =new Thread(() -> {
            while (flag.get()){
                System.out.println("count left -->"+cdt.getCount());
            }}
        );
        watcher.start();

        new Thread(() -> {
            try {
                System.out.println("over Thread,count left -->" + cdt.getCount());
                cdt.await();
                System.out.println("over Thread,count left -->" + cdt.getCount());
                flag.set(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Over");
        }).start();

        for(int j=0;j<arr.length;j++){

            arr[j].start();
        }

    }
}

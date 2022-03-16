package com.example.demo.practice.bingfa;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * AQS ,AbstractQueenSynchronize ,java.util.concurrent包的基础
 */
public class TAQS {
    public static void main(String[] args) {
        //AbstractQueuedSynchronizer
        Object ob = new Object();
        try{
        for(int i=0;i<1000;i++){
            new Thread(()->{
                try{Thread.sleep(6000L);}catch (Exception e){}
                synchronized (ob){

                    System.out.println(1);
                }
            }).start();
        }}catch (Exception e){e.printStackTrace();}
    }
}

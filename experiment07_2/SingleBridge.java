package com.experiments.experiment07_2;

public class SingleBridge implements Runnable{
    @Override
    public void run() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" 开始过桥");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 已过桥");
        }
    }
}

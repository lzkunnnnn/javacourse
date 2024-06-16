package com.experiments.experiment07;

import com.experiments.experiment07.entity.Outlet;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) {
        Outlet o1 = new Outlet("A");
        Outlet o2 = new Outlet("B");
        Outlet o3 = new Outlet("C");

        int count = 600;
        CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < 200; i ++){
            new Thread(() -> {
                o1.sell();
                latch.countDown();
            }).start();
        }
        for (int i = 0; i < 200; i ++){
            new Thread(() -> {
                o2.sell();
                latch.countDown();
            }).start();
        }
        for (int i = 0; i < 200; i ++){
            new Thread(() -> {
                o3.sell();
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(o1.getCount());
        System.out.println(o2.getCount());
        System.out.println(o3.getCount());

//        o3.getTickets().stream()
//                .forEach(s -> {
//                    System.out.println(s.getId());
//                });

    }
}

package com.experiments.experiment07_1;

public class MyThread extends Thread{
    private int distance=100;
    static int tuziDistance=0;
    static int wuguiDistance=0;
    static boolean flag=true;
    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        while(flag){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(name.equals("兔子")){
                tuziDistance=tuziDistance+10;
                if(tuziDistance>=wuguiDistance&&tuziDistance<distance){
                    System.out.println(name+"说: 我还剩"+(distance-tuziDistance)+"米! "+"我跑得快,睡一觉。");
                    try{
                        Thread.sleep((long) (Math.random()*4));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println(name+"说：我还剩"+(distance-tuziDistance)+"米！");
                }
                if(tuziDistance==distance){
                    System.out.println(name+"达到了终点，比赛结束！");
                    flag=false;
                    break;
                }
                if(!flag){
                    System.out.println(name+"说：我输了! 早知道不睡了!");
                }
            }
            if(name.equals("乌龟")){
                wuguiDistance=wuguiDistance+1;
                if(!flag){
                    System.out.println(name+"说：我输了!");
                }else{
                    System.out.println(name+"说：我还剩"+(distance-wuguiDistance)+"米！");
                }

                if(wuguiDistance==distance&&flag){//兔子未到达终点
                    System.out.println(name+"达到了终点，比赛结束！");
                    flag=false;
                    break;
                }
            }
        }
    }
}

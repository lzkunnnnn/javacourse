package com.experiments.experiment07_2;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Test {
    public static void main(String[] args) {
        SingleBridge s = new SingleBridge();
        List<String> list = new ArrayList<>();
        Random random = new Random();
        list.add("XiaoMing");
        list.add("XiaoHong");
        list.add("LiLi");
        list.add("Rose");
        list.add("Cindy");
        list.add("David");
        list.add("Frank");
        list.add("Berry");
        list.add("Eila");
        list.add("Grand");
        while(list.size() > 0) {
            int index = random.nextInt(list.size());//随机抽人
            Thread t=new Thread(s,list.get(index));
            t.start();
            list.remove(index);
        }
    }
}

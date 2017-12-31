package com.yc.core.algorithm;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/12/1
 * Time: 上午11:59
 */
public class MockVerbMethod extends AbstractMethod {

    public static final double START_T = 100 ;
    public static final double END_T   = 1 ;
    public static final double x    = 0.95;
    public static final double y    = 0.9;


    @Override
    protected void init() {
        Box box = new Box();
        for (Node node : this.getInputs()) {
            box.addOne(node);
        }
        this.addBox(box);
    }

    @Override
    protected void deal() {
        double T = START_T;
        //初始解
        List<Box> bestBoxs = this.getBoxes();
        //评价值
        int bestFit = fitness(bestBoxs);
        int i = 0;
        while (T > END_T) {
            List<Box> newboxes = putToSuitableBox(bestBoxs);
            int nowFit = fitness(newboxes);
            System.out.println("bestFit:"+bestFit);
            System.out.println("nowFIt:"+nowFit);
            if (nowFit < bestFit || P(T) > Math.random()) {
                bestBoxs = newboxes;
                bestFit = nowFit;
            }
            T = x * T;
            i++;
        }

        System.out.println("i = "+ i +"_"+ bestBoxs);
    }

    private List<Box> putToSuitableBox(List<Box> bestBoxs) {
        LinkedList<Box> newBoxs = Lists.newLinkedList();
        for (Box box : bestBoxs) {
            newBoxs.add(box.clone());
        }
        System.out.println(newBoxs);
        for (int i = 0 ; i < 2; i++) {
            Box box = newBoxs.get(getRandomIndex(newBoxs.size()));
            Node node = box.pickRandom();
            if (node == null) {
                continue;
            }
            if (Math.random() > y) {
                newBoxs.add(new Box(node));
            } else {
                box.removeOne(node);
                newBoxs.get(getRandomIndex(newBoxs.size())).addOne(node);
            }
        }
        return newBoxs;
    }

    private int getRandomIndex(Integer size) {
        return (int) Math.floor(Math.random() * size);
    }

    private double P(double t) {
        return  (t - END_T)/END_T;
    }

    private int fitness(List<Box> boxes){
        Box box = boxes.parallelStream().max(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.getSize() - o2.getSize();
            }
        }).get();
        //int size = boxes.size();//并发数
        return box.getSize();// * size;
    }

    public MockVerbMethod(List<Node> inputs) {
        super(inputs);
    }
}

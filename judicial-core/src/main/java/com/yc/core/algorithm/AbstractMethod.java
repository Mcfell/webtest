package com.yc.core.algorithm;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/12/1
 * Time: 上午10:19
 */
@Data
public abstract class AbstractMethod implements Method {

    private List<Node> inputs;

    private List<Box>  boxes;

    public void process(){
        long start = System.currentTimeMillis();
        init();
        System.out.println("init finished");
        deal();
        System.out.println("total time : "+ (System.currentTimeMillis() - start) + "ms" );
    }

    protected abstract void deal();

    public AbstractMethod(List<Node> inputs) {
        this.inputs = inputs;
        boxes = Lists.newLinkedList();
    }

    protected void init() {
        Collections.sort(inputs);
        System.out.println(inputs);
    }

    protected void addBox(Box box) {
        boxes.add(box);
    }
}

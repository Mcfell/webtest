package com.yc.core.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/12/1
 * Time: 上午11:09
 */
public class Main {
    public static void main(String[] args) {
        List<Node> nodes = createNodes(2,5,4,7,1,3,8);
//        new GreedMethod(nodes).process();
//
//        List<Node> nodes2 = createNodes(2,5,4,7,1,3,8,6,2,2,9,1);
//        new GreedMethod2(nodes2).process();
        new MockVerbMethod(nodes).process();

    }

    public static List<Node> createNodes(Integer... node) {
        List<Node> nodes = Lists.newArrayList();
        for (Integer val : node) {
            nodes.add(new Node(val));
        }
        return nodes;
    }
}

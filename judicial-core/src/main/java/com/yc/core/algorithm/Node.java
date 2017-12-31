package com.yc.core.algorithm;

import lombok.Data;

/**
 * User: mcfell.yc
 * Date: 2017/12/1
 * Time: 上午10:11
 */
@Data
public class Node implements Comparable<Node>{
    private Integer val;
    private Node    next;
    public Node(Integer val) {
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return o.getVal() - this.getVal();
    }

    @Override
    public String toString() {
        return  val.toString();
    }

}

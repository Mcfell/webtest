package com.yc.myproject.domain.DO;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/15
 * Time: 上午12:18
 */
public class Node<T> {

    private T value;

    private Node pre;

    private List<Node> childs ;

    public Node() {
        this.childs = Lists.newLinkedList();
    }

    public Node(T value, Node pre) {
        this.value = value;
        this.pre = pre;
        this.childs = Lists.newLinkedList();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }
}

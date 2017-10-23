package com.yc.myproject.domain.DO;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * User: mcfell.yc
 * Date: 2017/9/15
 * Time: 上午12:18
 */
public class Node<T> {

    private T value;

    private Node pre;

    private Set<Node> childs ;

    public Node() {
        this.childs = Sets.newHashSet();
    }

    public Node(T value, Node pre) {
        this.value = value;
        this.pre = pre;
        this.childs = Sets.newHashSet();
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

    public Set<Node> getChilds() {
        return childs;
    }

    public void setChilds(Set<Node> childs) {
        this.childs = childs;
    }
}

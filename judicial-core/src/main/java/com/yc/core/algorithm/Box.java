package com.yc.core.algorithm;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.LinkedList;

/**
 * User: mcfell.yc
 * Date: 2017/12/1
 * Time: 上午10:12
 */
@Data
public class Box {

    private LinkedList<Node> nodes;

    private int size;

    public Box() {
        nodes = Lists.newLinkedList();
    }

    @Override
    protected Box clone(){
        Box box = new Box();
        LinkedList<Node> newNodes = Lists.newLinkedList();
        for (Node node : this.nodes) {
            newNodes.add(new Node(node.getVal()));
        }
        box.setNodes(newNodes);
        box.setSize(this.size);
        return box;
    }

    public Box(Node node) {
        nodes = Lists.newLinkedList();
        this.addOne(node);
    }

    public void addOne(Node node) {
        nodes.addLast(new Node(node.getVal()));
        size += node.getVal();
    }

    public void removeOne(Node node){
        for (Node node1 : nodes) {
            if (node1.getVal() == node.getVal()) {
                nodes.remove(node1);
                break;
            }
        }
        size -= node.getVal();
    }

    public Node pickRandom() {
        int size = nodes.size();
        int index = (int) Math.floor(size * Math.random());
        if (size == 0) {
            return null;
        }
        Node node = nodes.get(index);
        return node;
    }

    @Override
    public String toString() {
        return "Box{" + nodes + '}';
    }
}

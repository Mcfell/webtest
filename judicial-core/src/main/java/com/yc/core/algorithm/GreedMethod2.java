package com.yc.core.algorithm;

import java.util.List;

/**
 *
 * 贪心算法-最佳适合，即对于一个箱子，在剩下的物品中遍历所有物品，找看有物品可装进当前箱子，如果没有则重新找一个箱子，这个需要O(n * n)的复杂度；
 * User: mcfell.yc
 * Date: 2017/12/1
 * Time: 上午10:17
 */
public class GreedMethod2 extends AbstractMethod{


    public static final int MAX_BOX_SIZE = 10;

    public GreedMethod2(List<Node> inputs) {
        super(inputs);
    }

    @Override
    protected void deal() {
        for (Node node : this.getInputs()) {
            putToSuitableBox(node);
        }
        System.out.println(this.getBoxes());
    }

    private void putToSuitableBox(Node node) {
        int minRemainSize = Integer.MAX_VALUE;
        Box suitBox = null;
        for (Box box : this.getBoxes()) {
            int reaminSize = MAX_BOX_SIZE - box.getSize() - node.getVal();
            if (reaminSize < minRemainSize && reaminSize >= 0) {
                suitBox = box;
                minRemainSize = reaminSize;
            }
        }

        if (suitBox != null) {
            suitBox.addOne(node);
        } else {
            addBox(new Box(node));
        }
    }
}

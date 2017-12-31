package com.yc.core.algorithm;

import java.util.List;

/**
 *
 * 贪心算法-下项适合，下一个物品能否装进刚刚正在装的箱子中，如果不能则重新找一个箱子
 * User: mcfell.yc
 * Date: 2017/12/1
 * Time: 上午10:17
 */

public class GreedMethod extends AbstractMethod{


    public static final int MAX_BOX_SIZE = 10;

    public GreedMethod(List<Node> inputs) {
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
        boolean isPut = false;
        for (Box box : this.getBoxes()) {
            if (box.getSize() + node.getVal() > MAX_BOX_SIZE) {
                continue;
            } else {
                box.addOne(node);
                isPut = true;
                break;
            }
        }
        if (!isPut) {
            this.addBox(new Box(node));
        }
    }


}

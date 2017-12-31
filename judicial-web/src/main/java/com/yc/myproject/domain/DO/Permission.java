package com.yc.myproject.domain.DO;

import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/14
 * Time: 下午9:30
 */
public class Permission {
    private List<String> canVisits;
    private List<String> cannotVisits;

    public List<String> getCanVisits() {
        return canVisits;
    }

    public void setCanVisits(List<String> canVisits) {
        this.canVisits = canVisits;
    }

    public List<String> getCannotVisits() {
        return cannotVisits;
    }

    public void setCannotVisits(List<String> cannotVisits) {
        this.cannotVisits = cannotVisits;
    }
}

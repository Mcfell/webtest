package com.yc.myproject.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yc.myproject.domain.DO.Node;
import com.yc.myproject.domain.entity.App;
import com.yc.myproject.domain.vo.AppVO;
import com.yc.myproject.util.MyBeanUtils;

import java.util.HashMap;
import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/15
 * Time: 上午12:23
 */
public class AppNodeManager {

    private List<App> apps;

    private List<AppVO> appVOS;

    private HashMap<Integer,Node> nodeMap;

    private Node<App> root;

    public static final int NO_PARENT_ID = -1;
    public AppNodeManager(List<App> nodeList) {
        this.apps = nodeList;
        if (nodeList != null) {
            this.root = new Node<>();
            this.nodeMap = Maps.newHashMap();
            dealNodes();
        }
    }

    private void dealNodes() {
        for (App app : apps){
            if (app.getParentId() == null || app.getParentId() == NO_PARENT_ID) {
                Node<App> node = new Node<>(app,root);
                root.getChilds().add(node);
                nodeMap.put(app.getId(), node);
            } else {
                Node preNode = nodeMap.get(app.getParentId());
                Node<App> node = new Node<>(app,preNode);
                preNode.getChilds().add(node);
                nodeMap.put(app.getId(),node);
            }
        }
    }

    public List<AppVO> getAppVOS(){
        if (appVOS == null) {
            this.appVOS = buildAppVO(root);
        }
        return appVOS;
    }

    private List<AppVO> buildAppVO(Node<App> root) {
        if (root.getChilds() == null || root.getChilds().size() == 0) {
            return null;
        }
        List<AppVO> appVOS = Lists.newArrayList();
        for (Node<App> node : root.getChilds()) {
            App value = node.getValue();
            AppVO appVO = MyBeanUtils.convert2AppVO(value);
            appVO.setSoftWares(buildAppVO(node));
            appVOS.add(appVO);
        }
        return appVOS;
    }



}

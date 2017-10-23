package com.yc.myproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.yc.myproject.domain.entity.App;
import com.yc.myproject.domain.vo.AppVO;
import com.yc.myproject.manager.AppNodeManager;
import com.yc.myproject.mapper.AppMapper;
import com.yc.myproject.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/12
 * Time: 下午3:21
 */
@Service("appService")
public class AppServiceImpl extends BaseService<App> implements AppService{
    @Autowired
    private AppMapper appMapper;

    @Override
    public List<AppVO> selectAll(int page, int rows) {
        PageHelper.offsetPage(page,rows);
        List<App> apps = appMapper.selectAll();
        if (CollectionUtils.isEmpty(apps)) {
            return null;
        }
        AppNodeManager appNodeManager = new AppNodeManager(apps);
        return appNodeManager.getAppVOS();
    }

    @Override
    public int deleteFatherAndChild(int id) {/*
        Example example = new Example(App.class);
        example.or().andEqualTo("id",id);
        example.or().andEqualTo("parent_id",id);*/
        return appMapper.deleteFatherAndChild(id);
    }

    @Override
    public int countAll() {
        return appMapper.countAll();
    }

}

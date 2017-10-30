package com.yc.myproject.service.impl;

import com.yc.myproject.domain.entity.Company;
import com.yc.myproject.mapper.AppMapper;
import com.yc.myproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: mcfell.yc
 * Date: 2017/9/12
 * Time: 下午3:21
 */
@Service("appService")
public class CompanyServiceImpl extends BaseService<Company> implements CompanyService{
    @Autowired
    private AppMapper appMapper;
}

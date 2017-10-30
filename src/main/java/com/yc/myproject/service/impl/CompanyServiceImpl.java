package com.yc.myproject.service.impl;

import com.yc.myproject.domain.entity.Company;
import com.yc.myproject.exception.CheckException;
import com.yc.myproject.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * User: mcfell.yc
 * Date: 2017/9/12
 * Time: 下午3:21
 */
@Service("companyService")
public class CompanyServiceImpl extends BaseService<Company> implements CompanyService{
    @Override
    public Company getCompany() {
        return getMapper().selectByPrimaryKey(1);
    }

    @Override
    public int update(Company entity) {
        entity.setGmtUpdate(new Date());
        return super.update(entity);
    }

    @Override
    public int save(Company entity) throws CheckException {
        Date now = new Date();
        entity.setGmtCreate(now);
        entity.setGmtUpdate(now);
        return super.save(entity);
    }
}

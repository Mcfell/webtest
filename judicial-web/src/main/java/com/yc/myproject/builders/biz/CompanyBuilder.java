package com.yc.myproject.builders.biz;

import com.yc.myproject.builders.BaseBuilder;
import com.yc.myproject.domain.entity.Company;
import com.yc.myproject.service.CompanyService;
import com.yc.myproject.service.ServiceHolder;

import java.util.concurrent.ExecutionException;

/**
 * User: mcfell.yc
 * Date: 2017/11/2
 * Time: 下午5:03
 */
public class CompanyBuilder extends BaseBuilder<Company> {


    @Override
    public Company build() throws ExecutionException {
        CompanyService companyService = ServiceHolder.getInstance().getCompanyService();
        return companyService.getCompany();
    }
}

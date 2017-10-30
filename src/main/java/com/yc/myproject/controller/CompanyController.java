package com.yc.myproject.controller;

import com.yc.myproject.domain.DO.Result;
import com.yc.myproject.domain.entity.Company;
import com.yc.myproject.exception.CheckException;
import com.yc.myproject.service.CompanyService;
import com.yc.myproject.service.ConnectAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: mcfell.yc
 * Date: 2017/9/11
 * Time: 下午5:35
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ConnectAppService connectAppService;


    /****************** functions ************************/
    @RequestMapping("/get")
    @ResponseBody
    public Result<Company> get() {
        return new Result<>(companyService.selectByKey(1));
    }

    @PostMapping(value="/admin/update")
    @ResponseBody
    public Result<Integer> update(Company company) {
        return new Result<>(companyService.updateSelective(company));
    }

    @RequestMapping("/admin/add")
    @ResponseBody
    public Result<Integer> save(Company company) throws CheckException {
        return new Result<>(companyService.save(company));
    }
}

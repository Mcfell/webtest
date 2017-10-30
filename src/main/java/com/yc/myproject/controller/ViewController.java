package com.yc.myproject.controller;

import com.yc.myproject.domain.DO.StatisticInfoDO;
import com.yc.myproject.domain.entity.Company;
import com.yc.myproject.domain.vo.AppVO;
import com.yc.myproject.domain.vo.UserVO;
import com.yc.myproject.service.AppService;
import com.yc.myproject.service.CompanyService;
import com.yc.myproject.service.UserService;
import com.yc.myproject.service.sys.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * User: mcfell.yc
 * Date: 2017/10/11
 * Time: 下午3:01
 */
@Controller
public class ViewController {

    @Autowired
    private AppService appService;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/apps")
    public String showApps(
            Model model,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int rows) {
            List<AppVO> appVOS = appService.selectAll(page, rows);
            model.addAttribute("apps",appVOS);
        return "apps";
    }

    @GetMapping("/")
    public String index(Model model) throws ExecutionException {
        StatisticInfoDO statisticInfoDO = new StatisticInfoDO();
        cacheService.buildStatisticInfo(statisticInfoDO);
        List<UserVO> currentUsers = userService.getCurrentUsers(0, 10);
        Company company = companyService.getCompany();
        Integer online = cacheService.getOnlineUserNum();
        Integer offline = statisticInfoDO.getAllUserNum() - online;
        model.addAttribute("users",currentUsers);
        model.addAttribute("statistic",statisticInfoDO);
        model.addAttribute("company",company);
        model.addAttribute("online",online);
        model.addAttribute("offline",offline);
        return "index";
    }

    @GetMapping("/admin/login")
    public String login() throws ExecutionException {
        return "login";
    }
}

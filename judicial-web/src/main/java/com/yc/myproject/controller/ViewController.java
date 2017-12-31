package com.yc.myproject.controller;

import com.yc.myproject.builders.BaseBuilder;
import com.yc.myproject.builders.BuilderExecutor;
import com.yc.myproject.builders.biz.CompanyBuilder;
import com.yc.myproject.builders.biz.UsersBuilder;
import com.yc.myproject.domain.DO.StatisticInfoDO;
import com.yc.myproject.domain.context.MainContext;
import com.yc.myproject.domain.entity.Company;
import com.yc.myproject.domain.vo.AppVO;
import com.yc.myproject.domain.vo.UserVO;
import com.yc.myproject.service.AppService;
import com.yc.myproject.service.CompanyService;
import com.yc.myproject.service.ThreadPoolService;
import com.yc.myproject.service.UserService;
import com.yc.myproject.service.sys.CacheService;
import com.yc.myproject.util.SpringUtil;
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

    @Autowired
    private ThreadPoolService threadPoolService;
    @GetMapping("/apps")
    public String showApps(
            Model model,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "1000") int rows) {
            List<AppVO> appVOS = appService.selectAll(page, rows);
            model.addAttribute("apps",appVOS);
        return "apps";
    }

    @GetMapping("/")
    public String index(Model model) throws ExecutionException {
        if (!MainContext.isLogIn()) {
            return "login";
        }
        StatisticInfoDO statisticInfoDO = new StatisticInfoDO();

        UsersBuilder usersBuilder = new UsersBuilder();
        CompanyBuilder companyBuilder = new CompanyBuilder();
        BuilderExecutor executor = SpringUtil.getBean(BuilderExecutor.class)
                .addBuilder(usersBuilder)
                .addBuilder(companyBuilder);
        List<UserVO> currentUsers = executor.getResult(usersBuilder);
        Company company = executor.getResult(companyBuilder);

        cacheService.buildStatisticInfo(statisticInfoDO);
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

    @GetMapping("/uindex")
    public String uindex(Model model) throws ExecutionException {
        BaseBuilder appBuilder = new BaseBuilder() {
            @Override
            public Object build() {
                return appService.selectAll(0, 100);
            }
        };
        BaseBuilder companyBuilder = new BaseBuilder() {
            @Override
            public Object build() {
                return companyService.getCompany();
            }
        };
        BuilderExecutor executor = SpringUtil.getBean(BuilderExecutor.class)
                .addBuilder(appBuilder)
                .addBuilder(companyBuilder);
        List<AppVO> appVOS = (List<AppVO>) executor.getResult(appBuilder);
        Company company = (Company) executor.getResult(companyBuilder);

        String name = MainContext.getName();
        model.addAttribute("name",name);
        model.addAttribute("apps",appVOS);
        model.addAttribute("company",company);
        return "u_index";
    }
}

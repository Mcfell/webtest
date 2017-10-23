package com.yc.myproject.controller;

import com.yc.myproject.domain.DO.Result;
import com.yc.myproject.domain.entity.App;
import com.yc.myproject.domain.entity.ConnectHistory;
import com.yc.myproject.domain.vo.AppVO;
import com.yc.myproject.exception.CheckException;
import com.yc.myproject.service.AppService;
import com.yc.myproject.service.ConnectAppService;
import com.yc.myproject.util.MyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/11
 * Time: 下午5:35
 */
@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    @Autowired
    private ConnectAppService connectAppService;


    /****************** functions ************************/
    @RequestMapping("/getAll")
    @ResponseBody
    public Result<List<AppVO>> getAppsAdmin(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int rows) {
        return new Result<>(appService.selectAll(page, rows));
    }

    @PostMapping(value="/admin/update")
    @ResponseBody
    public Result<Integer> update(App app) {
        return new Result<>(appService.updateSelective(app));
    }

    @RequestMapping("/admin/add")
    @ResponseBody
    public Result<Integer> save(App app) throws CheckException {
        return new Result<>(appService.save(app));
    }

    @RequestMapping(value="/admin/delete/{id}")
    @ResponseBody
    public Result<Integer> delete(@PathVariable("id") Integer id) {
        return new Result<>(appService.deleteFatherAndChild(id));
    }

    @RequestMapping(value="/connect/{id}")
    @ResponseBody
    public Result<Integer> connect(@PathVariable("id") Integer appId) {
        return new Result<>(connectAppService.connect(appId));
    }

    @RequestMapping(value="/connect/history")
    @ResponseBody
    public Result<List<ConnectHistory>> connectHistory() {
        return new Result<>(connectAppService.getConnectHistory());
    }

    /****************** views ************************/
    @GetMapping("/update/{id}")
    public String getOne(Model model, @PathVariable("id") Integer id){
        App app = appService.selectByKey(id);
        AppVO appVO = MyBeanUtils.convert2AppVO(app);
        model.addAttribute("app",appVO);
        model.addAttribute("action","/app/admin/update");
        return "appEdit";
    }

    @GetMapping("/add")
    public String addOne(Model model, @RequestParam(required = false) Integer parentId){
        AppVO appVO = new AppVO();
        appVO.setParentId(parentId);
        model.addAttribute("app",appVO);
        model.addAttribute("action","/app/admin/add");
        return "appEdit";
    }
}

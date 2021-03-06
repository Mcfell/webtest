package com.yc.myproject.controller;

import com.yc.myproject.domain.DO.Result;
import com.yc.myproject.domain.context.MainContext;
import com.yc.myproject.domain.context.UserSession;
import com.yc.myproject.domain.entity.User;
import com.yc.myproject.domain.vo.UserVO;
import com.yc.myproject.enums.ErrorEnum;
import com.yc.myproject.exception.CheckException;
import com.yc.myproject.service.UserService;
import com.yc.myproject.util.MyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * User: mcfell.yc
 * Date: 2017/9/11
 * Time: 下午5:35
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserSession userSession;


    @RequestMapping("/admin/getUsers")
    @ResponseBody
    public Result<List<UserVO>> getUsersAdmin(
                                @RequestParam(required = false, defaultValue = "0") int page,
                               @RequestParam(required = false, defaultValue = "10") int rows) {
        return new Result<>(MyBeanUtils.covert2UserVOList(userService.selectAll(page, rows)));
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result<UserVO> login(HttpSession session, User user) throws CheckException {
        if (MainContext.isLogIn()) {
            throw new CheckException(ErrorEnum.HAS_LOGIN);
        }
        User login = userService.login(user);
        if (login != null) {
            session.setAttribute("user",login);
            userSession.setUser(login);
            return new Result<>(MyBeanUtils.convert2UserVO(login));
        } else {
            throw new CheckException(ErrorEnum.SYSYTEM_ERROR);
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result<Integer> logout(HttpSession session) throws CheckException {
        try {
            if (MainContext.isLogOut()) {
                throw new CheckException(ErrorEnum.HAS_LOGOUT);
            }
            return new Result<>(userService.logout(MainContext.getUser()));
        } finally {
            session.invalidate();
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result<Integer> save(User user) throws CheckException {
        return new Result<>(userService.save(user));
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public Result<Integer> update(HttpSession session,User user) {
        if (MainContext.isAdmin()) {
            return new Result<>(userService.update(user));
        }
        return new Result<>(0);
    }

    @RequestMapping(value="/admin/delete/{id}")
    @ResponseBody
    public Result<Integer> delete(@PathVariable("id") Integer id) {
        return new Result<>(userService.delete(id));
    }

    /****************** views ************************/
    @RequestMapping("/admin/login")
    public String adminlogin(RedirectAttributes redirectAttributes, HttpSession session, User user) throws CheckException {
        if (MainContext.isLogIn()) {
            redirectAttributes.addAttribute("msg",ErrorEnum.HAS_LOGIN.getMsg());
            return "login";
        }
        User login = userService.login(user);
        if (login != null) {
            session.setAttribute("user",login);
            userSession.setUser(login);
            return "redirect:/";
        } else {
            redirectAttributes.addAttribute("msg",ErrorEnum.SYSYTEM_ERROR.getMsg());
            return "login";
        }
    }

    @RequestMapping("/admin/logout")
    public String adminLogout(HttpSession session, User user) throws CheckException {
        try {
            return "login";
        } finally {
            if (session != null) {
                session.invalidate();
            }
        }
    }

    @RequestMapping("/admin/add")
    public String saveAdmin(RedirectAttributes redirectAttributes, User user) throws CheckException {
        int save = userService.save(user);
        if (save > 0) {
            redirectAttributes.addAttribute("msg",ErrorEnum.SYSYTEM_ERROR.getMsg());
            return "redirect:/";
        } else {

            return "login";
        }
    }
}

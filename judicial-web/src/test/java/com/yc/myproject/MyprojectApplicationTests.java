//package com.yc.myproject;
//
//import com.yc.myproject.domain.entity.App;
//import com.yc.myproject.domain.entity.User;
//import com.yc.myproject.exception.CheckException;
//import com.yc.myproject.service.AppService;
//import com.yc.myproject.service.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.Assert;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MyprojectApplicationTests {
//
//	@Resource
//	AppService appService;
//
//	@Resource
//    UserService userService;
//	@Test
//	public void contextLoads() throws CheckException {
//		App app = new App();
//		app.setIcon("testIcon");
//		app.setName("test2");
//		app.setHost("localhost");
//        int save = appService.save(app);
//        Assert.isTrue(save > 0,"插入失败");
//    }
//    @Test
//    public void selectUser(){
//        User test = userService.selectByKey(1);
//        System.out.println(test.toString());
//        Assert.isTrue(test != null,"appService.selectByKey fail");
//        List<User> users = userService.selectAll(3, 2);
//        Assert.isTrue(users != null && users.size() == 2,"userService.selectAll(1, 2) fail");
//    }
//    @Test
//    public void saveUser() throws CheckException {
//        User user = new User();
//        user.setName("xiaoming4");
//        user.setPwd("test1234");
//        user.setLevel(1);
//        user.setStatus(0);
//        Date now = new Date();
//        user.setGmtCreate(now);
//        user.setLastLogin(now);
//        int save = userService.save(user);
//        Assert.isTrue(save > 0,"userService.save(user) 插入失败");
//    }
//
//
//}

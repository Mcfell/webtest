package com.yc.myproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.yc.myproject.domain.entity.User;
import com.yc.myproject.domain.vo.UserVO;
import com.yc.myproject.enums.LevelEnum;
import com.yc.myproject.enums.StatusEnum;
import com.yc.myproject.exception.CheckException;
import com.yc.myproject.mapper.UserMapper;
import com.yc.myproject.service.UserService;
import com.yc.myproject.service.sys.CacheService;
import com.yc.myproject.util.CheckUtils;
import com.yc.myproject.util.MyBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: mcfell.yc
 * Date: 2017/9/12
 * Time: 下午11:06
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

    public static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    CacheService cacheService;

    @Override
    public List<User> selectAll(int page, int rows) {
        PageHelper.offsetPage(page,rows);
        return userMapper.selectAllOrderByStatus();
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) throws CheckException {
        CheckUtils.checkUser(user);
        User loginUser = mapper.selectOne(user);
        if (loginUser == null) {
            throw new CheckException("用户名或密码错误");
        }
        new Thread() {
            @Override
            public void run() {
                cacheService.addUserOne();
                loginUser.setLastLogin(new Date());
                loginUser.setStatus(StatusEnum.ONLINE.getVal());
                mapper.updateByPrimaryKeySelective(loginUser);
            }
        }.start();
        return loginUser;
    }

    @Override
    public int logout(User user) throws CheckException {
        user.setStatus(StatusEnum.OFFLINE.getVal());
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int countAll() {
        return userMapper.countAll();
    }

    @Override
    public List<UserVO> getCurrentUsers(int page, int rows){
        List<User> users = this.selectAll(page, rows);
        if (users == null) {
            return null;
        }
        Map<Integer, String> connectMap = cacheService.getUserAppHistory();
        List<UserVO> userVOS = MyBeanUtils.covert2UserVOList(users,connectMap);
        return userVOS;
    }

    /**
     * 注册用户
     *
     * @param entity
     * @return
     */
    @Override
    public int save(User entity) throws CheckException {
        CheckUtils.checkUser(entity);
        User query = new User();
        query.setName(entity.getName());
        List<User> select = mapper.select(query);
        if (!CollectionUtils.isEmpty(select)) {
            log.info("用户名：" + entity.getName() + "已被注册");
            throw new CheckException("用户名：" + entity.getName() + "已被注册");
        }
        Date now = new Date();
        entity.setStatus(StatusEnum.OFFLINE.getVal());
        if (entity.getLevel() == null) {
            entity.setLevel(LevelEnum.NORMAL.getVal());
        }
        entity.setGmtCreate(now);
        entity.setGmtUpdate(now);
        return super.save(entity);
    }

    @Override
    public int update(User entity) {
        Date now = new Date();
        entity.setGmtUpdate(now);
        return super.updateSelective(entity);
    }

//    Example example = new Example(User.class);
//    Example.Criteria criteria = example.createCriteria();
//        if (StringUtil.isNotEmpty(user.getName())) {
//        criteria.andEqualTo("name",  user.getName());
//    }
//        if (StringUtil.isNotEmpty(user.getPwd())) {
//        criteria.andEqualTo("pwd",  user.getPwd());
//    }
//    List<User> users = mapper.selectByExample(example);
}

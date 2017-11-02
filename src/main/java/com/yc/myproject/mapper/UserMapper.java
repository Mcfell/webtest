package com.yc.myproject.mapper;

import com.yc.myproject.domain.entity.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    @Select("select count(*) from user")
    int countAll();

    @Select("select * from user order by status desc")
    @ResultMap("UserMap")
    List<User> selectAllOrderByStatus();
}
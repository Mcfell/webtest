package com.yc.myproject.mapper;

import com.yc.myproject.domain.entity.App;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppMapper extends Mapper<App> {
    @Select("SELECT * FROM app WHERE name = #{name}")
    List<App> selectByName(@Param("name") String name);

    @Delete("DELETE FROM app where id = #{id} or parent_id = #{id}")
    int deleteFatherAndChild(@Param("id") int id) ;

    @Select("select count(*) from app where parent_id > 0")
    int countAll();
}
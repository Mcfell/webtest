package com.yc.myproject.mapper;

import com.yc.myproject.domain.entity.ConnectHistory;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ConnectHistoryMapper extends Mapper<ConnectHistory> {
    @Select(" select t.userId as userId, substring_index(group_concat(t.appName order by t.connect_start desc),',',3) as appName from (select * from connect_history order by userId asc,connect_start desc) as t group by t.userId;")
    List<ConnectHistory> getRecentConnectHistory();
}
package com.yc.myproject.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yc.myproject.domain.DO.Permission;
import com.yc.myproject.enums.LevelEnum;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;


/**
 * User: mcfell.yc
 * Date: 2017/9/14
 * Time: 下午9:33
 */
public class SecurityUtil {

    private static final String[] NORMAL_CAN_VISIT = new String[]{"update"};
    private static final String[] NORMAL_CAN_NOT_VISIT = new String[]{"delete","admin"};

    private static final String[] ADMIN_CAN_NOT_VISIT = new String[]{};
    private static final String[] ADMIN_CAN_VISIT = new String[]{"admin"};

    private static final Map<Integer,Permission> securityMap = Maps.newHashMap();

    static {
        Permission normal = new Permission();
        normal.setCannotVisits(Lists.newArrayList(NORMAL_CAN_NOT_VISIT));
        normal.setCanVisits(Lists.newArrayList(NORMAL_CAN_VISIT));
        securityMap.put(LevelEnum.NORMAL.getVal(),normal);

        Permission admin = new Permission();
        admin.setCannotVisits(Lists.newArrayList(ADMIN_CAN_NOT_VISIT));
        admin.setCanVisits(Lists.newArrayList(ADMIN_CAN_VISIT));
        securityMap.put(LevelEnum.ADMINISTRATOR.getVal(),admin);
    }

    public static boolean hasPermission(String uri,Integer level) {
        Permission permission = securityMap.get(level);
        if (permission == null) {
            return false;
        }
        List<String> cannotVisits = permission.getCannotVisits();
        if (!CollectionUtils.isEmpty(cannotVisits)) {
            for (String path : cannotVisits) {
                if (uri.contains(path)) {
                    return false;
                }
            }
        }
        return true;
    }
}

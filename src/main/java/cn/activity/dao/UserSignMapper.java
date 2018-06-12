package cn.activity.dao;

import cn.activity.domain.UserSign;
import java.util.List;

public interface UserSignMapper {
    int insert(UserSign record);

    List<UserSign> selectAll();
}
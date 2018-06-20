package cn.activity.dao;

import cn.activity.domain.UserSign;
import java.util.List;

public interface UserSignMapper {
    int insert(UserSign record);

    List<UserSign> selectAll();

    int isExists(int userId,int activityId);

    List<UserSign> getUserSignByUserId(int userId);

    void delete(int activityId,int userId);
}
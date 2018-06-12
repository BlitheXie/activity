package cn.activity.dao;

import cn.activity.domain.ActivityAfter;
import java.util.List;

public interface ActivityAfterMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(ActivityAfter record);

    ActivityAfter selectByPrimaryKey(Integer activityId);

    List<ActivityAfter> selectAll();

    int updateByPrimaryKey(ActivityAfter record);
}
package cn.activity.dao;

import cn.activity.domain.Activity;
import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    Activity selectByPrimaryKey(Integer id);

    List<Activity> selectAll();

    int updateByPrimaryKey(Activity record);

    List<Activity> selectDataBypage(int page);

    List<Activity> selectAllOrderByTime();


}
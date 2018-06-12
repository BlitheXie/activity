package cn.activity.dao;

import cn.activity.domain.Works;
import java.util.List;

public interface WorksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Works record);

    Works selectByPrimaryKey(Integer id);

    List<Works> selectAll();

    int updateByPrimaryKey(Works record);
}
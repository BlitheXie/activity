package cn.activity.dao;

import cn.activity.domain.Share;
import java.util.List;

public interface ShareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Share record);

    Share selectByPrimaryKey(Integer id);

    List<Share> selectAll();

    int updateByPrimaryKey(Share record);
}
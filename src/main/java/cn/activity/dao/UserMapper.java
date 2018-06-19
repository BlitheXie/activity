package cn.activity.dao;

import cn.activity.domain.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    List<User> getUserByStuNumber(String stuNumber);

    int update(User user);

    String getUserNameByUserId(int id);
}
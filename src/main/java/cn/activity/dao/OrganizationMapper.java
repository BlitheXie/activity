package cn.activity.dao;

import cn.activity.domain.Organization;
import java.util.List;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    Organization selectByPrimaryKey(Integer id);

    List<Organization> selectAll();

    int updateByPrimaryKey(Organization record);
}
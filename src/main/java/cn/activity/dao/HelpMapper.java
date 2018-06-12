package cn.activity.dao;

import cn.activity.domain.Help;
import java.util.List;

public interface HelpMapper {
    int insert(Help record);

    List<Help> selectAll();
}
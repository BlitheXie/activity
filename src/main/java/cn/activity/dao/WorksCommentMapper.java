package cn.activity.dao;

import cn.activity.domain.WorksComment;
import java.util.List;

public interface WorksCommentMapper {
    int insert(WorksComment record);

    List<WorksComment> selectAll();
}
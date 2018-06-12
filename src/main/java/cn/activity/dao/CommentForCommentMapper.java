package cn.activity.dao;

import cn.activity.domain.CommentForComment;
import java.util.List;

public interface CommentForCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentForComment record);

    CommentForComment selectByPrimaryKey(Integer id);

    List<CommentForComment> selectAll();

    int updateByPrimaryKey(CommentForComment record);
}
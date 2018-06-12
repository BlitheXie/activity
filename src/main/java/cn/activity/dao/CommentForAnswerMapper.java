package cn.activity.dao;

import cn.activity.domain.CommentForAnswer;
import java.util.List;

public interface CommentForAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentForAnswer record);

    CommentForAnswer selectByPrimaryKey(Integer id);

    List<CommentForAnswer> selectAll();

    int updateByPrimaryKey(CommentForAnswer record);
}
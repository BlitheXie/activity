package cn.activity.dao;

import cn.activity.domain.Answer;
import java.util.List;

public interface AnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Answer record);

    Answer selectByPrimaryKey(Integer id);

    List<Answer> selectAll();

    int updateByPrimaryKey(Answer record);
}
package cn.activity.dao;

import cn.activity.domain.ShareComment;
import java.util.List;

public interface ShareCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareComment record);

    ShareComment selectByPrimaryKey(Integer id);

    List<ShareComment> selectAll();

    int updateByPrimaryKey(ShareComment record);
}
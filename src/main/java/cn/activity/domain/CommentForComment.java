package cn.activity.domain;

import java.util.Date;

public class CommentForComment {
    private Integer id;

    private Integer answerId;

    private Integer answerForUserid;

    private Integer userId;

    private Integer commentId;

    private Integer comment;

    private Date createTime;

    private Integer lastComment;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getAnswerForUserid() {
        return answerForUserid;
    }

    public void setAnswerForUserid(Integer answerForUserid) {
        this.answerForUserid = answerForUserid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLastComment() {
        return lastComment;
    }

    public void setLastComment(Integer lastComment) {
        this.lastComment = lastComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
package cn.activity.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.Date;

public class Share {
    private Integer id;

    private byte[] content;

    private Integer sourceId;

    private Date createTime;

    private Integer lastComment;

    private Integer comment;

    private Integer lastLike;

    private Integer likes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
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

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getLastLike() {
        return lastLike;
    }

    public void setLastLike(Integer lastLike) {
        this.lastLike = lastLike;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
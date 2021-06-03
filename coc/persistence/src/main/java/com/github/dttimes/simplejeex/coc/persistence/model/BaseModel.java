package com.github.dttimes.simplejeex.coc.persistence.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.github.dttimes.simplejeex.coc.persistence.MP;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 14:23<p>
 *
 * @author 王辉
 */
public class BaseModel<T extends Model<T>> extends Model<T> {
    /**
     * 数据库主键
     */
    @TableId(value = MP.COLUMN_ID, type = IdType.AUTO)
    private Long id;
    /**
     * 逻辑删除标志位(mybatis-plus操作，不可手工修改)
     */
    @TableField(value = MP.COLUMN_DELETED)
    @TableLogic(value = "0", delval = "1")
    private boolean deleted;
    /**
     * 创建时间
     */
    @TableField(value = MP.COLUMN_CREATE_AT, fill = FieldFill.INSERT)
    private LocalDateTime createAt;
    /**
     * 创建人
     */
    @TableField(value = MP.COLUMN_CREATE_BY, fill = FieldFill.INSERT)
    private Long createBy;
    /**
     * 更新时间
     */
    @TableField(value = MP.COLUMN_UPDATE_AT, fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;
    /**
     * 更新人
     */
    @TableField(value = MP.COLUMN_UPDATE_BY, fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}

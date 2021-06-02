package com.github.dttimes.simplejeex.coc.persistence;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 14:18<p>
 *
 * @author 王辉
 */
public interface MP {
    /**
     * 数据库主键ID
     */
    String COLUMN_ID = "id";
    /**
     * 逻辑删除字段
     */
    String COLUMN_DELETED = "is_deleted";
    /**
     * 创建时间
     */
    String COLUMN_CREATE_AT = "create_at";
    /**
     * 创建人
     */
    String COLUMN_CREATE_BY = "create_by";
    /**
     * 更新时间
     */
    String COLUMN_UPDATE_AT = "update_at";
    /**
     * 更新人
     */
    String COLUMN_UPDATE_BY = "update_by";
    String FIELD_ID = StringUtils.underlineToCamel(COLUMN_ID);
    String FIELD_DELETED = StringUtils.underlineToCamel(COLUMN_DELETED);
    String FIELD_CREATE_AT = StringUtils.underlineToCamel(COLUMN_CREATE_AT);
    String FIELD_CREATE_BY = StringUtils.underlineToCamel(COLUMN_CREATE_BY);
    String FIELD_UPDATE_AT = StringUtils.underlineToCamel(COLUMN_UPDATE_AT);
    String FIELD_UPDATE_BY = StringUtils.underlineToCamel(COLUMN_UPDATE_BY);

}



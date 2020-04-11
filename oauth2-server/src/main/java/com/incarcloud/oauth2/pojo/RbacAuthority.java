package com.incarcloud.oauth2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 权限信息
 *
 * @author Aaric, created on 2020-04-11T19:18.
 * @version 0.7.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@TableName
public class RbacAuthority {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long parentId;
    private String name;
    private String code;
    private String url;
}

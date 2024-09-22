package com.laolang.jx.persist.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.laolang.jx.framework.mybatis.core.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("sys_tenant")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysTenant extends BaseEntity {

    private String name;
    private String code;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private Integer deleted = 0;
}

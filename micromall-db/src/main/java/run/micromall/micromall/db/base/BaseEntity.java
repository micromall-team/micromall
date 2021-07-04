/*
 * micromall https://github.com/micromall-team/micromall
 *
 * Copyright (C) 2021-2021 micromall
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package run.micromall.micromall.db.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseEntity
 *
 * @author songhaozhi
 * @since 2021/1/12
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -4528595239238220613L;

    /**
     * 添加时间
     */
    @TableField(value = "add_time",fill = FieldFill.INSERT)
    private LocalDateTime addTime;
    /**
     * 修改时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private LocalDateTime updateTime;
    /**
     * 逻辑删除
     */
    @TableField(value = "deleted")
    @JsonIgnore
    private Integer deleted;
}

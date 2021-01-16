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
package run.micromall.micromall.service.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import run.micromall.micromall.db.base.Constant;
import run.micromall.micromall.db.system.mapper.MicroMallConfigMapper;
import run.micromall.micromall.db.system.model.entity.MicroMallConfig;
import run.micromall.micromall.db.system.properties.Properties;
import run.micromall.micromall.service.system.service.MicroMallConfigService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 系统配置service
 *
 * @author songhaozhi
 * @since 2021/1/12
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MicroMallConfigServiceImpl implements MicroMallConfigService {

    private final MicroMallConfigMapper configMapper;

    @Override
    public int addConfig(String key, String value) {
        MicroMallConfig config = new MicroMallConfig();
        config.setKeyName(key);
        config.setKeyValue(value);
        return configMapper.insert(config);
    }

    @Override
    public Optional<Object> getByProperties(Properties properties) {
        return getByKey(properties.getValue());
    }

    @Override
    public <T> Optional<T> getByProperties(Properties properties, Class<T> propertyType) {
        return getByProperties(properties).map(propertyValue -> Properties.convertTo(propertyValue.toString(), propertyType));
    }

    @Override
    public <T> T getByPropertyOrDefault(Properties properties, Class<T> propertyType, T defaultValue) {
        return getByProperties(properties, propertyType).orElse(defaultValue);
    }

    @Override
    public Optional<Object> getByKey(String key) {
        return Optional.ofNullable(Constant.configMap.get(key));
    }

    @Override
    public Map<String, String> selectMap() {
        List<MicroMallConfig> microMallConfigs = configMapper.selectList(null);
        Map<String, String> systemConfigs = new HashMap<>();
        for (MicroMallConfig config : microMallConfigs) {
            systemConfigs.put(config.getKeyName(), config.getKeyValue());
        }
        return systemConfigs;
    }
}

package com.smile.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 14:49
 */
@Configuration
@MapperScan({"com.smile.dao"})
public class MyBatisConfig {
}

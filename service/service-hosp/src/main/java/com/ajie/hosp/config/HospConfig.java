package com.ajie.hosp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ajie
 * @date 2023/5/18
 * @description:
 */
@Configuration
@MapperScan("com.ajie.hosp.mapper")
@EnableTransactionManagement
public class HospConfig {
}

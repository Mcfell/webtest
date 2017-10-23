package com.yc.myproject;

import com.yc.myproject.service.upload.StorageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * User: mcfell.yc
 * Date: 2017/9/12
 * Time: 下午2:54
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@ImportResource({"classpath:conf/applicationContext.xml"})
public class MyConfiguration {
}

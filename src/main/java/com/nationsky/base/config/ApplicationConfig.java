package com.nationsky.base.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lidq
 */
@Configuration
public class ApplicationConfig {
    @Value("#{appProperties.domain_name}")
    public  String domain;

    public String getDomain() {
        return domain;
    }


}

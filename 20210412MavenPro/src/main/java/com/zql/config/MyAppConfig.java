package com.zql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zql.bean.User;

@Configuration
public class MyAppConfig {

    @Bean
    public User user() {
        User u = new User();
        u.setUserName("default name");
        return u;
    }
}

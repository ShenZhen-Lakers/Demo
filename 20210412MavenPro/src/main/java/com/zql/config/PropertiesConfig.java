package com.zql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(name = "config", value = {"classpath:db.properties","classpath:mybatis.properties"})
public class PropertiesConfig {
    @Value("${jdbc.url}")
    private String oracleUrl;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.userName}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    @Value("${mybatis.type.alias.package}")
    private String aliasPackage;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getAliasPackage() {
        return aliasPackage;
    }

    public void setAliasPackage(String aliasPackage) {
        this.aliasPackage = aliasPackage;
    }

    public String getOracleUrl() {
        return oracleUrl;
    }

    public void setOracleUrl(String oracleUrl) {
        this.oracleUrl = oracleUrl;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

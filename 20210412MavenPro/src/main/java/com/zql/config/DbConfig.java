package com.zql.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * 数据库配置类：
 */
@Configuration
@ComponentScan
@MapperScan("com.zql.dao")
@PropertySource("classpath:db.properties")
public class DbConfig {
    @Bean
    public DataSource dataSource(PropertiesConfig propertiesConfig) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertiesConfig.getOracleUrl());
        dataSource.setDriverClassName(propertiesConfig.getDriverClassName());
        dataSource.setUsername(propertiesConfig.getUserName());
        dataSource.setPassword(propertiesConfig.getPassword());
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(10);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, PropertiesConfig propertiesConfig) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源：
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置mapper XML 路径：
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:*/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        //设置别名包路径：
        //该属性可以给包中的类注册别名，注册后可以直接使用类名，而不用使用全限定的类名（就是不用包含包名）
        sqlSessionFactoryBean.setTypeAliasesPackage(propertiesConfig.getAliasPackage());
        //转驼峰配置：
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        //设置日志打印：
        configuration.setLogImpl(StdOutImpl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactoryBean;
    }
}

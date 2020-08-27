package com.boot.springmybatismultipledb.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class DataSourceConfig {

    /**
     * 创建多个数据源 ds1 和 ds2
     * 此处的Primary，是设置一个Bean的优先级
     * @return
     */
    @Primary
    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource getDateSource1() {
        log.info("ds1-----------------");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource getDateSource2() {
        log.info("ds2-----------------");
        return DataSourceBuilder.create().build();
    }

    /**
     * 将多个数据源注入到DynamicDataSource
     * @param dataSource1
     * @param dataSource2
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("ds1") DataSource dataSource1,
                                        @Qualifier("ds2") DataSource dataSource2) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.ds1, dataSource1);
        targetDataSource.put(DataSourceType.DataBaseType.ds2, dataSource2);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(dataSource1);
        return dataSource;
    }

    /**
     * 将动态数据源注入到SqlSessionFactory
     * @param dynamicDataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
        bean.setTypeAliasesPackage("com.boot.springmybatismultipledb.entity");
        return bean.getObject();
    }
}
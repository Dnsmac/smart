package org.qidian.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by summer on 2016/11/25.
 */
@Configuration
@MapperScan(basePackages = SmartKitDatasource.PACKAGE, sqlSessionTemplateRef  = "SmartKit")
public class SmartKitDatasource {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "org.qidian.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";
    
    
    @Bean(name = "SmartKitDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource textDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "SmartKitSqlSessionFactory")
    @Primary
    public SqlSessionFactory textSqlSessionFactory(@Qualifier("SmartKitDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SmartKitDatasource.MAPPER_LOCATION));
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/woshipm_new/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "SmartKitTransactionManager")
    @Primary
    public DataSourceTransactionManager textTransactionManager(@Qualifier("SmartKitDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SmartKit")
    @Primary
    public SqlSessionTemplate textSessionTemplat(@Qualifier("SmartKitSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

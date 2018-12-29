package com.sr.DataSource;

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

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.sr.firstmapper", sqlSessionTemplateRef = "firstdbaSqlSessionTemplate")
//这里的package指向的是DAO层的接口文件所在的包
public class FirstDataSource {
    @Bean(name = "firstdbaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.first")//这里的前缀和yml配置文件中数据库的配置一致
    @Primary
    public DataSource ucmlbusinessaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "firstdbaSqlSessionFactory")
    @Primary
    public SqlSessionFactory firstdbaSqlSessionFactory(@Qualifier("firstdbaDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/firstmapper/*.xml"));// 指向的是mapping文件的存放地址
        return bean.getObject();
    }

    @Bean(name = "firstdbaTransactionManager")
    @Primary
    public DataSourceTransactionManager ucmlbusinessaTransactionManager(@Qualifier("firstdbaDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "firstdbaSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate ucmlbusinessaSqlSessionTemplate(@Qualifier("firstdbaSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

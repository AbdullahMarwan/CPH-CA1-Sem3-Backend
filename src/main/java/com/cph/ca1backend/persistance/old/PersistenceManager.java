package com.cph.ca1backend.persistance.old;

import com.mysql.cj.jdbc.MysqlDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
/*

@Configuration
@Service
public class PersistenceManager {
    //@Autowired
    //public DatasourceConfig datasourceConfig;

    //@Autowired
    //public DataSource dataSource;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PersistenceManager() {
        this.entityManagerFactory = this.entityManagerFactory();
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    //@Bean
    //@Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .driverClassName(this.driverClassName)
                .url(this.url)
                .username(this.username)
                .password(this.password)
                .build();
    }

    public DataSource dataSourceNEW() {
        return DataSourceBuilder
                .create()
                .driverClassName(System.getenv("JDBC_DRIVER"))
                .url(System.getenv("JDBC_DRIVER_PREFIX") + System.getenv("JDBC_HOST") + System.getenv("JDBC_DB") + System.getenv("JDBC_PARAMS"))
                .username(System.getenv("JDBC_USER"))
                .password(System.getenv("JDBC_PASSWORD"))
                .build();
    }

    @Autowired
    @Qualifier("mainJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    public EntityManagerFactory entityManagerFactory() {
        /*
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
         */

/*
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(this.dataSourceNEW_DESPERATE());
        entityManagerFactoryBean.setPackagesToScan("com.cph.ca1backend.entities");

        return entityManagerFactoryBean.getObject();
    }

    public EntityTransaction entityTransaction() {
        return this.entityManager.getTransaction();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}*/

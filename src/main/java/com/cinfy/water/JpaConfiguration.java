package com.cinfy.water;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;
 
@Configuration
@EnableJpaRepositories(basePackages = "com.cinfy.water.model.repositories",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class JpaConfiguration {
 
    @Autowired
    private Environment environmentWater;
 
    @Value("${datasource.maxPoolSize}")
    private int maxPoolSizeWater;
 
    /*
     * Populate SpringBoot DataSourceProperties object directly from application.yml 
     * based on prefix.Thanks to .yml, Hierachical data is mapped out of the box with matching-name
     * properties of DataSourceProperties object].
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }
 
    /*
     * Configure HikariCP pooled DataSource.
     */
    @Bean
    public DataSource dataSourceWater() {
        DataSourceProperties dataSourcePropertiesWater = dataSourceProperties();
            HikariDataSource dataSourceWater = (HikariDataSource) DataSourceBuilder
                    .create(dataSourcePropertiesWater.getClassLoader())
                    .driverClassName(dataSourcePropertiesWater.getDriverClassName())
                    .url(dataSourcePropertiesWater.getUrl())
                    .username(dataSourcePropertiesWater.getUsername())
                    .password(dataSourcePropertiesWater.getPassword())
                    .type(HikariDataSource.class)
                    .build();
            dataSourceWater.setMaximumPoolSize(maxPoolSizeWater);            
            return dataSourceWater;
    }
 
    /*
     * Entity Manager Factory setup.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBeanWater = new LocalContainerEntityManagerFactoryBean();
        factoryBeanWater.setDataSource(dataSourceWater());
        factoryBeanWater.setPackagesToScan(new String[] { "com.cinfy.water.model" });
        factoryBeanWater.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBeanWater.setJpaProperties(jpaProperties());
        return factoryBeanWater;
    }
 
    /*
     * Provider specific adapter.
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapterWater = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapterWater;
    }
 
    /*
     * Here you can specify any provider specific properties.
     */
    private Properties jpaProperties() {
        Properties propertiesWater = new Properties();
        propertiesWater.put("hibernate.dialect", environmentWater.getRequiredProperty("datasource.hibernate.dialect"));
        propertiesWater.put("hibernate.hbm2ddl.auto", environmentWater.getRequiredProperty("datasource.hibernate.hbm2ddl.method"));
        propertiesWater.put("hibernate.show_sql", environmentWater.getRequiredProperty("datasource.hibernate.show_sql"));
        propertiesWater.put("hibernate.format_sql", environmentWater.getRequiredProperty("datasource.hibernate.format_sql"));
        propertiesWater.put("hibernate.hbm2ddl.auto", environmentWater.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
        if(StringUtils.isNotEmpty(environmentWater.getRequiredProperty("datasource.defaultSchema"))){
        	propertiesWater.put("hibernate.default_schema", environmentWater.getRequiredProperty("datasource.defaultSchema"));
        }
        return propertiesWater;
    }
 
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManagerWater = new JpaTransactionManager();
        txManagerWater.setEntityManagerFactory(emf);
        return txManagerWater;
    }
    
}
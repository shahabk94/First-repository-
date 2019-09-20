package com.iconnect.demo.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({
    "classpath:database.properties"
})
@ComponentScan({
    "com.iconnect.demo"
})
@EnableJpaRepositories(basePackages = {"com.iconnect.demo.repository"})
@EnableTransactionManagement
public class JpaConfig   {
	  @Autowired
	    private Environment env;

	    public JpaConfig() {
	        super();
	    }

	
	
@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPackagesToScan(new String[] {
            "com.iconnect.demo.domain"
        });
    

    final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    em.setJpaProperties(additionalProperties());
	//em.setPackagesToScan("com.iconnect.demo.domain");
	//em.setPersistenceUnitName("Destination");
  
   // factoryBean.setPersistenceUnitName("Destination");
      
    return em;
}

final Properties additionalProperties() {
    final Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
    hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
    hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
    hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
    // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
    return hibernateProperties;
}


@Bean
public DataSource dataSource() {
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
    dataSource.setUrl(env.getProperty("jdbc.url"));
    dataSource.setUsername(env.getProperty("jdbc.user"));
    dataSource.setPassword(env.getProperty("jdbc.pass"));
    return dataSource;
}

@Bean
public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
    final JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
}

@Bean
public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
}
}
package com.huynguyen.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.huynguyen"})
@EnableTransactionManagement
public class UserConfiguration {

	@Autowired
	Environment environment;
	
	// Hibernate JDBC
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/glassesshop");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() { // tạo session Factory ket noi DB
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.huynguyen.entity");
	    Properties hibernateProperties=new Properties();
	    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    hibernateProperties.setProperty("hibernate.show_sql", "true");
	    bean.setHibernateProperties(hibernateProperties);
	    return bean;
	}
	
	@Bean(name="transactionManager")
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory  sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
}

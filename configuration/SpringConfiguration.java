package com.huynguyen.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;



/**
 *
 * @author User
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.huynguyen"} )
@EnableTransactionManagement
public class SpringConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/resource/");
       
    }
	
	@Autowired
	org.springframework.core.env.Environment environment;
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurerSupport() {
		return new PropertySourcesPlaceholderConfigurer();
    	
    }
	
	
	
//	
//    @Bean
//    public MessageSource messageSource(){
//        ReloadableResourceBundleMessageSource bundleMessageSource=new ReloadableResourceBundleMessageSource();
//        bundleMessageSource.setBasename("classpath:messages");
//        bundleMessageSource.setDefaultEncoding("utf-8");
//        return bundleMessageSource;
//    }
//    
//    @Bean
//    public MultipartResolver multipartResolver() {
//    	CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
//    	commonsMultipartResolver.setMaxUploadSize(-1);
//    	return commonsMultipartResolver;
//    }
//    
    // Upload File
    @Bean
    public MultipartResolver multipartResolver() {
    	CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
    	commonsMultipartResolver.setMaxUploadSize(-1);
    	return commonsMultipartResolver;
    }
    
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource bundleMessageSource=new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setBasename("classpath:messages");
        bundleMessageSource.setDefaultEncoding("utf-8");
        return bundleMessageSource;
    }

 	
	
}

package com.cinfy.water;

import java.util.Locale;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.cinfy.water.JpaConfiguration;
import com.cinfy.water.WaterApplication;

@EnableCaching
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.cinfy.water.api","com.cinfy.water.controller","com.cinfy.water.utils","com.cinfy.water.model.mapper"})
@EnableJpaRepositories({"com.cinfy.water.model.repositories"})
@org.springframework.boot.autoconfigure.domain.EntityScan(basePackages={"com.cinfy.water.model"})
@EnableTransactionManagement
@EnableJpaAuditing
@EnableScheduling
public class WaterApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(WaterApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WaterApplication.class);
    }
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.ENGLISH);
	    return slr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("lang");
	    return lci;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	      .addResourceHandler("/files/**")
	      .addResourceLocations("file:///D:/MLearning/");
	 }
	
	/*@Bean
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(new String[] { "classpath:validation","classpath:messages" });
        //messageSource.setBasename("classpath:validation");
        return messageSource;
    }*/
	 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("mail.cinfysystems.com");
		mailSender.setPort(587);

		mailSender.setUsername("sender@dpsplfranchisero.org");
		mailSender.setPassword("dpspl@123");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
	//	props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		
		return mailSender;
	}

}

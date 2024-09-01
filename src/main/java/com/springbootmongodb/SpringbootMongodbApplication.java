package com.springbootmongodb;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringbootMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}
	
	//create LocaleResolver bean from org.springframework.web.servlet.LocaleResolver
	@Bean
	public LocaleResolver localeResolver() {
		//create session local resolver class object from i18n class
	//	SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		//set default locale as us
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
//	//create ResourceBundleMessageSource bean
//	@Bean
//	public ResourceBundleMessageSource bundleMEssageResource() {
//		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
//		//set message base name
//		bundleMessageSource.setBasename("messages");
//		return bundleMessageSource;
//	}
//	
}

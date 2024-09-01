package com.springbootmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmongodb.model.HelloWorld;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "welcome controller produces")
@RestController
public class HelloController {

	@Autowired
	private MessageSource messageSource;
//	
//	@Value("${welcome.message}")
//	private String messageName;

	// 1. @RequestHeader(name = "Accept-Language", required = false) Locale locale
	@RequestMapping(method = RequestMethod.GET, path = "/welcome")
	public String getMessage() {
		return messageSource.getMessage("messageName", null, LocaleContextHolder.getLocale());
		//return messageName;
	}

	@ApiOperation(value = "this method will display the wel come message")
	@RequestMapping(method = RequestMethod.GET, path = "/welcomeMessage")
	public HelloWorld getWelMessage() {
		return new HelloWorld("welcome to springBoot");
	}
}

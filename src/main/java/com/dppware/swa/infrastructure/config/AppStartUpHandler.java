package com.dppware.swa.infrastructure.config;

import java.util.Map;
import java.util.TimeZone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * Handle StartUp process
 * -
 * - ...
 * @author dpena
 *
 */
@Component
@Slf4j
public class AppStartUpHandler {



	/**
	 * Prints all requestMapping on startup
	 * @param event
	 */
	@EventListener
	public void printRequestMappingDiscovered(ContextRefreshedEvent event) {
	    ApplicationContext applicationContext = event.getApplicationContext();
	    RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
	        .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
	    Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
	        .getHandlerMethods();
	    map.forEach((key, value) -> System.out.println( key+ " -> "+ value));
	    
	    
	    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	}
	
}

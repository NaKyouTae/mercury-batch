package com.competition;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware{
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return context;
	}

}

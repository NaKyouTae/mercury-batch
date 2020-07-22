package com.mercury.util;

import org.springframework.context.ApplicationContext;

import com.mercury.config.ApplicationContextProvider;

@SuppressWarnings("unchecked")
public class BeanUtil {
	public static <T extends Object> T getBean(String beanName) throws Exception {
		try {
			ApplicationContext context = ApplicationContextProvider.getApplicationContext();
			
			return (T) context.getBean(beanName);
		} catch (Exception e) {
			e.printStackTrace();
			return (T) e;
		}
	}
}

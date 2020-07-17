package com.mercury.util.loader;

import org.quartz.Job;

@SuppressWarnings("unchecked")
public interface ClassLoaderUtil {
	
	public static Class<? extends Job> getClass(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> cls = Class.forName(name);
		ClassLoader loader = cls.getClassLoader();
		Class<?> c = Class.forName(name, true, loader);
		return (Class<? extends Job>) c;
	}
	
}

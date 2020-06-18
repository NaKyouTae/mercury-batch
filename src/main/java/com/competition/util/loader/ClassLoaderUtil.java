package com.competition.util.loader;

@SuppressWarnings("unchecked")
public interface ClassLoaderUtil {
	

	public static <T> Class<? extends T> getClass(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> cls = Class.forName(name);
		ClassLoader loader = cls.getClassLoader();
		Class<?> c = Class.forName(name, true, loader);
		return (Class<? extends T>) c;
	}
	
}

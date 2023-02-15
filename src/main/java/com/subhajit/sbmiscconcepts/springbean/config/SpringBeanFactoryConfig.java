package com.subhajit.sbmiscconcepts.springbean.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanFactoryConfig {

	// This factory bean holds the user-defined interface through which we can fetch beans from IOC context
	@Bean(name="serviceBean")
	public FactoryBean<Object> serviceBean(){
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(BeanTypeInterface.class); // Here BeanTypeInterface is the user-defined interface through which we can fetch beans from IOC context
		return factoryBean;
	}
}

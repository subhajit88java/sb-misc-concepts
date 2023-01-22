package com.subhajit.sbmiscconcepts.springbean.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanFactoryConfig {

	@Bean(name="serviceBean")
	public FactoryBean<Object> serviceBean(){
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(BeanTypeInterface.class);
		return factoryBean;
	}
}

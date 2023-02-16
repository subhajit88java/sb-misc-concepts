package com.subhajit.sbmiscconcepts.springbean.order.bean;

import java.lang.annotation.Annotation;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.OrderBeanInterface;

@Component
//@Order(2)
public class OrderBeanTwo implements OrderBeanInterface, Ordered{
	@Override
	public void printBeanInfo() {
		System.out.println("OrderBeanTwo");
	}

	@Override
	public int getOrder() {
		return OrderingEnum.valueOf(this.getClass().getSimpleName()).ordinal();
	}

	
}

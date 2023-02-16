package com.subhajit.sbmiscconcepts.springbean.order.bean;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.OrderBeanInterface;

@Component
//@Order(3)
public class OrderBeanThree implements OrderBeanInterface, Ordered{
	@Override
	public void printBeanInfo() {
		System.out.println("OrderBeanThree");
	}

	@Override
	public int getOrder() {
		return OrderingEnum.valueOf(this.getClass().getSimpleName()).ordinal();
	}

	
}

package com.subhajit.sbmiscconcepts.springbean.order.bean;


import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.OrderBeanInterface;

@Component
//@Order(1)
public class OrderBeanOne implements OrderBeanInterface, Ordered{

	@Override
	public void printBeanInfo() {
		System.out.println("OrderBeanOne");
	}

	@Override
	public int getOrder() {
		return OrderingEnum.valueOf(this.getClass().getSimpleName()).ordinal();
	}


}

// @Order class level annotation and implementing Ordered interface and overriding getOrder() are two ways of ordering
// The big difference is : Using @Order, ordering will be static by mentioning int values.
// But using Ordered interface allow us to write dynamic logic, and thus bean ordering could be achieved by ENUM

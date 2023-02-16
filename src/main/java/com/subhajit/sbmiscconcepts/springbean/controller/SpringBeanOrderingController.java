package com.subhajit.sbmiscconcepts.springbean.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.sbmiscconcepts.springbean.config.OrderBeanInterface;
import com.subhajit.sbmiscconcepts.springbean.order.bean.OrderingEnum;

@RestController
public class SpringBeanOrderingController {

	@Autowired
	List<OrderBeanInterface> orderBeanList;
	
	@GetMapping("/test-bean-ordering")
	public List<String> testBeanOrdering() {
		orderBeanList.stream().forEach(orderBean -> {
			orderBean.printBeanInfo();
		});
		
		return orderBeanList.stream().map(orderBean -> orderBean.getClass().getName()).collect(Collectors.toList());
	}
}

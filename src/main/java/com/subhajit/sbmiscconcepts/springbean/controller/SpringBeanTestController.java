package com.subhajit.sbmiscconcepts.springbean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.sbmiscconcepts.springbean.config.BeanTypeInterface;
import com.subhajit.sbmiscconcepts.springbean.config.CompanyInterface;

@RestController
public class SpringBeanTestController {
	
	@Autowired
	private BeanTypeInterface beanTypeInterface;
	
	@GetMapping("/test-bean")
	public String testBean() {
		CompanyInterface company1 = beanTypeInterface.fetchSpecificBean("CTS");
		System.out.println("Company1 : " + System.identityHashCode(company1));
		company1.printCompanyName();
		
		CompanyInterface company2 = beanTypeInterface.fetchSpecificBean("CG");
		System.out.println("Company2 : " + System.identityHashCode(company2));
		company2.printCompanyName();
		
		CompanyInterface company3 = beanTypeInterface.fetchSpecificBean("INT");
		System.out.println("Company3 : " + System.identityHashCode(company3));
		company3.printCompanyName();
		
		CompanyInterface company1_1 = beanTypeInterface.fetchSpecificBean("CTS");
		System.out.println("Company1_1 : " + System.identityHashCode(company1_1));
		System.out.println("--------------------------------------------------------------");
		
		return company1.getCompanyName() + " - " + company2.getCompanyName() + " - " + company3.getCompanyName();
	}

}

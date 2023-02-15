package com.subhajit.sbmiscconcepts.springbean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.subhajit.sbmiscconcepts.springbean.config.BeanTypeInterface;
import com.subhajit.sbmiscconcepts.springbean.config.CollegeInterface;
import com.subhajit.sbmiscconcepts.springbean.config.CompanyInterface;

@RestController
public class SpringBeanServiceLocatorController {
	
	@Autowired
	private BeanTypeInterface beanTypeInterface;
	
	@GetMapping("/test-company-bean")
	public String testCompanyBean() {
		
		CompanyInterface company1 = beanTypeInterface.fetchCompanySpecificBean("CTS");
		company1.printCompanyName();
		
		CompanyInterface company2 = beanTypeInterface.fetchCompanySpecificBean("CG");
		company2.printCompanyName();
		
		CompanyInterface company3 = beanTypeInterface.fetchCompanySpecificBean("INT");
		company3.printCompanyName();
		
		CompanyInterface company4 = beanTypeInterface.fetchCompanySpecificBean("AAR");
		company4.printCompanyName();
		
		System.out.println("--------------------------------------------------------------");
		
		return company1.getCompanyName() + " - " + company2.getCompanyName() + " - " + company3.getCompanyName() + " - " + company4.getCompanyName();
	}
	
	@GetMapping("/test-college-bean")
	public String testCollegeBean() {
		
		CollegeInterface college1 = beanTypeInterface.fetchCollegeSpecificBean("MMM");
		college1.printCollegeName();
		
		CollegeInterface college2 = beanTypeInterface.fetchCollegeSpecificBean("HITK");
		college2.printCollegeName();
		
		System.out.println("--------------------------------------------------------------");
		
		return college1.getCollegeName() + " - " + college2.getCollegeName();
	}
	

}

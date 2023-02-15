package com.subhajit.sbmiscconcepts.springbean.servicelocator.bean;

import org.springframework.stereotype.Component;
import com.subhajit.sbmiscconcepts.springbean.config.CompanyInterface;

@Component("CTS")
public class CognizantCompany implements CompanyInterface{

	@Override
	public String getCompanyName() {
		return "Cognizant";
	}

	@Override
	public void printCompanyName() {
		System.out.println("Company is Cognizant");
	}

}

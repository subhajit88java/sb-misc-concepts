package com.subhajit.sbmiscconcepts.springbean.servicelocator.bean;

import org.springframework.stereotype.Component;
import com.subhajit.sbmiscconcepts.springbean.config.CompanyInterface;

@Component("CG")
public class CapgeminiCompany implements CompanyInterface{

	@Override
	public String getCompanyName() {
		return "Capgemini";
	}

	@Override
	public void printCompanyName() {
		System.out.println("Company is Capgemini");
	}

}

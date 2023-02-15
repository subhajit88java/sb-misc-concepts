package com.subhajit.sbmiscconcepts.springbean.servicelocator.bean;

import org.springframework.stereotype.Component;
import com.subhajit.sbmiscconcepts.springbean.config.CompanyInterface;

@Component("AAR")
public class RtizenCompany implements CompanyInterface {

	@Override
	public String getCompanyName() {
		return "Rtizen";
	}

	@Override
	public void printCompanyName() {
		System.out.println("Company is Rtizen");
	}

}

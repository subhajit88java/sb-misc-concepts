package com.subhajit.sbmiscconcepts.springbean.service;

import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.CompanyInterface;

@Component("CG")
public class CapgeminiClasss implements CompanyInterface{

	@Override
	public String getCompanyName() {
		return "Capgemini";
	}

	@Override
	public void printCompanyName() {
		System.out.println("Company is Capgemini");
	}

}

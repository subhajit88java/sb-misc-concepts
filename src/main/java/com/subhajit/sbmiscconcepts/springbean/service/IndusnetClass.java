package com.subhajit.sbmiscconcepts.springbean.service;

import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.CompanyInterface;

@Component("INT")
public class IndusnetClass implements CompanyInterface{

	@Override
	public String getCompanyName() {
		return "Indusnet";
	}

	@Override
	public void printCompanyName() {
		System.out.println("Company is Indusnet");
	}

}

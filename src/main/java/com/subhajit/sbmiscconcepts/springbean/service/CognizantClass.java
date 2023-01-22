package com.subhajit.sbmiscconcepts.springbean.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.subhajit.sbmiscconcepts.springbean.config.CompanyInterface;

@Component("CTS")
@Scope("application")
public class CognizantClass implements CompanyInterface{

	@Override
	public String getCompanyName() {
		return "Cognizant";
	}

	@Override
	public void printCompanyName() {
		System.out.println("Company is Cognizant");
	}

}

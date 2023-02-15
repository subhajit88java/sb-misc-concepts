package com.subhajit.sbmiscconcepts.springbean.config;

// user-defined interface through which we can fetch beans from IOC context.
public interface BeanTypeInterface {
	CompanyInterface fetchCompanySpecificBean(String companyAbbr);
	CollegeInterface fetchCollegeSpecificBean(String collegeAbbr);
	ScopeInterface fetchScopeSpecificBean(String scopeName);
}

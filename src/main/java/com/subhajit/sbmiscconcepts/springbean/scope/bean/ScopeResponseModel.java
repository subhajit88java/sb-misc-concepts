package com.subhajit.sbmiscconcepts.springbean.scope.bean;

public class ScopeResponseModel {

	private String beanScope;
	private Integer memoryAddress;
	
	public ScopeResponseModel(String beanScope, Integer memoryAddress) {
		super();
		this.beanScope = beanScope;
		this.memoryAddress = memoryAddress;
	}

	public String getBeanScope() {
		return beanScope;
	}

	public void setBeanScope(String beanScope) {
		this.beanScope = beanScope;
	}

	public Integer getMemoryAddress() {
		return memoryAddress;
	}

	public void setMemoryAddress(Integer memoryAddress) {
		this.memoryAddress = memoryAddress;
	}
	
	
}

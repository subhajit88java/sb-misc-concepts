package com.subhajit.sbmiscconcepts.springbean.scope.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.ScopeInterface;

@Component("prototype-scope")
@Scope("prototype") // new bean will be provided per bean fetch from IOC context
public class PrototypeScopeBean implements ScopeInterface {

	@Override
	public String getScope() {
		return "prototype-scope";
	}

}

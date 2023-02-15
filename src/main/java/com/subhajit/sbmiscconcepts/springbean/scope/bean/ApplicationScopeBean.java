package com.subhajit.sbmiscconcepts.springbean.scope.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.ScopeInterface;

@Component("application-scope")
@Scope("application") // bean will be alive through the entire application lifetime.
public class ApplicationScopeBean implements ScopeInterface{

	@Override
	public String getScope() {
		return "application-scope";
	}

}

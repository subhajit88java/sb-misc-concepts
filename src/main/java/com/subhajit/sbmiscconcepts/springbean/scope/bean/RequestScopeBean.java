package com.subhajit.sbmiscconcepts.springbean.scope.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.ScopeInterface;

@Component("request-scope")
@Scope("request") // new bean will be provided per request
public class RequestScopeBean implements ScopeInterface {

	@Override
	public String getScope() {
		return "request-scope";
	}

}

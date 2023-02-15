package com.subhajit.sbmiscconcepts.springbean.scope.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.ScopeInterface;

@Component("session-scope")
@Scope("session") // new bean will be provided per session
public class SessionScopeBean implements ScopeInterface{

	@Override
	public String getScope() {
		return "session-scope";
	}

}

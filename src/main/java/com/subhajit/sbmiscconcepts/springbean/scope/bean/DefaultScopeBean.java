package com.subhajit.sbmiscconcepts.springbean.scope.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.subhajit.sbmiscconcepts.springbean.config.ScopeInterface;

@Component("default-scope")
@Scope("singleton") // one bean per application context. If no scope is mentioned, singleton is regarded as default scope
public class DefaultScopeBean implements ScopeInterface {

	@Override
	public String getScope() {
		return "default/singleton-scope";
	}

}

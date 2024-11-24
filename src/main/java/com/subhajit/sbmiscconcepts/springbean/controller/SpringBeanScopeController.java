package com.subhajit.sbmiscconcepts.springbean.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.subhajit.sbmiscconcepts.springbean.config.BeanTypeInterface;
import com.subhajit.sbmiscconcepts.springbean.config.ScopeInterface;
import com.subhajit.sbmiscconcepts.springbean.scope.bean.ScopeResponseModel;

@RestController
public class SpringBeanScopeController {
	
	@Autowired
	private BeanTypeInterface beanTypeInterface;
	
	@Autowired
	@Qualifier("application-scope")
	private ScopeInterface application;
	
	// If bean is in session scope then autowiring will fail.
//	@Autowired
//	@Qualifier("session-scope")
//	private ScopeInterface session;
	
	// If bean is in session scope then autowiring will fail.
//	@Autowired
//	@Qualifier("request-scope")
//	private ScopeInterface request;
	
	// All the prototype scope beans will be different for each autowire, but the same bean will be maintained throughout application
	@Autowired
	@Qualifier("prototype-scope")
	private ScopeInterface prototype1;
	
	@Autowired
	@Qualifier("prototype-scope")
	private ScopeInterface prototype2;
	
	@Autowired
	@Qualifier("prototype-scope")
	private ScopeInterface prototype3;
	
	@Autowired
	@Qualifier("default-scope")
	private ScopeInterface defaultScope;
	
	@GetMapping("/test-bean-scope-by-service-locator")
	public List<ScopeResponseModel> testBeanScopeByServiceLocator() {
		
		List<ScopeResponseModel> responseList = new ArrayList<>();
		
		ScopeInterface application = beanTypeInterface.fetchScopeSpecificBean("application-scope");
		responseList.add(new ScopeResponseModel(application.getScope(), System.identityHashCode(application)));
		
		ScopeInterface session = beanTypeInterface.fetchScopeSpecificBean("session-scope");
		responseList.add(new ScopeResponseModel(session.getScope(), System.identityHashCode(session)));
		
		ScopeInterface request = beanTypeInterface.fetchScopeSpecificBean("request-scope");
		responseList.add(new ScopeResponseModel(request.getScope(), System.identityHashCode(request)));
		
		ScopeInterface prototype1 = beanTypeInterface.fetchScopeSpecificBean("prototype-scope");
		responseList.add(new ScopeResponseModel(prototype1.getScope(), System.identityHashCode(prototype1)));
		
		ScopeInterface prototype2 = beanTypeInterface.fetchScopeSpecificBean("prototype-scope");
		responseList.add(new ScopeResponseModel(prototype2.getScope(), System.identityHashCode(prototype2)));
		
		ScopeInterface prototype3 = beanTypeInterface.fetchScopeSpecificBean("prototype-scope");
		responseList.add(new ScopeResponseModel(prototype3.getScope(), System.identityHashCode(prototype3)));
		
		ScopeInterface defaultScope = beanTypeInterface.fetchScopeSpecificBean("default-scope");
		responseList.add(new ScopeResponseModel(defaultScope.getScope(), System.identityHashCode(defaultScope)));
				
		return responseList;
	}
	
	@GetMapping("/test-bean-scope-by-autowiring")
	public List<ScopeResponseModel> testBeanScopeByAutowiring() {
		
		List<ScopeResponseModel> responseList = new ArrayList<>();
		
		responseList.add(new ScopeResponseModel(application.getScope(), System.identityHashCode(application)));
						
		responseList.add(new ScopeResponseModel(prototype1.getScope(), System.identityHashCode(prototype1)));
		
		responseList.add(new ScopeResponseModel(prototype2.getScope(), System.identityHashCode(prototype2)));
		
		responseList.add(new ScopeResponseModel(prototype3.getScope(), System.identityHashCode(prototype3)));
		
		responseList.add(new ScopeResponseModel(defaultScope.getScope(), System.identityHashCode(defaultScope)));
			
		return responseList;
	}

}

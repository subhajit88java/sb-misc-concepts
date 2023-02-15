package com.subhajit.sbmiscconcepts.springbean.servicelocator.bean;

import org.springframework.stereotype.Component;
import com.subhajit.sbmiscconcepts.springbean.config.CollegeInterface;

@Component("HITK")
public class HeritageCollege implements CollegeInterface{

	@Override
	public String getCollegeName() {
		return "Heritage Institute of Technology";
	}

	@Override
	public void printCollegeName() {
		System.out.println("College is Heritage Institute of Technology");
	}

}

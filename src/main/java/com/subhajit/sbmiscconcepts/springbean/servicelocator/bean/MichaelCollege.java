package com.subhajit.sbmiscconcepts.springbean.servicelocator.bean;

import org.springframework.stereotype.Component;
import com.subhajit.sbmiscconcepts.springbean.config.CollegeInterface;

@Component("MMM")
public class MichaelCollege implements CollegeInterface{

	@Override
	public String getCollegeName() {
		return "Michael Madhusudan memorial College";
	}

	@Override
	public void printCollegeName() {
		System.out.println("College is Michael Madhusudan memorial College");
	}

}

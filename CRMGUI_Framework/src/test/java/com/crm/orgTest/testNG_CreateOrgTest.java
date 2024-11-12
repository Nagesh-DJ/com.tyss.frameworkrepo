package com.crm.orgTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseUtility.a_BaseClass;

public class testNG_CreateOrgTest extends a_BaseClass
{
	
	@Test
	public void createOrgTest() {
		System.out.println("Execute createOrgTest & verify");
	}
	@Test
	public void createOrgWithIndustryTest() {
		System.out.println("Execute createOrgWithIndustryTest & verify");
	}
	
	
}

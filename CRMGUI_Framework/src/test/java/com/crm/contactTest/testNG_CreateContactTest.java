package com.crm.contactTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseUtility.a_BaseClass;

public class testNG_CreateContactTest extends a_BaseClass
{
	@Test
	public void createContactTest() {
		System.out.println("Execute createContactTest & verify");
	}
	@Test
	public void createContactwithDateTest() {
		System.out.println("Execute createContactwithDateTest & verify");
	}
}

package practice.TestNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class a_practice_BeforeSuit_class_me_And_After_S_C_M {
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("===Execute BS===");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("Execute BC");
	}
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("Execute BM");
	}

	@Test
	public void createContactTest() {
		System.out.println("Execute createContactTest");
	}
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("Execute AM");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("Execute AC");
	}

	@AfterSuite
	public void configAS()
	{
		System.out.println("===Execute AS===");
	}
}

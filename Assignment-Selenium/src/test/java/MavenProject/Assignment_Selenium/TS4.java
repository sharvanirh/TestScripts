package MavenProject.Assignment_Selenium;

import org.testng.annotations.Test;

public class TS4 {
@Test(groups="sanity")
	
	public void SanityTestCase1() {
		System.out.println("TestSuite4:Sanity testcase1");
	}
	
	@Test(groups="sanity")
	public void SanityTestCase2() {
		System.out.println("TestSuite4:Sanity testcase2");
	}

	
	@Test(groups="sanity")
	public void SanityTestCase3() {
		System.out.println("TestSuite4:Sanity testcase3");
	}
	
	@Test(groups="Regression")
	public void RegressionTestCase1() {
		System.out.println("TestSuite4:Regression TestCase1");
	}
	
	@Test(groups="Regression")
	public void RegressionTestCase2() {
		System.out.println("TestSuite4:Regression TestCase2");
	}
}

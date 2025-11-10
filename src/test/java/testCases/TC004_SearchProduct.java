package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseTest;

public class TC004_SearchProduct extends BaseTest {
	@Test
	public void verifySearch() {
		HomePage hp=new HomePage(driver);
		logger.info("Execution started");
		hp.searchProduct("mac");
		hp.search();
		logger.info("Execution ended");
	}
	
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC002_VerifyLogin extends BaseTest{
	@Test(groups= {"regression","master"})
	public void verifyLogin() {
		try {
		logger.info("Execution started");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountBtn();
		hp.clickLoginBtn();
		logger.info("Login page is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("mail"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("My account page is loaded");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		boolean page_status=myAccPage.verifyMyAcc();
		Assert.assertEquals(page_status, true);
		}
		catch(Exception e) {
			 Assert.fail();
			 logger.error("testcase failed");
		}
		logger.info("Test case executed");
	
		}
	}



package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviderClass;

public class TC003_VerifyLoginUsingVariousData extends BaseTest{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviderClass.class,groups= {"regression","master"})
	public void verifyLogin(String mail,String pwd,String exp_res) {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountBtn();
		hp.clickLoginBtn();
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(mail);
		lp.setPassword(pwd);
		lp.clickLogin();
		MyAccountPage myAccPage=new MyAccountPage(driver);
		boolean page_status=myAccPage.verifyMyAcc();
		if(exp_res.equalsIgnoreCase("valid")) {
			if(page_status==true) {
				myAccPage.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp_res.equalsIgnoreCase("invalid")) {
			if(page_status==true) {
				Assert.assertTrue(false);
			}
			else {
				myAccPage.clickLogout();
				Assert.assertTrue(true);
			}
		}
		
	}

}

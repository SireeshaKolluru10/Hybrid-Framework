package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegestrationPage;
import testBase.BaseTest;
public class TC001_UserRegestration extends BaseTest {
		@Test(groups= {"sanity","master"})
	public void verifyRegestartion() {
		logger.info("Test started");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccountBtn();
		hp.clickRegisterBtn();
		logger.info("Navigated to registration page");
		RegestrationPage regPage = new RegestrationPage(driver);
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setMail(randomString() + "@gmail.com");
		regPage.setTelephoneNum(randomNumber());
		String pass = randomString();
		regPage.setPassword(pass);
		regPage.setConfirmPassword(pass);
		regPage.clickCheckbox();
		regPage.clickContinue();
		logger.info("All the text fields are entered");
		String cnfrmMsg = regPage.getConfirmationMsg();
		logger.info("Received confirmation message "+cnfrmMsg);
		try {
		Assert.assertEquals(cnfrmMsg, "Your Account Has Been Created!");
		logger.info("Assertion passed: Confirmation message received");
		}
		catch(AssertionError e) {
			logger.error("Assertion failed! Expected: 'Your Account Has Been Created!' but got: '" + cnfrmMsg + "'");
		    logger.debug("Detailed error stack trace: ", e);
		    Assert.fail();
		}
	}
}

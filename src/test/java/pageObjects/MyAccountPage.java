package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
public MyAccountPage(WebDriver driver) {
	super(driver);
}
@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myAccText;
@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement logout_btn;
public boolean verifyMyAcc() {
	return myAccText.isDisplayed();
}
public void clickLogout() {
	logout_btn.click();
}
}

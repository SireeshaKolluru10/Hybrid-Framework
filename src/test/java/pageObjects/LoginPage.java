package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']") WebElement email_field;
	@FindBy(xpath="//input[@id='input-password']") WebElement password_field;
	@FindBy(xpath="//input[@value='Login']") WebElement login_btn;
	public void setEmail(String email) {
		email_field.sendKeys(email);
	}
	public void setPassword(String pwd) {
		password_field.sendKeys(pwd);
	}
	public void clickLogin() {
		login_btn.click();
	}

}

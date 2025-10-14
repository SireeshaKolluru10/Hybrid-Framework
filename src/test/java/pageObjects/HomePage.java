package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
 public WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);

}
@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myAccount_btn;
@FindBy(xpath="//a[text()='Register']") WebElement register_btn;
@FindBy(xpath="//a[text()='Login']") WebElement login_btn;
public void clickMyAccountBtn() {
	myAccount_btn.click();
}
public void clickRegisterBtn() {
	register_btn.click();
}
public void clickLoginBtn() {
	login_btn.click();
}
}

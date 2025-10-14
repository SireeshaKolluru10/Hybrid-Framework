package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegestrationPage extends BasePage {
	public RegestrationPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_mail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confirmPassword;
	@FindBy(xpath="//input[@type='checkbox']") WebElement checkbox;
	@FindBy(xpath="//input[@value='Continue']") WebElement continue_btn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmation_msg;
	public void setFirstName(String fname) {
		txt_firstname.sendKeys(fname);
		
	}
	public void setLastName(String lname) {
		txt_lastname.sendKeys(lname);
	}
	public void setMail(String mail) {
		txt_mail.sendKeys(mail);
	}
	public void setTelephoneNum(String tele_num) {
		txt_telephone.sendKeys(tele_num);
	}
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	public void setConfirmPassword(String conf_pwd) {
		txt_confirmPassword.sendKeys(conf_pwd);
	}
	public void clickCheckbox() {
		checkbox.click();
	}
	public void clickContinue() {
		continue_btn.click();
	}
	public String getConfirmationMsg() {
		try{
			return confirmation_msg.getText();
		}
		catch(Exception e) {
			return (e.getMessage());
		}
		
	}
}

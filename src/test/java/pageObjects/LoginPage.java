package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;

public class LoginPage extends Page{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void setUserName(String strUserName) {
		driver.findElement(By.name("uid")).sendKeys(strUserName);
	}
	
	public void setPassword(String strPassword) {
		driver.findElement(By.name("password")).sendKeys(strPassword);
	//	tb_password.sendKeys(strPassword);
	}
	
	public void clickLogin() {
		driver.findElement(By.name("btnLogin")).click();
	//	btn_login.click();
	}
	

}

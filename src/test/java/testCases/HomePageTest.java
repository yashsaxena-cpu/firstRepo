package testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;


import base.BaseTest;
import base.BrowserFactory;
import pageObjects.LoginPage;

public class HomePageTest  extends BaseTest{
	@Test
	public void sum() throws IOException, InterruptedException {
        LoginPage lgp = new LoginPage(driver);
		lgp.setUserName("mngr204304");
		lgp.setPassword("ytyzAqE");
		lgp.clickLogin();     
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();	
        Thread.sleep(5000);
		
        // Accepting alert		
        alert.accept();		
		
        Assert.assertEquals(alertMessage,"User or Password is not valid");
		driver.close();
	}
	@Test
	public void subtract() {
		Assert.assertEquals(false, true);
	}

}

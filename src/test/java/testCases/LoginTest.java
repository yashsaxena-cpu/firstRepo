package testCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import base.BaseTest;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {
	
	
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
		Assert.assertEquals(alertMessage, "User or Password is not valid");
	
	}
	@Test
	public void subtract1() throws IOException {
         Assert.assertEquals(false, true);
	}
	@Test
	public void subtract2() throws IOException {
         Assert.assertEquals(true, true);
	}
	@Test
	public void subtract3() throws IOException {
         Assert.assertEquals(false, true);
	}
	@Test
	public void subtract4() throws IOException {
         Assert.assertEquals(false, true);
	}
	@Test
	public void subtract5() throws IOException {
         Assert.assertEquals(false, true);
	}
	@Test
	public void subtract6() throws IOException {
         Assert.assertEquals(false, true);
	}
}

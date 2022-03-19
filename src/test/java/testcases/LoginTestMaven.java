package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTestMaven extends BaseClass {
	
	
	@Test
	public void LoginFailureTest() {
		
		//test = report.startTest("LoginFailureTest");
		LoginPage login = new LoginPage();
		login.LoginFunction("xyz@abc.com","Abc@12345");
		
				
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
		//report.endTest(test);
	}
	
		
	
	 @Test public void LoginSuccessTest() {
	 
	 LoginPage login = new LoginPage();
	 login.LoginFunction("corps2006@yandex.ru","Treize13");
	 }
	 
	 
	 @Test
	 @Parameters({"Param1","Param2"}) 
	 public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		 LoginPage login = new LoginPage();
		 login.LoginFunction(UserNameVal, PasswordVal);
		 
		 
	 }
	 
	 @Test
	 public void ExternalDataTest() {
		
		 String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		 String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		 
		 
		 LoginPage login = new LoginPage();
		 login.LoginFunction(UserNameVal, PasswordVal);
		 
	 }
		
		/*
		 * WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		 * //wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
		 * 
		 * LoginLink.click();
		 * 
		 * WebElement UserName = driver.findElement(By.name("user_login"));
		 * 
		 * WebElement Password = driver.findElement(By.id("password"));
		 * 
		 * WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		 * 
		 * WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		 * 
		 * UserName.sendKeys("corps2006@yandex.ru"); Password.sendKeys("Treize13");
		 * RememberMe.click(); LoginBtn.click();
		 */
		
		/*
		 * WebElement ErrorMsg = driver.findElement(By.id("msg_box")); String ActualMsg
		 * = ErrorMsg.getText(); String ExpMsg =
		 * "The email or password you have entered is invalid.";
		 * 
		 * Assert.assertEquals(ActualMsg, ExpMsg);
		 */
	
	
}
	
	



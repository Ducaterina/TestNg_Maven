package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
public static WebDriver driver;
	
//add these to access your .xlsx file 
	XSSFWorkbook wbook;
	XSSFSheet sheet;

	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeTest
	public void DataSetUP()  throws IOException {
		
		FileInputStream fis = new FileInputStream ("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		report = new ExtentReports ("C:\\users\\asus\\eclipse-workspace\\Selenium-Maven\\reports\\" + timeStamp + "ExtentReport.html", true);
		
		//report = new ExtentReports("ExtentReports.html");
		
			
	}
	
	@AfterTest
	public void DataTearDown() throws IOException {
		wbook.close();
		report.flush();
		report.close();
	}
	
	@BeforeMethod
	public void SetUp(Method method) throws MalformedURLException {
		
		test = report.startTest(method.getName());
		
	System.setProperty("webdriver.chrome.driver", "chromedriver103.0.5060.53.exe");
//		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
	driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setPlatform(Platform.WINDOWS);
//		cap.setBrowserName("chrome");
//		URL url = new URL("http://localhost:4444/wd/hub");	
//		WebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("https://simplilearn.com/");
		
		driver.manage().window().maximize();
		
		//wait for 5 sec for your browser to load
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//WebDriverWait wait = new WebDriverWait(driver,50);
		
		
	}
	
	@AfterMethod
	public void TearDown() {
		report.endTest(test);
		driver.quit();
	}
	

}

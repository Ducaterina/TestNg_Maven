package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {

			public static void main(String[] args) throws MalformedURLException {
			// TODO Auto-generated method stub

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setPlatform(Platform.WINDOWS);			//this is where we specify the platform
			cap.setBrowserName("chrome");				//this is where we specify the browser
			URL url = new URL("http://localhost:4444/wd/hub");	
			WebDriver driver = new RemoteWebDriver(url, cap);
			
			driver.get("https://simplilearn.com/");
			driver.quit();
}
}
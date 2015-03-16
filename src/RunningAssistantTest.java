import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RunningAssistantTest {

	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		File classPathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classPathRoot, "Application");
		File app = new File(appDir, "RunningAssistant.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "samsung-sgh_m919-93884d7c");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("app-activity", "com.group6.runningassistant.MainActivity");
		
		driver = new RemoteWebDriver(new URL("http://127.0.01:4723/wd/hub/"), capabilities);	
	}
	
	@Test
	public void test() throws Exception {
		
		Thread.sleep(3000);
		
		// Test UserProfile
		List<WebElement> textField = driver.findElements(By.className("android.widget.EditText"));
		
		textField.get(0).sendKeys("28");
		textField.get(1).sendKeys("70");
		textField.get(2).sendKeys("140");
		Thread.sleep(100);
		
		List<WebElement> radioButton = driver.findElements(By.className("android.widget.RadioButton"));
		radioButton.get(0).click();
		Thread.sleep(200);
		radioButton.get(1).click();
		
		driver.navigate().back();
		Thread.sleep(200);
		
		WebElement confirmButton = driver.findElement(By.id("com.group6.runningassistant:id/btn_confirm"));
		confirmButton.click();
		Thread.sleep(200);
		
		WebElement settingButton = driver.findElement(By.id("com.group6.runningassistant:id/action_settings"));
		settingButton.click();
		Thread.sleep(500);
		
		driver.findElement(By.id("com.group6.runningassistant:id/btn_bmi")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		settingButton.click();
		Thread.sleep(500);
		
		driver.findElement(By.id("com.group6.runningassistant:id/btn_clear")).click();
		Thread.sleep(200);
		
		textField.get(0).sendKeys("28");
		textField.get(1).sendKeys("70");
		textField.get(2).sendKeys("140");
		Thread.sleep(100);
		
		driver.navigate().back();
		Thread.sleep(200);
		
		confirmButton.click();
		Thread.sleep(200);
	
		// Test MainActivity
		//List<WebElement> Buttons = driver.findElements(By.className("android.widget.Button"));
		WebElement startButton = driver.findElement(By.id("com.group6.runningassistant:id/start"));
		WebElement pauseButton = driver.findElement(By.id("com.group6.runningassistant:id/pause"));
		WebElement resetButton = driver.findElement(By.id("com.group6.runningassistant:id/reset"));
		WebElement saveButton = driver.findElement(By.id("com.group6.runningassistant:id/save"));
		WebElement openButton = driver.findElement(By.id("com.group6.runningassistant:id/open"));
		WebElement exitButton = driver.findElement(By.id("com.group6.runningassistant:id/quit"));
		
		startButton.click();
		Thread.sleep(8000);
			
		pauseButton.click();
		Thread.sleep(1000);
		
		resetButton.click();
		Thread.sleep(1000);
		
		startButton.click();
		Thread.sleep(15000);
		
		pauseButton.click();
		Thread.sleep(1000);
		
		// Test GraphView
		driver.findElement(By.id("com.group6.runningassistant:id/show_report")).click();
		Thread.sleep(1000);
		
		List<WebElement> list = driver.findElement(By.id("com.group6.runningassistant:id/listView_stats")).findElements(By.className("android.widget.TextView"));
		list.get(0).click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		list.get(1).click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		list.get(2).click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		driver.navigate().back();
		
		// Test Mysqlview (database) 
		saveButton.click();
		Thread.sleep(1000);
		
		openButton.click();
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(1000);
		driver.navigate().back();


		// Test Find Store
		driver.findElement(By.id("com.group6.runningassistant:id/btn_cancel")).click();
		Thread.sleep(500);
		//driver.findElement(By.tagName("android.view.Menu")).click();
//		driver.findElement(By.name("Apps")).click();;
		Thread.sleep(1000);
//		HashMap swipeObject = new HashMap(); 
//		swipeObject.put("keycode", 82);
//		 ((JavascriptExecutor ) driver).executeScript("mobile: keyevent", swipeObject);
		driver.findElement(By.id("com.group6.runningassistant:id/findstore")).click();
		Thread.sleep(5000);
		driver.navigate().back();

		// Test feedback 
		driver.findElement(By.id("com.group6.runningassistant:id/feedback")).click();
		driver.findElement(By.name("Gmail")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		driver.navigate().back();
		
		// Test Exit
		exitButton.click();
	}
	
	@AfterMethod 
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}


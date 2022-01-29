package rough;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;
	 @BeforeMethod
	  public void beforeMethod() {

			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			
		    driver= new ChromeDriver();
			
			
			driver.get("http://demo.guru99.com/test/newtours/");
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
	  }
  @Test
  public void f() throws IOException {
	  File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\screencapture2.jpg"));
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		int linkCount=links.size();
		
		System.out.println("Total number of links present in home page are : "+linkCount);
		
		if(linkCount!=0) 
		  { 
			  System.out.println("Test passed");
		  }
		  else 
		  { 
			  System.out.println("Test failed");
			  
		  }
  }
 

  @AfterMethod
  public void afterMethod() {
	  driver.quit();

  }

}

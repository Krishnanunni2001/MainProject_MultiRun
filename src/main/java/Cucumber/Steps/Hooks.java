package Cucumber.Steps;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import Project_POM.CarPOM;
import Utilities.DriverSetup;
import Utilities.ScrollDown;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	static WebDriver driver;
	static DriverSetup dd;
	static String b="chrome";
	
		@BeforeAll
	    public static void before_or_after_all() throws IOException, InterruptedException{
			
	    	dd=new DriverSetup();
			driver=dd.SelectDriver(b);
			//driver=new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			driver.get("https://emicalculator.net/");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//			driver.manage().window().maximize();

	}
		@AfterStep
	    public void addScreenshot(Scenario scenario) {
	    if(!scenario.isFailed()) {
	       TakesScreenshot ts=(TakesScreenshot) driver;
	       byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	       scenario.attach(screenshot, "image/png",scenario.getName());
	        }
		}
		@AfterAll
		public static void before_or_after_all1() {
			driver.quit();
			String reportFilePath = "C:\\Users\\2303964\\eclipse-workspace\\MainProject\\Reports\\Cucumber_Report.html";
	        File htmlFile = new File(reportFilePath);
	        try {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}





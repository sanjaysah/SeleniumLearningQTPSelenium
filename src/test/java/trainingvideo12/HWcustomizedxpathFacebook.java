package trainingvideo12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class HWcustomizedxpathFacebook {
	WebDriver driver;
	
	@Test
	public void facebookHW() throws InterruptedException{
		String projectBasePath = "D:\\Programming\\JavaLearning\\SeleniumLearningQTPSelenium";
		
		//Logs
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, projectBasePath+"\\Logs\\FirefoxBrowserLogs.txt");//or null value instead of file
		
		//Firefox Profiling
		FirefoxOptions opt = new FirefoxOptions();
		ProfilesIni allProf = new ProfilesIni();
		FirefoxProfile myProf = allProf.getProfile("dev-edition-sanjay");
		opt.setProfile(myProf);
		
		//Notifications off
		opt.addPreference("dom.webnotifications.enabled", false);
		//opt.addArguments("--disable-notifications");//doesnt works on firefox but should work on Chrome
		
		//Page Load Strategy
		opt.setPageLoadStrategy(PageLoadStrategy.EAGER);//NORMAL,NONE,EAGER
		
		//Binary File
		///opt.setBinary(projectBasePath+"//exe path");
		
		//Certificate issues handling
		opt.setAcceptInsecureCerts(true);
		myProf.setAssumeUntrustedCertificateIssuer(false);//this option is available in profile object only and not in FirefoxOptions
		
		//Info Bars disable
		//opt.addArguments("disable-infobars");//doesnt works on firefox but should work on Chrome
		
		opt.setProfile(myProf);
		driver = new FirefoxDriver(opt);
		//Implicitwait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://facebook.com");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sweet.sanjay@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Sonu0383");
		driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
		
		driver.findElement(By.xpath("//a[@title='Profile']/span/span")).click();
		driver.findElement(By.xpath("//a[@data-tab-key='friends']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for your friends']")).sendKeys("ranjan");
		//driver.findElement(By.xpath("//input[@placeholder='Search for your friends']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.quit();
	}

}

package trainingVideo11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Part4ChromeOptions {
	
	@Test
	public void browserIssues() throws InterruptedException{
		//PreRequisites - Latest version of Firefox and Driver
		
		//Logs coming in Console mixing with code outputs
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"C:\\Selenium\\seleniumChrome.log");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		
		ChromeOptions opt = new ChromeOptions();
		
		//Binary/EXE file missing error by Selenium - same as FIrefox
/*		opt.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");*/	 
		
		//Page Load Strategy - actions taken after or before page loaded completely - same as Chrome
/*		//opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);//default behaviour, browser actions taken after page loaded completely
		//opt.setPageLoadStrategy(PageLoadStrategy.NONE);//browser actions taken before page loads completely - faster
		opt.setPageLoadStrategy(PageLoadStrategy.EAGER);//same as NONE but faster
*/		
		
		//Chrome Profiling - It can be done with Gmail login only - DIFF than Firefox
		/*opt.addArguments("user-data-dir=C:\\Users\\Sanjay Kumar\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\");*/
		
/*		//Maximize -  new
		opt.addArguments("--start-maximized");

		//Infobar disabling
		opt.addArguments("--disable-infobars");
		
		//Notification disabling
		opt.addArguments("--disable-notifications");
		
		//Proxy Servers
		opt.addArguments("--proxy-server=https://83.209.94.87:8855");*/
		
		//Certificate Issues - Chrome auto handlesthe certification issue, so no need to handle
		
		ChromeDriver driver = new ChromeDriver(opt);
		//driver.get("https:\\www.rediff.com");
		//driver.get("https://abroadjobs.ga/bcn/");//notification
		driver.get("http://www.thehindu.com/news/");//notification2
		//driver.get("https://untrusted-root.badssl.com/");//certificate issue
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//input[@id='srchword']")).sendKeys("Hello");
		Thread.sleep(5000);
		driver.quit();
	}
}

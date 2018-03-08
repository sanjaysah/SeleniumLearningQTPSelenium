package trainingVideo11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Part5EdgeOptions {
	
	@Test
	public void browserIssues() throws InterruptedException{
		//PreRequisites ----------------
		// 1 - Latest version of IE is 11 and will not upgrade further
		// 2 - Zoom Level 100%
		// 3 - Internet Options - Security - Protected mode disable(chckbox)
		// 4 - Internet Options - Security - all Leveller arrow down at bottom lower
		// 5 - Internet Options - Advanced - Security - checkbox  "Allow active content to run in files on .." ON/Selected 
		
		//Logs coming in Console mixing with code outputs
		//System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"C:\\Selenium\\seleniumEdge.log");
		//System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"null");
		
		EdgeOptions opt = new EdgeOptions();
		
		//Binary/EXE file missing error by Selenium - NO FACILITY BY Edge

		//Page Load Strategy - actions taken after or before page loaded completely
/*		//opt.setPageLoadStrategy("normal");//default behaviour, browser actions taken after page loaded completely
		//opt.setPageLoadStrategy("none");//browser actions taken before page loads completely - faster
		opt.setPageLoadStrategy("eager");//same as NONE but faster
*/		
		
		//Chrome Profiling - NO FACILITY BY Edge

		
		//Notification disabling - NO FACILITY BY Edge
		
		//Proxy Servers - NO FACILITY BY Edge
		
		//Certificate Issues - std 2 lines of code for IE
		EdgeDriver driver = new EdgeDriver(opt);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://untrusted-root.badssl.com/");//certificate issue
		driver.findElement(By.id("moreInformationDropDownSpan")).click();
		driver.findElement(By.id("Invalidcert_continue")).click();
		
		
		/*EdgeDriver driver = new EdgeDriver(opt);
		driver.get("https://www.rediff.com");
		//driver.get("https://abroadjobs.ga/bcn/");//notification
		//driver.get("http://www.thehindu.com/news/");//notification2
		//driver.get("https://untrusted-root.badssl.com/");//certificate issue
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='srchword']")).sendKeys("Hello");*/
		Thread.sleep(5000);
		driver.quit();
	}
}

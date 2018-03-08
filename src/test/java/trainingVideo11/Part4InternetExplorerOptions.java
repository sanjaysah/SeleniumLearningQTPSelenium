package trainingVideo11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Part4InternetExplorerOptions {
	
	@Test
	public void browserIssues() throws InterruptedException{
		//PreRequisites ----------------
		// 1 - Latest version of IE is 11 and will not upgrade further
		// 2 - Zoom Level 100%
		// 3 - Internet Options - Security - Protected mode disable(chckbox)
		// 4 - Internet Options - Security - all Leveller arrow down at bottom lower
		// 5 - Internet Options - Advanced - Security - checkbox  "Allow active content to run in files on .." ON/Selected 
		
		//Logs coming in Console mixing with code outputs
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY,"C:\\Selenium\\seleniumIE.log");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_SILENT_PROPERTY,"true");
		
		InternetExplorerOptions opt = new InternetExplorerOptions();
		
		//Binary/EXE file missing error by Selenium - NO FACILITY BY IE

		
		//Page Load Strategy - NO FACILITY BY IE
	
		
		//Chrome Profiling - NO FACILITY BY IE

		
		//Notification disabling - NO FACILITY BY IE
		
		//Proxy Servers
		/*String PROXY = "83.209.94.87:8855";
		Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setSocksProxy(PROXY);
		
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(CapabilityType.PROXY, proxy);
		opt.merge(cap);*/
		
		//Certificate Issues - std 2 lines of code for IE
		/*InternetExplorerDriver driver = new InternetExplorerDriver(opt);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://untrusted-root.badssl.com/");//certificate issue
		driver.get("javascript:document.getElementById('overridelink').click();");*/
		
		
		InternetExplorerDriver driver = new InternetExplorerDriver(opt);
		driver.get("https://www.rediff.com");
		//driver.get("https://abroadjobs.ga/bcn/");//notification
		//driver.get("http://www.thehindu.com/news/");//notification2
		//driver.get("https://untrusted-root.badssl.com/");//certificate issue
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='srchword']")).sendKeys("Hello");
		Thread.sleep(5000);
		driver.quit();
	}
}

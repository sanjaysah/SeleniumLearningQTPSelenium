package trainingVideo11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Part34FirefoxOptions {
	
	@Test
	public void browserIssues() throws InterruptedException{
		//PreRequisites - use 2-3 older version of latest version of Firefox
		
		//Logs coming in Console mixing with code outputs
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\Selenium\\selenium.log");
		
		FirefoxOptions opt = new FirefoxOptions();
		
		//Binary/EXE file missing error by Selenium
/*		opt.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");*/	 
		
		//Page Load Strategy - actions taken after or before page loaded completely
/*		//opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);//default behaviour, browser actions taken after page loaded completely
		//opt.setPageLoadStrategy(PageLoadStrategy.NONE);//browser actions taken before page loads completely - faster
		opt.setPageLoadStrategy(PageLoadStrategy.EAGER);//same as NONE but faster
*/		
		
		//Firefox Profiling
/*		ProfilesIni allProf = new ProfilesIni();
		FirefoxProfile myProf = allProf.getProfile("dev-edition-sanjay");
		opt.setProfile(myProf);*/
	
		//Notification disabling
		/*ProfilesIni allProf = new ProfilesIni();
		FirefoxProfile myProf = allProf.getProfile("dev-edition-sanjay");
		myProf.setPreference("dom.webnotifications.enabled", false);
		opt.setProfile(myProf);*/
		
		//Certificate Issues Old code
/*		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		opt.merge(cap);	*/ 
		
		//Certificate Error Latest Selenium version 3.8 onwards
		/*FirefoxProfile myProf = new FirefoxProfile();
		myProf.setAcceptUntrustedCertificates(true);
		myProf.setAssumeUntrustedCertificateIssuer(false);
		opt.setProfile(myProf);*/
		
		//Proxy Server Handling
		/*FirefoxProfile myProf = new FirefoxProfile();
		myProf.setPreference("network.proxy.type", 1);
		myProf.setPreference("network.proxy.socks", "83.209.94.87");
		myProf.setPreference("network.proxy.socks_port", 3343);
		opt.setProfile(myProf);*/
		
		FirefoxDriver driver = new FirefoxDriver(opt);
		driver.get("https:\\www.rediff.com");
		//driver.get("http://www.thehindu.com/news/");//notification
		//driver.get("https://untrusted-root.badssl.com/");//certificate issue
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='srchword']")).sendKeys("Hello");
		Thread.sleep(5000);
		driver.quit();
	}
}

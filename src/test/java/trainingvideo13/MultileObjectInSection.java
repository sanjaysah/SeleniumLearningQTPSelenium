package trainingvideo13;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MultileObjectInSection {
	
	String browser="firefox";
	WebDriver driver;
	
	@Test
	public void getElementsInSection(){
		
		if(browser.equals("firefox")){
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			driver=new FirefoxDriver(loadFirefoxOptions());//here we can create a load firefoxoptions method and pass as arguments.
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}else if(browser.equals("chrome")){
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}else if(browser.equals("IE")){
			driver=new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}else if(browser.equals("Edge")){
			driver=new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		//get url
		//driver.get("https://cnn.com");//https://edition.cnn.com/
		driver.navigate().to("https://cnn.com/");
		String part1 = "//*[@id='intl_homepage1-zone-1']/div[2]/div/div[3]/ul/li[";
		String part2 = "]/article/div/div/h3/a";
		
		/*//Find number of links inside section
		WebElement section = driver.findElement(By.cssSelector("#intl_homepage1-zone-1>div:nth-child(2)>div:nth-child(1)>div:nth-child(3)"));
		List<WebElement> secLinks = section.findElements(By.tagName("a")); 
		int noofLinksSec = secLinks.size();
		System.out.println(noofLinksSec);
		
		for(int i=2;i<noofLinksSec;i++){
			WebElement link = driver.findElement(By.xpath(part1+i+part2));
			System.out.println(link.getText());
		}*/
		int i=2;
		while(isElementPresent(part1+i+part2, "xpath")){
			WebElement link = driver.findElement(By.xpath(part1+i+part2));
			System.out.println((i-1)+". "+link.getText());
			String url = link.getAttribute("href");
			System.out.println(url);
			//response code
			if(getResponseCode(url)){
				link.click();
				driver.navigate().back();
			}else{
				//report Failure - Extent report
				System.out.println("Response code not 200 ok");
			}
			i++;
		}

	}
	
	private boolean getResponseCode(String url) {
		int response_code=0;
		try{
		response_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
		System.out.println("Response code for url -> "+url+" is -> "+response_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(response_code==200)
			return true;
		else
			return false;
	}

	public boolean isElementPresent(String Locator, String LocatorType){
		int count=0;
		if(LocatorType.equals("xpath")){
			count = driver.findElements(By.xpath(Locator)).size();
		}else if(LocatorType.equals("cssSelector")){
			count = driver.findElements(By.cssSelector(Locator)).size();
		}else if(LocatorType.equals("id")){
			count = driver.findElements(By.id(Locator)).size();
		}else if(LocatorType.equals("name")){
			count = driver.findElements(By.name(Locator)).size();
		}//we can write if-else for all locator type here e.g. tagname, class, linktext, partiallinktext etc...
		
		if(count==0)
			return false;
		else
			return true;
	}
	
	@AfterMethod
	public void quit(){
		driver.quit();
	}
		
		
public FirefoxOptions loadFirefoxOptions(){
		
		//PreRequisites - use 2-3 older version of latest version of Firefox
		
		//Logs coming in Console mixing with code outputs
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\Selenium\\selenium.log");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
		
		FirefoxOptions opt = new FirefoxOptions();
		
		//Binary/EXE file missing error by Selenium
		opt.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");	 
		
		//Page Load Strategy - actions taken after or before page loaded completely
		//opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);//default behaviour, browser actions taken after page loaded completely
		//opt.setPageLoadStrategy(PageLoadStrategy.NONE);//browser actions taken before page loads completely - faster
		opt.setPageLoadStrategy(PageLoadStrategy.EAGER);//same as NONE but faster
		
		
		//Firefox Profiling
		ProfilesIni allProf = new ProfilesIni();
		FirefoxProfile myProf = allProf.getProfile("dev-edition-sanjay");
		//opt.setProfile(myProf);
	
		//Notification disabling
		//ProfilesIni allProf = new ProfilesIni();
		//FirefoxProfile myProf = allProf.getProfile("dev-edition-sanjay");
		myProf.setPreference("dom.webnotifications.enabled", false);
		//opt.setProfile(myProf);
		
		//Certificate Issues Old code
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		opt.merge(cap);	 
		
		//Certificate Error Latest Selenium version 3.8 onwards
		//FirefoxProfile myProf = new FirefoxProfile();
		myProf.setAcceptUntrustedCertificates(true);
		myProf.setAssumeUntrustedCertificateIssuer(false);
		//opt.setProfile(myProf);
		
		//Proxy Server Handling
		/*FirefoxProfile myProf = new FirefoxProfile();
		myProf.setPreference("network.proxy.type", 1);
		myProf.setPreference("network.proxy.socks", "83.209.94.87");
		myProf.setPreference("network.proxy.socks_port", 3343);*/
		
		opt.setProfile(myProf);
		
		return opt;
		
	}
	

}

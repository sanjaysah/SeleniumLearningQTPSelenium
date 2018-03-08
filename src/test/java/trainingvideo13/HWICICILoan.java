package trainingvideo13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HWICICILoan {
	String browser="chrome";
	WebDriver driver;
	//https://loan.icicibank.com/asset-portal/#!/auto-loan/check-eligibility?WT.mc_id=NLI_Apply_Online_page
	@Test
	public void testLoanFormFill() throws InterruptedException, ParseException{
		
		if(browser.equals("firefox")){
			driver=new FirefoxDriver(loadFirefoxOptions());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}else if(browser.equals("chrome")){
			driver=new ChromeDriver(loadChromeOptions());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}else if(browser.equals("IE")){
			driver=new InternetExplorerDriver(loadIEOptions());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}else if(browser.equals("Edge")){
			driver=new EdgeDriver(loadEdgeOptions());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		//get url
		driver.get("https://loan.icicibank.com/asset-portal/#!/auto-loan/check-eligibility?WT.mc_id=NLI_Apply_Online_page");
		//select car type dropdown
		driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div/form/div[2]/div[1]/div/div/button")).click();
		driver.findElement(By.xpath("//span[text()='New Car Loan']")).click();
		//enter mobile number
		driver.findElement(By.xpath("//*[@id='mobileNumber']")).sendKeys("9739606237");
		//Locator here - //span[@class='input input--hoshi']/input, returns 10 elements but the first one on page is what we want and findelement returns the same
		//enter place you live in
		driver.findElement(By.xpath("//span[@class='input input--hoshi']/input")).sendKeys("Bengaluru");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@ng-bind-html='match.label | iciciTypeaheadHighlight:query']")));
		driver.findElement(By.xpath("//span[@class='input input--hoshi']/input")).sendKeys(Keys.ENTER);

		//select dropdown car type to buy
		driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div/form/div[5]/div[2]/div/div/button/span[1]")).click();
		driver.findElement(By.xpath("//a/span[text()='Owned']")).click();
		//select dropdown, when car bought
		driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div/form/div[6]/div[1]/div/div/div[1]/div/button/span[1]")).click();
		driver.findElement(By.xpath("//span[text()='<2013']")).click();
		//Enter Date OF Birth
		String dob ="04/04/1983";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(dob);
		String day = new SimpleDateFormat("dd").format(date);
		System.out.println(day);
		String month = new SimpleDateFormat("MMM").format(date);
		System.out.println(month);
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		driver.findElement(By.xpath("//img[@ng-src='assets/images/calendar.svg']")).click();
		
		//once year is found, click and exit while loop
		while(true){
			String CalYear = driver.findElement(By.xpath("//*[starts-with(@id,'datepicker-')]/strong")).getText();
			StringTokenizer strTok = new StringTokenizer(CalYear, " - ");
			int lowerYearRange = Integer.parseInt(strTok.nextToken());
			//System.out.println(lowerYearRange);
			int highYearRange = Integer.parseInt(strTok.nextToken());		
			//System.out.println(highYearRange);
			if(year>lowerYearRange&&year<highYearRange){
				driver.findElement(By.xpath("//*[starts-with(@id,'datepicker-')]/button/span[text()='"+year+"']")).click();
				break;
			}else if(year<highYearRange){
				driver.findElement(By.xpath("//*[@class='btn btn-default btn-sm pull-left']")).click();
			}else if(year>lowerYearRange){
				driver.findElement(By.xpath("//*[@class='btn btn-default btn-sm pull-right']")).click();
			}
		}
		
		//select Date and Month
		driver.findElement(By.xpath("//input[contains(@ng-class,'month')]")).click();
		driver.findElement(By.xpath("//*[starts-with(@id,'datepicker-')]/button/span[text()='"+month+"']")).click();
		driver.findElement(By.xpath("//input[contains(@ng-class,'day')]")).click();
		driver.findElement(By.xpath("//*[starts-with(@id,'datepicker-')]/button/span[text()='"+day+"']")).click();
		
		//Choose yes or no radio button for dealer selected
		driver.findElement(By.xpath("//label[@for='dealerIdentifiedNo']")).sendKeys(Keys.ENTER);
		//Select dropdown, car model
		driver.findElement(By.xpath("//*[@id='makeAndModel']")).sendKeys("Chevrolet Beat LS Diesel");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@ng-bind-html='match.label | iciciTypeaheadHighlight:query']")));
		driver.findElement(By.xpath("//*[@id='makeAndModel']")).sendKeys(Keys.ENTER);
		//Select dropdown type of employment
		driver.findElement(By.xpath("//label[@for='employment-type']/following-sibling::div/button/span")).click();
		driver.findElement(By.xpath("//span[text()='Salaried']")).click();
		////Type and select company working
		driver.findElement(By.xpath("//input[@icici-typeahead='obj.companyName for obj in showCompanies($viewValue)']")).sendKeys("GOOGLE");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@ng-bind-html='match.label | iciciTypeaheadHighlight:query']")));
		driver.findElement(By.xpath("//input[@icici-typeahead='obj.companyName for obj in showCompanies($viewValue)']")).sendKeys(Keys.ENTER);
		//Select dropdown joining year
		driver.findElement(By.xpath("//button[@data-id='joiningDate']")).click();
		driver.findElement(By.xpath("//button[@data-id='joiningDate']/following::div/ul//span[text()='2017']")).click();
		//select dropdown joining month
		driver.findElement(By.xpath("//button[@data-id='joiningDate']/parent::div/parent::div/following::div/div/button/span[text()='Select']")).click();
		driver.findElement(By.xpath("//button[@data-id='joiningDate']/parent::div/parent::div/following::div/div/button/span[text()='Select']/following::div[2]/ul//span[text()='Jan']")).click();
		//dropdown - no of years employed/working 
		driver.findElement(By.xpath("//label[text()='Your Total Work Experience']/following::div/button")).click();
		driver.findElement(By.xpath("//label[text()='Your Total Work Experience']/following::div/button/following::div/ul/li//span[text()='5']")).click();
		//take home monthly salary 
		driver.findElement(By.xpath("//*[@id='step1-salary']")).sendKeys("80000");
		//gross monthly salary 
		driver.findElement(By.xpath("//*[@id='step1-grossFixedMonthlySal']")).sendKeys("100000");
		// emi going from salary per month
		driver.findElement(By.xpath("//*[@id='step1-emiPerMonth']")).sendKeys("0");
		//radio button relation ship with icici yesy or no
		driver.findElement(By.xpath("//label[@for='iciciBankRelationNo']/span")).click();
		//submit button click
		driver.findElement(By.cssSelector("input.col-xs-1.ng-pristine.ng-untouched.ng-invalid.ng-invalid-required")).click();
		//driver.findElement(By.cssSelector("button.btn.blue.btnMainStep1")).click();
		
		Thread.sleep(3000);
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
	
	public ChromeOptions loadChromeOptions(){
			
		//PreRequisites - Latest version of Firefox and Driver
		
		//Logs coming in Console mixing with code outputs
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"C:\\Selenium\\seleniumChrome.log");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		
		ChromeOptions opt = new ChromeOptions();
		
		//Binary/EXE file missing error by Selenium - same as FIrefox
		opt.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");	 
		
		//Page Load Strategy - actions taken after or before page loaded completely - same as Chrome
		//opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);//default behaviour, browser actions taken after page loaded completely
		//opt.setPageLoadStrategy(PageLoadStrategy.NONE);//browser actions taken before page loads completely - faster
		//opt.setPageLoadStrategy(PageLoadStrategy.EAGER);//same as NONE but faster
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "normal");
		opt.merge(cap);
		
		
		//Chrome Profiling - It can be done with Gmail login only - DIFF than Firefox
		opt.addArguments("user-data-dir=C:\\Users\\Sanjay Kumar\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\");
		
		//Maximize -  new
		opt.addArguments("--start-maximized");

		//Infobar disabling
		opt.addArguments("--disable-infobars");
		
		//Notification disabling
		opt.addArguments("--disable-notifications");
		
		//Proxy Servers
		//opt.addArguments("--proxy-server=https://83.209.94.87:8855");
		
		//Certificate Issues - Chrome auto handlesthe certification issue, so no need to handle
		
		return opt;
			
		}
	
	public InternetExplorerOptions loadIEOptions(){
		
		//PreRequisites ----------------
				// 1 - Latest version of IE is 11 and will not upgrade further
				// 2 - Zoom Level 100%
				// 3 - Internet Options - Security - Protected mode disable(chckbox)
				// 4 - Internet Options - Security - all Leveller arrow down at bottom lower
				// 5 - Internet Options - Advanced - Security - checkbox  "Allow active content to run in files on .." ON/Selected 
				
				//Logs coming in Console mixing with code outputs
				//System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY,"C:\\Selenium\\seleniumIE.log");
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
		return opt;
		
	}
	
	public EdgeOptions loadEdgeOptions(){
		
		//PreRequisites ----------------
		// 1 - Latest version of IE is 11 and will not upgrade further
		// 2 - Zoom Level 100%
		// 3 - Internet Options - Security - Protected mode disable(chckbox)
		// 4 - Internet Options - Security - all Leveller arrow down at bottom lower
		// 5 - Internet Options - Advanced - Security - checkbox  "Allow active content to run in files on .." ON/Selected 
		
		//Logs coming in Console mixing with code outputs
		//System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"C:\\Selenium\\seleniumEdge.log");
		System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"null");
		
		EdgeOptions opt = new EdgeOptions();
		
		//Binary/EXE file missing error by Selenium - NO FACILITY BY Edge

		//Page Load Strategy - actions taken after or before page loaded completely
		//opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);//default behaviour, browser actions taken after page loaded completely
		//opt.setPageLoadStrategy(PageLoadStrategy.NONE);//browser actions taken before page loads completely - faster
		opt.setPageLoadStrategy("eager");//same as NONE but faster
		
		
		//Chrome Profiling - NO FACILITY BY Edge

		
		//Notification disabling - NO FACILITY BY Edge
		
		//Proxy Servers - NO FACILITY BY Edge
		
		//Certificate Issues - std 2 lines of code for IE
		/*EdgeDriver driver = new EdgeDriver(opt);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://untrusted-root.badssl.com/");//certificate issue
		driver.findElement(By.id("moreInformationDropDownSpan")).click();
		driver.findElement(By.id("Invalidcert_continue")).click();*/
		return opt;
		
	}

}

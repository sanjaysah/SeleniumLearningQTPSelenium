package trainingvideo12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HWAmericanGolf {
	
	@Test
	public void americanGolf(){
		ChromeOptions opt = new ChromeOptions();

		//Info Bars close
		opt.addArguments("--disable-infobars");
		//Notifications disabled
		opt.addArguments("--disable-notifications");
		//Maximize -  new
		opt.addArguments("--start-maximized");

		//Chrome Profiling - It can be done with Gmail login only - DIFF than Firefox
		opt.addArguments("user-data-dir=C:\\Users\\Sanjay Kumar\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\");
		
		//Page Load Strategy - actions taken after or before page loaded completely 
		//opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);//default behaviour, browser actions taken after page loaded completely
		//opt.setPageLoadStrategy(PageLoadStrategy.NONE);//browser actions taken before page loads completely - faster
		//opt.setPageLoadStrategy(PageLoadStrategy.EAGER);//same as NONE but faster
		
		//Binary/EXE file missing error by Selenium - same as FIrefox
		opt.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");	 
	
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get("https:\\www.americangolf.co.uk");
		//driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[5]/div/div/div[1]/a/i")).click();
		driver.findElement(By.xpath("//*[@id='header-navigation']/div[2]/div[4]/div/div[2]/a/i")).click();
		String shopCartText = driver.findElement(By.cssSelector("#cart > h1")).getText();
		System.out.println(shopCartText);
		driver.quit();
	}

}

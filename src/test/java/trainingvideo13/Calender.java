package trainingvideo13;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender {
	@Test
	public void calenderTest() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//get url
		driver.get("https://loan.icicibank.com/asset-portal/#!/auto-loan/check-eligibility?WT.mc_id=NLI_Apply_Online_page");
		//Enter Date OF Birth
		String dob ="24/11/1983";
		String day = "24";
		String month = "11";
		String year = "1983";
		driver.findElement(By.xpath("//*[@id='city-map-icon']")).click();
		
		String CalYear = driver.findElement(By.xpath("//*[@id='datepicker-335-5297-title']/strong")).getText();
		StringTokenizer strTok = new StringTokenizer(CalYear, " - ");
		String lowerYearRange = strTok.nextToken();
		System.out.println(lowerYearRange);
		String highYearRange = strTok.nextToken();		
		System.out.println(highYearRange);
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}

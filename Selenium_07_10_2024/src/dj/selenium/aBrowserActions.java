package dj.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class aBrowserActions {

	public static void main(String[] args) throws InterruptedException {
		//1.Launch Browser
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		
		//2.get the given url page or navigate to url ;
		driver.get("https://www.chatgpt.com");
		Thread.sleep(2000);
		
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		
		//3.getTitle of the URL
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		
		//4.get current url
		String url=driver.getCurrentUrl();
		System.out.println("URL: "+url);
		
		//5.get pageSource
		String pageSource = driver.getPageSource();
		//System.out.println("pageSource: "+pageSource);
		
		//6.navigate()
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().forward();
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.chatgpt.com");
		Thread.sleep(2000);
		
		//7.maximize(),minimize()
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.manage().window().minimize();
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//close browser
		//driver.close();
		
		//to get the address of the current browser
		String s = driver.getWindowHandle();
		System.out.println(s);
		
	}

}

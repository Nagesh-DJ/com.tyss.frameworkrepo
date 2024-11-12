package dj.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class aLaunchBrowser {

	public static void main(String[] args) {
		//To launch a browser
		WebDriver   driver=new ChromeDriver();
					driver=new FirefoxDriver();
					driver=new InternetExplorerDriver();

	}

}

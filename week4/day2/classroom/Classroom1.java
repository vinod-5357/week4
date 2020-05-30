package week4.day2.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.chrome.ChromeDriver;


public class Classroom1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		driver.switchTo().frame("iframeResult");

		Thread.sleep(1000);

		driver.findElementByXPath("//button[text()='Try it']").click();

		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);

		alert.sendKeys("VinodKumar");

		alert.accept();

		Thread.sleep(2000);

		String text = driver.findElementByXPath("//p[@id='demo']").getText();

		System.out.println("Entered input text :"+text);

		if(text.contains(text)) {

			System.out.println("Enter input exist"); }

		else {

			System.out.println("Entered input do not exist"); }




	}


}



package week4.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MergeLead {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64 bit.exe");




		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement username= driver.findElementByXPath("(//input[@class= 'inputLogin'])[1]");
		username.sendKeys("Demosalesmanager");

		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("crmsfa");

		WebElement login= driver.findElement(By.xpath("//input[@class= 'decorativeSubmit']"));
		login.click();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		WebElement Link1= driver.findElement(By.xpath("(//a)[2]"));
		Link1.click();

		driver.findElementByXPath("//a[text()='Contacts']").click();

		driver.findElementByXPath("//a[text()='Merge Contacts']").click();


		WebElement mainwindow= driver.findElementByXPath("(//img[@alt='Lookup'])[1]");

		mainwindow.click();


		Set<String> Windows = driver.getWindowHandles();

		List<String> listHandles = new ArrayList<String>(Windows);

		String mergeWindow = listHandles.get(1);

		driver.switchTo().window(mergeWindow);

		Thread.sleep(2000);

		driver.findElementByXPath("(//a[@class='linktext'])[1]").click();

		Thread.sleep(2000);

		driver.switchTo().window(listHandles.get(0));

		Thread.sleep(2000);

		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();

		Thread.sleep(2000);


		Set<String> Windows2 = driver.getWindowHandles();

		List<String> listHandles2 = new ArrayList<String>(Windows2);

		String mergeWindow2 = listHandles2.get(1);

		driver.switchTo().window(mergeWindow2);


		
		Thread.sleep(2000);

		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]").click();

		Thread.sleep(2000);

		driver.switchTo().window(listHandles.get(0));



		driver.findElementByXPath("//a[@class='buttonDangerous']").click();

		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);

		alert.accept();

		Thread.sleep(5000);

		String title= driver.getTitle();

		System.out.println(title);





	}

}

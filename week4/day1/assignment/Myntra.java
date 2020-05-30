package week4.day1.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.myntra.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement women = driver.findElementByXPath("//a[text()='Women']");

		Actions builder = new Actions(driver);

		builder.moveToElement(women).perform();

		Thread.sleep(2000);

		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();

		Thread.sleep(2000);

		String TotalcountOfItems = driver.findElementByXPath("//span[@class='title-count']").getText();

		String count = TotalcountOfItems.replaceAll("[^0-9.]", "");

		int Totalcount = Integer.parseInt(count);

		System.out.println("Total count of jackets & Coats =" + Totalcount);

		driver.findElementByXPath("//span[text()='Categories']");

		String jackets = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();

		String jacketscount = jackets.replaceAll("[^0-9.]", "");

		int Totaljacket = Integer.parseInt(jacketscount);

		System.out.println("Total count of jackets =" + Totaljacket);

		String coat = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();

		String coatsCount = coat.replaceAll("[^0-9.]", "");

		int Totalcoat = Integer.parseInt(coatsCount);

		System.out.println("Total count of Coats =" + Totalcoat);

		if ((Totaljacket + Totalcoat) == (Totalcount)) {

			System.out.println("Total count of items matched with number of jackets and Coats ");

		} else

		{

			System.out.println("Total count of items unmatched with number of jackets and coats");

		}

		driver.findElementByXPath("//div[@class='brand-more']").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("Mango");

		  driver.findElementByXPath("//label[@class=' common-customCheckbox']//div[1]").click();
		  //Close the pop-up x
		  
		  driver.findElementByXPath("//div[@class='FilterDirectory-titleBar']//span[1]").click();
		  
		  Thread.sleep(2000);
		  //Confirm all the Coats are of brand MANGO  
		  int mangocount=0;
		  List<WebElement> text=driver.findElementsByXPath("//h3[@class='product-brand']");
		  
		  String name="MANGO";
		 for (WebElement mango : text) {
			 String eachbrandname=mango.getText();
			 if(eachbrandname.equals(name))
			 {
			  mangocount++;
			 }
			
			
		}
		 if(mangocount!=0)
		 {
			 System.out.println("mango name matched");
		 }
		 // Sort by Better Discount
		 
		 driver.findElementByXPath("//div[@class='sort-sortBy']").click();

		 driver.findElementByXPath("//label[text()='Better Discount']").click();
		//Find the price of first displayed item    
		 String firstprice=driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
		 System.out.println(firstprice);
		 //Mouse over on size of the first item
		 WebElement firstitem=driver.findElementByXPath("//div[@class='product-sliderContainer']");
		 builder.moveToElement(firstitem).perform();;
		 Thread.sleep(2000);
		 //Click on WishList Now
		 driver.findElementByXPath("(//span[text()='wishlist'])[1]").click();

		Thread.sleep(2000);

		driver.close();

	}

}

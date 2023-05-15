package phase1project;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	
		WebElement AmazonSearch=driver.findElement(By.xpath("//input[@placeholder='Search Amazon']"));
		AmazonSearch.sendKeys("samsung mobiles");
		Thread.sleep(2000);
		
		WebElement ClickSearch=driver.findElement(By.xpath("//input[@type='submit']"));
		ClickSearch.click();
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("image.png");
		
		FileUtils.copyFile(fileObj,screenshotObj);
		
		List<WebElement> ProductList=driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		List<WebElement> PriceList=driver.findElements(By.xpath("//div[@class='a-section']//a//span[@class='a-price-whole']"));
		List<WebElement> CurrencyList=driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		
		for(int i=0;i<ProductList.size();i++)
		{
			System.out.println("Product is : "+ ProductList.get(i).getText());
			System.out.println("Product is : "+ CurrencyList.get(i).getText() + " " + PriceList.get(i).getText());
		}
		
		
		
		driver.close();
	}

}

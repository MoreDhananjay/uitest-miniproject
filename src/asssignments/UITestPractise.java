package asssignments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UITestPractise {
	WebDriver driver;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  //System.setProperty("webdriver.chrome.driver", "provideChromeDriverExePath");
	  driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	  driver.manage().window().maximize();
 }
  
  @Test
  public void verifyHomePage() {
	  driver.get("https://www.google.com/");
	  
	  String actTitle = driver.getTitle();
	  String expTitle = "Google";
	  sft=new SoftAssert();
	  sft.assertEquals(actTitle, expTitle);
	  String pageURL = driver.getCurrentUrl();
	  sft.assertTrue(pageURL.contains("google"), pageURL);
	  driver.findElement(By.id("APjFqb")).sendKeys("selenium");
	  sft.assertAll();	   
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}

package demo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.*;

import page.GmailInboxPage;
import page.GmailLoginPage;
import junit.framework.TestCase;;
public class LoginGmailExample extends TestCase{
	private WebDriver driver;
	
	public void  testGmailLogin() throws FindFailed {
		Screen screen =  new Screen();
		Pattern gmail_link =  new Pattern("\\images\\gmail\\gmail_link.png");
//		Pattern email_field =  new Pattern("\\images\\gmail\\email_field.png");
//		Pattern next =  new Pattern("\\images\\gmail\\next_after_email.png");
//		Pattern pass_field =  new Pattern("\\images\\gmail\\password_field.png");
//		Pattern init_session =  new Pattern("\\images\\gmail\\init_session.png");		
		driver =  new FirefoxDriver();
		String email =  "making.sikuli@gmail.com";
		String password = "pswd1234";
		GmailInboxPage gmailInbox;
		GmailLoginPage gmailLoginPage;
		String lastEmailSubject;
		boolean present;
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		screen.wait(gmail_link, 10);
		screen.click(gmail_link);
		gmailLoginPage =  new GmailLoginPage(driver, screen);
		gmailLoginPage.performLogin(email, password);
//		screen.wait(email_field, 10);		
//		screen.paste(email_field, email);
//		screen.click(next);
//		screen.wait(pass_field, 10);
//		screen.type(pass_field, password);
//		screen.click(init_session);
		gmailInbox =  new GmailInboxPage(driver,screen);
		gmailInbox.gmailComposeMail();
		lastEmailSubject =  gmailInbox.lastSubject();		
		try {
		   //driver.findElement(By.xpath("//b[text()='"+lastEmailSubject+"']"));
		   WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		   .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[text()='"+lastEmailSubject+"']")));
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		}
		Assert.assertTrue(present);
	}
	public void tearDown(){
		driver.close();
		driver.quit();
	}	
}

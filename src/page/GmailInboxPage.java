package page;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.*;
public class GmailInboxPage {
	private final WebDriver driver;
	private final Pattern composeButton; 
	private final Pattern toField;
	private final Pattern subjectField;
	private final Pattern bodyArea;
	private final Pattern sendButton;
	private final Pattern updateInbox;
	private String emailsubject;
	Screen screen;
	public GmailInboxPage(WebDriver driver, Screen screen){
		this.driver =  driver;
		composeButton =  new Pattern("\\images\\gmail\\compose.png");
		toField =  new Pattern("\\images\\gmail\\to.png");
		subjectField =  new Pattern("\\images\\gmail\\subject.png");
		bodyArea =  new Pattern("\\images\\gmail\\body.png");
		sendButton =  new Pattern("\\images\\gmail\\send.png");
		updateInbox =  new Pattern("\\images\\gmail\\updateInbox.png");
		this.screen = screen;
	}
	public void gmailComposeMail(){
		//WebElement composeButton;
		Date dNow = new Date( );
		SimpleDateFormat subjectdate = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh.mm.ss a zzz");
		emailsubject="Current time "+subjectdate.format(dNow).toString();
		String tomailid ="making.sikuli@gmail.com";
		String mailBody ="Great to sent email :-)"+"\n" + "Regards,"+"\n"+"Tester";
		//composeButton = driver.findElement(By.xpath("//div[text()='REDACTAR']"));
		//composeButton.click();
		try {
			screen.wait(composeButton, 10);
			screen.click(composeButton);
			screen.wait(toField, 10);
			screen.click(toField);
			screen.paste(toField,tomailid);
			screen.click(subjectField);
			screen.paste(subjectField,emailsubject);
			screen.click(bodyArea);
			screen.paste(bodyArea,mailBody);
			screen.click(sendButton);
			screen.click(updateInbox);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String lastSubject(){
		return emailsubject;
	}
}

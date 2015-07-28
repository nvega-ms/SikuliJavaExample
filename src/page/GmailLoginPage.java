package page;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GmailLoginPage {
	private final Screen screen;
	private final WebDriver driver;
	private final Pattern emailField;
	private final Pattern nextButton;
	private final Pattern passwordField;
	private final Pattern initSessionButton;
	public GmailLoginPage(WebDriver driver, Screen screen){
		this.screen = screen;
		this.driver = driver;
		 emailField =  new Pattern("\\images\\gmail\\email_field.png");
		 nextButton =  new Pattern("\\images\\gmail\\next_after_email.png");
		 passwordField =  new Pattern("\\images\\gmail\\password_field.png");
		 initSessionButton =  new Pattern("\\images\\gmail\\init_session.png");	
	}
	public void  performLogin(String email, String password){
		try {
			screen.wait(emailField, 10);
			screen.paste(emailField, email);
			screen.click(nextButton);
			screen.wait(passwordField, 10);
			screen.type(passwordField, password);
			screen.click(initSessionButton);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
}

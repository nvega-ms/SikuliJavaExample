package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.junit.Assert;
import org.junit.Test;
import junit.framework.TestCase;

public class AngryBirdsExample extends TestCase{
		private WebDriver driver;

		public void testAngryBirds() throws Exception{
			Screen screen =  new Screen();
			Pattern start =  new Pattern("\\images\\angrybirds\\start.png");
			Pattern levelSelect =  new Pattern("\\images\\angrybirds\\level_select_1.png");
			Pattern scenarioSelect =  new Pattern("\\images\\angrybirds\\scenario_1.png");
			Pattern tutorialOk =  new Pattern("\\images\\angrybirds\\tutorial_1_ok.png");
			Pattern tutorialOk2 =  new Pattern("\\images\\angrybirds\\test.png");
			Pattern tutorialOk3 =  new Pattern("\\images\\angrybirds\\test.png");
			Pattern bird =  new Pattern("\\images\\angrybirds\\bird.png");
			Pattern drop =  new Pattern("\\images\\angrybirds\\drop.png");
			Pattern page_end =  new Pattern("\\images\\angrybirds\\page_end.png");
			Pattern succeed =  new Pattern("\\images\\angrybirds\\succeed.png");
			Pattern score =  new Pattern("\\images\\angrybirds\\score.png");
			driver =  new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://srv1.us.gamex.com/files/games/angry-birds-rio-online-2630.swf");
			screen.wait(start, 10);
			screen.click(start);
			screen.wait(levelSelect, 10);
			screen.click(levelSelect);
			screen.wait(scenarioSelect, 10);
			screen.click(scenarioSelect);
			screen.wait(page_end,10);
			screen.wait(tutorialOk, 10);
			screen.click(tutorialOk);
			screen.wait(tutorialOk2, 10);
			screen.click(tutorialOk2);
			screen.wait(tutorialOk3, 10);
			screen.click(tutorialOk3);
			screen.dragDrop(bird, drop);
			Match match = screen.exists(succeed,20);
			Assert.assertNotNull(match);
		}

		public void tearDown(){
			driver.close();
			driver.quit();
		}	
		
}

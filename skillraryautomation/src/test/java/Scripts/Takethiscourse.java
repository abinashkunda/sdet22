package Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import genericlibrary.PropertyFile;
import pomPages.SeleniumPage;
import pomPages.SkillraryLoginPage;
import pomPages.Takethiscoursepage;

public class Takethiscourse extends BaseClass {
	@Test
	public void tc2() throws IOException, InterruptedException {
		SkillraryLoginPage s=new SkillraryLoginPage(driver);
		s.searchTextbox(PropertyFile.getData("coursename"));
		s.searchbutton();
		
		SeleniumPage sel=new SeleniumPage(driver);
		sel.corejavacourse();
		
		Takethiscoursepage t=new Takethiscoursepage(driver);
		utilities.SwitchFrame(driver);
		t.playbutton();
		Thread.sleep(15000);
		t.pausebutton();
		utilities.SwitchBackFrame(driver);
		Thread.sleep(3000);
		t.takethiscoursebtn();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(),PropertyFile.getPropertyfile("loginpageurl"));
		
		
		
		
	}

}


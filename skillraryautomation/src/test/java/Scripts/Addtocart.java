package Scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import pomPages.AddtocartPage;
import pomPages.SkillraryDemoLogin;
import pomPages.SkillraryLoginPage;

public class Addtocart extends BaseClass {
	@Test
	public void tc1() throws FileNotFoundException, IOException {
	SkillraryLoginPage s=new SkillraryLoginPage(driver);
	s.gearsButton();
	s.skillrarydemoApplication();
	
	utilities.switchTabs(driver);
	SkillraryDemoLogin d=new SkillraryDemoLogin(driver);
	utilities.mouseHover(driver,d.getCoursebtn());
	d.Seleniumtraining();
	
	AddtocartPage a=new AddtocartPage(driver);
	utilities.doubleClick(driver,a.getAddbtn());
	a.addtocartbutton();
	utilities.alertpopup(driver);
	
	Assert.assertEquals(driver.getTitle(),pdata.getData("addtocarttitle"));
	Reporter.log(driver.getTitle(),true);

}
}


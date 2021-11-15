package axaSearch;
import axaPages.loginPage;
import axaPages.SearchPage;
import com.sumerge.momra.tests.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class validateSearchButton {

    ChromeDriver driver ;

    @BeforeMethod
    public void openURL()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:4200/search-prospect");
    }

    @Test
    public void ValidateSearchBtn ()
    {
        loginPage clickObj = new loginPage(driver);
        clickObj.clickSubmit();
        clickObj.clickSearchProspect();
        SearchPage field = new SearchPage(driver);
        field.setFirstname("Ahmed");
        field.setLastname("elmoghazy");
        field.setPolicyNo("p123");
        field.setFaName("FANAME");
        field.setTicketNo("t123");
        field.setSerialNo("s123");
        field.setDateOfBirthFrom("01012001");
        field.setDateOfBirthTo("11112011");
        field.setFollowUpDateFrom("02022002");
        field.setFollowUpDateTo("12122012");
        field.selectProspectStatus("Pending");
        field.selectFollowUpAction("call");
        field.selectBranch("CIB");
        field.selectBankStaff("Pending");
        field.Search();

    }

    @Test
    public void ValidateClearFiltersBtn ()
    {
        loginPage clickObj = new loginPage(driver);
        clickObj.clickSubmit();
        clickObj.clickSearchProspect();
        SearchPage field = new SearchPage(driver);
        field.setFirstname("Ahmed");
        field.setLastname("elmoghazy");
        field.setPolicyNo("p123");
        field.setFaName("FANAME");
        field.setTicketNo("t123");
        field.setSerialNo("s123");
        field.setDateOfBirthFrom("01012001");
        field.setDateOfBirthTo("11112011");
        field.setFollowUpDateFrom("02022002");
        field.setFollowUpDateTo("12122012");
        field.selectProspectStatus("Pending");
        field.selectFollowUpAction("call");
        field.selectBranch("CIB");
        field.selectBankStaff("Pending");
        field.ClearFilters();

    }
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}

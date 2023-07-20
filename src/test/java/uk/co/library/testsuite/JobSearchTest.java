package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;

@Listeners(CustomListeners.class)
public class JobSearchTest extends BaseTest {
    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod
    public void inIT(){
        homePage = new HomePage();
    }
    @Test(dataProvider ="Job Search",dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobtitle , String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result){


homePage.jobSearch(jobtitle,location,distance,salaryMin,salaryMax,salaryType,jobType,result);
       // Assert.assertEquals(resultPage.verifyTheResults(), result, "Result Not Found");
    }





}

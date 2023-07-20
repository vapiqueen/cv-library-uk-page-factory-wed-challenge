package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobtitle;

    @CacheLookup
    @FindBy(xpath = "//input[@id='location']")
    WebElement location;

    @CacheLookup
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[@id='toggle-hp-search']" )
    WebElement moreSearchOptionsLink;

    @CacheLookup
    @FindBy(xpath="//input[@id='salarymin']")
    WebElement MinSalary;

    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement MaxSalary;

    @CacheLookup
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement SalaryTypeDropDown;

    @CacheLookup
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement JobTypeDropDown;


     @CacheLookup
             @FindBy(xpath ="//input[@id='hp-search-btn']")
              WebElement FindJobButton;


    @CacheLookup
    @FindBy(xpath = "//span//div//span[normalize-space()='Accept All']")
    WebElement acceptCookies;


    public void enterJobTitle(String jobTitle){
         sendTextToElement(jobtitle,jobTitle);
         CustomListeners.test.log(Status.PASS,"enterJobTittle");
         Reporter.log("enterJobTittle"+jobtitle.toString());


     }
     public void enterLocator(String locations){
         sendTextToElement(location,locations);
         CustomListeners.test.log(Status.PASS,"enterLocator");
         Reporter.log("enterLocator"+location.toString());
     }
     public void selectDistance(String distance){
         selectByVisibleTextFromDropDown(distanceDropdown,distance);
         CustomListeners.test.log(Status.PASS,"selectDistance");
         Reporter.log("selectDistance"+location.toString());
     }
     public void clickOnMoreSearchOptionLink(){
         clickOnElement(moreSearchOptionsLink);
         CustomListeners.test.log(Status.PASS,"ClickOnMoreSearchOptionLink");
         Reporter.log("ClickOnMoreSearchOptionLink"+moreSearchOptionsLink.toString());
     }
     public void enterMinSalary(String minSalary){
         sendTextToElement(MinSalary,minSalary);
         CustomListeners.test.log(Status.PASS,"enterMinimumSalary");
         Reporter.log("enterMinimumSalary"+MinSalary.toString());
     }
     public void enterMaxSalary(String maxSalary){
         sendTextToElement(MaxSalary,maxSalary);
         CustomListeners.test.log(Status.PASS,"enterMaximumSalary");
         Reporter.log("enterMaximumSalar"+MaxSalary.toString());
     }
     public void selectSalaryType(String sType){
         selectByVisibleTextFromDropDown(SalaryTypeDropDown,sType);
         CustomListeners.test.log(Status.PASS,"selectSalaryType");
         Reporter.log("selectSalaryType"+SalaryTypeDropDown.toString());
     }
     public void selectJobType(String jobType){
         selectByVisibleTextFromDropDown(JobTypeDropDown,jobType);
         CustomListeners.test.log(Status.PASS,"selectJobType");
         Reporter.log("selectJobType"+JobTypeDropDown.toString());
     }
     public void clickOnFindJobsButton(){
         clickOnElement(FindJobButton);
         CustomListeners.test.log(Status.PASS,"clickOnFindButton");
         Reporter.log("clickOnFindButton"+FindJobButton.toString());
     }
    public void setAcceptCookies() {


        System.out.println("we are switching to iFrame");
        clickOnElement(acceptCookies);//click on Acceptall
        System.out.println("We are done with iFrame");

        driver.switchTo().defaultContent();//switch to default window
    }
    public void jobSearch(String jobtitle , String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String resultS){
        enterJobTitle(jobtitle);
        enterLocator(location);
       selectDistance(distance);
        clickOnMoreSearchOptionLink();
       enterMinSalary(salaryMin);
       enterMaxSalary(salaryMax);
        selectSalaryType(salaryType);
        selectJobType(jobType);
        clickOnFindJobsButton();

    }
}


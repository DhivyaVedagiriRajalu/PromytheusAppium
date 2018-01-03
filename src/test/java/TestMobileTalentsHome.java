import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

public class TestMobileTalentsHome {
    //String title;
    WebDriverWait waitVar;
    TalentsHomePage objTalentsHome;
    public static AndroidDriver  driver;
    //for data provider
    String excelPath="C:\\Users\\Dhivya Balaji\\IdeaProjects\\ProMyTheUs\\src\\test\\TestData\\TestData.xlsx";
    String sheetName="Sheet1";
    //private String sTestCaseName;
    public int iTestCaseRow;

    @BeforeTest
    public void setup() throws Exception{
        driver = TestMobileApplication.driver;
        objTalentsHome = new TalentsHomePage(driver);
        TalentsHomePage.mobile=true;
    }
    //click new tab in talents page
    @Test(enabled = false, groups = {"newTalent"}, priority = 2 ,dataProvider="TestData")
    public void test_click_new_tab(String title) throws Exception{
        objTalentsHome.clickNew();
        waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);

    }
    //click logo in the talents page
    @Test(enabled = false, priority = 3 ,dataProvider="TestData")
    public void test_navigation_by_clicking_logo(String title) throws Exception{
        objTalentsHome.clickLogo();
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);
    }

    //Select category to created new talent
    @Test(enabled = false,groups = {"newTalent"}, priority = 4)
    public void test_create_new_talent() throws Exception{
        objTalentsHome.clickCategory_selectOption();
    }

    //Enter firstName and lastName in Personal tab
    @Test(enabled = false,groups = {"newTalent"}, priority = 5 ,dataProvider="TestData")
    public void test_enter_firstName_lastName(String firtName,String lastName) throws Exception{
        objTalentsHome.enter_firstName_lastName(firtName,lastName);
    }

    //Enter address and contact details in Personal tab
    @Test(enabled = false,groups = {"newTalent"}, priority = 6 ,dataProvider="TestData")
    public void test_enter_address_phone(String street, String city, String email, String phone, String state, String zip) throws Exception{
        objTalentsHome.enter_address_contact(street,city,email,phone,state,zip);
    }


    //Click quick test tab and finish button in new talent creation page
    @Test(enabled = false,groups = {"newTalent"}, priority = 7 ,dataProvider="TestData")
    public void test_click_quickTest(String title) throws Exception{
        // title = ExcelUtils.getCellData(2,1);
        objTalentsHome.click_QuickTest();
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);
    }

    //To test that the new talent created reflects the entered data
    @Test(enabled = false,groups = {"newTalent"}, priority = 8 ,dataProvider="TestData")
    public void test_personalDetails_displayed(String name,String street,String phone,String email,String title) throws Exception {


        String[] displayedInfo = objTalentsHome.retrieve_newTalent_data();

        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(displayedInfo[0],name);
        Assert.assertEquals(displayedInfo[1],street);
        Assert.assertEquals(displayedInfo[2],email);
        Assert.assertEquals(displayedInfo[3],phone);
    }

    //To test editing
    @Test(enabled = false, priority = 9, dataProvider="TestData")
    public void test_edit_talent_profile(String title) throws Exception{
        objTalentsHome.click_edit_talent();
        Assert.assertEquals(driver.getTitle(),title);
        //driver.navigate().back();
    }

    //To search talent using search field in talent's home
    @Test(enabled = false, priority = 10, dataProvider="TestData")
    public void test_search_talent(String searchName) throws Exception{
        List<WebElement> data = objTalentsHome.search_talent(searchName);
        for (WebElement element:data) {
            Boolean search = element.getAttribute("textContent").contains(searchName);
            // System.out.println("name "+element.getAttribute("textContent"));
            Assert.assertEquals(search.toString(),"true");
        }
//        driver.findElement(objTalentsHome.searchTalent).clear();
//        driver.findElement(objTalentsHome.searchTalentBtn).click();
    }

    //To verify check box is selected
    @Test(enabled = false, groups = {"selectUnselect"}, priority = 11)
    public void test_select_talent(){
        WebElement checkBox=objTalentsHome.select_Talent();
        Boolean checked=checkBox.getAttribute("className").contains("ng-not-empty");
        Assert.assertEquals(checked.toString(),"true");
    }
    //To verify check box is unselected
    @Test(enabled = false, groups = {"selectUnselect"}, priority = 12)
    public void test_unselect_talent(){
        WebElement checkBox=objTalentsHome.select_Talent();
        Boolean checked=checkBox.getAttribute("className").contains("ng-not-empty");
        Assert.assertEquals(checked.toString(),"false");
    }
    //To verify multiple check box is selected
    @Test(enabled = false,priority = 13)
    public void test_select_multiple_talent(){
        List<WebElement> checkBox=objTalentsHome.select_Multiple_Talent();
        int i=0;
        for (WebElement element:checkBox) {
            Boolean checked=element.getAttribute("className").contains("ng-not-empty");
            i++;
            // element.click();
        }
        Assert.assertEquals(checkBox.size(),i);

    }

    //To verify all talents are selected
    @Test(enabled = false,priority = 14)
    public void test_all_talents_selected(){
        List<WebElement> no_of_talents_available=objTalentsHome.select_All_Talent();
        int select_talent_count=0;
        for (WebElement element:no_of_talents_available) {
            Boolean checked=element.getAttribute("className").contains("select");
            //System.out.println("check "+checked);
            if(checked) {
                select_talent_count++;
            }
        }
        Assert.assertEquals(no_of_talents_available.size(),select_talent_count);          //expected,actual
        // driver.findElement(objTalentsHome.selectAllCheckBox).click();
    }

    //To verify all talents are active by default
    @Test(enabled = false, priority = 15)
    public void test_all_talents_are_active_byDefault() {
        int no_of_talents_available = objTalentsHome.no_Of_Talents();
        //System.out.println("no_of_talents_available "+no_of_talents_available);
        int no_of_active_talents = objTalentsHome.no_Of_Active_Talents();
       // System.out.println("no_of_active_talents "+no_of_active_talents);
        Assert.assertEquals(no_of_active_talents,no_of_talents_available);
    }
    //To verify talents can be disabled
    @Test(enabled = true, groups = {"enableDisable"}, priority = 16)
    public void test_disabling_active_talent() {
        List<WebElement> disabledTalents = objTalentsHome.disable_Talent();
        for (WebElement element:disabledTalents) {
            Assert.assertEquals(element.getAttribute("title"),"INACTIVE");
        }
    }

    //To verify talents can be enabled
    @Test(enabled = false, groups = {"enableDisable"}, priority = 17)
    public void test_enabling_inactive_talent() {
        List<WebElement> enabledTalents = objTalentsHome.enable_Talent();
        for (WebElement element:enabledTalents) {
            Assert.assertEquals(element.getAttribute("title"),"ACTIVE");
        }

    }

    //To verify talents can be archived
    @Test(enabled = false,priority = 18)
    public void test_archive_talent() {

        int secondRow = objTalentsHome.secondTalent.hashCode();
        System.out.println(secondRow);
        objTalentsHome.archive_Talent();
        int firstRow = objTalentsHome.firstTalent.hashCode();
        System.out.println(firstRow);
        Assert.assertEquals(secondRow,firstRow);
    }

    //To verify only selected number of values are displayed in 1st page
    @Test(enabled = false,priority = 19, dataProvider="TestData")
    public void test_select_noOf_talents_toDisplay(String noOfTalentsToDisplay) {
        String actualDisplay = objTalentsHome.numberOfTalentsInFirstPage(noOfTalentsToDisplay);
        Assert.assertEquals(actualDisplay,noOfTalentsToDisplay);
    }

    //To verify navigation to talent's profile on clicking talents name
    @Test(enabled = false,priority = 20, dataProvider="TestData")
    public void test_navigation_to_talentProfile(String title,String firstName,String lastName) {
        String[] name=objTalentsHome.clickTalentName(title);
        Assert.assertEquals(name[0],firstName);
        Assert.assertEquals(name[1],lastName);
    }

    //To verify sign out under profile icon
    @Test(enabled = false,priority = 21, dataProvider="TestData")
    public void test_sign_out(String title) {
        objTalentsHome.clickSignOut();
        Assert.assertEquals(driver.getTitle(),title);
    }

    //To verify trade mark at the bottom of the talent's personal page
    @Test(enabled = false,priority = 22, dataProvider="TestData")
    public void test_trademark(String tradeMark) {
        WebElement tradeMarkDisplayed = objTalentsHome.checkForTrademark();
        Assert.assertEquals(tradeMarkDisplayed.getAttribute("textContent"),tradeMark);
    }

    //To verify version at the bottom of the talent's personal page
    @Test(enabled = false,priority = 23, dataProvider="TestData")
    public void test_app_version(String version) {
        WebElement versionDisplayed = objTalentsHome.checkForVersion();
        Boolean actualResult = versionDisplayed.getAttribute("textContent").contains(version);
        Assert.assertEquals(actualResult.toString(),"true");
    }

    //To verify clicking profile icon offers two different actions
    @Test(enabled = false,priority = 24, dataProvider="TestData")
    public void test_profileIcon_options(String option1,String option2) {
        List<WebElement> profileOptions = objTalentsHome.clickProfileIcon();
        Assert.assertEquals(profileOptions.get(0).getAttribute("innerText"),option1);
        Assert.assertEquals(profileOptions.get(1).getAttribute("innerText"),option2);
    }

    @DataProvider
    public Object[][] TestData(Method method) throws Exception{
        // Setting up the Test Data Excel file
        ExcelUtils.setExcelFile(excelPath,sheetName);


        // The below method will give your test case name, exactly the name we have used
        String sTestCaseName = method.getName() ;

        // Fetching the Test Case row number from the Test Data Sheet
        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

        Object[][] testObjArray = ExcelUtils.getTableArray(excelPath,sheetName,iTestCaseRow);
        return (testObjArray);
    }
}

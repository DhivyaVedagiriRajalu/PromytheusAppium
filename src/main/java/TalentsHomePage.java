import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TalentsHomePage {
    WebDriver driver;
    WebDriverWait waitVar;
    JavascriptExecutor js;
    public static  boolean mobile=false;

    //public WebElement dropdown;
    @FindBy(className="img-responsive")
    WebElement Logo;

    @FindBy(linkText="New")
    WebElement newTab;

    @FindBy(xpath="//div[@name='category']")
    WebElement dropDown;

    @FindBy(xpath="//span[@class='ui-select-choices-row-inner' and text()='Art']")
    WebElement selectOption;

    @FindBy(xpath="//button[text()='Next']")
    WebElement nextBtn;

    @FindBy(name="firstName")
    WebElement firstName;

    @FindBy(name="lastName")
    WebElement lastName;

    @FindBy(xpath="//li/span[text()='Quick Tests']")
    WebElement quickTestTab;

    @FindBy(xpath="//button[text()='Finish']")
    WebElement finshBtn;

    @FindBy(id="address")
    WebElement addressLine1;

    @FindBy(name="city")
    WebElement addressLine2;

    @FindBy(name="addressState")
    WebElement addressLine3;

    @FindBy(name="zip")
    WebElement addressLine4;

    @FindBy(name="email")
    WebElement emailAdress;

    @FindBy(name="phone")
    WebElement phoneNumber;

    @FindBy(xpath="//table/tbody/tr[1]/td[2]")
    WebElement nameEntered;

    @FindBy(xpath="//table/tbody/tr[1]/td[4]")
    WebElement addressEntered;

    @FindBy(xpath="//table/tbody/tr[1]/td[6]")
    WebElement emailEntered;

    @FindBy(xpath="//table/tbody/tr[1]/td[5]")
    WebElement phoneEntered;

    @FindBy(xpath="(//a[@class='clear-hover'])[1]")
    WebElement editIcon;

    @FindBy(name="search")
    WebElement searchTalent;

    @FindBy(xpath="//button[text()='Search']")
    WebElement searchTalentBtn;

    @FindBy(xpath="(//input[@type = 'checkbox'])[2]")
    WebElement firstCheckBox;

    @FindAll({@FindBy(xpath = "//tbody/tr")})
    List<WebElement> tableRows;
    By byTableRows = By.xpath("//tbody/tr");

    @FindBy(xpath="(//input[@type = 'checkbox'])[1]")
    WebElement selectAllCheckBox;

    @FindAll({@FindBy(xpath = "//tbody/tr/td[@class='status text-center']/em[@title='ACTIVE']")})
    List<WebElement> activeTalents;

    @FindBy(xpath="//button[text()='Disable']")
    WebElement disableButton;

    @FindAll({@FindBy(xpath = "//tr[td[em[@title='ACTIVE']]]/td[div[@class='checkbox c-checkbox']]")})
    List<WebElement> activeTalentsCheckBox;

    @FindBy(xpath="//button[text()='Enable']")
    WebElement enableButton;

    @FindAll({@FindBy(xpath = "//tr[td[em[@title='INACTIVE']]]/td[div[@class='checkbox c-checkbox']]")})
    List<WebElement> inActiveTalentsCheckBox;

    @FindBy(xpath="//button[text()='Archive']")
    WebElement archiveButton;

    @FindBy(xpath="//tbody/tr[1]")
    WebElement firstTalent;

    @FindBy(xpath="//tbody/tr[2]")
    WebElement secondTalent;

    @FindBy(xpath="/html/body/app/ui-view/public-area/div/ui-view/talents-section/div/section/div/div/spinner-container/div[1]/div/div[1]/div/div/select")
    WebElement selectDropDown;

    @FindBy(linkText="tyiyu  wrwe")
    WebElement talentName;

    @FindBy(xpath="//*[@id=\"talentForm\"]/wizard-form/div/ol/li[2]")
    WebElement personalBtn;
    By byPersonalBtn = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/ol/li[2]");

    @FindBy(xpath="//li[@class='dropdown dropdown-list']/a/em[@class='icon-user']")
    WebElement profileIcon;

    @FindBy(xpath="//a[@class='list-group-item']/div/div[2]/p[text()='Sign Out']")
    WebElement signOut;

    @FindBy(xpath="//footer/div[1]")
    WebElement tradeMark;

    @FindBy(xpath="//footer/div[2]")
    WebElement version;


    @FindAll({@FindBy(xpath = "/html/body/app/ui-view/public-area/div/header/nav/div[2]/ul[2]/li[2]/ul/li/div/a")})
    List<WebElement> iconOptions;


    //constructor
    public TalentsHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = ((JavascriptExecutor) driver);
    }

    //Click ProMyTheUs Logo in talents home
    public void clickLogo(){
        Logo.click();

    }

    //Click New tab in talents home
    public void clickNew(){
       newTab.click();
    }



//Select category to created new talent in mobile web app
  public void clickCategory_selectOption() throws Exception {

        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        dropDown.click();
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", selectOption);
        selectOption.click();
        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
        nextBtn.click();
   }

    //Enter firstName and LastName in Personal Tab
    public void enter_firstName_lastName(String sFirstName,String sLastName) throws Exception{
        firstName.sendKeys(sFirstName);
        lastName.sendKeys(sLastName);
    }

    //Enter address and contact details
    public void enter_address_contact(String street, String city, String email, String phone, String state, String zip) throws Exception{
        js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", addressLine1);
        addressLine1.sendKeys(street);
        addressLine2.sendKeys(city);
        emailAdress.sendKeys(email);
        phoneNumber.sendKeys(phone);
        System.out.println("ph "+phone);
        addressLine3.sendKeys(state);

        //String zip = ExcelUtils.getCellData(6,2);
        System.out.println("zip " + zip);
        addressLine4.sendKeys(zip);

   }


    //Click QuickTest tab to finish the talent creation

   public void click_QuickTest(){
        js.executeScript("arguments[0].scrollIntoView(true);", quickTestTab);
        quickTestTab.click();
        js.executeScript("arguments[0].scrollIntoView(true);", finshBtn);
        finshBtn.click();
    }

    //Send the data displayed in talent home page for verification
    public String[] retrieve_newTalent_data() throws Exception{
        String[] talentInfo = new String[4];
        String title = ExcelUtils.getCellData(2,1);
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.titleIs(title));
        talentInfo[0]=nameEntered.getText();
        talentInfo[1]=addressEntered.getText();
        talentInfo[2]=emailEntered.getText();
        talentInfo[3]=phoneEntered.getText();

        return talentInfo;
    }

    //edit talent profile
    public void click_edit_talent(){
        editIcon.click();
    }

    //search talent using search field in talent's home page
    public List<WebElement> search_talent(String searchName) throws Exception{
        if(mobile){
            js.executeScript("arguments[0].scrollIntoView(true);", searchTalent);
        }
        searchTalent.sendKeys(searchName);
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.visibilityOf(searchTalentBtn));
        searchTalentBtn.click();


        List<WebElement> searchedData = tableRows;
        return searchedData;
    }

    //Select talent
    public WebElement select_Talent(){
        WebElement checkBox = firstCheckBox;
        checkBox.click();
        return checkBox;
    }
    //Select multiple talent
    public List<WebElement> select_Multiple_Talent(){
      //  By tableRows1 = By.xpath();
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(byTableRows));
        List<WebElement> checkBoxList = tableRows;
        for (WebElement x: checkBoxList) {
            if(mobile){
                js.executeScript("arguments[0].scrollIntoView(true);", x);
                x.click();
            }
            else {
                x.click();
            }
        }
     return checkBoxList;
    }
    //Select All talent
    public List<WebElement> select_All_Talent(){
        selectAllCheckBox.click();
        List<WebElement> noOfTalents = tableRows;
        return noOfTalents;
    }

    //Verify Talents are active by default
    public int no_Of_Talents(){
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(byTableRows));
        int noOfTalents = tableRows.size();
        return noOfTalents;
    }
    public int no_Of_Active_Talents(){
        int noOfActiveTalents = activeTalents.size();
        return noOfActiveTalents;
    }

    //Change challenge status inactive
    public List<WebElement> disable_Talent() {
        WebElement inactiveColumn;
        List<WebElement> elements_disabled = new ArrayList<WebElement>();
        List<WebElement> activeTalentList = activeTalentsCheckBox;
        System.out.println("activeTalentList.size() "+activeTalentList.size());
        if(activeTalentList.size()>=1){
            for (WebElement element:activeTalentList) {
                element.click();
                inactiveColumn = element.findElement(By.xpath("//tr/td/em[@title='ACTIVE']"));
                elements_disabled.add(inactiveColumn);

            }
            if(disableButton.isEnabled()) {
               disableButton.click();
                //to retrieve one column element from another column element in a table row
                // element.click();
            }

        }
        else{
            System.out.println("No active talents found to disable");
        }
        return elements_disabled;
    }

    //Change inactive challenge status to active
    public List<WebElement> enable_Talent() {
        WebElement activeColumn;
        List<WebElement> elements_enabled = new ArrayList<WebElement>();
        List<WebElement> inActiveTalentList = inActiveTalentsCheckBox;
        System.out.println("inActiveTalentList.size() "+inActiveTalentList.size());
        if(inActiveTalentList.size()>=1){
            for (WebElement element:inActiveTalentList) {
                element.click();
                activeColumn = element.findElement(By.xpath("//tr/td/em[@title='INACTIVE']"));
                elements_enabled.add(activeColumn);
            }
            if(enableButton.isEnabled()) {
                enableButton.click();
            }
        }
        else{
            System.out.println("No inactive talents found to enable");
        }
        return elements_enabled;
    }

    //Change inactive challenge status to active
    public void archive_Talent() {
        List<WebElement> noOfTalents = tableRows;
        if(noOfTalents.size()>0){
          firstCheckBox.click();
          WebElement archive = archiveButton;
          if(archive.isEnabled()){
              archive.click();
          }
        }

    }

    //Select number of talents to be displayed in first page
    public String numberOfTalentsInFirstPage(String noOfTalentToDisplay) {
        Select selectVar = new Select(selectDropDown);
        selectVar.selectByVisibleText(noOfTalentToDisplay);
        String noOfRowsInPage1 = tableRows.size()+"";
        return noOfRowsInPage1;
    }

    //Navigate to talent's profile by clicking talent's name
    public String[] clickTalentName(String title){
        talentName.click();
        String[] name = new String[2];
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(byPersonalBtn));
        personalBtn.click();
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.titleIs(title));
        name[0]=firstName.getAttribute("value");
        name[1]=lastName.getAttribute("value");
        return name;
    }

    //Click sign out under profile icon
    public void clickSignOut(){
        profileIcon.click();
        signOut.click();
    }

    //Check trademark in footer
    public WebElement checkForTrademark(){
        return tradeMark;
    }

    //Check verrsion in footer
    public WebElement checkForVersion(){
        return version;
    }

    //Click profile icon
    public List<WebElement> clickProfileIcon(){
        profileIcon.click();
        List<WebElement> profileOptions = iconOptions;
        return profileOptions;
    }
}

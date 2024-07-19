package hoinstructormanagement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import hoadminbasereport.AdminBaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class InstructorManagementTest extends AdminBaseTest{

    @Test(priority = 1)
    public void InstructorManagementListTest1() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement table = driver.findElement(By.xpath("//tbody"));
        WebElement PaginationDropdown = driver.findElement(By.xpath("//select[@class='form-control form-control-solid d-inline m-1 px-3 py-2 border rounded-2 w-auto bg-white']"));
        try {
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
        wait1.until(ExpectedConditions.elementToBeClickable(PaginationDropdown));
        Select select = new Select(PaginationDropdown);
        for (WebElement option : select.getOptions()) {
            select.selectByVisibleText(option.getText());
            try {
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
                wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr")));

            } catch (Throwable e) {
                System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
            }
            List<WebElement> rowsElements = driver.findElements(By.xpath("//tbody/tr"));
            System.out.println("********Total number of rows " + rowsElements.size() + " in this page********");
            List<WebElement> columnElements = driver.findElements(By.xpath("//tbody/tr[1]/td"));
            System.out.println("********Total number of columns " + columnElements.size() + " in this page********");
            int rowSize = rowsElements.size();
            int colSize = columnElements.size();
            for (int i = 1; i <= rowSize; i++)
            {
                for (int j = 1; j <= colSize; j++)
                {

                    System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ");
                }
                System.out.println();
            }
        }
        System.out.println("\u001B[33m-----TestCases1:-Check instructor management list page pagination wise data displayed properly-----\u001B[0m");
        String expected1 = "https://hogrowth.jainam.in/backoffice/apps/instructor-management/instructor";
        String actual1 = driver.getCurrentUrl();
        test = reports.createTest("Check instructor management list page pagination wise data displayed properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check instructor management list page pagination wise data displayed properly").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected1=" + expected1);
        System.out.println("actual1=" + actual1);

        if (actual1.equalsIgnoreCase(expected1))
        {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        }
        else
        {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
        Assert.assertEquals("In instructor management list page data not display properly", expected1, actual1);
    }
    @Test(priority = 4)
    public void InstructorManagementSearchingDataTest2() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Instructor']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement searchVal = driver.findElement(By.xpath("//input[@placeholder='Search Instructor']"));
        searchVal.sendKeys("Test");
        WebElement btnSearch=driver.findElement(By.xpath("//button[text()=\"Search\"]"));
        btnSearch.click();
        List<WebElement> rowsElements1 = driver.findElements(By.xpath("//tbody/tr"));
        //List<WebElement> filterVal= rowsElements1.stream().filter(rowsElementsVal->rowsElementsVal.getText().contains("Admin")).toList();
        System.out.println("\u001B[33m-----TestCases2:-Check instructor management list page data searching functionality properly work-----\u001B[0m");
        String expected2 = "Testing Automation";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual2 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]")).getText();
        test = reports.createTest("Check instructor management list page data searching functionality properly work").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check instructor management list page data searching functionality properly work").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected2=" + expected2);
        System.out.println("actual2=" + actual2);
        if (actual2.equalsIgnoreCase(expected2))
        {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        }
        else
        {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
        Assert.assertEquals("In instructor management list page data searching functionality not working properly", expected2, actual2);
    }
    @Test(priority = 3)
    public void InstructorManagementFilterDataTest3() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Filter']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnFilterMenu = driver.findElement(By.xpath("//button[text()='Filter']"));
        btnFilterMenu.click();
        WebElement filterStatus=driver.findElement(By.xpath("//select[@data-kt-user-table-filter='filterStatus']"));
        Select select =new Select(filterStatus);
        select.selectByVisibleText("Active");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-select form-select-solid fw-bolder']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnFilterApply= driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
        btnFilterApply.click();
        System.out.println("\u001B[33m-----TestCases3:-Check instructor management list page data filter functionality properly work-----\u001B[0m");
        String expected3 = "ACTIVE";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual3 = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
        test = reports.createTest("Check instructor management list page data filter functionality properly work").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check instructor management list page data filter functionality properly work").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected3=" + expected3);
        System.out.println("actual3=" + actual3);
        if (actual3.equalsIgnoreCase(expected3))
        {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        }
        else
        {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
        Assert.assertEquals("In instructor management list page data filter functionality not working properly", expected3, actual3);
    }
    @Test(priority = 5)
    public void InstructorManagementActionViewTest4() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[6]/a[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]"));
        actionMenu.click();
        WebElement btnViewDetails = driver.findElement(By.xpath("(//a[@class='menu-link px-3'][normalize-space()='View'])[1]"));
        btnViewDetails.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='View Instructor']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }

        try {
            // Find elements and retrieve text values
            WebElement fullNameDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[1]"));
            String fullNameDataValue = fullNameDataElement.getText();

            WebElement userNameDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[2]"));
            String userNameDataValue = userNameDataElement.getText();

            WebElement mobileStdNoDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8 fv-row'])[1]"));
            String mobileStdNoDataValue = mobileStdNoDataElement.getText();

            WebElement mobileNoDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8 d-flex align-items-center'])[1]"));
            String mobileNoDataValue = mobileNoDataElement.getText();

            WebElement countryDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[3]"));
            String countryDataValue = countryDataElement.getText();

            WebElement qualificationDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[4]"));
            String qualificationDataValue = qualificationDataElement.getText();

            WebElement descriptionDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[5]"));
            String descriptionDataValue = descriptionDataElement.getText();

            WebElement twitterUrlDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[6]"));
            String twitterUrlDataValue = twitterUrlDataElement.getText();

            WebElement  linkedinDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[7]"));
            String linkedinUrlDataValue = linkedinDataElement.getText();

            WebElement instagramDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[8]"));
            String instagramUrlDataValue = instagramDataElement.getText();

            WebElement createdAtDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[9]"));
            String createdAtDataValue = createdAtDataElement.getText();

            WebElement createdByDataElement = driver.findElement(By.xpath("(//div[@class='col-lg-8'])[10]"));
            String createdByDataValue = createdByDataElement.getText();

            // Print a message to indicate the start of the test case
            System.out.println("\u001B[33m----- TestCases4: Check instructor wise instructor management details properly display ----- \u001B[0m");

            // Verify if the page title is displayed
            WebElement detailsPageTitle = driver.findElement(By.xpath("//h1[normalize-space()='View Instructor']"));
            assertTrue(detailsPageTitle.isDisplayed());
            // Create a TestNG test and log the result
            test = reports.createTest("Check instructor wise instructor management details properly display").assignAuthor("Fenil").assignCategory(getClass().
                    getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                    ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check instructor wise instructor management details properly display").build());

            // Perform assertions for each data element
            Assert.assertFalse("The full name data value is blank. Expected: Not blank", fullNameDataValue.trim().isEmpty());
            Assert.assertFalse("The username data value is blank. Expected: Not blank", userNameDataValue.trim().isEmpty());
            Assert.assertFalse("The mobile std no data value is blank. Expected: Not blank", mobileStdNoDataValue.trim().isEmpty());
            Assert.assertFalse("The mobile no data value is blank. Expected: Not blank", mobileNoDataValue.trim().isEmpty());
            Assert.assertFalse("The country data value is blank. Expected: Not blank", countryDataValue.trim().isEmpty());
            Assert.assertFalse("The qualification data value is blank. Expected: Not blank", qualificationDataValue.trim().isEmpty());
            Assert.assertFalse("The description data value is blank. Expected: Not blank", descriptionDataValue.trim().isEmpty());
            Assert.assertFalse("The twitter url data value is blank. Expected: Not blank", twitterUrlDataValue.trim().isEmpty());
            Assert.assertFalse("The linkedin url data value is blank. Expected: Not blank", linkedinUrlDataValue.trim().isEmpty());
            Assert.assertFalse("The instagram url data value is blank. Expected: Not blank", instagramUrlDataValue.trim().isEmpty());
            Assert.assertFalse("The createdAt data value is blank. Expected: Not blank", createdAtDataValue.trim().isEmpty());
            Assert.assertFalse("The createdBy data value is blank. Expected: Not blank", createdByDataValue.trim().isEmpty());

            // Log a pass status if all assertions pass
            System.out.println("All data values are not blank as expected.");

        } catch (NoSuchElementException e) {
            // Handle the exception for element not found
            System.err.println("Element not found: " + e.getMessage());
            test = reports.createTest("Check instructor wise instructor management details properly display").assignAuthor("Fenil").assignCategory(getClass().
                    getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                    ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check instructor wise instructor management details properly display").build());
            if (e.getMessage().contains("(//div[@class='col-lg-8'])[10]")) {
                test.fail("Linkedin data is not shown during view time.");
                Assert.fail("Linkedin data is not displayed.");
            } else {
                System.out.println("Linkedin data properly display");
            }
        } catch (Exception e) {
            // Handle any other exceptions
            System.err.println("Exception occurred: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
    @Test(priority = 9)
    public void InstructorManagementActionEditDataTest5() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[6]/a[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[text()='Actions'])[1]"));
        actionMenu.click();
        WebElement btnEdit = driver.findElement(By.xpath("(//a[text()='Edit'])[1]"));
        btnEdit.click();
        System.out.println("\u001B[33m-----TestCases5:-Check edit time instructor management details edit functionality working properly-----\u001B[0m");
        //Firstname
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement firstNameDataElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameDataValue = firstNameDataElement.getAttribute("value");
        System.out.println("First Name Data Value: " + firstNameDataValue);

        if (firstNameDataValue.trim().isEmpty()) {
            System.out.println("The first name data value is blank.");
        } else {

            firstNameDataElement.sendKeys(Keys.CONTROL + "a");
            firstNameDataElement.sendKeys(Keys.DELETE);
            firstNameDataElement.sendKeys("TestFirstName");
        }


        //Lastname
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement LastNameDataElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameDataValue = LastNameDataElement.getAttribute("value");
        System.out.println("Last Name Data Value: " + lastNameDataValue);

        if (lastNameDataValue.trim().isEmpty()) {
            System.out.println("The last name data value is blank.");
        } else {

            LastNameDataElement.sendKeys(Keys.CONTROL + "a");
            LastNameDataElement.sendKeys(Keys.DELETE);
            LastNameDataElement.sendKeys("TestLastName");
        }

        //Email
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement EmailDataElement = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        String EmailDataValue = EmailDataElement.getAttribute("value");
        System.out.println("Email Data Value: " + EmailDataValue);
        boolean isEmailReadOnly = EmailDataElement.isEnabled();
        if (isEmailReadOnly) {
            System.out.println("The email input field is read-only.");
        } else {
            if (EmailDataValue.trim().isEmpty()) {
                System.out.println("The email data value is blank.");
            } else {
                EmailDataElement.clear();
                String newEmailAddress = "newtestemail" + System.currentTimeMillis() + "@gmail.com";
                EmailDataElement.sendKeys(newEmailAddress);

                System.out.println("Updated email address to: " + newEmailAddress);
            }
        }
        //Gender
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Gender']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement GenderDropdownElement = driver.findElement(By.xpath("//select[@placeholder='Gender']"));
        Select GenderDropdown = new Select(GenderDropdownElement);
        WebElement GenderSelectedOption = GenderDropdown.getFirstSelectedOption();
        String GenderSelectedValue = GenderSelectedOption.getText();
        System.out.println("Gender Data Value: " + GenderSelectedValue);
        if (GenderSelectedValue.trim().isEmpty()) {
            System.out.println("The gender data value is blank.");
        } else {
            GenderDropdownElement.click();
            GenderDropdown.selectByVisibleText("Male");
        }

        //Country
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Country']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CountryDropdownElement = driver.findElement(By.xpath("//select[@placeholder='Country']"));
        Select CountryDropdown = new Select(CountryDropdownElement);
        WebElement CountrySelectedOption = CountryDropdown.getFirstSelectedOption();
        String CountrySelectedValue = CountrySelectedOption.getText();
        System.out.println("Country Data Value: " + CountrySelectedValue);
        if (CountrySelectedValue.trim().isEmpty()) {
            System.out.println("The country data value is blank.");
        } else {
            CountryDropdownElement.click();
            CountryDropdown.selectByVisibleText("India");
        }

        //STD no
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Mobile No STD Code']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement StdNoDataElement = driver.findElement(By.xpath("//input[@placeholder='Mobile No STD Code']"));
        String StdNoDataValue = StdNoDataElement.getAttribute("value");
        System.out.println("Std No. Data Value: " + StdNoDataValue);

        boolean isStdNoReadOnly = StdNoDataElement.isEnabled();
        if (isStdNoReadOnly) {
            System.out.println("The Std No input field is read-only.");
        } else {
            if (StdNoDataValue.trim().isEmpty()) {
                System.out.println("The Std No data value is blank.");
            } else {
                StdNoDataElement.clear();
                StdNoDataElement.sendKeys("91");
            }
        }

        //Mobile no
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Mobile No']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement MobileNoDataElement = driver.findElement(By.xpath("//input[@placeholder='Mobile No']"));
        String MobileNoDataValue = MobileNoDataElement.getAttribute("value");
        System.out.println("Mobile No. Data Value: " + MobileNoDataValue);

        if (MobileNoDataValue.trim().isEmpty()) {
            System.out.println("The Mobile No. data value is blank.");
        } else {

            MobileNoDataElement.sendKeys(Keys.CONTROL + "a");
            MobileNoDataElement.sendKeys(Keys.DELETE);
            MobileNoDataElement.sendKeys(generateRandomMobileNumber());
        }

        //Qualification
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Qualification']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement QualificationDataElement = driver.findElement(By.xpath("//input[@placeholder='Qualification']"));
        String QualificationDataValue = QualificationDataElement.getAttribute("value");
        System.out.println("Qualification Data Value: " + QualificationDataValue);

        if (QualificationDataValue.trim().isEmpty()) {
            System.out.println("The qualification data value is blank.");
        } else {

            QualificationDataElement.sendKeys(Keys.CONTROL + "a");
            QualificationDataElement.sendKeys(Keys.DELETE);
            QualificationDataElement.sendKeys("TestQualification");
        }

        //Description
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Description']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement DescriptionDataElement = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
        String DescriptionDataValue = DescriptionDataElement.getAttribute("value");
        System.out.println("Description Data Value: " + DescriptionDataValue);

        if (DescriptionDataValue.trim().isEmpty()) {
            System.out.println("The Description data value is blank.");
        } else {

            DescriptionDataElement.sendKeys(Keys.CONTROL + "a");
            DescriptionDataElement.sendKeys(Keys.DELETE);
            DescriptionDataElement.sendKeys("TestDescription");
        }

        //Linkedin
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Linkedin Url']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement LinkedinDataElement = driver.findElement(By.xpath("//input[@placeholder='Linkedin Url']"));
        String LinkedinDataValue = LinkedinDataElement.getAttribute("value");
        System.out.println("Linkedin url Data Value: " + LinkedinDataValue);

        if (LinkedinDataValue.trim().isEmpty()) {
            System.out.println("The linkedin url data value is blank.");
        } else {

            LinkedinDataElement.sendKeys(Keys.CONTROL + "a");
            LinkedinDataElement.sendKeys(Keys.DELETE);
            LinkedinDataElement.sendKeys("https://in.linkedin.com/");
        }
        //Twitter
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Twitter Url']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement TwitterDataElement = driver.findElement(By.xpath("//input[@placeholder='Twitter Url']"));
        String TwitterDataValue = TwitterDataElement.getAttribute("value");
        System.out.println("Twitter Data Value: " + TwitterDataValue);

        if (TwitterDataValue.trim().isEmpty()) {
            System.out.println("The twitter data value is blank.");
        } else {

            TwitterDataElement.sendKeys(Keys.CONTROL + "a");
            TwitterDataElement.sendKeys(Keys.DELETE);
            TwitterDataElement.sendKeys("https://twitter.com/login?lang=en");
        }
        //Instagram
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Instagram Url']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstagramDataElement = driver.findElement(By.xpath("//input[@placeholder='Instagram Url']"));
        String InstagramDataValue = InstagramDataElement.getAttribute("value");
        System.out.println("Instagram Data Value: " + InstagramDataValue);

        if (InstagramDataValue.trim().isEmpty()) {
            System.out.println("The instagram data value is blank.");
        } else {

            InstagramDataElement.sendKeys(Keys.CONTROL + "a");
            InstagramDataElement.sendKeys(Keys.DELETE);
            InstagramDataElement.sendKeys("https://www.instagram.com/");
        }

        WebElement fileInput = driver.findElement(By.id("upload"));
        String absoluteFilePath = "/home/j/IdeaProjects/HoGrowthAdminPanel/src/main/java/download.jpeg";
        fileInput.sendKeys(absoluteFilePath);
        WebElement btnEditUserData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditUserData.click();
        String expected5 = "Instructor updated successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual5 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check edit time instructor management details edit functionality working properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check edit time instructor management details edit functionality working properly").build());
        Assert.assertTrue(true);
        System.out.println("expected5=" + expected5);
        System.out.println("actual5=" + actual5);
        Assert.assertEquals("Edit time instructor management details edit functionality not working properly", expected5, actual5);
        if (actual5.equalsIgnoreCase(expected5)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }
    @Test(priority = 6)
    public void InstructorManagementInsertBlankDataTest6() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Instructor']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnNewInstructor = driver.findElement(By.xpath("//button[text()='Add Instructor']"));
        btnNewInstructor.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement FirstNameInput = driver.findElement(By.name("firstName"));

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement LastNameInput = driver.findElement(By.name("lastName"));

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement EmailIdInput = driver.findElement(By.name("email"));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement PasswordInput = driver.findElement(By.name("password"));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("gender")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement GenderInput = driver.findElement(By.name("gender"));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("countryId")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CountryInput = driver.findElement(By.name("countryId"));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement MobileNoInput = driver.findElement(By.name("mobileNo"));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("status")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement StatusInput = driver.findElement(By.name("status"));
        FirstNameInput.clear();
        LastNameInput.clear();
        EmailIdInput.clear();
        PasswordInput.clear();
        GenderInput.isSelected();
        CountryInput.isSelected();
        MobileNoInput.clear();
        StatusInput.isSelected();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text-center pt-15']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        driver.findElement(By.xpath("//span[text()='Submit']")).click();

        System.out.println("\u001B[33m-----TestCases6:-Check blank first name validation-----\u001B[0m");
        try {
            WebElement errorMessageFirstName = driver.findElement(By.xpath("//span[normalize-space()='First name is required']"));
            // Check blank field handled or not
            if (errorMessageFirstName.isDisplayed()) {
                System.out.println("Blank full name fields handled correctly.");
            } else {
                System.out.println("Full name error handling is not working as expected.");
            }
            String expected6 = "First name is required";
            String actual6 = driver.findElement(By.xpath("//span[normalize-space()='First name is required']")).getText();
            test = reports.createTest("Check blank first name validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank full name validation").build());
            Assert.assertTrue(true); // pass
            System.out.println("expected6=" + expected6);
            System.out.println("actual6=" + actual6);
            Assert.assertEquals("First name required field validation not work ", expected6, actual6);
            if (actual6.equalsIgnoreCase(expected6)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank first name validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank first name validation").build());
            }
            test.fail(e.getMessage());
            test.fail("First name require field validation not shown");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank first name validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank first name validation").build());
            }
            test.fail(e.getMessage());
        }

        System.out.println("\u001B[33m-----TestCases7:-Check blank email validation-----\u001B[0m");
        try {
            WebElement errorMessageEmailId = driver.findElement(By.xpath("//span[normalize-space()='Email is required']"));
            // Check blank field handled or not
            if (errorMessageEmailId.isDisplayed()) {
                System.out.println("Blank email fields handled correctly.");
            } else {
                System.out.println("Email ID error handling is not working as expected.");
            }

            String expected7 = "Email is required";
            String actual7 = driver.findElement(By.xpath("//span[normalize-space()='Email is required']")).getText();

            test = reports.createTest("Check blank email validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank email validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected7=" + expected7);
            System.out.println("actual7=" + actual7);

            Assert.assertEquals("Email ID required field validation not work ", expected7, actual7);

            if (actual7.equalsIgnoreCase(expected7)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank email validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank email validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank email validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank email validation").build());
            }
            test.fail(e.getMessage());
        }

        System.out.println("\u001B[33m-----TestCases8:-Check blank password validation-----\u001B[0m");
        try {
            WebElement errorMessagePassword = driver.findElement(By.xpath("//span[normalize-space()='Password is required']"));
            // Check blank field handled or not
            if (errorMessagePassword.isDisplayed()) {
                System.out.println("Blank password fields handled correctly.");
            } else {
                System.out.println("Password error handling is not working as expected.");
            }

            String expected8 = "Password is required";
            String actual8 = driver.findElement(By.xpath("//span[normalize-space()='Password is required']")).getText();

            test = reports.createTest("Check blank password validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank password validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected8=" + expected8);
            System.out.println("actual8=" + actual8);

            Assert.assertEquals("Password required field validation not work ", expected8, actual8);

            if (actual8.equalsIgnoreCase(expected8)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank password validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank password validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank password validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank password validation").build());
            }
            test.fail(e.getMessage());
        }
        System.out.println("\u001B[33m-----TestCases9:-Check blank gender validation-----\u001B[0m");
        try {
            WebElement errorMessageGender = driver.findElement(By.xpath("//span[normalize-space()='Gender is required']"));
            // Check blank field handled or not
            if (errorMessageGender.isDisplayed()) {
                System.out.println("Blank gender fields handled correctly.");
            } else {
                System.out.println("Gender error handling is not working as expected.");
            }

            String expected9 = "Gender is required";
            String actual9 = driver.findElement(By.xpath("//span[normalize-space()='Gender is required']")).getText();

            test = reports.createTest("Check blank gender validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank gender validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected9=" + expected9);
            System.out.println("actual9=" + actual9);

            Assert.assertEquals("Gender required field validation not work ", expected9, actual9);

            if (actual9.equalsIgnoreCase(expected9)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank gender validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank gender validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank gender validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank gender validation").build());
            }
            test.fail(e.getMessage());
        }

        System.out.println("\u001B[33m-----TestCases10:-Check blank country validation-----\u001B[0m");
        try {
            WebElement errorMessageCountry = driver.findElement(By.xpath("//span[normalize-space()='Country is required']"));
            // Check blank field handled or not
            if (errorMessageCountry.isDisplayed()) {
                System.out.println("Blank country fields handled correctly.");
            } else {
                System.out.println("Country error handling is not working as expected.");
            }

            String expected10 = "Country is required";
            String actual10 = driver.findElement(By.xpath("//span[normalize-space()='Country is required']")).getText();

            test = reports.createTest("Check blank country validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank country validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected10=" + expected10);
            System.out.println("actual10=" + actual10);

            Assert.assertEquals("Country required field validation not work ", expected10, actual10);

            if (actual10.equalsIgnoreCase(expected10)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank country validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank country validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank country validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank country validation").build());
            }
            test.fail(e.getMessage());
        }
        System.out.println("\u001B[33m-----TestCases11:-Check blank mobile number validation-----\u001B[0m");
        try {
            WebElement errorMessageMobileNo = driver.findElement(By.xpath("//span[normalize-space()='Mobile number is required']"));
            // Check blank field handled or not
            if (errorMessageMobileNo.isDisplayed()) {
                System.out.println("Blank mobile number fields handled correctly.");
            } else {
                System.out.println("Mobile number error handling is not working as expected.");
            }
            String expected11 = "Mobile number is required";
            String actual11 = driver.findElement(By.xpath("//span[normalize-space()='Mobile number is required']")).getText();
            test = reports.createTest("Check blank mobile number validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank mobile number validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected11=" + expected11);
            System.out.println("actual11=" + actual11);

            Assert.assertEquals("Mobile number required field validation not work ", expected11, actual11);

            if (actual11.equalsIgnoreCase(expected11)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank mobile number validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank mobile number validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank mobile number validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName());
            }
            test.fail(e.getMessage());
        }
        System.out.println("\u001B[33m-----TestCases12:-Check blank status validation-----\u001B[0m");
        try {
            WebElement errorMessageStatus = driver.findElement(By.xpath("//span[normalize-space()='Status is required']"));

            // Check blank field handled or not
            if (errorMessageStatus.isDisplayed()) {
                System.out.println("Blank status fields handled correctly.");
            } else {
                System.out.println("Status error handling is not working as expected.");
            }

            String expected12 = "Status is required";
            String actual12 = driver.findElement(By.xpath("//span[normalize-space()='Status is required']")).getText();

            test = reports.createTest("Check blank status validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank status validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected12=" + expected12);
            System.out.println("actual12=" + actual12);

            Assert.assertEquals("Status required field validation not work ", expected12, actual12);

            if (actual12.equalsIgnoreCase(expected12)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank status validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank status validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank status validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank status validation").build());
            }
            test.fail(e.getMessage());
        }
        System.out.println("\u001B[33m-----TestCases13:-Check blank last name validation-----\u001B[0m");
        try {
            WebElement errorMessageLastName = driver.findElement(By.xpath("//span[normalize-space()='Last name is required']"));
            // Check blank field handled or not
            if (errorMessageLastName.isDisplayed()) {
                System.out.println("Blank last name fields handled correctly.");
            } else {
                System.out.println("Last name error handling is not working as expected.");
            }
            String expected13 = "Last name is required";
            String actual13 = driver.findElement(By.xpath("//span[normalize-space()='Last name is required']")).getText();
            test = reports.createTest("Check blank last name validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank last name validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected13=" + expected13);
            System.out.println("actual13=" + actual13);

            Assert.assertEquals("Last name required field validation not work ", expected13, actual13);

            if (actual13.equalsIgnoreCase(expected13)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank last name validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank last name validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank last name validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName());
            }
            test.fail(e.getMessage());
        }
    }
    @Test(priority = 7)
    public void InstructorManagementInsertDataTimeEmailValidationTest7() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add Instructor']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnNewInstructor = driver.findElement(By.xpath("//button[normalize-space()='Add Instructor']"));
        btnNewInstructor.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement emailIDInput = driver.findElement(By.name("email"));
        String email = "test@example";
        emailIDInput.sendKeys(email);
        WebElement PasswordInput=driver.findElement(By.name("password"));
        PasswordInput.sendKeys("Test@123#");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@role='alert'])")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement responseMessage = driver.findElement(By.xpath("(//span[@role='alert'])"));
        String responseText = responseMessage.getText();
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(responseText);
        System.out.println("\u001B[33m-----TestCases14:-Check invalid email address validation-----\u001B[0m");
        // Check the validation result
        if (matcher.matches())
        {
            System.out.println("The email address " + email + " is valid.");
        } else

        {
            System.out.println("The email address " + email + " is not valid.");
        }
        String expected14 = "Please enter a valid email address";
        String actual14 = driver.findElement(By.xpath("//span[@role='alert']")).getText();
        test = reports.createTest("Check invalid email address validation")
                .assignAuthor("Fenil")
                .assignCategory(getClass().getName())
                .assignDevice(driver.getClass().getSimpleName())
                .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                        "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                        "Check invalid email address validation").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected14=" + expected14);
        System.out.println("actual14=" + actual14);
        Assert.assertEquals("Email validation not work", expected14, actual14);
        if (actual14.equalsIgnoreCase(expected14))
        {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        }
        else
        {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }
    @Test(priority = 8)
    public void InstructorManagementInsertDataTimePasswordValidationTest8() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add Instructor']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnNewInstructor = driver.findElement(By.xpath("//button[normalize-space()='Add Instructor']"));
        btnNewInstructor.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement PasswordInput = driver.findElement(By.name("password"));
        String Pass="123";
        PasswordInput.sendKeys(Pass);
        WebElement GenderInput = driver.findElement(By.name("gender"));
        Select select =new Select(GenderInput);
        select.selectByVisibleText("Male");
        WebElement responseMessage = driver.findElement(By.xpath("//span[contains(text(),'Password must include at least 8 character, one sp')]"));
        String responseText = responseMessage.getText();
        String lengthRegex = ".{8,}";
        String specialCharRegex = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?].*";
        String digitRegex = ".*\\d.*";
        String uppercaseRegex = ".*[A-Z].*";
        String lowercaseRegex = ".*[a-z].*";
        String combinedRegex = lengthRegex + specialCharRegex + digitRegex + uppercaseRegex + lowercaseRegex;
        Pattern pattern = Pattern.compile(combinedRegex);
        Matcher matcher = pattern.matcher(responseText);
        System.out.println("\u001B[33m-----TestCases15:-Check password must include at least 8 character, one special character, one digit, one uppercase and one lowercase letter validation-----\u001B[0m");
        if (matcher.matches()) {
            System.out.println("The password " + Pass + " is valid.");
        } else {
            System.out.println("The password  " + Pass + " is not valid.");
        }
        String expected15 = "Password must include at least 8 character, one special character, one digit, one uppercase and one lowercase letter";
        String actual15 = driver.findElement(By.xpath("//span[contains(text(),'Password must include at least 8 character, one sp')]")).getText();
        test = reports.createTest("Check password must include at least 8 character, one special character, one digit, one uppercase and one lowercase letter validation")
                .assignAuthor("Fenil")
                .assignCategory(getClass().getName())
                .assignDevice(driver.getClass().getSimpleName())
                .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                        "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                        "Check password must include at least 8 character, one special character, one digit, one uppercase and one lowercase letter validation").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected15=" + expected15);
        System.out.println("actual15=" + actual15);
        Assert.assertEquals("Password must include at least 8 character, one special character, one digit, one uppercase and one lowercase letter not work", expected15, actual15);
        if (actual15.equalsIgnoreCase(expected15)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }
    @Test(priority = 2)
    public void InstructorManagementInsertFunctionalityWithValidDataTest9() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Instructor Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement InstructorManagementMenu = driver.findElement(By.xpath("//span[text()='Instructor Management']"));
        InstructorManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add Instructor']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnNewInstructor = driver.findElement(By.xpath("//button[normalize-space()='Add Instructor']"));
        btnNewInstructor.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement FirstNameInput = driver.findElement(By.name("firstName"));
        FirstNameInput.sendKeys("Testing");
        WebElement LastNameInput = driver.findElement(By.name("lastName"));
        LastNameInput.sendKeys("Automation");
        WebElement EmailIDInput = driver.findElement(By.name("email"));
        EmailIDInput.sendKeys("Testnewinsertemail" + System.currentTimeMillis() + "@gmail.com");
        WebElement PasswordInput = driver.findElement(By.name("password"));
        PasswordInput.sendKeys("Fenil@1212");
        WebElement GenderInput = driver.findElement(By.name("gender"));
        Select selectGender=new Select(GenderInput);
        selectGender.selectByVisibleText("Male");
        WebElement CountryInput = driver.findElement(By.name("countryId"));
        Select selectCountry=new Select(CountryInput);
        selectCountry.selectByVisibleText("India");
        WebElement MobileNoInput = driver.findElement(By.name("mobileNo"));
        MobileNoInput.sendKeys(generateRandomMobileNumber());
        WebElement StatusInput = driver.findElement(By.name("status"));
        Select selectStatus=new Select(StatusInput);
        selectStatus.selectByVisibleText("Active");
        WebElement QualificationInput = driver.findElement(By.name("qualification"));
        QualificationInput.sendKeys("TestQualification");
        WebElement DescriptionInput = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
        DescriptionInput.sendKeys("TestDescription");
        WebElement LinkedinUrlInput = driver.findElement(By.xpath("//input[@placeholder='Linkedin Url']"));
        LinkedinUrlInput.sendKeys("https://in.linkedin.com/");
        WebElement TwitterUrlInput = driver.findElement(By.name("twitterUrl"));
        TwitterUrlInput.sendKeys("https://twitter.com/login");
        WebElement InstagramUrlInput = driver.findElement(By.name("instagramUrl"));
        InstagramUrlInput.sendKeys("https://www.instagram.com/");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-12']")));
        element.click();
        WebElement fileInput = driver.findElement(By.id("upload"));
        File file = new File("/home/j/IdeaProjects/HoGrowthAdminPanel/src/main/java/download.jpeg");
        String filePath = file.getAbsolutePath();
        fileInput.sendKeys(filePath);
        WebElement btnSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
        btnSubmit.click();
        System.out.println("\u001B[33m-----TestCases16:-Check insert functionality with valid data-----\u001B[0m");
        String expected16 = "Instructor created successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual16 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check insert functionality with valid data")
                .assignAuthor("Fenil")
                .assignCategory(getClass().getName())
                .assignDevice(driver.getClass().getSimpleName())
                .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                        "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                        "Check insert functionality with valid data").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected16=" + expected16);
        System.out.println("actual16=" + actual16);
        Assert.assertEquals("Insert functionality not work", expected16, actual16);
        if (actual16.equalsIgnoreCase(expected16)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

}


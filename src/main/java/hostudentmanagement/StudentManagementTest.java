package hostudentmanagement;

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

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class StudentManagementTest extends AdminBaseTest {

    @Test
    public void StudentManagementListTest() throws IOException {
        AdminLogin();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Student Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement StudentManagementMenu = driver.findElement(By.xpath("//span[text()='Student Management']"));
        StudentManagementMenu.click();
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
        System.out.println("\u001B[33m-----TestCases1:-Check student management list page pagination wise data displayed properly-----\u001B[0m");
        String expected1 = "https://hogrowth.jainam.in/backoffice/apps/student-management/student";
        String actual1 = driver.getCurrentUrl();
        test = reports.createTest("Check student management list page pagination wise data displayed properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check student management list page pagination wise data displayed properly").build());
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
        Assert.assertEquals("In student management list page data not display properly", expected1, actual1);

    }

    @Test
    public void studentManagementSearchingDataTest3() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Student Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnStudentManagementMenu = driver.findElement(By.xpath("//span[text()='Student Management']"));
        btnStudentManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Student']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement searchVal = driver.findElement(By.xpath("//input[@placeholder='Search Student']"));
        searchVal.sendKeys("fenil");
        WebElement btnSearch=driver.findElement(By.xpath("//button[text()=\"Search\"]"));
        btnSearch.click();
        List<WebElement> rowsElements1 = driver.findElements(By.xpath("//tbody/tr"));
        //List<WebElement> filterVal= rowsElements1.stream().filter(rowsElementsVal->rowsElementsVal.getText().contains("Admin")).toList();
        System.out.println("\u001B[33m-----TestCases2:-Check student management list page data searching functionality properly work-----\u001B[0m");
        String expected2 = "fenil test";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]
        }
        String actual2 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]")).getText();
        test = reports.createTest("Check student management list page data searching functionality properly work").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check student management list page data searching functionality properly work").build());
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
        Assert.assertEquals("In student management list page data searching functionality not working properly", expected2, actual2);
    }

    @Test
    public void studentManagementFilterDataTest3() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Student Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnStudentManagementMenu = driver.findElement(By.xpath("//span[text()='Student Management']"));
        btnStudentManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Filter']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnFilterMenu = driver.findElement(By.xpath("//button[text()='Filter']"));
        btnFilterMenu.click();
//        List<WebElement> rowsElements1 = driver.findElements(By.xpath("//tbody/tr[1]"));
        // List<WebElement> filterVal= rowsElements1.stream().filter(rowsElementsVal->rowsElementsVal.getText().contains("Student")).toList();
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
        System.out.println("\u001B[33m-----TestCases3:-Check student management list page data filteration functionality properly work-----\u001B[0m");
        String expected3 = "ACTIVE";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[3]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual3 = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        test = reports.createTest("Check student management list page data filter functionality properly work").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check student management list page data filter functionality properly work").build());
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
        Assert.assertEquals("In student management list page data filter functionality not working properly", expected3, actual3);
    }

    @Test
    public void studentManagementActionViewTest4() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Student Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnStudentManagementMenu = driver.findElement(By.xpath("//span[text()='Student Management']"));
        btnStudentManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[5]/a[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]"));
        actionMenu.click();
        WebElement btnViewDetails = driver.findElement(By.xpath("(//a[@class='menu-link px-3'][normalize-space()='View'])[1]"));
        btnViewDetails.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='View Student']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement fullNameDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[1]//div[1]"));
        String fullNameDataValue = fullNameDataElement.getText();
        WebElement mobileStdNoDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[2]//div[1]"));
        String mobileStdNoDataValue = mobileStdNoDataElement.getText();
        WebElement mobileNoDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[3]//div[1]"));
        String mobileNoDataValue = mobileNoDataElement.getText();
        WebElement countryDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[4]//div[1]"));
        String countryDataValue = countryDataElement.getText();
        WebElement goalDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[5]//div[1]"));
        String goalDataValue = goalDataElement.getText();
        WebElement qualificationDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[6]//div[1]"));
        String qualificationDataValue = qualificationDataElement.getText();
        WebElement twitterUrlDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[7]//div[1]"));
        String twitterUrlDataValue = twitterUrlDataElement.getText();
        WebElement linkedinDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[8]//div[1]"));
        String linkedinUrlDataValue = linkedinDataElement.getText();
        WebElement instagramDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[9]//div[1]"));
        String instagramUrlDataValue = instagramDataElement.getText();
        WebElement createdAtDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[10]//div[1]"));
        String createdAtDataValue = createdAtDataElement.getText();
        WebElement createdByDataElement = driver.findElement(By.xpath("//div[@class='card-body p-8']//div[11]//div[1]"));
        String createdByDataValue = createdByDataElement.getText();
        System.out.println("\u001B[33m-----TestCases4:-Check student wise student management details properly display -----\u001B[0m");
        WebElement detailsPageTitle = driver.findElement(By.xpath("//h1[normalize-space()='View Student']"));
        assertTrue(detailsPageTitle.isDisplayed());
        test = reports.createTest("Check student wise student management details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check student wise student management details properly display").build());
        Assert.assertTrue(true);

        if (fullNameDataValue.trim().isEmpty()) {
            System.out.println("The full name data value is blank.");
        } else {
            System.out.println("The full name data value is not blank: " + fullNameDataValue);
        }

        if (mobileStdNoDataValue.trim().isEmpty()) {
            System.out.println("The mobile std no data value is blank.");
        } else {
            System.out.println("The mobile std no data value is not blank: " + mobileStdNoDataValue);
        }

        if (mobileNoDataValue.trim().isEmpty()) {
            System.out.println("The mobile no data value is blank.");
        } else {
            System.out.println("The mobile no data value is not blank: " + mobileNoDataValue);
        }

        if (countryDataValue.trim().isEmpty()) {
            System.out.println("The country data value is blank.");
        } else {
            System.out.println("The country data value is not blank: " + countryDataValue);
        }

        if (goalDataValue.trim().isEmpty()) {
            System.out.println("The goal data value is blank.");
        } else {
            System.out.println("The goal data value is not blank: " + goalDataValue);
        }

        if (qualificationDataValue.trim().isEmpty()) {
            System.out.println("The qualification data value is blank.");
        } else {
            System.out.println("The qualification data value is not blank: " + qualificationDataValue);
        }

        if (twitterUrlDataValue.trim().isEmpty()) {
            System.out.println("The twitter url data value is blank.");
        } else {
            System.out.println("The twitter url data value is not blank: " + twitterUrlDataValue);
        }

        if (linkedinUrlDataValue.trim().isEmpty()) {
            System.out.println("The linkedin url data value is blank.");
        } else {
            System.out.println("The linkedin url data value is not blank: " + linkedinUrlDataValue);
        }

        if (instagramUrlDataValue.trim().isEmpty()) {
            System.out.println("The instagram url data value is blank.");
        } else {
            System.out.println("The instagram url data value is not blank: " + instagramUrlDataValue);
        }

        if (createdAtDataValue.trim().isEmpty()) {
            System.out.println("The createdAt data value is blank.");
        } else {
            System.out.println("The createdAt data value is not blank: " + createdAtDataValue);
        }

        if (createdByDataValue.trim().isEmpty()) {
            System.out.println("The createdBy data value is blank.");
        } else {
            System.out.println("The createdBy data value is not blank: " + createdByDataValue);
        }


        if (fullNameDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The full name data value is blank. Expected: Not blank, Actual: " + fullNameDataValue);
            test.log(Status.PASS, "Test Passed!");
        }



        if (mobileStdNoDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The mobile std no data value is blank. Expected: Not blank, Actual: " + mobileStdNoDataValue);

        }


        if (mobileNoDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The mobile no data value is blank. Expected: Not blank, Actual: " + mobileNoDataValue);
        }


        if (countryDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The country data value is blank. Expected: Not blank, Actual: " + countryDataValue);
        }

        if (goalDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The goal data value is blank. Expected: Not blank, Actual: " + goalDataValue);
        }

        if (qualificationDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The qualification data value is blank. Expected: Not blank, Actual: " + qualificationDataValue);
        }

        if (twitterUrlDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The twitter url data value is blank. Expected: Not blank, Actual: " + twitterUrlDataValue);
        }

        if (linkedinUrlDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The linkedin url data value is blank. Expected: Not blank, Actual: " + linkedinUrlDataValue);
        }

        if (instagramUrlDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The instagram url data value is blank. Expected: Not blank, Actual: " + instagramUrlDataValue);
        }

        if (createdAtDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The createdAt data value is blank. Expected: Not blank, Actual: " + createdAtDataValue);
        }
        if (createdByDataValue.isEmpty()) {
            // Test case fails with expected and actual values
            Assert.fail("The createdBy data value is blank. Expected: Not blank, Actual: " + createdByDataValue);
        }
    }
    @Test
    public void StudentManagementActionEditDataTest5() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        AdminLogin();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Student Management']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnStudentManagementMenu = driver.findElement(By.xpath("//span[text()='Student Management']"));
        btnStudentManagementMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[5]/a[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[text()='Actions'])[1]"));
        actionMenu.click();
        WebElement btnEdit = driver.findElement(By.xpath("(//a[text()='Edit'])[1]"));
        btnEdit.click();
        System.out.println("\u001B[33m-----TestCases5:-Check edit time student management details edit functionality working properly-----\u001B[0m");
        //FullName
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Full Name']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement fullNameDataElement = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        String fullNameDataValue = fullNameDataElement.getAttribute("value");
        System.out.println("Full Name Data Value: " + fullNameDataValue);

        if (fullNameDataValue.trim().isEmpty()) {
            System.out.println("The first name data value is blank.");
        } else {

            fullNameDataElement.sendKeys(Keys.CONTROL + "a");
            fullNameDataElement.sendKeys(Keys.DELETE);
            fullNameDataElement.sendKeys("Test Name");
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
        //Goal
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Goal']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement GoalDropdownElement = driver.findElement(By.xpath("//select[@placeholder='Goal']"));
        Select GoalDropdown = new Select(GoalDropdownElement);
        WebElement GoalSelectedOption = GoalDropdown.getFirstSelectedOption();
        String GoalSelectedValue = GoalSelectedOption.getText();
        System.out.println("Goal Data Value: " + GoalSelectedValue);
        if (GoalSelectedValue.trim().isEmpty()) {
            System.out.println("The goal data value is blank.");
        } else {
            GoalDropdownElement.click();
            GoalDropdown.selectByVisibleText("Students");
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

        //StudentImage

        WebElement fileInput = driver.findElement(By.id("upload"));
        String absoluteFilePath = "/home/j/IdeaProjects/HoGrowthAdminPanel/src/main/java/download.jpeg";
        fileInput.sendKeys(absoluteFilePath);
        WebElement btnEditUserData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditUserData.click();
        String expected5 = "Student updated successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual5 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check edit time student management details edit functionality working properly").assignAuthor("Fenil").assignCategory("Student Management Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check edit time student management details edit functionality working properly").build());
        Assert.assertTrue(true);
        System.out.println("expected5=" + expected5);
        System.out.println("actual5=" + actual5);
        Assert.assertEquals("Edit time student management details edit functionality not working properly", expected5, actual5);
        if (actual5.equalsIgnoreCase(expected5)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }
}

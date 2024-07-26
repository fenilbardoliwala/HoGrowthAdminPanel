package hocoursemanagement;

import com.aventstack.extentreports.MediaEntityBuilder;
import hoadminbasereport.AdminBaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CourseSkillTest extends AdminBaseTest {

    @Test(priority = 1)
    public void CourseSkillListTest1() throws IOException, InterruptedException {
        AdminLogin();
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Course Management')]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion = driver.findElement(By.xpath("//span[contains(text(),'Course Management')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Skills']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseSkillMenu = driver.findElement(By.xpath("//span[text()='Course Skills']"));
        CourseSkillMenu.click();
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
        System.out.println("\u001B[33m-----TestCases1:-Check course skills list page pagination wise data displayed properly-----\u001B[0m");
        String expected1 = "https://hogrowth.jainam.in/backoffice/apps/course-management/course-skill";
        String actual1 = driver.getCurrentUrl();
        test = reports.createTest("Check course skills list page pagination wise data displayed properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course skills list page pagination wise data displayed properly").build());
        assertTrue(true);//pass
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
        Assert.assertEquals("In course skills list page data not display properly", expected1, actual1);
    }

    @Test(priority = 3)
    public void CourseSkillSearchingDataTest2() throws InterruptedException, IOException {
       AdminLogin();
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Course Management')]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion = driver.findElement(By.xpath("//span[contains(text(),'Course Management')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion.click();
        accordion.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Skills']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseSkillMenu = driver.findElement(By.xpath("//span[text()='Course Skills']"));
        CourseSkillMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Course Skill']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        try {
            WebElement searchVal = driver.findElement(By.xpath("//input[@placeholder='Search Course Skill']"));
            searchVal.sendKeys("Equity");
            WebElement btnSearch=driver.findElement(By.xpath("//button[text()=\"Search\"]"));
            btnSearch.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]")));
            test = reports.createTest("Check course skills list page data searching functionality properly work").assignAuthor("Fenil").assignCategory(getClass().
                    getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                    ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course skills list page data searching functionality properly work").build());

            String actual2 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/div[1]")).getText();
            String expected2 = "Equity";

            System.out.println("\u001B[33m-----TestCases2:-Check course skills list page data searching functionality properly work-----\u001B[0m");
            System.out.println("expected2=" + expected2);
            System.out.println("actual2=" + actual2);

            if (actual2.contains(expected2)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }

            // Assertion for TestNG or JUnit
            Assert.assertTrue("In course skills list page data searching functionality not working properly", actual2.contains(expected2));

        } finally {
            System.out.println("In course skills list page data searching functionality working properly");
        }
    }

    @Test(priority = 7)
    public void CourseSkillActionDeleteTest3() throws InterruptedException, IOException {
        AdminLogin();
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Course Management')]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion = driver.findElement(By.xpath("//span[contains(text(),'Course Management')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Skills']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseSkillMenu = driver.findElement(By.xpath("//span[text()='Course Skills']"));
        CourseSkillMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[4]/a[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/a[1]"));
        actionMenu.click();
        WebElement btnDelete=driver.findElement(By.xpath("(//a[@class='menu-link px-3'][normalize-space()='Delete'])[1]"));
        btnDelete.click();
        WebElement btnPopUpDelete=driver.findElement(By.xpath("//div[@class='btn btn-primary btn-sm']"));
        btnPopUpDelete.click();
        System.out.println("\u001B[33m-----TestCases3:-Check record delete functionality work with proper validation-----\u001B[0m");
        String expected3 = "Course skill deleted successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual3 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check record delete functionality work with proper validation").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check record delete functionality work with proper validation").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected3=" + expected3);
        System.out.println("actual3=" + actual3);
        Assert.assertEquals("Record delete functionality not work", expected3, actual3);
        if (actual3.equalsIgnoreCase(expected3))
        {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        }
        else
        {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

    @Test(priority = 4)
    public void CourseLanguagesActionViewTest4() throws IOException, InterruptedException {
        AdminLogin();
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Course Management')]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion = driver.findElement(By.xpath("//span[contains(text(),'Course Management')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Skills']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseSkillMenu = driver.findElement(By.xpath("//span[text()='Course Skills']"));
        CourseSkillMenu.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[4]/a[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/a[1]"));
        actionMenu.click();
        WebElement btnViewDetails = driver.findElement(By.xpath("(//a[@class='menu-link px-3'][normalize-space()='View'])[1]"));
        btnViewDetails.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='View Course Skills']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='First name'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement SkillNameTextBox = driver.findElement(By.xpath("(//input[@placeholder='First name'])[1]"));
        String SkillNameValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", SkillNameTextBox);
        WebElement CreateAtTextBox = driver.findElement(By.xpath("(//input[@placeholder='Created At'])[1]"));
        String CreateAtValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", CreateAtTextBox);
        WebElement CreateByTextBox = driver.findElement(By.xpath("(//input[@placeholder='Created By'])[1]"));
        String CreateByValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", CreateByTextBox);

        System.out.println("\u001B[33m-----TestCases4:-Check course skills details properly display -----\u001B[0m");
        WebElement detailsPageTitle = driver.findElement(By.xpath("//h1[normalize-space()='View Course Skills']"));
        assertTrue(detailsPageTitle.isDisplayed());
        test = reports.createTest("Check course skills details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course skills details properly display").build());
        Assert.assertTrue(true);

        if (SkillNameValue.trim().isEmpty()) {
            System.out.println("The skill name data value is blank.");
            test.fail("The skill name data value is blank.");
        } else {
            System.out.println("The skill name  data value is not blank: " + SkillNameValue);
        }

        if (CreateAtValue.trim().isEmpty()) {
            System.out.println("The create at data value is blank.");
            test.fail("The create at data value is blank.");
        } else {
            System.out.println("The create at data value is not blank: " + CreateAtValue);
        }

        if (CreateByValue.trim().isEmpty()) {
            System.out.println("The created by data value is blank.");
            test.fail("The created by data value is blank.");
        } else {
            System.out.println("The created by data value is not blank: " + CreateByValue);
        }


        if (SkillNameValue.isEmpty()) {
            Assert.fail("The skill name  data value is blank. Expected: Not blank, Actual: " + SkillNameValue);
        }

        if (CreateAtValue.isEmpty()) {
            Assert.fail("The created at data value is blank. Expected: Not blank, Actual: " + CreateAtValue);
        }

        if (CreateByValue.isEmpty()) {
            Assert.fail("The created by data value is blank. Expected: Not blank, Actual: " + CreateByValue);
        }
    }

    @Test(priority = 6)
    public void CourseLanguagesActionEditDataTest5() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Course Management')]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion = driver.findElement(By.xpath("//span[contains(text(),'Course Management')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Languages']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseLanguageMenu = driver.findElement(By.xpath("//span[text()='Course Languages']"));
        CourseLanguageMenu.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[text()='Actions'])[1]"));
        actionMenu.click();
        WebElement btnEdit = driver.findElement(By.xpath("(//a[text()='Edit'])[1]"));
        btnEdit.click();
        System.out.println("\u001B[33m-----TestCases5:-Check edit time course languages details edit functionality working properly-----\u001B[0m");
        //Name
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Name']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement  NameDataElement = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        String NameDataValue = NameDataElement.getAttribute("value");
        System.out.println("Name Data Value: " + NameDataValue);

        if (NameDataValue.trim().isEmpty()) {
            System.out.println("The name data value is blank.");
        } else {

            NameDataElement.sendKeys(Keys.CONTROL + "a");
            NameDataElement.sendKeys(Keys.DELETE);
            NameDataElement.sendKeys("African Language");
        }

        //ShortCode
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Short Code']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement ShortCodeDataElement = driver.findElement(By.xpath("//input[@placeholder='Short Code']"));
        String ShortCodeDataValue = ShortCodeDataElement.getAttribute("value");
        System.out.println("Short Code Data Value: " + ShortCodeDataValue);

        if (ShortCodeDataValue.trim().isEmpty()) {
            System.out.println("The short code data value is blank.");
        } else {

            ShortCodeDataElement.sendKeys(Keys.CONTROL + "a");
            ShortCodeDataElement.sendKeys(Keys.DELETE);
            ShortCodeDataElement.sendKeys("AL");
        }

        WebElement btnEditLangData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditLangData.click();
        String expected5 = "Course language updated successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual5 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check edit time course language details edit functionality working properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check edit time course language details edit functionality working properly").build());
        Assert.assertTrue(true);
        System.out.println("expected5=" + expected5);
        System.out.println("actual5=" + actual5);
        Assert.assertEquals("Edit time course language details edit functionality not working properly", expected5, actual5);
        if (actual5.equalsIgnoreCase(expected5)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

    @Test(priority = 5)
    public void CourseLanguagesInsertBlankDataTest6() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Course Management')]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion = driver.findElement(By.xpath("//span[contains(text(),'Course Management')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Languages']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseLanguageMenu = driver.findElement(By.xpath("//span[text()='Course Languages']"));
        CourseLanguageMenu.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Course Language']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnNewLang = driver.findElement(By.xpath("//button[text()='Add Course Language']"));
        btnNewLang.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement NameInput = driver.findElement(By.name("name"));

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("shortCode")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement ShortCodeInput = driver.findElement(By.name("shortCode"));


        NameInput.clear();
        ShortCodeInput.clear();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text-center pt-15']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        driver.findElement(By.xpath("//span[text()='Submit']")).click();

        System.out.println("\u001B[33m-----TestCases6:-Check blank name validation-----\u001B[0m");
        try {
            WebElement errorMessageFirstName = driver.findElement(By.xpath("//span[normalize-space()='Name is required']"));
            // Check blank field handled or not
            if (errorMessageFirstName.isDisplayed()) {
                System.out.println("Blank name fields handled correctly.");
            } else {
                System.out.println("Name error handling is not working as expected.");
            }
            String expected6 = "Name is required";
            String actual6 = driver.findElement(By.xpath("//span[normalize-space()='Name is required']")).getText();
            test = reports.createTest("Check blank name validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank name validation").build());
            Assert.assertTrue(true); // pass
            System.out.println("expected6=" + expected6);
            System.out.println("actual6=" + actual6);
            Assert.assertEquals("Name required field validation not work ", expected6, actual6);
            if (actual6.equalsIgnoreCase(expected6)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank name validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank name validation").build());
            }
            test.fail(e.getMessage());
            test.fail("Name require field validation not shown");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank name validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank name validation").build());
            }
            test.fail(e.getMessage());
        }

        System.out.println("\u001B[33m-----TestCases7:-Check blank short code validation-----\u001B[0m");
        try {
            WebElement errorMessageShortCode = driver.findElement(By.xpath("//span[normalize-space()='Short code is required']"));
            // Check blank field handled or not
            if (errorMessageShortCode.isDisplayed()) {
                System.out.println("Blank short code fields handled correctly.");
            } else {
                System.out.println("Short code error handling is not working as expected.");
            }

            String expected7 = "Short code is required";
            String actual7 = driver.findElement(By.xpath("//span[normalize-space()='Short code is required']")).getText();

            test = reports.createTest("Check blank short code validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank short code validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected7=" + expected7);
            System.out.println("actual7=" + actual7);

            Assert.assertEquals("Short code required field validation not work ", expected7, actual7);

            if (actual7.equalsIgnoreCase(expected7)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank short code validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank short code validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank short code validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank short code validation").build());
            }
            test.fail(e.getMessage());
        }

    }

    @Test(priority = 2)
    public void CourseLanguagesInsertFunctionalityWithValidDataTest7() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.navigate().refresh();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Course Management')]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion = driver.findElement(By.xpath("//span[contains(text(),'Course Management')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Languages']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseLanguageMenu = driver.findElement(By.xpath("//span[text()='Course Languages']"));
        CourseLanguageMenu.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Course Language']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnNewLang = driver.findElement(By.xpath("//button[text()='Add Course Language']"));
        btnNewLang.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement NameInput = driver.findElement(By.name("name"));
        NameInput.sendKeys("American Language"+RandomsNumber());
        WebElement ShortCodeInput = driver.findElement(By.name("shortCode"));
        ShortCodeInput.sendKeys("AAL");

        WebElement btnSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
        btnSubmit.click();
        System.out.println("\u001B[33m-----TestCases8:-Check insert functionality with valid data-----\u001B[0m");
        String expected8 = "Course language created successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual8 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check insert functionality with valid data")
                .assignAuthor("Fenil")
                .assignCategory(getClass().getName())
                .assignDevice(driver.getClass().getSimpleName())
                .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                        "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                        "Check insert functionality with valid data").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected8=" + expected8);
        System.out.println("actual8=" + actual8);
        Assert.assertEquals("Insert functionality not work", expected8, actual8);
        if (actual8.equalsIgnoreCase(expected8)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

}

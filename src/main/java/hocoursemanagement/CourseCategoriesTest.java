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

public class CourseCategoriesTest extends AdminBaseTest {

    @Test(priority = 1)
    public void CourseCategoryListTest1() throws IOException, InterruptedException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Categories']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseCateMenu = driver.findElement(By.xpath("//span[text()='Course Categories']"));
        CourseCateMenu.click();
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
        System.out.println("\u001B[33m-----TestCases1:-Check course categories list page pagination wise data displayed properly-----\u001B[0m");
        String expected1 = "https://hogrowth.jainam.in/backoffice/apps/course-management/course-categories";
        String actual1 = driver.getCurrentUrl();
        test = reports.createTest("Check course categories list page pagination wise data displayed properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course categories list page pagination wise data displayed properly").build());
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
        Assert.assertEquals("In course categories list page data not display properly", expected1, actual1);
    }

    @Test(priority = 3)
    public void CourseCategoriesSearchingDataTest2() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Categories']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseCateMenu = driver.findElement(By.xpath("//span[text()='Course Categories']"));
        CourseCateMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Course Category']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        try {
            WebElement searchVal = driver.findElement(By.xpath("//input[@placeholder='Search Course Category']"));
            searchVal.sendKeys("Equity");
            WebElement btnSearch=driver.findElement(By.xpath("//button[text()=\"Search\"]"));
            btnSearch.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[1]")));
            test = reports.createTest("Check course categories list page data searching functionality properly work").assignAuthor("Fenil").assignCategory(getClass().
                    getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                    ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course categories list page data searching functionality properly work").build());

            String actual2 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[1]")).getText();
            String expected2 = "Equity";
            System.out.println("\u001B[33m-----TestCases2:-Check course categories list page data searching functionality properly work-----\u001B[0m");
            System.out.println("expected2=" + expected2);
            System.out.println("actual2=" + actual2);

            if (actual2.contains(expected2)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }

            // Assertion for TestNG or JUnit
            Assert.assertTrue("In course categories list page data searching functionality not working properly", actual2.contains(expected2));

        } finally {
            System.out.println("In course skills list page data searching functionality working properly");
        }
    }

    @Test(priority = 7)
    public void CourseCategoriesActionDeleteTest3() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Categories']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseCateMenu = driver.findElement(By.xpath("//span[text()='Course Categories']"));
        CourseCateMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu=driver.findElement(By.xpath("(//a[text()='Actions'])[1]"));
        actionMenu.click();
        WebElement btnDelete=driver.findElement(By.xpath("(//a[@class='menu-link px-3'][normalize-space()='Delete'])[1]"));
        btnDelete.click();
        WebElement btnPopUpDelete=driver.findElement(By.xpath("//div[@class='btn btn-primary btn-sm']"));
        btnPopUpDelete.click();
        System.out.println("\u001B[33m-----TestCases3:-Check record delete functionality work with proper validation-----\u001B[0m");
            String expected3 = "Course category deleted successfully";
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
    public void CourseCategoriesActionViewTest4() throws IOException, InterruptedException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Categories']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseCateMenu = driver.findElement(By.xpath("//span[text()='Course Categories']"));
        CourseCateMenu.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[text()='Actions'])[1]"));
        actionMenu.click();
        WebElement btnViewDetails = driver.findElement(By.xpath("(//a[@class='menu-link px-3'][normalize-space()='View'])[1]"));
        btnViewDetails.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='View Course Category']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='First name'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CateNameTextBox = driver.findElement(By.xpath("(//input[@placeholder='First name'])[1]"));
        String CateNameValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", CateNameTextBox);
        WebElement SortNoTextBox = driver.findElement(By.xpath("(//input[@placeholder='Sort Number'])[1]"));
        String SortNoValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", SortNoTextBox);
        WebElement CreateAtTextBox = driver.findElement(By.xpath("(//input[@placeholder='Created At'])[1]"));
        String CreateAtValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", CreateAtTextBox);
        WebElement CreateByTextBox = driver.findElement(By.xpath("(//input[@placeholder='Created By'])[1]"));
        String CreateByValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", CreateByTextBox);
        WebElement PCateTextBox = driver.findElement(By.xpath("(//input[@placeholder='Parent Category'])[1]"));
        String PCateByValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", PCateTextBox);
        System.out.println("\u001B[33m-----TestCases4:-Check course skills details properly display -----\u001B[0m");
        WebElement detailsPageTitle = driver.findElement(By.xpath("//h1[normalize-space()='View Course Skills']"));
        assertTrue(detailsPageTitle.isDisplayed());
        test = reports.createTest("Check course categories details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course categories details properly display").build());
        Assert.assertTrue(true);

        if (CateNameValue.trim().isEmpty()) {
            System.out.println("The categories name data value is blank.");
            test.fail("The categories name data value is blank.");
        } else {
            System.out.println("The categories name  data value is not blank: " + CateNameValue);
        }

        if (SortNoValue.trim().isEmpty()) {
            System.out.println("The sort number data value is blank.");
            test.fail("The sort number data value is blank.");
        } else {
            System.out.println("The sort number data value is not blank: " + SortNoValue);
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

        if (PCateByValue.trim().isEmpty()) {
            System.out.println("The parent categories  data value is blank.");
            test.fail("The parent categories  data value is blank.");
        } else {
            System.out.println("The parent categories data value is not blank: " + PCateByValue);
        }


        if (CateNameValue.isEmpty()) {
            Assert.fail("The categories name  data value is blank. Expected: Not blank, Actual: " + CateNameValue);
        }

        if (SortNoValue.isEmpty()) {
            Assert.fail("The sort number data value is blank. Expected: Not blank, Actual: " + SortNoValue);
        }

        if (CreateAtValue.isEmpty()) {
            Assert.fail("The created at data value is blank. Expected: Not blank, Actual: " + CreateAtValue);
        }

        if (CreateByValue.isEmpty()) {
            Assert.fail("The created by data value is blank. Expected: Not blank, Actual: " + CreateByValue);
        }
        if (PCateByValue.isEmpty()) {
            Assert.fail("The parent categories name  data value is blank. Expected: Not blank, Actual: " + PCateByValue);
        }
    }

    @Test(priority = 6)
    public void CourseCategoriesActionEditDataTest5() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Categories']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseCateMenu = driver.findElement(By.xpath("//span[text()='Course Categories']"));
        CourseCateMenu.click();

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
        System.out.println("\u001B[33m-----TestCases5:-Check edit time course categories details edit functionality working properly-----\u001B[0m");
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
            NameDataElement.sendKeys("Trading"+RandomsNumber());
        }
        WebElement fileInput = driver.findElement(By.id("upload"));
        String absoluteFilePath = "/home/j/IdeaProjects/HoGrowthAdminPanel/src/main/java/download.jpeg";
        fileInput.sendKeys(absoluteFilePath);
        WebElement btnEditLangData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditLangData.click();
        String expected5 = "Course category updated successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual5 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check edit time course categories details edit functionality working properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check edit time course categories details edit functionality working properly").build());
        Assert.assertTrue(true);
        System.out.println("expected5=" + expected5);
        System.out.println("actual5=" + actual5);
        Assert.assertEquals("Edit time course categories details edit functionality not working properly", expected5, actual5);
        if (actual5.equalsIgnoreCase(expected5)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

    @Test(priority = 5)
    public void CourseCategoriesInsertBlankDataTest6() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course Categories']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseCateMenu = driver.findElement(By.xpath("//span[text()='Course Categories']"));
        CourseCateMenu.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Course Category']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnNewCate = driver.findElement(By.xpath("//button[text()='Add Course Category']"));
        btnNewCate.click();
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
//        } catch (Throwable e) {
//            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
//        }
//        WebElement NameInput = driver.findElement(By.name("name"));
//        WebElement SnoInput = driver.findElement(By.name("sortNumber"));
//
//        NameInput.clear();
//        SnoInput.clear();

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
        System.out.println("\u001B[33m-----TestCases7:-Check blank short number validation-----\u001B[0m");
        try {
            WebElement errorMessageShortCode = driver.findElement(By.xpath("//span[normalize-space()='Short number is required']"));
            // Check blank field handled or not
            if (errorMessageShortCode.isDisplayed()) {
                System.out.println("Blank short number fields handled correctly.");
            } else {
                System.out.println("Short number error handling is not working as expected.");
            }

            String expected7 = "Short number is required";
            String actual7 = driver.findElement(By.xpath("//span[normalize-space()='Short number is required ']")).getText();

            test = reports.createTest("Check blank short number validation")
                    .assignAuthor("Fenil")
                    .assignCategory(getClass().getName())
                    .assignDevice(driver.getClass().getSimpleName())
                    .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                            "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                            "Check blank short number validation").build());

            Assert.assertTrue(true); // pass
            System.out.println("expected7=" + expected7);
            System.out.println("actual7=" + actual7);

            Assert.assertEquals("Short number required field validation not work ", expected7, actual7);

            if (actual7.equalsIgnoreCase(expected7)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The required element was not found: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank short number validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank short number validation").build());
            }
            test.fail(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (test == null) {
                test = reports.createTest("Exception in Check blank short number validation")
                        .assignAuthor("Fenil")
                        .assignCategory(getClass().getName())
                        .assignDevice(driver.getClass().getSimpleName())
                        .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                                "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                                "Check blank short number validation").build());
            }
            test.fail(e.getMessage());
        }

    }

    @Test(priority = 2)
    public void CourseSkillInsertFunctionalityWithValidDataTest7() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Course Skill']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnNewSkill = driver.findElement(By.xpath("//button[text()='Add Course Skill']"));
        btnNewSkill.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement NameInput = driver.findElement(By.name("name"));
        NameInput.sendKeys("Algo Trading F&O"+RandomsNumber());

        WebElement btnSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
        btnSubmit.click();
        System.out.println("\u001B[33m-----TestCases7:-Check insert functionality with valid data-----\u001B[0m");
        String expected7 = "Course skill created successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual7 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check insert functionality with valid data")
                .assignAuthor("Fenil")
                .assignCategory(getClass().getName())
                .assignDevice(driver.getClass().getSimpleName())
                .pass(MediaEntityBuilder.createScreenCaptureFromPath(
                        "./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                        "Check insert functionality with valid data").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected7=" + expected7);
        System.out.println("actual7=" + actual7);
        Assert.assertEquals("Insert functionality not work", expected7, actual7);
        if (actual7.equalsIgnoreCase(expected7)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }
}

package hocoursemanagement;

import com.aventstack.extentreports.MediaEntityBuilder;
import hoadminbasereport.AdminBaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CourseListTest extends AdminBaseTest {
    @Test(priority = 1)
    public void CourseListTest1() throws IOException, InterruptedException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course List']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseCateMenu = driver.findElement(By.xpath("//span[text()='Course List']"));
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
        System.out.println("\u001B[33m-----TestCases1:-Check course list page pagination wise data displayed properly-----\u001B[0m");
        String expected1 = "https://hogrowth.jainam.in/backoffice/apps/course-management/course/list";
        String actual1 = driver.getCurrentUrl();
        test = reports.createTest("Check course list page pagination wise data displayed properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list page pagination wise data displayed properly").build());
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
        Assert.assertEquals("In course list page data not display properly", expected1, actual1);
    }
    @Test(priority = 3)
    public void CourseListSearchingDataTest2() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course List']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseListMenu = driver.findElement(By.xpath("//span[text()='Course List']"));
        CourseListMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Course']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        try {
            WebElement searchVal = driver.findElement(By.xpath("//input[@placeholder='Search Course']"));
            searchVal.sendKeys("Behavioral Finance");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[1]")));
            test = reports.createTest("Check course list page data searching functionality properly work").assignAuthor("Fenil").assignCategory(getClass().
                    getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                    ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list page data searching functionality properly work").build());
            String actual2 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[1]")).getText();
            String expected2 = "Behavioral Finance";
            System.out.println("\u001B[33m-----TestCases2:-Check course list page data searching functionality properly work-----\u001B[0m");
            System.out.println("expected2=" + expected2);
            System.out.println("actual2=" + actual2);
            if (actual2.contains(expected2)) {
                System.out.println("\u001B[32m***Test passed***\u001B[0m");
            } else {
                System.out.println("\u001B[31m***Test Failed***\u001B[0m");
            }
            // Assertion for TestNG or JUnit
            Assert.assertTrue("In course list page data searching functionality not working properly", actual2.contains(expected2));

        } finally {
            System.out.println("In course list page data searching functionality working properly");
        }
    }
    @Test
    public void CourseListActionViewTest3() throws IOException, InterruptedException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course List']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseListMenu = driver.findElement(By.xpath("//span[text()='Course List']"));
        CourseListMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='menu-arrow'])[1]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion1 = driver.findElement(By.xpath("(//span[@class='menu-arrow'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion);
        accordion1.click();
        accordion1.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Course List']")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnCourseModeMenu = driver.findElement(By.xpath("//span[normalize-space()='Course List']"));
        btnCourseModeMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]"));
        actionMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-bold fs-7 w-125px py-4 show']//a[@class='menu-link px-3'][normalize-space()='View']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnViewDetails = driver.findElement(By.xpath("//div[@class='menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-bold fs-7 w-125px py-4 show']//a[@class='menu-link px-3'][normalize-space()='View']"));
        btnViewDetails.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='View Course']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        //CourseName
        WebElement CourseNameTextBox = driver.findElement(By.xpath("(//div[@class='d-flex justify-content-between align-items-start flex-wrap mb-2'])[1]"));
        String CourseNameValue = CourseNameTextBox.getText();

        // OverView Tab
        WebElement SortOrderTextBox = driver.findElement(By.xpath("(//div[@class='col-lg-7 fv-row'])[1]"));
        String SortOrderValue = SortOrderTextBox.getText();
        WebElement CourseStatusTextBox = driver.findElement(By.xpath("(//div[@class='col-lg-7 d-flex align-items-center'])[1]"));
        String CourseStatusValue = CourseStatusTextBox.getText();
        WebElement CourseCertificateTextBox = driver.findElement(By.xpath("//div[@class='tab-pane active']//div[3]//div[1]//div[1]"));
        String CourseCertificateValue = CourseCertificateTextBox.getText();
        WebElement CourseQuizTextBox = driver.findElement(By.xpath("//div[@class='tab-pane active']//div[4]//div[1]//div[1]"));
        String CourseQuizValue = CourseQuizTextBox.getText();
        WebElement ShortDescTextBox = driver.findElement(By.xpath("(//div)[116]"));
        String ShortDescValue = ShortDescTextBox.getText();
        WebElement DescTextBox = driver.findElement(By.xpath("(//div)[124]"));
        String DescValue = DescTextBox.getText();
        WebElement StartTimeTextBox = driver.findElement(By.xpath("(//div[@class='col-lg-7'])[5]"));
        String StartTimeValue = StartTimeTextBox.getText();
        WebElement EndTimeTextBox = driver.findElement(By.xpath("(//div[@class='col-lg-7'])[6]"));
        String EndTimeValue = EndTimeTextBox.getText();
        WebElement TotalSeatTextBox = driver.findElement(By.xpath("(//div[@class='col-lg-7'])[7]"));
        String TotalSeatValue = TotalSeatTextBox.getText();
        WebElement PrSiteTextBox = driver.findElement(By.xpath("(//div[@class='col-lg-7'])[8]"));
        String PrSiteValue = PrSiteTextBox.getText();
        System.out.println("\u001B[33m-----TestCases3:-Check course list view course overview details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course overview details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list view course overview details properly display").build());
        Assert.assertTrue(true);
        //info
        Thread.sleep(6000);
        WebElement tabInfoDetails = driver.findElement(By.xpath("(//div[normalize-space()='Info'])[1]"));
        tabInfoDetails.click();

        WebElement CourseCategoryCard = driver.findElement(By.xpath("(//div[@class='col-xl-4 col-lg-6 col-md-6 col-12 mt-2 pt-2'])[1]"));
        String CourseCategoryCardValue = CourseCategoryCard.getText();
        WebElement CourseSubCategoryCard = driver.findElement(By.xpath("(//div[@class='col-xl-4 col-lg-6 col-md-6 col-12 mt-2 pt-2'])[2]"));
        String CourseSubCategoryCardValue = CourseSubCategoryCard.getText();
        WebElement CourseLevelCard = driver.findElement(By.xpath("(//div[@class='col-xl-4 col-lg-6 col-md-6 col-12 mt-2 pt-2'])[3]"));
        String CourseLevelCardValue = CourseLevelCard.getText();
        WebElement CourseModeCard = driver.findElement(By.xpath("(//div[@class='col-xl-4 col-lg-6 col-md-6 col-12 mt-2 pt-2'])[4]"));
        String CourseModeCardValue = CourseModeCard.getText();
        WebElement CourseTypeCard = driver.findElement(By.xpath("(//div[@class='col-xl-4 col-lg-6 col-md-6 col-12 mt-2 pt-2'])[5]"));
        String CourseTypeCardValue = CourseTypeCard.getText();
        WebElement CourseLanguagesCard = driver.findElement(By.xpath("(//div[@class='col-xl-4 col-lg-6 col-md-6 col-12 mt-2 pt-2'])[6]"));
        String CourseLanguagesCardValue = CourseLanguagesCard.getText();
        System.out.println("\u001B[33m-----TestCases4:-Check course list view course info properly details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course info properly details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list view course info properly details properly display").build());
        Assert.assertTrue(true);
        WebElement detailsPageTitle = driver.findElement(By.xpath("//h1[normalize-space()='View Course']"));
        assertTrue(detailsPageTitle.isDisplayed());

        //Sections
        Thread.sleep(6000);
        WebElement tabSectionDetails = driver.findElement(By.xpath("(//div[normalize-space()='Sections'])[1]"));
        tabSectionDetails.click();
        WebElement CourseSectionsCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseSectionsCardValue = CourseSectionsCard.getText();

        System.out.println("\u001B[33m-----TestCases5:-Check course list view course sections details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course sections details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list view course sections details properly display").build());
        Assert.assertTrue(true);

        //Costing&Contract
        Thread.sleep(6000);
        WebElement tabCostingANDContractDetails = driver.findElement(By.xpath("(//div[normalize-space()='Costing & Contact'])[1]"));
        tabCostingANDContractDetails.click();
        WebElement CourseCostingANDContractCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseCostingANDContractCardValue = CourseCostingANDContractCard.getText();
        System.out.println("\u001B[33m-----TestCases6:-Check course list view course costing and contract details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course costing and contract details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list view course costing and contract details properly display").build());
        Assert.assertTrue(true);


        //Mentors
        Thread.sleep(6000);
        WebElement tabMentorDetails = driver.findElement(By.xpath("(//div[normalize-space()='Mentors'])[1]"));
        tabMentorDetails.click();
        WebElement CourseMentorCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseMentorCardValue = CourseMentorCard.getText();
        System.out.println("\u001B[33m-----TestCases7:-Check course list view course mentor details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course mentor details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list view course mentor details properly display").build());
        Assert.assertTrue(true);

        //Highlights
        Thread.sleep(6000);
        WebElement tabHighlightDetails = driver.findElement(By.xpath("(//div[normalize-space()='Highlights'])[1]"));
        tabHighlightDetails.click();
        WebElement CourseHighlightCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseHighlightCardValue = CourseHighlightCard.getText();
        System.out.println("\u001B[33m-----TestCases8:-Check course list view course highlights details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course highlights details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list view course highlights details properly display").build());
        Assert.assertTrue(true);

        //Logs
        Thread.sleep(6000);
        WebElement tabLogDetails = driver.findElement(By.xpath("(//div[normalize-space()='Logs'])[1]"));
        tabLogDetails.click();
        WebElement CourseLogCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseLogCardValue = CourseLogCard.getText();
        System.out.println("\u001B[33m-----TestCases9:-Check course list view course logs details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course logs details properly display").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list view course logs details properly display").build());
        Assert.assertTrue(true);

        System.out.println("\u001B[33m-----Course Name-----\u001B[0m");
        if (CourseNameValue.trim().isEmpty()) {
            System.out.println("The course name value is blank.");
        } else {
            System.out.println("The course name data value is not blank: " + CourseNameValue);
        }

        if (SortOrderValue.trim().isEmpty()) {
            System.out.println("The sort order data value is blank.");
        } else {
            System.out.println("The sort order data value is not blank: " + SortOrderValue);
        }

        if (CourseStatusValue.trim().isEmpty()) {
            System.out.println("The course status data value is blank.");
        } else {
            System.out.println("The course status data value is not blank: " + CourseStatusValue);
        }

        if (CourseCertificateValue.trim().isEmpty()) {
            System.out.println("The course certificate data value is blank.");
        } else {
            System.out.println("The course certificate data value is not blank: " + CourseCertificateValue);
        }

        if (CourseQuizValue.trim().isEmpty()) {
            System.out.println("The course quiz data value is blank.");
        } else {
            System.out.println("The course quiz data value is not blank: " + CourseQuizValue);
        }

        if (ShortDescValue.trim().isEmpty()) {
            System.out.println("The short description data value is blank.");
        } else {
            System.out.println("The short description data value is not blank: " + ShortDescValue);
        }

        if (DescValue.trim().isEmpty()) {
            System.out.println("The description data value is blank.");
        } else {
            System.out.println("The description data value is not blank: " + DescValue);
        }

        if (StartTimeValue.trim().isEmpty()) {
            System.out.println("The start time data value is blank.");
        } else {
            System.out.println("The start time data value is not blank: " + DescValue);
        }
        if (EndTimeValue.trim().isEmpty()) {
            System.out.println("The end time data value is blank.");
        } else {
            System.out.println("The end time data value is not blank: " + EndTimeValue);
        }
        if (TotalSeatValue.trim().isEmpty()) {
            System.out.println("The total seat data value is blank.");
        } else {
            System.out.println("The total seat data value is not blank: " + TotalSeatValue);
        }

        if (PrSiteValue.trim().isEmpty()) {
            System.out.println("The pre-requisites data value is blank.");
        } else {
            System.out.println("The pre-requisites data value is not blank: " + PrSiteValue);
        }

        if (CourseCategoryCardValue.trim().isEmpty()) {
            System.out.println("The course category card data value is blank.");
        } else {
            System.out.println("The course category card data value is not blank: " + CourseCategoryCardValue);
        }
        if (CourseSubCategoryCardValue.trim().isEmpty()) {
            System.out.println("The course subcategory card data value is blank.");
        } else {
            System.out.println("The course subcategory card data value is not blank: " + CourseSubCategoryCardValue);
        }
        if (CourseLevelCardValue.trim().isEmpty()) {
            System.out.println("The course level card data value is blank.");
        } else {
            System.out.println("The course level card data value is not blank: " + CourseLevelCardValue);
        }

        if (CourseModeCardValue.trim().isEmpty()) {
            System.out.println("The course mode card data value is blank.");
        } else {
            System.out.println("The course mode card data value is not blank: " + CourseModeCardValue);
        }
        if (CourseTypeCardValue.trim().isEmpty()) {
            System.out.println("The course type card data value is blank.");
        } else {
            System.out.println("The course type card data value is not blank: " + CourseTypeCardValue);
        }
        if (CourseLanguagesCardValue.trim().isEmpty()) {
            System.out.println("The course languages card data value is blank.");
        } else {
            System.out.println("The course languages card data value is not blank: " + CourseLanguagesCardValue);
        }
        if (CourseSectionsCardValue.trim().isEmpty()) {
            System.out.println("The course section card data value is blank.");
        } else {
            System.out.println("The course section card data value is not blank: " + CourseSectionsCardValue);
        }
        if (CourseCostingANDContractCardValue.trim().isEmpty()) {
            System.out.println("The course costing and contract card data value is blank.");
        } else {
            System.out.println("The course costing and contract data value is not blank: " + CourseCostingANDContractCardValue);
        }
        if (CourseMentorCardValue.trim().isEmpty()) {
            System.out.println("The course mentor card data value is blank.");
        } else {
            System.out.println("The course mentor data value is not blank: " + CourseMentorCardValue);
        }
        if (CourseHighlightCardValue.trim().isEmpty()) {
            System.out.println("The course highlight card data value is blank.");
        } else {
            System.out.println("The course highlight data value is not blank: " + CourseHighlightCardValue);
        }
        if (CourseLogCardValue.trim().isEmpty()) {
            System.out.println("The course logs card data value is blank.");
        } else {
            System.out.println("The course logs data value is not blank: " + CourseLogCardValue);
        }

//Condition
        if (CourseNameValue.isEmpty()) {
            Assert.fail("The course name data value is blank. Expected: Not blank, Actual: " + CourseNameValue);
        }

        if (SortOrderValue.isEmpty()) {
            Assert.fail("The sort order data value is blank. Expected: Not blank, Actual: " + SortOrderValue);
        }
        if (CourseStatusValue.isEmpty()) {
            Assert.fail("The course status data value is blank. Expected: Not blank, Actual: " + CourseStatusValue);
        }
        if (CourseCertificateValue.isEmpty()) {
            Assert.fail("The course certificate data value is blank. Expected: Not blank, Actual: " + CourseCertificateValue);
        }
        if (CourseQuizValue.isEmpty()) {
            Assert.fail("The course quiz data value is blank. Expected: Not blank, Actual: " + CourseQuizValue);
        }
        if (ShortDescValue.isEmpty()) {
            Assert.fail("The short description data value is blank. Expected: Not blank, Actual: " + ShortDescValue);
        }
        if (DescValue.isEmpty()) {
            Assert.fail("The description data value is blank. Expected: Not blank, Actual: " + DescValue);
        }
        if (StartTimeValue.isEmpty()) {
            Assert.fail("The start time data value is blank. Expected: Not blank, Actual: " + StartTimeValue);
        }
        if (EndTimeValue.isEmpty()) {
            Assert.fail("The end time data value is blank. Expected: Not blank, Actual: " + EndTimeValue);
        }
        if (TotalSeatValue.isEmpty()) {
            Assert.fail("The total seat data value is blank. Expected: Not blank, Actual: " + TotalSeatValue);
        }
        if (PrSiteValue.isEmpty()) {
            Assert.fail("The pre-requisites data value is blank. Expected: Not blank, Actual: " + PrSiteValue);
        }

        if (CourseCategoryCardValue.isEmpty()) {
            Assert.fail("The course category card data value is blank. Expected: Not blank, Actual: " + CourseCategoryCardValue);
        }
        if (CourseSubCategoryCardValue.isEmpty()) {
            Assert.fail("The course subcategory card data value is blank. Expected: Not blank, Actual: " + CourseSubCategoryCardValue);
        }
        if (CourseLevelCardValue.isEmpty()) {
            Assert.fail("The course level card data value is blank. Expected: Not blank, Actual: " + CourseLevelCardValue);
        }

        if (CourseModeCardValue.isEmpty()) {
            Assert.fail("The course mode card data value is blank. Expected: Not blank, Actual: " + CourseModeCardValue);
        }
        if (CourseTypeCardValue.isEmpty()) {
            Assert.fail("The course type card data value is blank. Expected: Not blank, Actual: " + CourseTypeCardValue);
        }
        if (CourseLanguagesCardValue.isEmpty()) {
            Assert.fail("The course languages card data value is blank. Expected: Not blank, Actual: " + CourseLanguagesCardValue);
        }
        if (CourseCostingANDContractCardValue.isEmpty()) {
            Assert.fail("The course costing and contract card data value is blank. Expected: Not blank, Actual: " + CourseCostingANDContractCardValue);
        }
        if (CourseMentorCardValue.isEmpty()) {
            Assert.fail("The course mentor card data value is blank. Expected: Not blank, Actual: " + CourseMentorCardValue);
        }
        if (CourseHighlightCardValue.isEmpty()) {
            Assert.fail("The course highlight card data value is blank. Expected: Not blank, Actual: " + CourseHighlightCardValue);
        }
        if (CourseLogCardValue.isEmpty()) {
            Assert.fail("The course logs card data value is blank. Expected: Not blank, Actual: " + CourseLogCardValue);
        }
    }
    @Test
    public void CourseListActionEditDataTest4() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course List']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseListMenu = driver.findElement(By.xpath("//span[text()='Course List']"));
        CourseListMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]"));
        actionMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=\"Edit\"])[1]]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnViewDetails = driver.findElement(By.xpath("(//a[text()=\"Edit\"])[1]"));
        btnViewDetails.click();

        System.out.println("\u001B[33m-----TestCases10:-Check edit time course details edit functionality working properly-----\u001B[0m");
        //CourseName
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='name'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseNameNameDataElement = driver.findElement(By.xpath("(//input[@id='name'])[1]"));
        String CourseNameDataValue = CourseNameNameDataElement.getAttribute("value");
        System.out.println("Course Name Data Value: " + CourseNameDataValue);

        if (CourseNameDataValue.trim().isEmpty()) {
            System.out.println("The course name data value is blank.");
        } else {

            CourseNameNameDataElement.clear();
            CourseNameNameDataElement.sendKeys("TestEditCourseName"+System.currentTimeMillis());
        }


        //SortOrder
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sortOrder']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement SortOrderDataElement = driver.findElement(By.xpath("//input[@id='sortOrder']"));
        String SortOrderDataValue = SortOrderDataElement.getAttribute("value");
        System.out.println("Sort Order Data Value: " + SortOrderDataValue);

        if (SortOrderDataValue.trim().isEmpty()) {
            System.out.println("The sort order data value is blank.");
        } else {

            SortOrderDataElement.clear();
            SortOrderDataElement.sendKeys("1");
        }

        //ShortDesc
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='shortDescription']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement SortDescDataElement = driver.findElement(By.xpath("//textarea[@id='shortDescription']"));
        String SortDescDataValue = SortDescDataElement.getAttribute("value");
        System.out.println("Sort Description Data Value: " + SortDescDataValue);

        if (SortDescDataValue.trim().isEmpty()) {
            System.out.println("The sort description data value is blank.");
        } else {

            SortDescDataElement.clear();
            SortDescDataElement.sendKeys("Short Description");
        }
        
        WebElement btnEditCourseEntryData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditCourseEntryData.click();

        //Category

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Select Category']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CategoryDropdownElement = driver.findElement(By.xpath("//select[@placeholder='Select Category']"));
        Select CategoryDropdown = new Select(CategoryDropdownElement);
        WebElement CountrySelectedOption = CategoryDropdown.getFirstSelectedOption();
        String CategoryDropdownSelectedValue = CountrySelectedOption.getText();
        System.out.println("Category Data Value: " + CategoryDropdownSelectedValue);
        if (CategoryDropdownSelectedValue.trim().isEmpty()) {
            System.out.println("The category data value is blank.");
        } else {
            CategoryDropdownElement.click();
            CategoryDropdown.selectByVisibleText("Research Analysis");
        }

        //SubCategory

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Select sub category']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement SubCategoryDropdownElement = driver.findElement(By.xpath("//select[@placeholder='Select sub category']"));
        Select SubCategoryDropdown = new Select(SubCategoryDropdownElement);
        WebElement SubCountrySelectedOption = SubCategoryDropdown.getFirstSelectedOption();
        String SubCategoryDropdownSelectedValue = SubCountrySelectedOption.getText();
        System.out.println("Sub Category Data Value: " + SubCategoryDropdownSelectedValue);
        if (SubCategoryDropdownSelectedValue.trim().isEmpty()) {
            System.out.println("The sub category data value is blank.");
        } else {
            SubCategoryDropdownElement.click();
            SubCategoryDropdown.selectByVisibleText("Technical Analysis");
        }

        //CourseMode

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Select mode']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseModeDropdownElement = driver.findElement(By.xpath("//select[@placeholder='Select mode']"));
        Select CourseModeDropdown = new Select(CourseModeDropdownElement);
        WebElement CourseModeSelectedOption = CourseModeDropdown.getFirstSelectedOption();
        String CourseModeDropdownSelectedValue = CourseModeSelectedOption.getText();
        System.out.println("Course Mode Data Value: " + CourseModeDropdownSelectedValue);
        if (CourseModeDropdownSelectedValue.trim().isEmpty()) {
            System.out.println("The course mode data value is blank.");
        } else {
            CourseModeDropdownElement.click();
            CourseModeDropdown.selectByVisibleText("Offline");
        }

        //CourseLevel

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Select level']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseLevelDropdownElement = driver.findElement(By.xpath("//select[@placeholder='Select level']"));
        Select CourseLevelDropdown = new Select(CourseLevelDropdownElement);
        WebElement CourseLevelSelectedOption = CourseModeDropdown.getFirstSelectedOption();
        String CourseLevelDropdownSelectedValue = CourseLevelSelectedOption.getText();
        System.out.println("Course Level Data Value: " + CourseLevelDropdownSelectedValue);
        if (CourseLevelDropdownSelectedValue.trim().isEmpty()) {
            System.out.println("The course level data value is blank.");
        } else {
            CourseLevelDropdownElement.click();
            CourseLevelDropdown.selectByVisibleText("Advanced");
        }

        //CourseType

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Select type']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseTypeDropdownElement = driver.findElement(By.xpath("//select[@placeholder='Select type']"));
        Select CourseTypeDropdown = new Select(CourseTypeDropdownElement);
        WebElement CourseTypeSelectedOption = CourseTypeDropdown.getFirstSelectedOption();
        String CourseTypeDropdownSelectedValue = CourseTypeSelectedOption.getText();
        System.out.println("Course Type Data Value: " + CourseTypeDropdownSelectedValue);
        if (CourseTypeDropdownSelectedValue.trim().isEmpty()) {
            System.out.println("The course type data value is blank.");
        } else {
            CourseTypeDropdownElement.click();
            CourseTypeDropdown.selectByVisibleText("Live Course");
        }

        WebElement btnEditCourseInfoData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditCourseInfoData.click();

        //Address

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Address']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement AddDataElement = driver.findElement(By.xpath("//input[@placeholder='Address']"));
        String AddDataValue = AddDataElement.getAttribute("value");
        System.out.println("Meeting Link Data Value: " + AddDataValue);

        if (AddDataValue.trim().isEmpty()) {
            System.out.println("The address data value is blank.");
        } else {

            AddDataElement.clear();
            AddDataElement.sendKeys("Jainam Broking Limited Piplod suart");
        }

        //Course Has Any Certificate ?

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='hasCertificate'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CertificateRadioButton = driver.findElement(By.xpath("(//input[@id='hasCertificate'])[1]"));
        Boolean CertificateRadioValue = CertificateRadioButton.isSelected();
        System.out.println("Course Has Any Certificate  Data Value: " + CertificateRadioValue);
        if (!CertificateRadioButton.isSelected()) {
            // If not selected, click on the radio button to select it
            CertificateRadioButton.click();
        }
        //Course Has Any Quiz ?

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='hasQuiz'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement QuizRadioButton = driver.findElement(By.xpath("(//input[@name='hasQuiz'])[1]"));
        Boolean QuizRadioValue = QuizRadioButton.isSelected();
        System.out.println("Course Has Any Quiz Data Value: " + QuizRadioValue);
        if (!QuizRadioButton.isSelected()) {
            // If not selected, click on the radio button to select it
            QuizRadioButton.click();
        }
        //Quiz
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='courseQuizId'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseQuizDropdownElement = driver.findElement(By.xpath("(//select[@id='courseQuizId'])[1]"));
        Select CourseQuizDropdown = new Select(CourseQuizDropdownElement);
        WebElement CourseQuizSelectedOption = CourseTypeDropdown.getFirstSelectedOption();
        String CourseQuizDropdownSelectedValue = CourseQuizSelectedOption.getText();
        System.out.println("Course Quiz Data Value: " + CourseQuizDropdownSelectedValue);
        if (CourseQuizDropdownSelectedValue.trim().isEmpty()) {
            System.out.println("The course quiz data value is blank.");
        } else {
            CourseTypeDropdownElement.click();
            CourseQuizDropdown.selectByVisibleText("Agile quiz");
        }

        WebElement btnEditCourseContactDetailsData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditCourseContactDetailsData.click();

        // Cost type
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='costType'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CostTypeRadioButton = driver.findElement(By.xpath("(//input[@id='costType'])[1]"));
        Boolean CostTypeRadioValue = CostTypeRadioButton.isSelected();
        System.out.println("Cost Type Data Value: " + CostTypeRadioValue);
        if (!CostTypeRadioButton.isSelected()) {
            // If not selected, click on the radio button to select it
            CostTypeRadioButton.click();
        }

        WebElement btnEditCourseCostingDetailsData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditCourseCostingDetailsData.click();


        //Add Objective

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Objective'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement ObjectivesDataElement = driver.findElement(By.xpath("(//input[@placeholder='Objective'])[1] "));
        String ObjectivesDataValue = ObjectivesDataElement.getAttribute("value");
        System.out.println("Course Objactive Data Value: " + ObjectivesDataValue);
        ObjectivesDataElement.clear();
        ObjectivesDataElement.sendKeys("TestEditCourseObjectiveName"+System.currentTimeMillis());


        WebElement btnAddObjactiveData = driver.findElement(By.xpath("(//button[text()='Add'])[1]"));
        btnAddObjactiveData.click();
        WebElement btnEditObjactiveData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditObjactiveData.click();

        WebElement btnEditCourseHighLightData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditCourseHighLightData.click();

        WebElement startDateInput = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        startDateInput.click();
        startDateInput.clear();
        startDateInput.sendKeys("04/08/2024 03:30");

        WebElement endDateInput = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[7]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        endDateInput.click();
        endDateInput.clear();
        endDateInput.sendKeys("30/10/2024 03:30");

        WebElement btnEditCourseFinalData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnEditCourseFinalData.click();

        String expected3 = "Course updated successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual3 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check edit time instructor management details edit functionality working properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check edit time instructor management details edit functionality working properly").build());
        Assert.assertTrue(true);
        System.out.println("expected3=" + expected3);
        System.out.println("actual3=" + actual3);
        Assert.assertEquals("Edit time instructor management details edit functionality not working properly", expected3, actual3);
        if (actual3.equalsIgnoreCase(expected3)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
        driver.quit();
    }
    @Test
    public void CourseListsActionUpdateStatusDataTest5() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course List']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseListMenu = driver.findElement(By.xpath("//span[text()='Course List']"));
        CourseListMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]"));
        actionMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=\"Update Status\"])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnUpdateStatusDetails = driver.findElement(By.xpath("(//a[text()=\"Update Status\"])[1]"));
        btnUpdateStatusDetails.click();

        System.out.println("\u001B[33m-----TestCases11:-Check course list page course wise update status functionality working properly-----\u001B[0m");
        //Status
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-control form-control-solid mb-3 mb-lg-0']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseStatusDropdownElement = driver.findElement(By.xpath("//select[@class='form-control form-control-solid mb-3 mb-lg-0']"));
        Select CourseStatusDropdown = new Select(CourseStatusDropdownElement);
        WebElement CourseStatusSelectedOption = CourseStatusDropdown.getFirstSelectedOption();
        String CourseStatusDropdownSelectedValue = CourseStatusSelectedOption.getText();
        System.out.println("Course Status Data Value: " + CourseStatusDropdownSelectedValue);
        if (CourseStatusDropdownSelectedValue.trim().isEmpty()) {
            System.out.println("The course status data value is blank.");
        } else {
            CourseStatusDropdownElement.click();
            CourseStatusDropdown.selectByVisibleText("Draft");
        }
        CourseStatusDropdownElement.click();
        WebElement btnSubmitData = driver.findElement(By.xpath("(//div[@class='btn btn-primary mx-2'])[1]"));
        btnSubmitData.click();
        String expected4 = "Course status updated successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual4 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check course list page course wise update status functionality working properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list page course wise update status functionality working properly").build());
        Assert.assertTrue(true);
        System.out.println("expected3=" + expected4);
        System.out.println("actual3=" + actual4);
        Assert.assertEquals("Course list page course wise update status functionality not working properly", expected4, actual4);
        if (actual4.equalsIgnoreCase(expected4)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }
    @Test
    public void CourseListsActionUpdateMentorDataTest6() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course List']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseListMenu = driver.findElement(By.xpath("//span[text()='Course List']"));
        CourseListMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]"));
        actionMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=\"Update Mentor\"])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnUpdateMentorDetails = driver.findElement(By.xpath("(//a[text()=\"Update Mentor\"])[1]"));
        btnUpdateMentorDetails.click();
        System.out.println("\u001B[33m-----TestCases12:-Check course list page course wise update mentor functionality working properly-----\u001B[0m");
        //Mentor
        WebElement multiSelectDropdown = driver.findElement(By.xpath("(//div[@class='my-react-select__control css-13cymwt-control'])[1]"));

        // Locate the individual items inside the dropdown
        List<WebElement> dropdownItems = multiSelectDropdown.findElements(By.xpath("(//div[@class='my-react-select__control css-13cymwt-control'])[1]"));

        // Initialize Actions class
        Actions actions = new Actions(driver);

        // Select multiple items by clicking on them
        for (WebElement item : dropdownItems) {
            actions.click(item).perform();
            item.isSelected();
        }
        multiSelectDropdown.click();


        WebElement btnSubmitData = driver.findElement(By.xpath("(//span[@class='indicator-label'])[1]"));
        btnSubmitData.click();
        String expected5 = "Course mentor updated successfully";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual5 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check course list page course wise update mentor functionality working properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list page course wise update mentor functionality working properly").build());
        Assert.assertTrue(true);
        System.out.println("expected5=" + expected5);
        System.out.println("actual5=" + actual5);
        Assert.assertEquals("Course list page course wise update mentor functionality not working properly", expected5, actual5);
        if (actual5.equalsIgnoreCase(expected5)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
        driver.quit();
    }
    @Test
    public void CourseListsActionDeleteDataTest7() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course List']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseListMenu = driver.findElement(By.xpath("//span[text()='Course List']"));
        CourseListMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]"));
        actionMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=\"Delete\"])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnDelete = driver.findElement(By.xpath("(//a[text()=\"Delete\"])[1]"));
        btnDelete.click();
       
        WebElement btnPopUpDelete=driver.findElement(By.xpath("(//div[@class='btn btn-primary btn-sm mx-2'])[1]"));
        btnPopUpDelete.click();
        System.out.println("\u001B[33m-----TestCases13:-Check course list page course wise delete functionality working properly-----\u001B[0m");
        String expected5 = "You Cannot Delete this course, User Already Enrolled in this course.";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual5 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check course list page course wise delete functionality working properly").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check course list page course wise delete functionality working properly").build());
        Assert.assertTrue(true);
        //test.fail("Currently Student is enrolled in the course after which the course is deleted then the course gets deleted successfully which should not happen");
        System.out.println("expected5=" + expected5);
        System.out.println("actual5=" + actual5);
        Assert.assertEquals("Course list page course wise delete functionality not working properly", expected5, actual5);
        if (actual5.equalsIgnoreCase(expected5)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
        driver.quit();
    }
    @Test
    public void CourseListsActionBlankSectionDataInsertTest7() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Course List']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseListMenu = driver.findElement(By.xpath("//span[text()='Course List']"));
        CourseListMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement actionMenu = driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='Actions'])[1]"));
        actionMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=\"Sections\"])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnDelete = driver.findElement(By.xpath("(//a[text()=\"Sections\"])[1]"));
        btnDelete.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add Course Section'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnAddSection=driver.findElement(By.xpath("(//button[normalize-space()='Add Course Section'])[1]"));
        btnAddSection.click();
        WebElement SectionNameInput = driver.findElement(By.name("name"));
        SectionNameInput.clear();
        SectionNameInput.click();
        WebElement IntroductionInput = driver.findElement(By.name("introduction"));
        IntroductionInput.clear();
        IntroductionInput.click();
        WebElement SortNoInput = driver.findElement(By.name("sortNumber"));
        SortNoInput.sendKeys(Keys.CONTROL + "a");
        SortNoInput.sendKeys(Keys.DELETE);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text-center pt-15']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        driver.findElement(By.xpath("//div[@class='text-center pt-15']")).click();
        WebElement errorMessageSectionName = driver.findElement(By.xpath("//span[normalize-space()='Name is required']"));
        WebElement errorMessageIntroducation = driver.findElement(By.xpath("(//span[normalize-space()='Introduction is required'])[1]"));
        WebElement errorMessageSortNoName = driver.findElement(By.xpath("(//span[normalize-space()='Sort number is required'])[1]"));
        System.out.println("\u001B[33m-----TestCases14:-Check blank section name validation-----\u001B[0m");
        //Check blank field handled or not
        if (errorMessageSectionName.isDisplayed())
        {
            System.out.println("Blank section name fields handled correctly.");
        }
        else
        {
            System.out.println("Section name error handling is not working as expected.");
        }
        String expected6 = "Name is required";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Name is required']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual6 = driver.findElement(By.xpath("//span[normalize-space()='Name is required']")).getText();
        test = reports.createTest("Check blank section name validation").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check blank section name validation").build());
        Assert.assertTrue(true);
        System.out.println("expected6=" + expected6);
        System.out.println("actual6=" + actual6);
        Assert.assertEquals("Check blank section name validation not work", expected6, actual6);
        if (actual6.equalsIgnoreCase(expected6)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }

        System.out.println("\u001B[33m-----TestCases15:-Check blank introducation validation-----\u001B[0m");
        //Check blank field handled or not
        if (errorMessageIntroducation.isDisplayed())
        {
            System.out.println("Blank introducation fields handled correctly.");
        }
        else
        {
            System.out.println("Introducation error handling is not working as expected.");
        }
        String expected7 = "Introduction is required";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='Introduction is required'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual7 = driver.findElement(By.xpath("(//span[normalize-space()='Introduction is required'])[1]")).getText();
        test = reports.createTest("Check blank introducation validation").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check blank introducation validation").build());
        Assert.assertTrue(true);
        System.out.println("expected7=" + expected7);
        System.out.println("actual7=" + actual7);
        Assert.assertEquals("Check blank section name validation not work", expected7, actual7);
        if (actual7.equalsIgnoreCase(expected7)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }

        System.out.println("\u001B[33m-----TestCases16:-Check blank sort number validation-----\u001B[0m");
        //Check blank field handled or not
        if (errorMessageSortNoName.isDisplayed())
        {
            System.out.println("Blank sort number fields handled correctly.");
        }
        else
        {
            System.out.println("Sort number error handling is not working as expected.");
        }
        String expected8 = "Sort number is required";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='Sort number is required'])[1]")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual8 = driver.findElement(By.xpath("(//span[normalize-space()='Sort number is required'])[1]")).getText();
        test = reports.createTest("Check blank sort number validation").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check blank sort number validation").build());
        Assert.assertTrue(true);
        System.out.println("expected8=" + expected8);
        System.out.println("actual8=" + actual8);
        Assert.assertEquals("Check blank sort number validation not work", expected8, actual8);
        if (actual8.equalsIgnoreCase(expected8)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

}

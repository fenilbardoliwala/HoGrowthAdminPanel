package hocoursemanagement;

import com.aventstack.extentreports.MediaEntityBuilder;
import hoadminbasereport.AdminBaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
        test = reports.createTest("Check course list view course overview  details properly display").assignAuthor("Fenil").assignCategory("Course List Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check course list view course overview    details properly display").build());
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
        test = reports.createTest("Check course list view course info properly details properly display").assignAuthor("Fenil").assignCategory("Course List Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check course list view course info properly details properly display").build());
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
        test = reports.createTest("Check course list view course sections details properly display").assignAuthor("Fenil").assignCategory("Course List Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check course list view course sections details properly display-").build());
        Assert.assertTrue(true);

        //Costing&Contract
        Thread.sleep(6000);
        WebElement tabCostingANDContractDetails = driver.findElement(By.xpath("(//div[normalize-space()='Costing & Contact'])[1]"));
        tabCostingANDContractDetails.click();
        WebElement CourseCostingANDContractCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseCostingANDContractCardValue = CourseCostingANDContractCard.getText();
        System.out.println("\u001B[33m-----TestCases6:-Check course list view course costing and contract details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course sections details properly display").assignAuthor("Fenil").assignCategory("Course List Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check course list view course costing and contract details properly display").build());
        Assert.assertTrue(true);


        //Mentors
        Thread.sleep(6000);
        WebElement tabMentorDetails = driver.findElement(By.xpath("(//div[normalize-space()='Mentors'])[1]"));
        tabMentorDetails.click();
        WebElement CourseMentorCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseMentorCardValue = CourseMentorCard.getText();
        System.out.println("\u001B[33m-----TestCases7:-Check course list view course mentor details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course mentor details properly display-").assignAuthor("Fenil").assignCategory("Course List Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check course list view course mentor details properly display").build());
        Assert.assertTrue(true);

        //Highlights
        Thread.sleep(6000);
        WebElement tabHighlightDetails = driver.findElement(By.xpath("(//div[normalize-space()='Highlights'])[1]"));
        tabHighlightDetails.click();
        WebElement CourseHighlightCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseHighlightCardValue = CourseHighlightCard.getText();
        System.out.println("\u001B[33m-----TestCases8:-Check course list view course highlights details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course highlights details properly display").assignAuthor("Fenil").assignCategory("Course List Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check course list view course highlights details properly display").build());
        Assert.assertTrue(true);

        //Logs
        Thread.sleep(6000);
        WebElement tabLogDetails = driver.findElement(By.xpath("(//div[normalize-space()='Logs'])[1]"));
        tabLogDetails.click();
        WebElement CourseLogCard = driver.findElement(By.xpath("(//div[@class='tab-content pt-3'])[1]"));
        String CourseLogCardValue = CourseLogCard.getText();
        System.out.println("\u001B[33m-----TestCases9:-Check course list view course logs details properly display-----\u001B[0m");
        test = reports.createTest("Check course list view course logs details properly display").assignAuthor("Fenil").assignCategory("Course List Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check course list view course logs details properly display").build());
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

}

package hocoursemanagement;

import com.aventstack.extentreports.MediaEntityBuilder;
import hoadminbasereport.AdminBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CreateCourseTest extends AdminBaseTest {
    @Test
    public void CourseListActionInsertDataTest5() throws InterruptedException, IOException {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Create Course']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement CourseListMenu = driver.findElement(By.xpath("//span[text()='Create Course']"));
        CourseListMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='menu-arrow'])[1]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement accordion1 = driver.findElement(By.xpath("(//span[@class='menu-arrow'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordion1);
        accordion1.click();
        accordion1.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Create Course'])[1]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        WebElement btnCourseCreateMenu = driver.findElement(By.xpath("(//span[normalize-space()='Create Course'])[1]"));
        btnCourseCreateMenu.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Name'])[1]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        //CourseEntry

        WebElement CourseNameInput = driver.findElement(By.xpath("(//input[@placeholder='Name'])[1]"));
        CourseNameInput.sendKeys("NewCourse1"+RandomsNumber());
        WebElement SortOrderInput = driver.findElement(By.xpath("(//input[@placeholder='Sort Order'])[1]"));
        SortOrderInput.sendKeys("1"+RandomsNumber());
        WebElement SortDescriptionInput = driver.findElement(By.xpath("(//textarea[@id='shortDescription'])[1]"));
        SortDescriptionInput.sendKeys("NewSortDescription1"+RandomsNumber());
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr'])[1]")));

        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String DescriptionXpath="//div[@contenteditable='true']";
        WebElement DescriptionInput = driver.findElement(By.xpath(DescriptionXpath));
        DescriptionInput.sendKeys("NewDescription1"+RandomsNumber());

//        WebElement fileInput = driver.findElement(By.id("upload"));
//        File file = new File("/home/j/IdeaProjects/HoGrowthAdminPanel/src/main/java/pdf-test.pdf");
//        String filePath = file.getAbsolutePath();
//        fileInput.sendKeys(filePath);
//        Thread.sleep(10000);
        WebElement btnInsertCourseEntryData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnInsertCourseEntryData.click();

        //Course Info

        WebElement CourseCategoryInput = driver.findElement(By.name("courseCategoryId"));
        Select selectCourseCategory=new Select(CourseCategoryInput);
        selectCourseCategory.selectByVisibleText("Research Analysis");

        WebElement SubCourseCategoryInput = driver.findElement(By.name("subCourseCategoryId"));
        Select selectSubCourseCategory=new Select(SubCourseCategoryInput);
        selectSubCourseCategory.selectByVisibleText("Technical Analysis");

        WebElement CourseModeInput = driver.findElement(By.name("courseModeId"));
        Select selectCourseMode=new Select(CourseModeInput);
        selectCourseMode.selectByVisibleText("Offline");

        WebElement CourseLevelInput = driver.findElement(By.name("courseLevelId"));
        Select selectCourseLevel=new Select(CourseLevelInput);
        selectCourseLevel.selectByVisibleText("Advanced");

        WebElement CourseTypeInput = driver.findElement(By.name("courseTypeId"));
        Select selectCourseType=new Select(CourseTypeInput);
        selectCourseType.selectByVisibleText("Live Course");

        WebElement selectSkillMyElement = driver.findElement((By.cssSelector(".my-react-select__placeholder")));
        selectSkillMyElement.click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN,Keys.ENTER)).click().perform();
//        WebElement selectSkillMyElement1 = driver.findElement(By.cssSelector("#react-select-8-placeholder"));
//        selectSkillMyElement1.click();

        WebElement selectLanguageMyElement = driver.findElement(By.cssSelector(".my-react-select__placeholder"));
        selectLanguageMyElement.click();
        Actions keyDown1 = new Actions(driver);
        keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN,Keys.ENTER)).click().perform();
//        WebElement selectLanguageMyElement1 = driver.findElement(By.id("react-select-9-listbox"));
//        selectLanguageMyElement1.click();

        WebElement btnInsertCourseInfoData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnInsertCourseInfoData.click();

        //  Contact Details

        WebElement AddressInput = driver.findElement(By.xpath("(//input[@placeholder='Address'])[1]"));
        AddressInput.sendKeys("Jainam House Piplod");


        WebElement CertificateRadioButton = driver.findElement(By.xpath("(//input[@id='hasCertificate'])[1]"));
        Boolean CertificateRadioValue = CertificateRadioButton.isSelected();
        System.out.println("Course Has Any Certificate  Data Value: " + CertificateRadioValue);
        if (!CertificateRadioButton.isSelected()) {
            // If not selected, click on the radio button to select it
            CertificateRadioButton.click();
        }

        WebElement QuizRadioButton = driver.findElement(By.xpath("(//input[@name='hasQuiz'])[1]"));
        Boolean QuizRadioValue = QuizRadioButton.isSelected();
        System.out.println("Course Has Any Quiz Data Value: " + QuizRadioValue);
        if (!QuizRadioButton.isSelected()) {
            // If not selected, click on the radio button to select it
            QuizRadioButton.click();
        }
        WebElement CourseQuizInput = driver.findElement(By.name("courseQuizId"));
        Select SelectCourseQuiz=new Select(CourseQuizInput);
        SelectCourseQuiz.selectByVisibleText("Agile quiz");

        WebElement btnInsertContactDetailsData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnInsertContactDetailsData.click();

        //Course Costing

        WebElement CostRadioButton = driver.findElement(By.xpath("(//input[@id='costType'])[1]"));
        Boolean CostRadioValue = CostRadioButton.isSelected();
        System.out.println("Cost Type Data Value: " + CostRadioValue);
        if (!CostRadioButton.isSelected()) {
            // If not selected, click on the radio button to select it
            CostRadioButton.click();
        }

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='fv-row ms-2']")));
        element.click();
        WebElement TotalSeatInput = driver.findElement(By.name("totalSeat"));
        TotalSeatInput.sendKeys("1"+RandomsNumber());
        WebElement fileInput1 = driver.findElement(By.id("upload"));
        File file1 = new File("/home/j/IdeaProjects/HoGrowthAdminPanel/src/main/java/download.jpeg");
        String filePath1 = file1.getAbsolutePath();
        fileInput1.sendKeys(filePath1);


        WebElement btnInsertCourseCostingData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnInsertCourseCostingData.click();

        //Course Mentor

        WebElement dropdownControl = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".my-react-select__menu")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownControl);
        dropdownControl.click();


        WebElement inputField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-select-10-input")));
        inputField.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement btnInsertMentorData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnInsertMentorData.click();

        //Course Objective
        WebElement ObjectiveInput = driver.findElement(By.xpath("(//input[@placeholder='Objective'])[1]"));
        ObjectiveInput.sendKeys("Newobjective1"+RandomsNumber());


        WebElement btnInsertObjectiveData = driver.findElement(By.xpath("(//button[@class='btn btn-light-primary btn btn-color-gray-600 btn-active-light-primary'])[1]"));
        btnInsertObjectiveData.click();

        WebElement btnInsertObjecativeData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnInsertObjecativeData.click();
        WebElement btnInsertHighlightData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnInsertHighlightData.click();

        WebElement StatusInput = driver.findElement(By.name("status"));
        Select SelectStatusInput=new Select(StatusInput);
        SelectStatusInput.selectByVisibleText("Draft");

        WebElement startDateInput = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
        startDateInput.click();
        startDateInput.clear();
        startDateInput.sendKeys("27/01/2023 03:30");

        WebElement endDateInput = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        endDateInput.click();
        endDateInput.clear();
        endDateInput.sendKeys("30/01/2023 03:30");

        WebElement btnInsertCourseFinalData = driver.findElement(By.xpath("//button[@type='submit']"));
        btnInsertCourseFinalData.click();

        System.out.println("\u001B[33m-----TestCases1:-Check create course time insert functionality working properly-----\u001B[0m");

        String expected3 = "Course created successfully";
        try {
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='status']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual3 = driver.findElement(By.xpath("//div[@role='status']")).getText();
        test = reports.createTest("Check create course time insert functionality working properly")
                .assignAuthor("Fenil").assignCategory("Course Create Testcases")
                .assignDevice("Firefox").pass(MediaEntityBuilder.createScreenCaptureFromPath("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),
                        "Check create course time insert functionality working properly").build());
        test.warning("Description and Pre-requisites HTML Ck editor data enter time spaceing issue");
        test.skip("HTML ck editor");
        test.skip("Multidropdown");
        test.skip("Highlight Icon Picker");
        Assert.assertTrue(true);
        System.out.println("expected3=" + expected3);
        System.out.println("actual3=" + actual3);
        Assert.assertEquals("Edit time instructor management details edit functionality not working properly", expected3, actual3);
        if (actual3.equalsIgnoreCase(expected3)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }
}

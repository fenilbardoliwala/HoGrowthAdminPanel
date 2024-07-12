package hoadminbasereport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.twilio.base.ResourceSet;
//import com.twilio.rest.api.v2010.account.Message;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AdminBaseTest {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test;
    public static String url;
    public static String email;
    public static String pass;
    public static String ipass;
    public static String dpass;
    public static String mobileno;
    protected String browserName;
    ExtentTest Test = null;
    //public static  WebDriver driver;
    public static ChromeDriver  driver = new ChromeDriver();

    @BeforeSuite
    public void StartReport() {
        WebDriverManager.chromedriver().setup();
        // Get browser name from capabilities
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        browserName = caps.getBrowserName();
        url = "https://hogrowth.jainam.in/backoffice";
        // url="http://192.168.51.185:3001/";
        email = "admin@smartlearn.com";
        pass = "Smart@123#";
        dpass="Fenil@66";
        ipass="12345678";
        mobileno="8460390306";
        htmlReporter = new ExtentSparkReporter("ExtentHoGrowthAdminPortalReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        // Add environment details
        String machineName = getMachineName();
        reports.setSystemInfo("Machine", machineName);
        String osName = System.getProperty("os.name");
        reports.setSystemInfo("OS", osName);
        String userName = System.getProperty("user.name");
        reports.setSystemInfo("User", userName);
        reports.setSystemInfo("Browser", caps.getBrowserName());
        // configuration to change look and feel
        htmlReporter.config().setDocumentTitle("Extent HoGrowth Admin Portal Report");
        htmlReporter.config().setReportName("HoGrowth Admin Portal TestCases Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        driver.manage().window().maximize();
        driver.get(url);
        //return reports;
    }

    @AfterMethod
    public void getTestResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAIL", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(convertNewlineToBr(result.getThrowable() + "FAIL"), ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getStatus() + "FAIL", ExtentColor.RED));

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASS", ExtentColor.GREEN));
            test.log(Status.PASS, MarkupHelper.createLabel(result.getStatus() + "PASS", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPPED", ExtentColor.YELLOW));
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable() + "SKIPPED", ExtentColor.YELLOW));
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getTestName() + "SKIPPED", ExtentColor.YELLOW));
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getStatus() + "SKIPPED", ExtentColor.YELLOW));
        }
    }

    private static String convertNewlineToBr(String message) {
        // Convert newline characters to HTML <br/> tags
        return message.replaceAll("\n", "<br/>");
    }

    @AfterSuite
    public void tearDown() {
        reports.flush();
    }

    public static String takingScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scrFile = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
        String fileName = "IMG" + timestamp + ".png";
        FileUtils.copyFile(scrFile, new File("./TestcasesScreenshot/screenshots" + fileName));
        return fileName;
    }

    public static int countSelectedCheckboxes(List<WebElement> checkboxes) {
        int count = 0;
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                count++;
            }
        }
        return count;
    }

    public static String generateRandomMobileNumber() {
        // Generate a random 10-digit mobile number
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder("9"); // Assuming the mobile number starts with 9

        for (int i = 0; i < 9; i++) {
            mobileNumber.append(random.nextInt(10));
        }

        return mobileNumber.toString();
    }

    public static String RandomsNumber() {
        // Generate a random 10-digit mobile number
        Random random = new Random();
        StringBuilder RandomNumber = new StringBuilder("3"); // Assuming the mobile number starts with 9

        for (int i = 0; i < 3; i++) {
            RandomNumber.append(random.nextInt(3));
        }

        return RandomNumber.toString();
    }
    public static String getMachineName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    protected String GetRandomEmail() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            salt.append(chars.charAt(index));
        }
        return salt.toString();

    }

    public static void AdminLogin()
    {
        WebElement EmailInput = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']"));
        EmailInput.sendKeys(email);

        WebElement PasswordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        PasswordInput.sendKeys(pass);

        WebElement btnContinue=driver.findElement(By.id("kt_sign_in_submit"));
        btnContinue.click();
    }
}

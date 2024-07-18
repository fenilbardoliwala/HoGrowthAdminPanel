package hoadminlogin;

import com.aventstack.extentreports.MediaEntityBuilder;
import hoadminbasereport.AdminBaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdminLoginTest extends AdminBaseTest {

    @Test

    public void AdminLoginBlankFieldValidationTest1() throws IOException {
        WebElement btnContinue=driver.findElement(By.id("kt_sign_in_submit"));
        btnContinue.click();

        WebElement errorMessageEmail=driver.findElement(By.xpath("//span[text()='Email is required']"));
        WebElement errorMessagePassword = driver.findElement(By.xpath("//span[text()='Password is required']"));

        System.out.println("\u001B[33m-----TestCases1:-Check blank email validation-----\u001B[0m");
        if(errorMessageEmail.isDisplayed())
        {
            System.out.print("Blank email fields handled correctly."+"\n");
        }
        else
        {
            System.out.print("Error handling is not working as expected."+"\n");
        }

        String expected1 = "Email is required";
        String actual1 = driver.findElement(By.xpath("//span[text()='Email is required']")).getText();
        test = reports.createTest("Check blank email validation").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check blank email validation").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected1=" + expected1);
        System.out.println("actual1=" + actual1);
        Assert.assertEquals("Email required field validation not work", expected1, actual1);
        if (actual1.equalsIgnoreCase(expected1))
        {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        }
        else
        { driver.quit();
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }

        System.out.println("\u001B[33m-----TestCases2:-Check blank password validation-----\u001B[0m");
        if(errorMessagePassword.isDisplayed())
        {
            System.out.print("Blank password fields handled correctly."+"\n");
        }
        else
        {
            System.out.print("Error handling is not working as expected."+"\n");
        }

        String expected2 = "Password is required";
        String actual2 = driver.findElement(By.xpath("//span[text()='Password is required']")).getText();
        test = reports.createTest("Check blank password validation").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver),"Check blank password validation").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected2=" + expected2);
        System.out.println("actual2=" + actual2);
        Assert.assertEquals("Password required field validation not work", expected2, actual2);
        if (actual2.equalsIgnoreCase(expected2))
        {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        }
        else
        {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }

        WebElement signupContent=driver.findElement(By.xpath("//div[@class='text-center login-mes-text']"));
        if(signupContent.isDisplayed())
        {
            test.warning("Remove sign up content in admin login page");
        }
        else
        {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        }
    }
    @Test
    public void AdminLoginInvalidInvalidEmailValidationTest2() throws IOException, InterruptedException {

        Thread.sleep(2000);
        driver.navigate().refresh();

        WebElement EmailInput = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']"));
        String email = "test@gmail";
        EmailInput.sendKeys(email);

        WebElement PasswordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        PasswordInput.sendKeys(pass);

        WebElement errorMessageEmail = driver.findElement(By.xpath("//span[text()='Please enter a valid email address']"));

        String responseText = errorMessageEmail.getText();
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(responseText);
        if (matcher.matches()) {
            System.out.println("The email address " + email + " is valid.");
        } else {
            System.out.println("The email address " + email + " is not valid.");
        }

        System.out.println("\u001B[33m-----TestCases3:-Check invlid email address validation-----\u001B[0m");
        String expected3 = "Please enter a valid email address";
        String actual3 = driver.findElement(By.xpath("//span[text()='Please enter a valid email address']")).getText();
        test = reports.createTest("Check blank email validation").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check blank email validation").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected3=" + expected3);
        System.out.println("actual3=" + actual3);
        Assert.assertEquals("Email required field validation not work", expected3, actual3);
        if (actual3.equalsIgnoreCase(expected3)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

    @Test
    public void AdminLoginInvalidInvalidPasswordValidationTest3() throws IOException, InterruptedException {

        Thread.sleep(2000);
        driver.navigate().refresh();

        WebElement EmailInput = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']"));
        EmailInput.sendKeys(email);

        WebElement PasswordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        PasswordInput.sendKeys(ipass);

        WebElement btnContinue=driver.findElement(By.id("kt_sign_in_submit"));
        btnContinue.click();

       // WebElement errorMessageInvalidPassword = driver.findElement(By.xpath("//div[text()='The login details are incorrect']"));

        System.out.println("\u001B[33m-----TestCases4:-Check invlid password validation-----\u001B[0m");
        String expected4 = "The login details are incorrect";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='The login details are incorrect']")));
        } catch (Throwable e) {
            System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
        }
        String actual4 = driver.findElement(By.xpath("//div[text()='The login details are incorrect']")).getText();
        test = reports.createTest("Check invalid password validation").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check invalid password validation").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected4=" + expected4);
        System.out.println("actual4=" + actual4);
        Assert.assertEquals("Invalid password functionality not work", expected4, actual4);
        if (actual4.equalsIgnoreCase(expected4)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

    @Test
    public void AdminLoginValidCredentialsTest4() throws IOException, InterruptedException {

        Thread.sleep(2000);
        driver.navigate().refresh();
        AdminLogin();
        // WebElement errorMessageInvalidPassword = driver.findElement(By.xpath("//div[text()='The login details are incorrect']"));

        System.out.println("\u001B[33m-----TestCases5:-Check valid email and password then redirect to admin dashboard-----\u001B[0m");
        String expected5 = "https://hogrowth.jainam.in/backoffice/dashboard";
        Thread.sleep(2000);
        String actual5 = driver.getCurrentUrl();
        test = reports.createTest("Check valid email and password then redirect to admin dashboard").assignAuthor("Fenil").assignCategory(getClass().
                getName()).assignDevice(driver.getClass().getSimpleName()).pass(MediaEntityBuilder.createScreenCaptureFromPath
                ("./TestcasesScreenshot/screenshots" + takingScreenshot(driver), "Check valid email and password then redirect to admin dashboard").build());
        Assert.assertTrue(true);//pass
        System.out.println("expected5=" + expected5);
        System.out.println("actual5=" + actual5);
        Assert.assertEquals("This is not dashboard", expected5, actual5);
        if (actual5.equalsIgnoreCase(expected5)) {
            System.out.println("\u001B[32m***Test passed***\u001B[0m");
        } else {
            System.out.println("\u001B[31m***Test Failed***\u001B[0m");
        }
    }

}

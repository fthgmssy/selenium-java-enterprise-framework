package base;

import config.ConfigReader;
import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE && ConfigReader.screenshotOnFailure()) {
            takeScreenshot(result.getName());
        }
        DriverManager.quitDriver();
    }

    @Attachment(value = "{testName}", type = "image/png")
    private byte[] takeScreenshot(String testName) {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

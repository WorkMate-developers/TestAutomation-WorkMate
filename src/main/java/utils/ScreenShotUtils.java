package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * This class contains the necessary methods for taking screenshots when a UI test fails.
 */

public class ScreenShotUtils {

    private static final String screenShotPath = System.getProperty("user.dir") +  PropertiesUtils.getScreenshotsFolder();


    public static void takeScreenShot(WebDriver driver, String sTestName) {
        LoggerUtils.log.trace("takeScreenShot({})", sTestName);
        String sFilePath = screenShotPath + sTestName + ".png";

        if(WebDriverUtils.hasDriverQuit(driver)) {
            LoggerUtils.log.warn("Cannot take a screenshot for {}, the driver has already quit!", sTestName);
        }

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(sFilePath);
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
            LoggerUtils.log.info("Screenshot for test {} is save to: {}", sTestName, sFilePath);
        } catch (IOException e) {
            LoggerUtils.log.warn("Screenshot for test {} could not be saved to: {}", sTestName, sFilePath);
        }
    }
}

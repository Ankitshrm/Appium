package com.test;


import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTesting {

    @Test
    public void Chrome() throws MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME,"Chrome");
        capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        WebDriver driver =new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Hello World",Keys.ENTER);
    }
}

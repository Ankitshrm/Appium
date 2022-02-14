package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class NewApp {

    @Test
    public void NewAppTesting() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.snapchat.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LandingPageActivity");
//        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 10");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElements(By.xpath("//android.widget.ListView[resource-id='android:id/list']/android.widget.TextView"))
                .stream().map(WebElement::getText).forEach(System.out::println);

    }
}


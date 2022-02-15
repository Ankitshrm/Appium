package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Scrolling {

    static AndroidDriver<AndroidElement> driver;

    private static void tap(AndroidElement view){
        new AndroidTouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(view))).perform();
    }


    @Test
    public void Scroll() throws MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/ApiDemos-debug.apk");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        AndroidElement view =driver.findElementByAccessibilityId("Views");
        tap(view);

        scrollAndClick(By.xpath("//*[@text='TextFields']"));
        driver.findElementById("io.appium.android.apis:id/edit").sendKeys("Helllo");
    }

    private void scrollAndClick(By by) {
        while(driver.findElements(by).isEmpty())
        {
            Dimension dimension =driver.manage().window().getSize();
            Double start =dimension.getHeight()*0.5;
            int startpoint = start.intValue();
            Double end =dimension.getHeight()*0.2;
            int endpoint =end.intValue();

            int center = (int) (dimension.width*0.5);
            new AndroidTouchAction(driver)
                    .press(PointOption.point(center,startpoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(center,endpoint))
                    .release()
                    .perform();

        }
        if(!driver.findElements(by).isEmpty()){
            driver.findElement(by).click();
        }
    }

}

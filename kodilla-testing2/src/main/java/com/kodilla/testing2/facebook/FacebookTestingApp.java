package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Optional;

public class FacebookTestingApp {

    public static final String XPATH_SELECT_DAY = "//*[@id=\"day\"]";
    public static final String XPATH_SELECT_MONTH = "//*[@id=\"month\"]";
    public static final String XPATH_SELECT_YEAR = "//*[@id=\"year\"]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//div[@class=\"_9xo5\"]/button[contains(@id, \"u_0_e_\")]")).click();

        driver.findElement(By.xpath("//div[@class=\"_6ltg\"]/a[contains(@data-testid, \"open-registration-form\")]")).click();

//        Myślę że ta wykomentowana wersja jest lepsza

//        Thread.sleep(2000);
//        WebElement selectCombo2 = driver.findElement(By.xpath("//*[@id=\"day\"]"));
//        Select selectDay = new Select(selectCombo2);
//        selectDay.selectByValue("25");

        Optional<WebElement> selectCombo =  Optional.ofNullable(null);
        while(selectCombo.isEmpty()) {
            try {
                selectCombo = Optional.ofNullable(driver.findElement(By.xpath(XPATH_SELECT_DAY)));
            } catch (org.openqa.selenium.NoSuchElementException e) {

            }
        }

        Select selectDay = new Select(selectCombo.get());
        selectDay.selectByValue("23");

        WebElement selectCombo2 = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectMonth = new Select(selectCombo2);
        selectMonth.selectByIndex(0);

        selectCombo2 = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectYear = new Select(selectCombo2);
        selectYear.selectByIndex(1);
    }
}
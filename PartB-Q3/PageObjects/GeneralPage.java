package Infra.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralPage {

    protected WebDriverWait wait;
    protected WebDriver driver;

    public GeneralPage(WebDriver driver) {
        this.driver = driver; // Initialize driver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
}

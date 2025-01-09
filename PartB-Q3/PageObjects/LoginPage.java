package Infra.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends GeneralPage{


    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".login-btn")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registerLink;

    @FindBy(id = "reg-username")
    private WebElement regUsernameInput;

    @FindBy(id = "reg-email")
    private WebElement regEmailInput;

    @FindBy(id = "reg-password")
    private WebElement regPasswordInput;

    @FindBy(css = ".register-btn")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password) {
        System.out.println("Attempting to login");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void register(String regUser, String regPass, String regMail){
        registerLink.click();
        wait.until(ExpectedConditions.visibilityOf(regUsernameInput));

        regUsernameInput.sendKeys(regUser);
        regEmailInput.sendKeys(regPass);
        regPasswordInput.sendKeys(regMail);

        System.out.println("Attempting to create new user");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void loginOrRegister(boolean createNewUser) {
        String newUserSt = "newuser" + System.currentTimeMillis();
        if (createNewUser) {
            register(newUserSt, newUserSt + "@example.com", "Temporary123!");
        } else {
            login("defaultuser", "password123");
        }
    }
}

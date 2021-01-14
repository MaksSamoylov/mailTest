package mail.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private PageFactory pageFactory;

    public MainPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//select[@class='domain-select svelte-no02r']")
    private WebElement domainNameField;
    @FindBy(xpath = "//input[@class='email-input svelte-no02r']")
    private WebElement emailNameField;
    @FindBy(xpath = "//button[@class='button svelte-no02r']")
    private WebElement enterPasswordButton;
    @FindBy(xpath = "//input[contains(@class, 'password-input')]")
    private WebElement passwordField;
    @FindBy(xpath = "//button[contains(@class, 'second-button')]")
    private WebElement loginButton;
    @FindBy(xpath = "//label[@class='saveauth svelte-no02r']")
    private WebElement rememberMeCheckbox;

    public InboxPage login(String emailName, String password) {
        emailNameField.sendKeys(emailName);
        enterPasswordButton.click();
        passwordField.sendKeys(password);
        loginButton.click();
        return new InboxPage(driver);
    }
}

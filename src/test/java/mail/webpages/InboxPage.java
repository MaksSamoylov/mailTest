package mail.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
    private WebDriver driver;
    private PageFactory pageFactory;

    public InboxPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class='compose-button__wrapper']")
    private WebElement writeLetterButton;
    @FindBy(xpath = "//label[@class='container--zU301']//input")
    private WebElement receiver;
    @FindBy(xpath = "//div[@class='subject__container--HWnat']//input")
    private WebElement topic;
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement body;
    @FindBy(xpath = "//span[contains(@title, 'Отправить')]/span")
    private WebElement sendButton;
    @FindBy(xpath = "//a[@class='layer__link']")
    private WebElement titleOfSuccessfullySentLetter;
    @FindBy(xpath = "//span[@class='layer-sent-page__contact-item']")
    private WebElement receiverOfSuccessfullySentLetter;

    public InboxPage writeLetter(String email, String subject, String text) {
        writeLetterButton.click();
        receiver.sendKeys(email);
        topic.sendKeys(subject);
        body.sendKeys(text);
        sendButton.click();
        return this;
    }

    public String checkTextOfSentLetterTitle() {
        return titleOfSuccessfullySentLetter.getText();
    }

    public String checkTextOfSentLetterReceiver() {
        return receiverOfSuccessfullySentLetter.getText();
    }
}

package mail.tests;


import mail.webpages.InboxPage;
import mail.webpages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailTests {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static InboxPage inboxPage;

    @BeforeAll
    public static void setUpBeforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maks\\projects\\mailru\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        inboxPage = new InboxPage(driver);
    }

    @BeforeEach
    public void setUpBeforeEach() {
        driver.get("https://mail.ru/");
    }

    @Test
    public void login() {
        mainPage.login("mhohlochev", "vaisler141")
                .writeLetter("vasilyushkn@yandex.by", "Job", "Hi,Maks");
        Assertions.assertTrue(inboxPage.checkTextOfSentLetterTitle().contains("Письмо отправлено"));
        Assertions.assertTrue(inboxPage.checkTextOfSentLetterReceiver().contains("vasilyushkn@yandex.by"));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

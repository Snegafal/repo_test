package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public abstract class BaseTest {

    private static final String url = "https://new-lka-rel.tricolor.ru/";

    protected void setConfiguration() {
          SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Attachment(value = "Screenshot", type = "img/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeEach
    protected void setUp() {
        setConfiguration();
        Selenide.open(url + "login");
    }

    @AfterEach
    protected void tearDown() {
        takeScreenshot();
        Selenide.closeWebDriver();
    }
}

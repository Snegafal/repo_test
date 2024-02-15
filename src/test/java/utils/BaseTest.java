package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    private static final String url = "https://new-lka-rel.tricolor.ru/";

    protected void setConfiguration() {
          SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    protected void setUp() {
        setConfiguration();
        Selenide.open(url + "login");
    }

    @AfterEach
    protected void tearDown() {
        Attach.screenshotAs("screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Selenide.closeWebDriver();
    }
}

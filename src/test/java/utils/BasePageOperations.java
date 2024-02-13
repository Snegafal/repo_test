package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class BasePageOperations extends BaseTest {

    protected void click (SelenideElement element) {
        element.shouldBe(Condition.visible);
        element.click();
    }

    protected String getText (SelenideElement element) {
        element.shouldBe(Condition.visible);
        return element.getText();
    }

    protected void elementIsVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    protected void writeText (SelenideElement element, String text) {
        elementIsVisible(element);
        element.clear();
        element.sendKeys(text);
    }
}


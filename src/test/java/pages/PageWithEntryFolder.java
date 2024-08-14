package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageWithEntryFolder {

    private final SelenideElement pressEntryInput = $(".css-1wyvf5z.eyoh4ac0"),
            headerInput = $(".css-115xp3c.eyoh4ac0"),
            loginInput = $("[name=login]"),
            passwordInput = $("[name=pass]"),
            captchaInput = $("[name=captcha]"),
            entryButtonInput = $(".e4uhfkv0.css-1nvnwij"),
            errorMessageCaptchaInput = $(".LoginPageLayout__error-message"),
            errorLoginInput = $(".e1te60g60.ebaq23t0.css-1itxpfa.e1gjr6xo0"),
            errorPasswordInput = $(".css-12tloqr.e15krpzo5");

    @Step("Открыть главную страницу")
    public PageWithEntryFolder openPage() {
        open("");
        Selenide.sleep(3000);
        return this;
    }

    @Step("Нажать на кнопку входа")
    public PageWithEntryFolder pressEntry() {
        pressEntryInput.click();
        return this;
    }

    @Step("Проверить заголовок: {value}")
    public PageWithEntryFolder checkHeader(String value) {
        Selenide.sleep(3000);
        headerInput.shouldHave(text(value));
        return this;
    }

    @Step("Ввести логин: {value}")
    public PageWithEntryFolder login(String value) {
        loginInput.setValue(value);
        return this;
    }

    @Step("Ввести пароль: {value}")
    public PageWithEntryFolder password(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Ввести капчу: {value}")
    public PageWithEntryFolder captcha(String value) {
        captchaInput.setValue(value);
        return this;
    }

    @Step("Нажать на кнопку входа с текстом: {value}")
    public PageWithEntryFolder entryButton(String value) {
        Selenide.sleep(3000);
        entryButtonInput.find(byText(value)).click();
        return this;
    }

    @Step("Проверить сообщение об ошибке капчи: {value}")
    public PageWithEntryFolder errorMessageCaptcha(String value) {
        errorMessageCaptchaInput.shouldHave(text(value));
        errorMessageCaptchaInput.shouldHave(cssValue("color", "rgba(237, 0, 0, 1)"));
        return this;
    }

    @Step("Проверить сообщение об ошибке логина: {value}")
    public PageWithEntryFolder errorLogin(String value) {
        Selenide.sleep(3000);
        errorLoginInput.shouldHave(text(value));
        errorLoginInput.shouldHave(cssValue("color", "rgba(237, 0, 0, 1)"));
        return this;
    }

    @Step("Проверить сообщение об ошибке пароля: {value}")
    public PageWithEntryFolder errorPassword(String value) {
        Selenide.sleep(3000);
        errorPasswordInput.shouldHave(text(value));
        errorPasswordInput.shouldHave(cssValue("color", "rgba(237, 0, 0, 1)"));
        return this;
    }

    @Step("Проверить, что кнопка входа не активна с текстом: {value}")
    public PageWithEntryFolder entryButtonNotActive(String value) {
        entryButtonInput.find(byText(value));
        String currentUrl = WebDriverRunner.url();
        entryButtonInput.find(byText(value)).click();
        return this;
    }
}

package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageWithHomeFolder {

    private final SelenideElement cookieHome = $(".css-1aoqav5"),
            cityInfoHome = $x("//*[@data-meta-name='HeaderTop__city-info']"),
            searchCityHome = $("[name='search-city']"),
            selectCityHome = $(".css-sl5paq.ek3bndn0"),
            checkTopHeaderHome = $(".css-fa32sz .fresnel-container.fresnel-greaterThanOrEqual-tabletL"),
            productCatalogOpenHome = $(".css-15x7smt[data-meta-name='DesktopHeaderFixed__catalog-menu']"),
            productCatalogCloseHome = $(".css-0.e1t4ztl50[data-meta-name='CatalogMenuDesktopLayout__close']"),
            checkProductSearchHome = $(".css-i9gxme[data-meta-name='HeaderBottom__search']"),
            checkBottomHeaderHome = $(".css-1pcsihw > .fresnel-container.fresnel-greaterThanOrEqual-tabletL"),
            checkFirstBannerHome = $(".app-catalog-0.eh6t20t0"),
            checkAmtFirstBannerHome = $(".app-catalog-qt6f7j"),
            popularCategoriesTitleHome = $("[data-meta-name='CategoryTilesLayout__title']"),
            checkPopularCategoriesHome = $("[data-meta-name='CategoryTilesLayout__category-tiles']"),
            businessCategoriesHome = $(".app-catalog-14l4nah"),
            checkBusinessCategoriesHome = $("[data-meta-name='CategoryTilesLayout__category-tiles']"),
            checkSecondBannerHome = $(".app-catalog-l6xrso"),
            checkThirdBannerHome = $(".app-catalog-116okc5"),
            checkBestsellersHome = $(".app-catalog-0.e6dnqu30"),
            checkBestNewProductsHome = $(".app-catalog-0.e1g4qpsb0"),
            checkHurryUpToBuyHome = $(".app-catalog-0.e1x63j640"),
            checkUsefulArticlesHome = $(".app-catalog-0.el6lsua0"),
            checkNewsHome = $(".app-catalog-0.e1nk0o1t0"),
            checkPopularBrendsHome = $(".app-catalog-0.e1f2u2390"),
            checkOtherServiceHome = $(".app-catalog-0.e5m37uz0"),
            checkPromotionsNewItemHome = $(".css-0.e14s7mmi0"),
            checkContactsHome = $(".e1j6azk00.css-1otgnon.e3tyxgd0"),
            checkPersonalDataHome = $(".css-0.eowcxv00");

    @Step("Открыть главную страницу")
    public PageWithHomeFolder openPage() {
        open("");
        Selenide.sleep(3000);
        return this;
    }

    @Step("Закрыть уведомление о Cookie")
    public PageWithHomeFolder cookieClose() {
        cookieHome.click();
        return this;
    }

    @Step("Открыть информацию о городе")
    public PageWithHomeFolder openCityInfo() {
        Selenide.sleep(3000);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(cityInfoHome).click().perform();
        return this;
    }

    @Step("Поиск и выбор города: {value}")
    public PageWithHomeFolder searchSelectCity(String value) {
        searchCityHome.setValue(value).pressEnter();
        selectCityHome.click();
        return this;
    }

    @Step("Проверка верхнего заголовка: {value}")
    public PageWithHomeFolder checkTopHeader(String value) {
        checkTopHeaderHome.shouldHave(text(value));
        return this;
    }

    @Step("Открыть каталог продуктов")
    public PageWithHomeFolder productCatalogOpen() {
        productCatalogOpenHome.click();
        Selenide.sleep(3000);
        return this;
    }

    @Step("Закрыть каталог продуктов")
    public PageWithHomeFolder productCatalogClose() {
        productCatalogCloseHome.click();
        return this;
    }

    @Step("Проверка наличия поля поиска продуктов")
    public PageWithHomeFolder checkProductSearch() {
        checkProductSearchHome.shouldBe(visible);
        return this;
    }

    @Step("Проверка нижнего заголовка: {value}")
    public PageWithHomeFolder checkBottomHeader(String value) {
        checkBottomHeaderHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка видимости первого баннера")
    public PageWithHomeFolder checkFirstBannerVisible() {
        checkFirstBannerHome.shouldBe(visible);
        return this;
    }

    @Step("Проверка количества реклам на первом баннере: {values}")
    public PageWithHomeFolder checkAmtFirstBanner(String... values) {
        checkAmtFirstBannerHome.shouldHave(or("text values", text(values[0]), text(values[1]), text(values[2]), text(values[3])));
        return this;
    }

    @Step("Проверка заголовка популярных категорий: {value}")
    public PageWithHomeFolder checkPopularCategoriesTitle(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        popularCategoriesTitleHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка популярных категорий: {value}")
    public PageWithHomeFolder checkPopularCategories(String value) {
        checkPopularCategoriesHome.shouldHave(text(value));
        return this;
    }

    @Step("Открыть бизнес категории: {value}")
    public PageWithHomeFolder openBusinessCategories(String value) {
        businessCategoriesHome.find(byText(value)).click();
        return this;
    }

    @Step("Проверка бизнес категорий: {value}")
    public PageWithHomeFolder checkBusinessCategories(String value) {
        checkBusinessCategoriesHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка второго баннера")
    public PageWithHomeFolder checkSecondBanner() {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkSecondBannerHome.shouldBe(visible);
        return this;
    }

    @Step("Проверка третьего баннера")
    public PageWithHomeFolder checkThirdBanner() {
        checkThirdBannerHome.shouldBe(visible);
        return this;
    }

    @Step("Проверка раздела 'Хиты продаж': {value}")
    public PageWithHomeFolder checkBestsellers(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkBestsellersHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Лучшие новинки': {value}")
    public PageWithHomeFolder checkBestNewProducts(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkBestNewProductsHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Успейте купить': {value}")
    public PageWithHomeFolder checkHurryUpToBuy(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkHurryUpToBuyHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Полезные статьи': {value}")
    public PageWithHomeFolder checkUsefulArticles(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkUsefulArticlesHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Новости': {value}")
    public PageWithHomeFolder checkNews(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkNewsHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Популярные бренды': {value}")
    public PageWithHomeFolder checkPopularBrends(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkPopularBrendsHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Другие услуги': {value}")
    public PageWithHomeFolder checkOtherService(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkOtherServiceHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Хочу быть в курсе акций и новинок': {value}")
    public PageWithHomeFolder checkPromotionsNewItem(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkPromotionsNewItemHome.shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Контакты': {value}")
    public PageWithHomeFolder checkContacts(String value) {
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        checkContactsHome.shouldHave(text(value));
        return this;
    }
    @Step("Проверка футера: {value}")
    public PageWithHomeFolder checkPersonalData(String value) {
        checkPersonalDataHome.shouldHave(text(value));
        return this;
    }
}
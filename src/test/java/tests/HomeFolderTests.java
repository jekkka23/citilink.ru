package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PageWithEntryFolder;
import pages.PageWithHomeFolder;
import utils.FakerUtil;

@Tag("regression")

public class HomeFolderTests extends TestBase {

    PageWithHomeFolder pageWithHomeFolder = new PageWithHomeFolder();
    PageWithEntryFolder pageWithEntryFolder = new PageWithEntryFolder();

    @Test
    @DisplayName("Проверка главной страницы")
    @Tag("smoke")
    @Owner("MihailovEvgeny")
    void homeFolderTest() {
        pageWithHomeFolder.openPage()
                .cookieClose()
                .openCityInfo()
                .searchSelectCity("Екатеринбург")

                .checkTopHeader("Екатеринбург")
                .checkTopHeader("+7 (343) 237-47-47")
                .checkTopHeader("Юридическим лицам")
                .checkTopHeader("Журнал")
                .checkTopHeader("Акции")
                .checkTopHeader("Конфигуратор ПК")
                .checkTopHeader("Доставка")
                .checkTopHeader("Магазины")
                .checkTopHeader("Обратная связь")

                .productCatalogOpen()
                .productCatalogClose()

                .checkProductSearch()
                .checkBottomHeader("Войти")
                .checkBottomHeader("Сравнение")
                .checkBottomHeader("Корзина")

                .checkFirstBannerVisible()
                .checkAmtFirstBanner("12", "13", "14", "15")

                .checkPopularCategoriesTitle("Популярные категории")
                .checkPopularCategories("Ноутбуки")
                .checkPopularCategories("Смартфоны")
                .checkPopularCategories("Телевизоры")
                .checkPopularCategories("Мониторы")
                .checkPopularCategories("Комплектующие для ПК")
                .checkPopularCategories("Садовая техника")
                .checkPopularCategories("Стиральные машины")
                .checkPopularCategories("Климатическая техника")
                .checkPopularCategories("Холодильники")
                .checkPopularCategories("Компьютеры")

                .openBusinessCategories("Бизнесу")
                .checkBusinessCategories("Компьютеры")
                .checkBusinessCategories("Мониторы")
                .checkBusinessCategories("Офисная техника")
                .checkBusinessCategories("Программное обеспечение")
                .checkBusinessCategories("Сетевое оборудование")
                .checkBusinessCategories("Телевизоры")
                .checkBusinessCategories("Проекторы")
                .checkBusinessCategories("Климатическая техника")
                .checkBusinessCategories("Расходные материалы для оргтехники")
                .checkBusinessCategories("Манипуляторы и устройства ввода")
                .checkBusinessCategories("Защита питания")
                .checkBusinessCategories("Эргономика")
                .checkBusinessCategories("Офисная мебель")
                .checkBusinessCategories("Серверы и СХД")
                .checkBusinessCategories("Системы безопасности")
                .checkBusinessCategories("Бумага")
                .checkBusinessCategories("Офисная канцелярия")
                .checkBusinessCategories("Носители информации")
                .checkBusinessCategories("Демонстрационное оборудование")
                .checkBusinessCategories("Оборудование для торговли")
                .checkBusinessCategories("Садовая техника")
                .checkBusinessCategories("Электроинструмент")
                .checkBusinessCategories("Умный дом")
                .checkBusinessCategories("Крупная бытовая техника")
                .checkBusinessCategories("Мелкая бытовая техника")

                .checkSecondBanner()
                .checkThirdBanner()

                .checkBestsellers("Хиты продаж")
                .checkBestNewProducts("Лучшие новинки")
                .checkHurryUpToBuy("Успейте купить")
                .checkUsefulArticles("Полезные статьи")
                .checkNews("Новости")
                .checkPopularBrends("Популярные бренды")
                .checkOtherService("Другие услуги")
                .checkPromotionsNewItem("Хочу быть в курсе акций и новинок")
                .checkContacts("Контакты")

                .checkPersonalData("Политика обработки персональных данных")
                .checkPersonalData("Рекомендательные технологии")
                .checkPersonalData("© Ситилинк, 2008 – 2024");
    }
    @Test
    @DisplayName("Вход. Успешный вход по номеру телефона")
    @Tag("smoke")
    @Owner("MihailovEvgeny")
    void entryNumberTelephoneSuccessTest() {
        pageWithEntryFolder.openPage()
                .pressEntry()
                .checkHeader("Вход / Регистрация")
                .login(FakerUtil.generatePhoneNumber())
                .password(FakerUtil.generatePassword())
                .captcha("captcha")
                .entryButton("Войти")
                .errorMessageCaptcha("Вы неправильно ввели код с картинки");
    }

    @Test
    @DisplayName("Вход. Успешный вход по Email")
    @Tag("smoke")
    @Owner("MihailovEvgeny")
    void entryEmailSuccessTest() {
        pageWithEntryFolder.openPage()
                .pressEntry()
                .checkHeader("Вход / Регистрация")
                .login(FakerUtil.generateEmail())
                .password(FakerUtil.generatePassword())
                .captcha("captcha")
                .entryButton("Войти")
                .errorMessageCaptcha("Вы неправильно ввели код с картинки");
    }

    @Test
    @DisplayName("Вход. Некорректный номер телефона")
    @Tag("smoke")
    @Owner("MihailovEvgeny")
    void entryInvalidNumberTelephoneTest() {
        pageWithEntryFolder.openPage()
                .pressEntry()
                .checkHeader("Вход / Регистрация")
                .login(FakerUtil.generateInvalidPhoneNumber())
                .password(FakerUtil.generatePassword())
                .captcha("captcha")
                .errorLogin("Введите правильный телефон или email");
    }

    @Test
    @DisplayName("Вход. Некорректный Email")
    @Tag("smoke")
    @Owner("MihailovEvgeny")
    void entryInvalidEmailTest() {
        pageWithEntryFolder.openPage()
                .pressEntry()
                .checkHeader("Вход / Регистрация")
                .login(FakerUtil.generateInvalidEmail())
                .password(FakerUtil.generatePassword())
                .captcha("captcha")
                .errorLogin("Введите правильный телефон или email");
    }

    @Test
    @DisplayName("Вход. Некорректный пароль")
    @Tag("smoke")
    @Owner("MihailovEvgeny")
    void entryInvalidPasswordTest() {
        pageWithEntryFolder.openPage()
                .pressEntry()
                .checkHeader("Вход / Регистрация")
                .login(FakerUtil.generateEmail())
                .password(FakerUtil.generateInvalidPassword())
                .captcha("captcha")
                .errorPassword("Поле должно содержать не менее 6 символов");
    }

    @Test
    @DisplayName("Вход. Не активная кнопка Вход")
    @Tag("smoke")
    @Owner("MihailovEvgeny")
    void entryButtonNotActiveTest() {
        pageWithEntryFolder.openPage()
                .pressEntry()
                .checkHeader("Вход / Регистрация")
                .login(FakerUtil.generateEmail())
                .password(FakerUtil.generatePassword())
                .entryButtonNotActive("Войти");
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static SelenideElement vacancies =  $(byText("Вакансии"));
    public static SelenideElement backend = $(byTagAndText("span", "Бэкенд-разработчик"));
    public static SelenideElement respondBtn =  $(byText("Откликнуться"));
    public static SelenideElement nameInput = $("input[placeholder='Имя']");
    public static Dropdown vacancyDd = new Dropdown($("div.dropdown[name='position']"));
    public static SelenideElement phoneInput = $("input[name='phone']");
    public static SelenideElement emailInput = $("input[name='email']");
    public static SelenideElement messageInput = $("textarea[name='user-message']");
    public static SelenideElement agreementCheckbox = $("#agreement-checkbox");
    public static SelenideElement fileInput = $("input[type = 'file']");
    public static SelenideElement submitBtn = $("button[type='submit']");
    public static SelenideElement successPopup = $("p[class='toast-text']");
}
package com.test.org;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import elements.Captcha;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class TestTask {

    private File file = new File("src\\test\\resources\\resume.txt");

    @Test
    void check() {
        Configuration.browserSize = "1920x1080";

        open("https://natlex.ru/");
        MainPage.vacancies.click();
        MainPage.backend.click();
        MainPage.respondBtn.scrollIntoView(false).click();
        MainPage.nameInput.scrollIntoView(true).setValue("Test-name");
        MainPage.vacancyDd.selectOption("Бэкенд-разработчик");
        MainPage.phoneInput.scrollIntoView(true).setValue("+79000000000");
        MainPage.emailInput.scrollIntoView(true).setValue("test@mail.ru");
        MainPage.messageInput.scrollIntoView(true).setValue("Привет. Я просто тест. Не обращай внимания");
        MainPage.fileInput.sendKeys(file.getAbsolutePath());

        /*
         Captcha captcha = new Captcha();
         captcha.passCaptcha();
        */

        MainPage.agreementCheckbox.click();
        MainPage.submitBtn.click();

        MainPage.successPopup.shouldBe(Condition.visible);
    }
}

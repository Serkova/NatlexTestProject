package elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Captcha {

    private SelenideElement captchaCheckbox = $("#recaptcha-anchor");
    private SelenideElement frame = $("iframe[title='reCAPTCHA']");
    private final String TEST_KEY = "6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI";

    public void passCaptcha() {
        changeCaptchaUrlKey();
        Selenide.switchTo().frame(frame);
        captchaCheckbox.scrollIntoView(true).click();
        Selenide.switchTo().defaultContent();
    }

    private void changeCaptchaUrlKey() {
        String url = frame.getAttribute("src");
        try {
            url = url.replaceAll("(?<=k=).+?(?=&)", TEST_KEY);
            executeJavaScript(String.format("document.querySelector(\"iframe[title='reCAPTCHA']\").setAttribute(\"src\",\"%s\")", url));
        } catch (NullPointerException ignored) {
        }
    }
}

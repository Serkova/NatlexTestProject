package elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class Dropdown {

    private SelenideElement ddElement;

    public Dropdown(SelenideElement element){
        ddElement = element;
    }

    public void openDropdown() {
        ddElement.click();
    }

    public void selectOption(String value) {
        openDropdown();
        SelenideElement option = ddElement.$(byText(value));
        option.click();
    }
}
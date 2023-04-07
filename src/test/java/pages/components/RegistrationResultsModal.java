package pages.components;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public RegistrationResultsModal verifyModalAppear (){
        $(".modal-content").should(Condition.appear);

        return this;
    }

    @Step("Проверка. Соответсвует  ли {key} значению {value}")
    public RegistrationResultsModal verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}

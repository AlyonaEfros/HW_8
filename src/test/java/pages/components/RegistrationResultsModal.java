package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public RegistrationResultsModal verifyModalAppear (){
        $(".modal-content").should(Condition.appear);

        return this;
    }

    public RegistrationResultsModal verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}

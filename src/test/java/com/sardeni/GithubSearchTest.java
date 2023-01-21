package com.sardeni;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubSearchTest {

    @ParameterizedTest(name = "Первая строка в выдаче:{1}  по поиску: {0}")
    @CsvSource (value = {
            "selenide, selenide/selenide",
            "selene python, yashaka/selene"
    })
    void csvTest(String searchQuery, String nameRepo) {
        open("https://github.com/");
        $("[name=q]").setValue(searchQuery).pressEnter();
        $$("ul.repo-list li").first().$("a").
                shouldHave(text(nameRepo));




    }

}

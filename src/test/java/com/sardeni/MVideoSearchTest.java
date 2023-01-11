package com.sardeni;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MVideoSearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @ParameterizedTest(name = "Наличие выдачи по ключу:{0}")
    @ValueSource(strings = {
            "Macbook",
            "холодильник",
            "микроволновая печь"
    })
    void valueSourceTest(String arg) {
        open("https://www.mvideo.ru/");
        $(".input__field").setValue(arg).pressEnter();
        $$("a.product-title__text").first().
                shouldHave(text(arg));




    }

}

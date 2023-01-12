package com.sardeni;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class ElitElectronicsMenuTest {
    static Stream<Arguments> checkLocalesMenuButtons() {
        return Stream.of(
                Arguments.of("eng", List.of("IT", "Large Domestic Appliances", "Mobile and Accessories", "Small Domestic Appliances", "TV and Entertainment", "Furniture", "Sales", "Brands", "Saved")),
                Arguments.of("geo", List.of("კომპიუტერული ტექნიკა", "მსხვილი საყოფაცხოვრებო ტექნიკა", "მობილური ტელეფონი და აქსესუარები", "წვრილი საყოფაცხოვრებო ტექნიკა", "ტელევიზორი და გასართობი საშუალებები", "ავეჯი", "ფასდაკლება", "ბრენდი", "შენახული ნივთები"))
        );
    }

    @ParameterizedTest(name = "Проверка корректности локали меню в {0}")
    @MethodSource
    void checkLocalesMenuButtons(String locale, List<String> buttons) {

        open("https://ee.ge/");
        $$(".geo a").find(text(locale)).click();
        $$(".header-menu-wrapper a").filter(visible).
                shouldHave(CollectionCondition.texts(buttons));
    }
}

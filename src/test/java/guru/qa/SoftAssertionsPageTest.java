package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertionsPageTest {
    @Test
    void softAssertionsPageTest() {
        open("https://github.com/");

        //Откройте страницу Selenide в Github
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $(".repo-list li").$("a").click();

        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byLinkText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}

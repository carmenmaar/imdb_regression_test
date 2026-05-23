package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import com.codeborne.selenide.SelenideElement;

public class SearchResultsPage {

    public void clickFirstTitle() {
        SelenideElement firstTitle = $("[data-testid='find-results-section-title']")
                .shouldBe(visible, Duration.ofSeconds(10))
                .$$(".ipc-title-link-wrapper")
                .filter(visible)
                .first()
                .shouldBe(visible, Duration.ofSeconds(5));

        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'start', behavior: 'instant'});",
                firstTitle
        );

        firstTitle.click();
    }
}

package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import com.codeborne.selenide.SelenideElement;

public class HomePage {

    private final SelenideElement searchBox = $("#suggestion-search");
    private final SelenideElement searchButton = $("#suggestion-search-button");

    public HomePage openPage() {
        open("https://www.imdb.com/");
        acceptConsentIfPresent();
        return this;
    }

    public void searchFor(String searchText) {
        searchBox.setValue(searchText);
        searchButton.click();
    }

    public void acceptConsentIfPresent() {
        SelenideElement acceptButton = $("button[data-testid='accept-button']");
        if (acceptButton.is(visible, Duration.ofSeconds(3))) {
            acceptButton.click();
        }
    }
}

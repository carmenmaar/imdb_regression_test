package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;
import java.util.stream.Collectors;

public class TitlePage {

    private final ElementsCollection castNames =
            $$("[data-testid='title-cast-item__actor']");

    public List<String> getTopCastMembers(int count) {
        castNames.first().shouldBe(visible);
        return castNames.stream()
                .limit(count)
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}
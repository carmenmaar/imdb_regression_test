package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.TitlePage;

import java.util.List;

@Epic("IMDb Regression Tests")
@Feature("IMDb Search")
public class ImdbSearchTest extends BaseTest {

    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    TitlePage titlePage = new TitlePage();

    @Test(description = "Search IMDb for QA and print 5 top cast members")
    @Story("Search for a title and print top cast members")
    @Description("Opens IMDb, searches for 'QA', opens the first title result and prints 5 members from the top cast section.")
    public void imdbQaSearchTest() {

        openIMDbHomePage();

        searchForTitle("QA");

        openFirstSearchResult();

        List<String> castMembers = getTopCastMembers(5);

        printCastMembers(castMembers);
    }

    @Step("Open IMDb homepage")
    public void openIMDbHomePage() {
        homePage.openPage();
    }

    @Step("Search IMDb for: {searchText}")
    public void searchForTitle(String searchText) {
        homePage.searchFor(searchText);
    }

    @Step("Open first search result")
    public void openFirstSearchResult() {
        searchResultsPage.clickFirstTitle();
    }

    @Step("Get top {count} cast members")
    public List<String> getTopCastMembers(int count) {
        return titlePage.getTopCastMembers(count);
    }

    @Step("Print cast members")
    public void printCastMembers(List<String> castMembers) {

        System.out.println("Top " + castMembers.size() + " cast members:");

        castMembers.forEach(actor ->
                System.out.println("- " + actor)
        );
    }
}
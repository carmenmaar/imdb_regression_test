# IMDb Regression Automation Project

Automated regression test for [imdb.com](https://www.imdb.com) using **Java 21**, **Selenide**, **TestNG**, and **Allure**.

## What the test does

1. Open `imdb.com`
2. Search for `"QA"` using the search bar
3. Click on the first title (titles section)
4. Print up to five members of the top cast section to the console

**Tech stack:** Java 21 · Maven · Selenide · TestNG · Allure Report · Google Chrome

---

## How to Run the Solution

### Prerequisites

Install the following before running the test:

- Java 21
- Maven
- Google Chrome
- Allure (for viewing the HTML report)

**Check installed versions:**

```bash
java -version
mvn -version
allure --version
```

**Install on macOS (if needed):**

Java 21:

```bash
brew install openjdk@21
```

If `java -version` does not show 21 after install, run the `export PATH=...` command that Homebrew prints, or install JDK 21 from [Adoptium](https://adoptium.net/).

Maven and Allure:

```bash
brew install maven
brew install allure
```

**Other operating systems:** install [JDK 21](https://adoptium.net/), [Maven](https://maven.apache.org/download.cgi), and [Allure](https://allurereport.org/docs/install/), and use your system’s usual way to install Google Chrome.

### Get the project from GitHub

Clone the repository and move into the project folder:

```bash
git clone YOUR_REPOSITORY_LINK
cd imdb_regression_test
```

Example:

```bash
git clone https://github.com/your-username/imdb_regression_test.git
cd imdb_regression_test
```

All commands below must be run from the project root (the folder that contains `pom.xml`).

### Open the project (optional)

The project can be opened in any Java-compatible IDE, for example IntelliJ IDEA, Visual Studio Code, or Eclipse.

**Visual Studio Code:**

1. Open Visual Studio Code
2. Select **File → Open Folder**
3. Choose the cloned project folder

You do **not** need to wait for the IDE to finish indexing or downloading dependencies before running the test. The steps below use Maven from the terminal; the first `mvn clean test` downloads whatever is missing.

### Run tests

Execute:

```bash
mvn clean test
```

This command will:

- clean previous results
- compile the project
- run the automated IMDb regression test (`ImdbSearchTest`)

On the first run, Maven downloads dependencies. Chrome opens automatically (managed by Selenide).

**Expected result:** `BUILD SUCCESS` in the terminal and cast names printed to the console (for example `Top 5 cast members:`). If fewer than five cast entries exist on the page, fewer names are printed.

### Generate Allure report

After a test run:

```bash
allure serve target/allure-results
```

The Allure report opens in your browser and includes:

- test execution results
- passed/failed tests
- screenshots on failure
- step-by-step execution details

### Project structure

```text
src/test/java/
├── base
│   └── BaseTest.java
├── pages
│   ├── HomePage.java
│   ├── SearchResultsPage.java
│   └── TitlePage.java
└── tests
    └── ImdbSearchTest.java
```

- `base` — reusable browser and test configuration
- `pages` — Page Object classes with page-specific locators and actions
- `tests` — automated regression test cases

---

## Why the Project is Maintainable

The project uses the Page Object Model (POM) design pattern.

Page-specific locators and actions are separated from the test logic. This makes the project easier to update if the IMDb user interface changes.

For example:

- If the IMDb search field changes, only `HomePage.java` needs to be updated.
- If the search results layout changes, only `SearchResultsPage.java` needs to be updated.
- If the top cast section changes, only `TitlePage.java` needs to be updated.

This keeps the test logic cleaner, easier to maintain, and easier to scale.

---

## Notes

- IMDb may display a cookie consent popup. The automation accepts it only when the button is visible.
- Search results may include people, companies, and titles. The automation selects the first result from the **titles** section.
- If IMDb changes its UI, some locators may need to be updated.

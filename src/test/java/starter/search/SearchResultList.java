package starter.search;

import org.openqa.selenium.By;

class SearchResultList {
    static By RESULT_TITLES = By.cssSelector("ul.job_listings .position");
    static By RESULT_TITLES_LOCATION = By.cssSelector("ul.job_listings .location");
}

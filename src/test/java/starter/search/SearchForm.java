package starter.search;

import org.openqa.selenium.By;

public class SearchForm {
    public static By SEARCH_FIELD = By.id("search_keywords");
    public static By SEARCH_FIELD_LOCATION = By.id("search_location");
    public static By SEARCH_BUTTON = By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[8]/div/div/div/div/div/div[3]/div/div/div/form/div[1]/div[4]/input");
}

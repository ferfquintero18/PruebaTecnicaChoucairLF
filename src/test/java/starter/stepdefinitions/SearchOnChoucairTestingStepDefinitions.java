package starter.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import starter.navigation.NavigateTo;
import starter.search.SearchFor;
import starter.search.SearchResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;
import static starter.matchers.StringContainsIgnoringCase.containsIgnoringCase;

public class SearchOnChoucairTestingStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the ChoucairTesting Empleos Page")
    public void on_the_ChoucairTesting_Empleos_Page(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theChoucairTestingEmpleosPage());
    }

    @When("she/he searches for {string}")
    public void search_for(String term) {

        withCurrentActor(
                SearchFor.term(term)
        );
    }

    @Then("all the result titles should contain the word {string}")
    public void all_the_result_titles_should_contain_the_word(String term) {
        withCurrentActor(
                Ensure.thatTheAnswersTo(SearchResult.titles())
                        .allMatch("a title containing '" + term + "'",
                                title -> title.toLowerCase().contains(term.toLowerCase()))

        );



        theActorInTheSpotlight().should(
                seeThat("search result titles",
                        SearchResult.titles(), hasSize(greaterThan(0))),
                seeThat("search result titles",
                        SearchResult.titles(), everyItem(containsIgnoringCase(term)))
        );
    }

    @When("she/he searches for location {string}")
    public void search_for_location(String term) {

        withCurrentActor(
                SearchFor.termLocation(term)
        );
    }

    @Then("all the result titles location should contain the word {string}")
    public void all_the_result_titles_location_should_contain_the_word(String term) {
        withCurrentActor(
                Ensure.thatTheAnswersTo(SearchResult.titleslocation())
                        .allMatch("a title location containing '" + term + "'",
                                title -> title.toLowerCase().contains(term.toLowerCase()))

        );


        theActorInTheSpotlight().should(
                seeThat("search result titles location",
                        SearchResult.titleslocation(), hasSize(greaterThan(0))),
                seeThat("search result titles location",
                        SearchResult.titleslocation(), everyItem(containsIgnoringCase(term)))
        );
    }


    @When("she searches for keyword {string} and location {string}")
    public void sheSearchesForLocationAndKeywordAnd(String keyword, String location) {
        withCurrentActor(
                SearchFor.termLocationKeyword(keyword,location)
        );
    }


}

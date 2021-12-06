package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsPage;
import tests.BaseTest;

import java.io.IOException;

public class CucumberSteps extends BaseTest {

    @Before
    public void init(){
        init("Chrome", "96", 30);
    }


    @Given("I am on products page")
    public void iAmOnProductsPage() {
        driver.get("https://gigatron.rs/tv-audio-video/slusalice");
        System.out.println("Hello from GitHub!");
    }

    @When("I click Sort by {string}")
    public void iClickSortBy(String sortingMethod) throws InterruptedException {
        ProductsPage p = new ProductsPage(driver, wait);
        p.sortBy(sortingMethod); //ovo je rastuci u Cucumberu
    }

    @Then("I should see products sorted {string}")
    public void iShouldSeeProductsSorted(String sortingMethod) throws Exception {
        ProductsPage p = new ProductsPage(driver, wait);
        p.verifyItemsAreSorted(sortingMethod); //na osnovu ove metode i sorting method-a koji dobije iz Cucumbera i onda tamo iz ProductPage-a iz switch-a izbere sorting method
    }


    @After
    public void quit() throws IOException {
        //reportScreenshot("Test", "TestAllure");
        quitDriver();
    }

}

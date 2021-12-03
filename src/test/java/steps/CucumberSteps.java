package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import tests.BaseTest;

import java.io.IOException;

public class CucumberSteps extends BaseTest {

    @Before
    public void init(){
        init("Chrome", "96", 30);
    }

    @After
    public void quit() throws IOException {
        reportScreenshot("Test", "TestAllure");
        quitDriver();
    }

}

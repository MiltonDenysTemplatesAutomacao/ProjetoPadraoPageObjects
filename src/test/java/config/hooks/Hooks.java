package config.hooks;

import config.browser_factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void init(){
        DriverFactory.getDriver();
    }
    @After
    public void finish(){
        DriverFactory.killDriver();
    }

}

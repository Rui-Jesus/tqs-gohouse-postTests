/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rui.ua.tqs.gohouse.posttests;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author rui
 */
public class InitTest {
    
    private WebDriver driver;
    private String baseUrl;
    private static final String DRIVER_PATH = "/home/r.jesus"; 
    
    @Before
    public void setUp() throws Exception {
        //Este path é o da VM !!!! 
        //Pra testar localmente trocar para o path onde têm o vosso download do chrome driver
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH); 
        
        ChromeOptions options = new ChromeOptions();
        
        // setting headless mode to true.. so there isn't any ui
        options.setHeadless(true);

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver(options);
        baseUrl = "http://www.netbeans.org";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Test
    public void testSimple() throws Exception {
        
        System.out.println("It's working"); 
        
        // And now use this to visit NetBeans
        driver.get(baseUrl);
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.netbeans.org");

        // Check the title of the page
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("NetBeans");
            }
        });

        //Close the browser
        driver.quit();
    }
    
}

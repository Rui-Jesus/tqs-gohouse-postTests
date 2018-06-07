/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rui.ua.tqs.gohouse.posttests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author rui
 */
public class InitTest {

    private WebDriver driver;
    private String baseUrl;
    private static final String DRIVER_PATH = "/home/r.jesus/chromedriver";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

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

        driver.get("http://192.168.160.224:8080/tqs-gohouse-1.0-SNAPSHOT/faces/home.xhtml");
        try {
            driver.findElement(By.linkText("Logout")).click();

        } catch (Exception e) {
        }
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("j_idt20:j_idt22")).click();
        driver.findElement(By.name("j_idt20:j_idt22")).clear();
        driver.findElement(By.name("j_idt20:j_idt22")).sendKeys("jjpp");
        driver.findElement(By.name("j_idt20:j_idt24")).click();
        driver.findElement(By.name("j_idt20:j_idt24")).clear();
        driver.findElement(By.name("j_idt20:j_idt24")).sendKeys("jjpp");
        driver.findElement(By.name("j_idt20:j_idt26")).click();
        driver.findElement(By.name("j_idt20:j_idt26")).clear();
        driver.findElement(By.name("j_idt20:j_idt26")).sendKeys("jjpp@outlook.com");
        driver.findElement(By.name("j_idt20:j_idt28")).click();
        driver.findElement(By.id("j_idt20:0:j_idt28")).click();
        driver.findElement(By.name("j_idt21:j_idt23")).click();
        driver.findElement(By.linkText("Adicionar Propriedade")).click();
        driver.findElement(By.name("j_idt19:j_idt21")).click();
        driver.findElement(By.name("j_idt19:j_idt21")).clear();
        driver.findElement(By.name("j_idt19:j_idt21")).sendKeys("1");
        driver.findElement(By.name("j_idt19:j_idt23")).click();
        driver.findElement(By.name("j_idt19:j_idt23")).clear();
        driver.findElement(By.name("j_idt19:j_idt23")).sendKeys("1");
        driver.findElement(By.id("j_idt19")).click();
        driver.findElement(By.name("j_idt19:j_idt25")).click();
        driver.findElement(By.name("j_idt19:j_idt25")).clear();
        driver.findElement(By.name("j_idt19:j_idt25")).sendKeys("1");
        driver.findElement(By.id("j_idt19")).click();
        driver.findElement(By.id("j_idt19")).click();
        driver.findElement(By.name("j_idt19:j_idt27")).click();
        new Select(driver.findElement(By.name("j_idt19:j_idt27"))).selectByVisibleText("Apartamento");

        driver.findElement(By.linkText("Minha Conta")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

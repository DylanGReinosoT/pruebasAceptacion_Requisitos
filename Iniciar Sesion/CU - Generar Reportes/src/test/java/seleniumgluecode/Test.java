package seleniumgluecode;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.time.Duration;

public class Test {

    private ChromeDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @Given("^El administrador se encuentra en la pagina Inicio$")
    public void el_administrador_se_encuentra_en_la_pagina_Inicio() throws Throwable {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:5173/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10).toMillis());

    }

    @When("^Ingrese su usuario y contraseña correctas$")
    public void ingrese_su_usuario_y_contraseña_correctas() throws Throwable {
        driver.get("http://localhost:5173/login");
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        username.sendKeys("gareinoso");
        password.sendKeys("220874");
    }

    @When("^Haga clic en el boton de Iniciar Sesion$")
    public void haga_clic_en_el_boton_de_Iniciar_Sesion() throws Throwable {
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginButton")));
        loginButton.click();

    }

    @Then("^Se debe redirigir a la pantalla del inventario$")
    public void se_debe_redirigir_a_la_pantalla_del_inventario() throws Throwable {
        WebElement pageTitleLocator = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Titulo")));
        Assert.assertTrue("No se direcciono correctamente a la pagina del inventario", pageTitleLocator.isDisplayed());
        Assert.assertEquals("Inventario",pageTitleLocator.getText());
    }
}

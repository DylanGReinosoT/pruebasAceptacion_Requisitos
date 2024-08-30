package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test {

    private ChromeDriver driver;
    private WebDriverWait wait;

    @Given("^El administrador se encuentra en la pantalla principal del inventario$")
    public void el_administrador_se_encuentra_en_la_pantalla_principal_del_inventario() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");  // Cambia la URL si es necesario
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("^El administrador selecciona la opción \"([^\"]*)\"$")
    public void el_administrador_selecciona_la_opcion(String opcion) throws Throwable {
        WebElement opcionElemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(opcion)));
        opcionElemento.click();
    }

    @When("^Ingresa la fecha de inicio \"([^\"]*)\" y la fecha de fin \"([^\"]*)\"$")
    public void ingresa_la_fecha_de_inicio_y_la_fecha_de_fin(String fechaInicio, String fechaFin) throws Throwable {
        WebElement fechaInicioInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fechaInicio")));
        WebElement fechaFinInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fechaFin")));
        fechaInicioInput.sendKeys(fechaInicio);
        fechaFinInput.sendKeys(fechaFin);
    }

    @When("^Hace clic en el botón de \"([^\"]*)\"$")
    public void hace_clic_en_el_boton_de(String boton) throws Throwable {
        WebElement generarReporteButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("generarReporteButton")));
        generarReporteButton.click();
    }

    @Then("^El reporte debe generarse y mostrar la información correspondiente al rango de fechas seleccionado$")
    public void el_reporte_debe_generarse_y_mostrar_la_informacion_correspondiente_al_rango_de_fechas_seleccionado() throws Throwable {
        WebElement reporte = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reporte")));
        Assert.assertTrue("El reporte no se generó correctamente", reporte.isDisplayed());
        String reporteTexto = reporte.getText();
        Assert.assertTrue(reporteTexto.contains("Reporte generado del"));
        Assert.assertTrue(reporteTexto.contains("Detalles del inventario de materia prima..."));
    }

    @Then("^El administrador debe poder descargar el reporte en formato PDF$")
    public void el_administrador_debe_poder_descargar_el_reporte_en_formato_PDF() throws Throwable {
        WebElement downloadButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("downloadPDFButton")));
        Assert.assertTrue("El botón de descarga no está presente", downloadButton.isDisplayed());
        downloadButton.click();  // Aquí puedes agregar más lógica para verificar la descarga si es necesario
    }

    @Then("^El administrador debe poder cerrar el navegador$")
    public void el_administrador_debe_poder_cerrar_el_navegador() throws Throwable {
        driver.quit();
    }
}

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextFild() {
		dsl.escrever("elementosForm:nome", "Rafael");
		Assert.assertEquals("Rafael", dsl.obterValoCampo("elementosForm:nome"));
	}

	@Test
	public void testeTextArea() {
		dsl.escrever("elementosForm:sugestoes", "Olá Mundo");
		Assert.assertEquals("Olá Mundo", dsl.obterValoCampo("elementosForm:sugestoes"));

	}

	@Test
	public void testeRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}

	@Test
	public void testeCheckBox() {
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}

	@Test
	public void testeComboBox() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
//		combo.selectByIndex(3);
//		combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau incompleto");
		Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
	}

	@Test
	public void deveVerificarValoresCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);

		java.util.List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
	}

//	@Test
//	public void testeComboBoxMultiplos() {
//		System.setProperty("webdriver.chrome.driver", "c:/selenium/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
//		Select combo = new Select(element);
//		combo.selectByVisibleText("Natacao");
//		combo.selectByVisibleText("Corrida");
//		combo.selectByVisibleText("O que eh esporte?");

//		combo.deselectByVisibleText("Corrida");
//		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
//		
// Não conegui fazer funcionar rs ->		
//		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
//		Assert.assertEquals(3, allSelectedOptions.size());

//	}

	@Test
	public void testeButton() {
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}

	@Test
	// @Ignore
	public void testeLinks() {
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}

	@Test
	public void testeBuscarTextosNaTela() {
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());

		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadatroPages {

	static WebDriver driver;

	public CadatroPages(WebDriver driver) {
		CadatroPages.driver = driver;
	}

	public void preencherCampos() {
		WebElement nome = driver.findElement(By.name("firstname"));
		nome.sendKeys("Rafael");

		WebElement sobrenome = driver.findElement(By.name("lastname"));
		sobrenome.sendKeys("Lima");

		WebElement sex = driver.findElement(By.xpath("//input[@id='sex-0']"));
		sex.click();

		WebElement anosExperiencia = driver.findElement(By.xpath("//input[@id='exp-0']"));
		anosExperiencia.click();

		WebElement senha = driver.findElement(By.id("datepicker"));
		senha.sendKeys("25/08/2018");

		WebElement profissional = driver.findElement(By.xpath("//input[@id='profession-0']"));
		profissional.click();

		WebElement automacaoCom = driver.findElement(By.xpath("//input[@id='tool-2']"));
		automacaoCom.click();

		WebElement continente = driver.findElement(By.xpath("//*[@id=\"continents\"]"));
		continente.click();

		WebElement selecionaContinente = driver.findElement(By.xpath("//option[contains(text(),'South America')]"));
		selecionaContinente.click();

		WebElement comandosSelenium = driver.findElement(By.xpath("//option[contains(text(),'WebElement Commands')]"));
		comandosSelenium.click();

	}

}

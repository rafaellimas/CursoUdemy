import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mainframe {
	
	private WebDriver driver;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		//driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.get("https://www.google.com.br/webhp?hl=pt-BR&sa=X&ved=0ahUKEwih8e6ewsLdAhWDh5AKHTsHCgEQPAgD");
	}

	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void procuraMainframe(){
		driver.findElement(By.id("lst-ib")).sendKeys("mainframe");
		driver.findElement(By.xpath("//input[@value='Pesquisa Google']")).click();
		
		Assert.assertEquals("mainframe", driver.findElement(By.id("lst-ib")).getAttribute("value"));
	}

}

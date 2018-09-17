import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", "c:/selenium/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "c:/selenium/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
// 1 delimitar o tamanho do browser. 2 Iden, 3 iniciar browser maximizado
//	1	driver.manage().window().setPosition(new Point(100, 100));
//	2	driver.manage().window().setSize(new Dimension(1200, 765));
//	3	driver.manage().window().maximize();
		driver.get("https://google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}

}

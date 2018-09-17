package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CadatroPages;

public class CadatroTest {
	
	static WebDriver driver;	
	static CadatroPages cadatroPages;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "c:/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://toolsqa.com/automation-practice-form/");
		cadatroPages = new CadatroPages(driver);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@Test
	public void test() {
		cadatroPages.preencherCampos();
	
	}

}

package Base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import Pages.HomePage;

public class Base {
	private static WebDriver driver;
	protected static HomePage homePage;
	
	@BeforeAll
	public static void inicia() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nunesnel\\aula\\iterasys-web\\TestWeb\\drives\\chromedriver.exe");
		homePage = new HomePage(driver);
		
	}
	
	@BeforeEach
	public void carrega() {
		homePage.carregasite();
	}
	
	
	@AfterAll
	public static void encerra() {
		homePage.driver.quit();
	}
	
	public String gerapastalog() {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd hhmmss");
		String stringdate = DateFor.format(date);
		return stringdate;
	}

	
	
	public void capturascreen(String produto, String passo, String pastalog) {
		var screen = (TakesScreenshot) homePage.driver;
		File pasta = new File("C:\\Users\\nunesnel\\aula\\iterasys-web\\TestWeb\\src\\test\\resources\\" + pastalog);
        pasta.mkdir();
		File arquivo = screen.getScreenshotAs(OutputType.FILE);
		try {
		Files.move(arquivo, new File(pasta + "//Teste_" + produto + "_" + passo + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

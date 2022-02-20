package br.com.mbaiesp.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.mbaiesp.driver.CoreDriver;


public class Aula1Selenium {

	public WebDriver driver;
	private static String textoRecursividade;
	private static String textoQuisDizer;
	private static String fraseCompleta;


	@Before
	public void before() {
		driver = CoreDriver.getDriver();
	}
	@After
	public void after() {
		driver = null;
		CoreDriver.resetDriver();
	}
	
	@Test
	public void teste01() {
		
		PageFactory.initElements(this.driver, this);
		driver.navigate().to("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("recursividade");
		driver.findElement(By.name("q")).submit();
		driver.findElement(By.name("q")).getText();
		textoQuisDizer = driver.findElement(By.id("taw")).findElement(By.tagName("span")).getText();
		textoRecursividade = driver.findElement(By.id("taw")).findElement(By.tagName("i")).getText();
		fraseCompleta = coverteString(textoQuisDizer, textoRecursividade);
		Assert.assertEquals("Você quis dizer: recursividade", fraseCompleta);

	}

	private String coverteString(String textoQuisDizer, String textoRecursividade) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(textoQuisDizer);
		stringBuilder.append(" ");
		stringBuilder.append(textoRecursividade);
		String frase = stringBuilder.toString();
		return frase;
	}
}

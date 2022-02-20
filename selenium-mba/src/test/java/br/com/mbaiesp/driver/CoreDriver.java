package br.com.mbaiesp.driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.com.mbaiesp.config.Browser;
import br.com.mbaiesp.config.Property;
import br.com.mbaiesp.util.ConversorTipos;



/**
 * Selenium WebDriver
 *
 * @author thiago.freire
 */
public class CoreDriver {

	static WebDriver driver;
	static String OS = System.getProperty("os.name").toLowerCase();
	static String OS_ARCH = System.getProperty("sun.arch.data.model").toLowerCase();

	public static WebDriver getDriver() {
		if (driver == null) {
			try {
				if(Browser.CHROME.equals(Property.BROWSER_NAME)){
					ChromeOptions chromeOptions = new ChromeOptions();
//					chromeOptions.addArguments("--start-maximized");// Maximiza o navegador
//					chromeOptions.addArguments("headless");
					System.setProperty("webdriver.chrome.driver",getFileDriverPathChrome().getAbsolutePath());
					driver = new ChromeDriver(chromeOptions);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return driver;
	}
	
	/**
	 * 
	 * @return sistema Operacional Windows
	 */
	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}
	/**
	 * @return sistema Operacional Linux
	 */
	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS
				.indexOf("aix") > 0);
	}
	
	public static boolean isOS64bits() {
		if (ConversorTipos.check(OS_ARCH)) {
			return Integer.valueOf(OS_ARCH) == 64;
		}
		return false;
	}
	
	private static File getFileDriverPathChrome() throws Exception{
		File file = null;
			if (isWindows()) {
				file = new File(Property.CHROME_DRIVE_PATH);
			} else if (isUnix()) {
				file = new File(Property.CHROME_DRIVE_LINUX_PATH);
			} else
				throw new Exception("Sistema operacional nao compativel");
		return file;
	}

	public static void resetDriver() {
		if(driver != null) {
			driver.close();
			driver = null;
		}
		
	}
}

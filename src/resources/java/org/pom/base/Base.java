package org.pom.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.pom.testLocators.LoginPage;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static LoginPage login;

	// Load property file
	public Base() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\ssndr\\eclipse-workspace\\POMFrameWork\\src\\resources\\"
				+ "java\\org\\pom\\practice\\config\\config.properties");
		prop.load(ip);
	}

	// Get driver and Url
	public static void getDriver(String url) throws IOException {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	// Send keys
	public static void type(WebElement element, String name) {
		element.clear();
		element.sendKeys(name);
	}

	// Select
	public static void select(WebElement element, String name) {
		Select select = new Select(element);
		select.selectByVisibleText(name);
	}

	// Click
	public static void btnClick(WebElement element) {
		element.click();

	}

	// Quit
	public static void quitBrowser(WebDriver driver) {
		driver.quit();

	}
	//XML to java object conversion
	public static void convertToObjet() throws JAXBException {

		// Create JAXB context
		JAXBContext context = JAXBContext.newInstance(LoginPage.class);

		// Create Unmarshaller
		Unmarshaller un = context.createUnmarshaller();

		// xml Location
		login = (LoginPage) un.unmarshal(new File("Adactin.xml"));

	}
	//Java object to XML
	public static void convertToXml() throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(LoginPage.class);
		
		Marshaller ma = context.createMarshaller();
		login.setLogged("Success");
		ma.marshal(login, new File("Adactin.xml"));
		
		}

}
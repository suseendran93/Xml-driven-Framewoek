package org.pom.tests;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pom.base.Base;
import org.pom.testLocators.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
	public static LoginPage log;
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public static void setup() throws IOException, JAXBException {
		
		getDriver(prop.getProperty("homeUrl"));
		convertToObjet();
		type(login.getTxtUsername(), login.getUsername());// locator,value
		type(login.getTxtPassword(), login.getPassword());// locator,value
		btnClick(login.getBtnLogin());
	}

	@Test
	public static void validateLogin() throws JAXBException {
		WebElement user = driver.findElement(By.xpath("//input[@id=\"username_show\"]"));
		if (user.getAttribute("value").contains("suseendran")) {
			System.out.println("Correct user");
			
		}
		
	}
		
	@Test(dependsOnMethods="validateLogin")
	public static void dependentTest() throws JAXBException {
	convertToXml();
	}

	@AfterMethod

	public void tearDown() {
		quitBrowser(driver);
	}

}

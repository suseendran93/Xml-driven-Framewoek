package org.pom.testLocators;

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pom.base.Base;

@XmlRootElement
public class LoginPage extends Base{
	
	private String username;
	private String password;
	private String logged;
	
	
	

	@FindBy(id = "username")
	private WebElement txtUsername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@id='login']")
	private WebElement btnLogin;

	public LoginPage() throws IOException { // Constructor
		PageFactory.initElements(driver, this);
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	//XML attributes
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLogged() {
		return logged;
	}

	public void setLogged(String logged) {
		this.logged = logged;
	}

}

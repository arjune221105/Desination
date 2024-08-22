package Vtigrt.Object.Reposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contacts")
	private WebElement ContectLink;

	@FindBy(linkText = "Organizations")
	private WebElement OrgnazationsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement SingoutLink ;

	public WebElement getContectLink() {
		return ContectLink;
	}

	public WebElement getOrgnazationsLink() {
		return OrgnazationsLink;
	}

	public WebElement getSingoutLink() {
		return SingoutLink;
	}
	
	
}

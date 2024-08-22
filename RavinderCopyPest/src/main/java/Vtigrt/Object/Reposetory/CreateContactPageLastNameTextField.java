package Vtigrt.Object.Reposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPageLastNameTextField {

	public CreateContactPageLastNameTextField(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "lastname")
	private WebElement LastNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebuttonContact ;

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getSavebuttonContact() {
		return savebuttonContact;
	}

	
	
}

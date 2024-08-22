package Vtigrt.Object.Reposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgnazationPage {

	public CreateOrgnazationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")

	private WebElement OrgnazationLookpButton;

	public WebElement getOrgnazationLookpButton() {
		return OrgnazationLookpButton;
	}
	
	

}

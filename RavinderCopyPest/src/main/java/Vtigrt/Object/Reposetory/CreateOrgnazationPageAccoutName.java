package Vtigrt.Object.Reposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgnazationPageAccoutName {

	public CreateOrgnazationPageAccoutName(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "accountname")
	private  WebElement OrgnazationTextFiled;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	
	private WebElement savebuttonOrgnazation ;

	public WebElement getOrgnazationTextFiled() {
		return OrgnazationTextFiled;
	}

	public WebElement getSavebuttonOrgnazation() {
		return savebuttonOrgnazation;
	}
	
	
	

}

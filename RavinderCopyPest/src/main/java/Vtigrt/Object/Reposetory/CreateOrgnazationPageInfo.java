package Vtigrt.Object.Reposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgnazationPageInfo {

	public CreateOrgnazationPageInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")

	private WebElement toOrgnazationPageInfo;

	public WebElement getToOrgnazationPageInfo() {
		return toOrgnazationPageInfo;
	}

	
	
	
}

package Vtigrt.Object.Reposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContectPageInfo {
	
	public CreateContectPageInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	
	private WebElement toContactPageinfo;

	public WebElement getToContactPageinfo() {
		return toContactPageinfo;
	}
	
	

}

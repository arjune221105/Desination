package Vtiger.contect.reposotory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcleFileUtility;
import Vtigrt.Object.Reposetory.CreateContactPage;
import Vtigrt.Object.Reposetory.CreateContactPageLastNameTextField;
import Vtigrt.Object.Reposetory.CreateContectPageInfo;
import Vtigrt.Object.Reposetory.HomePage;



public class ToCreateContect  extends BaseClass{
	
	@Test (groups ="Regression")
	public void toCreatContect_001() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getContectLink().click();
		
		
		CreateContactPage cp=new CreateContactPage(driver);
		cp.getToclickContactLookupButton().click();
		
		
		ExcleFileUtility eutil=new ExcleFileUtility();
		String LASTNAME = eutil.toReadDataFromExcleFile("Contact", 1, 2);
		
		
		CreateContactPageLastNameTextField ccp=new CreateContactPageLastNameTextField(driver);
		ccp.getLastNameTextField().sendKeys(LASTNAME);
		ccp.getSavebuttonContact().click();
		
		
		CreateContectPageInfo cip=new CreateContectPageInfo(driver);
		String lastname = cip.getToContactPageinfo().getText();
		
		Assert.assertTrue(lastname.contains(LASTNAME));
		
	}

}

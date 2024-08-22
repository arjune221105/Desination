package Vtiger.contect.reposotory;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcleFileUtility;
import GenericUtility.JavaFileUtility;
import Vtigrt.Object.Reposetory.CreateOrgnazationPage;
import Vtigrt.Object.Reposetory.CreateOrgnazationPageAccoutName;
import Vtigrt.Object.Reposetory.CreateOrgnazationPageInfo;
import Vtigrt.Object.Reposetory.HomePage;


public class ToCreateOrgnazation  extends BaseClass{
	
	
	@Test(groups = "smoke")
	public void toCreateOrgnazationTc_001() throws EncryptedDocumentException, IOException {
		HomePage hp= new HomePage(driver);
		hp.getOrgnazationsLink().click();
		
		
		CreateOrgnazationPage cop=new CreateOrgnazationPage(driver);
		cop.getOrgnazationLookpButton().click();
		
		
		ExcleFileUtility eutil=new ExcleFileUtility();
		JavaFileUtility jutil=new JavaFileUtility();
		String ORGNAME = eutil.toReadDataFromExcleFile("Orgnazation", 1, 2)+jutil.toGetRandonNumber();
		System.out.println(ORGNAME);
		
		CreateOrgnazationPageAccoutName copn=new CreateOrgnazationPageAccoutName(driver);
		copn.getOrgnazationTextFiled().sendKeys(ORGNAME);
		copn.getSavebuttonOrgnazation().click();
		

		// VALIDATE
		CreateOrgnazationPageInfo cifo=new CreateOrgnazationPageInfo(driver);
		
		
		String orginfomation = cifo.getToOrgnazationPageInfo().getText();
		
		Assert.assertTrue(orginfomation.contains(ORGNAME));
		
		
	}
	

}

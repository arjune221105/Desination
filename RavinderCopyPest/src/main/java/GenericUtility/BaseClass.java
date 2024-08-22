package GenericUtility;



public class BaseClass {

	PropertyFileUtility putil=new PropertyFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	ExcleFileUtility eutil=new ExcleFileUtility();
	
	public WebDriver driver = null;

	public static WebDriver sDriver;

	@BeforeSuite (groups = {"smoke","Regression"})
	public void beforsuifconfig() {

		Reporter.log("-------DataBase Connection Stabilished------", true);
	}

	@BeforeClass (groups = {"smoke","Regression"})
	public void beforclassconfig() throws IOException {

		String BROWSER = putil.toReadDataFromPropertyFile("browsername");
		String URL = putil.toReadDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}

		// Lanch the Browser
		sDriver =driver;
		wutil.ToMaximize(driver);
		Reporter.log("Browser got Maximize successfully", true);
		wutil.toWaitForElement(driver);
		driver.get(URL);

	}

	@BeforeMethod (groups = {"smoke","Regression"})
	public void beformethodsconfig() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextField().sendKeys(USERNAME);
		lp.getPasswordnameTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		Reporter.log("Login Successfully",true);
	}
	
	@AfterMethod (groups = {"smoke","Regression"})
	public void aftermethodconfig() {
		HomePage hp=new HomePage(driver);
		wutil.toMouseHover(driver, hp.getSingoutLink());
		hp.getSingoutLink().click();
		Reporter.log("Logout Successfully",true);
	}
	
	@AfterClass (groups = {"smoke","Regression"})
	public void afterclassconfig() {
		Reporter.log("Browser got Closed Successfully",true);
		driver.quit();
	}

/*@Test
	public void RunSuccessfully() {
		Reporter.log("All working fine",true);
	}
	
	
	*/
	
	
	
	

}

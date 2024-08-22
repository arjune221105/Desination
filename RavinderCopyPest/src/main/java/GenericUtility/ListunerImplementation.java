package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListunerImplementation implements ITestListener {
	
	 	ExtentReports reoport ;
	 	ExtentTest test ;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--start--");
		test=reoport.createTest(methodname);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Pass--");
		test.log(Status .PASS,methodname+"--Pased");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Fail--");
		test.log(Status. FAIL,methodname+"---Failed---");
		WebDriverUtility wutil =new WebDriverUtility();
		JavaFileUtility jutil=new JavaFileUtility();
		String screenshotname = methodname + "-" + jutil.toGetSystemDateandStringTime();
		try {
			wutil.toTakeScreenShot(BaseClass.sDriver, screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "--Skip--");

	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println(context + "--Suit execution stared--");
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(
				"./ExtentReports/Report-" + new JavaFileUtility().toGetSystemDateandStringTime() + ".html");

		htmlreport.config().setDocumentTitle("Vtiger Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VITGER EXECUTION REPORT");

		reoport = new ExtentReports();
		reoport.attachReporter(htmlreport);
		reoport.setSystemInfo("Base Url", "http://localhost:8888/");
		reoport.setSystemInfo("Username", "admin");
		reoport.setSystemInfo("Password", "password");
		reoport.setSystemInfo("Base Browser", "Chrome");

	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println(context + "---Finish---");
		reoport.flush();
		

	}

}

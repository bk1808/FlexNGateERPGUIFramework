package com.flexngate.erp.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.flexngate.erp.generic.basetest.BaseClass;
import com.flexngate.erp.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Report confifguration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		// add Env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backUP");
		report.flush();

	}

	public void onTestStart(ITestResult result) {
		System.out.println("===== =====>" + result.getMethod().getMethodName() + ">===START======");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==> STARTED <====");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("===== =====>" + result.getMethod().getMethodName() + ">=====END======");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==> COMPLETED <====");

	}

	public void onTestFailure(ITestResult result) {
		String testNAme = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testNAme + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==> FAILED <====");

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}

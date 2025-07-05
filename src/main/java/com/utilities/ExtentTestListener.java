package com.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	    ExtentTest test = ExtentReportManager.getReportInstance()
	        .createTest(result.getMethod().getMethodName());
	    ExtentReportManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    ExtentTest test = ExtentReportManager.getTest();
	    test.log(Status.FAIL, "Test Failed");
	    test.log(Status.FAIL, result.getThrowable());

	    String testName = result.getMethod().getMethodName();
	    String screenshotPath = utilities.captureScreenshot(testName);
	    try {
	        test.addScreenCaptureFromPath(screenshotPath);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.getReportInstance().flush();
	}
}



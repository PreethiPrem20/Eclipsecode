package preethiAcademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentNG {
	static ExtentReports extent;
	static ExtentTest test;
	public static ExtentReports getReportData() {
        //ExtentReports, ExtentSpakeReporter
        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation report");
        reporter.config().setDocumentTitle("Test Results");

        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Preethi");
		return extent;
	}

}

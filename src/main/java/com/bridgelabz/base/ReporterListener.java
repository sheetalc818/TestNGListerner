package com.bridgelabz.base;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReporterListener implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for(ISuite suite : suites) {
            String suiteName = suite.getName();
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite "+ suiteName + "is : "
                        +tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite "+ suiteName + "is : "
                        +tc.getSkippedTests().getAllResults().size());

                Set<ITestResult> passedTestResults = tc.getPassedTests().getAllResults();

                for (ITestResult passedTestResult : passedTestResults){
                    String methodName = passedTestResult.getName();
                    System.out.println("Method Name : "+methodName);
                    System.out.println("Status : "+passedTestResult.getStatus());

                    System.out.println("Exception : "+passedTestResult.getThrowable());
                }
            }
        }
    }
}

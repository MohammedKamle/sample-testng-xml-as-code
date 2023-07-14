package com.example.runners;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class XMLRunner {
    public static void main(String[] args) {
        // Create an instance of XmlSuite
        XmlSuite suite = new XmlSuite();
        suite.setName("All Test Suite");
        suite.setParallel(XmlSuite.ParallelMode.CLASSES);
        suite.setThreadCount(2);

        // Create an instance of XmlTest
        XmlTest test = new XmlTest(suite);
        test.setVerbose(2);
        test.setPreserveOrder(true);
        test.setName("/Users/mohammadk/sample-testng-class-runner");

        // Create a list of XmlClass for test classes
        List<XmlClass> classes = new ArrayList<>();

        // TestClass1 configuration
        XmlClass testClass1 = new XmlClass("com.example.testcases.TestCase1");
        classes.add(testClass1);

        // TestClass2 configuration
        XmlClass testClass2 = new XmlClass("com.example.testcases.TestCase2");
        classes.add(testClass2);

        // Set the test classes in XmlTest
        test.setXmlClasses(classes);

        // Create a list of XmlSuite to run
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        // Create an instance of TestNG
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);

        // Run the TestNG tests
        testNG.run();
    }
}

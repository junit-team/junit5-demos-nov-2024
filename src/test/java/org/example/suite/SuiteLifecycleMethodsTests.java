package org.example.suite;

import org.junit.platform.suite.api.AfterSuite;
import org.junit.platform.suite.api.BeforeSuite;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import static java.lang.System.out;

@Suite
@SuiteDisplayName("Demo of suite lifecycle methods")
@SelectPackages("org.example.suite")
public class SuiteLifecycleMethodsTests {

    @BeforeSuite
    static void setUp() {
        out.println("--> @BeforeSuite is executed before the whole test suite");
    }

    @AfterSuite
    static void tearDown() {
        out.println("--> @AfterSuite is executed after the whole test suite");
    }

}

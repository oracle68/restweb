package com.myapp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressTest.class, JavaTest.class, TestProduct2.class, testrest.class})
public class AllTests {

}

package com.testng;

import org.testng.annotations.*;

public class BeforeandAfter {

    @BeforeSuite
    public void beforesuit() {
        System.out.println("beforesuite");
    }

    @AfterSuite
    public void aftersuit() {
        System.out.println("aftersuite");
    }

    @BeforeTest
    public void beforetest() {
        System.out.println("beforetest");
    }

    @AfterTest
    public void aftertest() {
        System.out.println("aftertest");
    }

    @BeforeClass
    public void beforeclass() {
        System.out.println("beforeclass");
    }

    @AfterClass
    public void afterclass() {
        System.out.println("afterclass");
    }

    @BeforeMethod
    public void beforemethod() {
        System.out.println("beforemethod");
    }

    @AfterMethod
    public void aftermethod() {
        System.out.println("aftermethod");
    }

    @Test(groups = {"fast"})
    public void test1() {
        System.out.println("case1----test1");
    }

    @Test(groups = "fast")
    public void test2() {
        System.out.println("case2----test2");
    }
}

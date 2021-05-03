package com.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HelloTestNG {
    @BeforeClass
    public void setUp() {
        // code this will be invoked when this test is instantiated
    }

    @Test(groups = {"fast"}, description = "生成产品")
    public void aFastTest() {
        System.out.println("Fast test");
        Assert.assertEquals(false, true, "return false error");
    }

    // 依赖的方法失败了，后面的方法就不会执行了，除非加上alwaysRun
    @Test(groups = {"slow"},dependsOnMethods = "aFastTest", alwaysRun = true, description = "生成用户")
        public void aSlowTest() {
        System.out.println("case-HelloTestNG----Slow test");
    }

    @Test(groups = {"mid"})
    public void test01() {
        System.out.println("不会执行");
    }

    @Test(enabled = false)
    public void test02() {
        System.out.println("不会执行");
    }

}

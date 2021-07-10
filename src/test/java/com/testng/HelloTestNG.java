package com.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 反射:把Java中的各个成分分别映射成一个个Java对象.利用反射把类中的各个信息都映射成Java对象
 * 位于java.lang.reflect包中:有如下类:
 * Class类:代表一个类
 * Filed类:代表类的成员变量
 * Method类:代表类的方法
 * Construct类:代表类的构造方法
 * Array类:提供创建动态数组以及访问数组元素的静态方法
 *
 * Hello hello = new Hello();
 * 利用反射获取类对象
 * Class class = Class.forName(driver) 通过Class.forName()
 * Class class = Hello.class           通过类的静态成员变量
 * Class class = hello.getClass()      通过Object类的getClass()方法
 */
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

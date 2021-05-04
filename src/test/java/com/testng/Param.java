package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Param {
    // 参数化1
    @Test
    @Parameters({"fname", "lname"})
    public void param(String fname, String lname) {
        System.out.println("名字是---->" + fname + "·" + lname + "\n");
    }

    // 参数化2
    @Test(dataProvider = "datas")
    public void param2(String fname, String lname) {
        System.out.println("名字是---->" + fname + "·" + lname);
    }

    @DataProvider(name = "datas")
    public Object[][] datas() {
        return new Object[][]{
                {"亚历山大", "二世"},
                {"尼古拉斯", "赵四"},
                {"小林", "杏奈"}
        };
    }

}

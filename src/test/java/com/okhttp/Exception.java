package com.okhttp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/7 下午 10:08
 */
public class Exception {
    private final static Logger log = LoggerFactory.getLogger(Exception.class);

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "NUllPoint")
    public void testException() {
        new IllegalArgumentException("NullPoint");
        log.info("测试exception");
    }

    @Test(enabled = false, description = "忽略测试")
    public void testEnable() {
        log.info("测试enable");
    }

    @Test(dependsOnMethods = {"testException"}, description = "依赖测试")
    public void testDependOnMethod() {
        log.info("测试dependOnMethod");
    }
}

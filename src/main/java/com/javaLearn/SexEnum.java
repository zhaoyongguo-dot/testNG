package com.javaLearn;

/**
 * 枚举用法,jdk1.5
 * 对象(额外信息,额外信息...)
 * set/get方法 + 构造方法
 * <p>
 * 下面这种方法更简洁
 * public class Enums {
 * enum Method {
 * get,post,put,delete,
 * }
 * }
 */
public enum SexEnum {
    MALE("1", "男性"),
    FEMALE("0", "女性");
    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    SexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

package com.javaLearnTest;

import com.javaLearn.SexEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class enumTest {
    public static void main(String[] args) {
        SexEnum sexMale = SexEnum.MALE;
        SexEnum sexFemale = SexEnum.FEMALE;
        switch (sexFemale) {
            // 两个case打印信息一致,可以合并
            case MALE:
            case FEMALE:
                log.info("性别-{},代号-{}", sexFemale.getDesc(), sexFemale.getCode());
                break;
            default:
                log.info("没有匹配到性别枚举");
                break;
        }
    }
}

package com.mysql;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/8 上午 12:28
 */
public class EntityRegion {
    private Integer region_id;
    private String region_name;
    private String language;

    // alt + insert ---->生成set get constructor toString

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public String getLanguage() {
        return language;
    }

    public EntityRegion() {
    }

    public EntityRegion(Integer region_id, String region_name, String language) {
        this.region_id = region_id;
        this.region_name = region_name;
        this.language = language;
    }

    @Override
    public String toString() {
        return "EntityRegion{" +
                "region_id=" + region_id +
                ", region_name='" + region_name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}

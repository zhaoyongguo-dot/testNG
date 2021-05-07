package com.mysql;

/**
 * @description:TODO
 * @author:zyg
 * @time:2021/5/8 上午 12:28
 */
public class Region {
    private Integer regionId;
    private String regionName;
    private String language;

    // alt + insert ---->生成set get constructor toString
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Region(Integer regionId, String regionName, String language) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}

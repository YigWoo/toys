package com.yigwoo.comparator;


/**
 * @author linda
 * @date 2018/8/1
 */

public class ItemScore {
    private Long itemId;
    private String subjectId;
    private String subjectType;
    private Double score = 0.0;
    private Integer city;
    private Integer province;
    private Long ctime = 0L;

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ItemScore{" +
                "itemId=" + itemId +
                ", subjectId='" + subjectId + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", score=" + score +
                ", city=" + city +
                ", province=" + province +
                ", ctime=" + ctime +
                '}';
    }
}

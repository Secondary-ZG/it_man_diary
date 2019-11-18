package com.secondary.entity;

import com.secondary.common.BaseEntity;

/**
 * Java Class
 * Created By Secondary
 * On 2019/11/5 14:53
 * Description: 食品实体类
 */
public class Food extends BaseEntity {

    /** id **/
    private int foodId;

    /** 编码 **/
    private String foodCode;

    /** 名称 **/
    private String foodName;

    /** 图片 **/
    private String foodPicture;

    /** 类型 **/
    private String foodType;

    /** 描述 **/
    private String foodMarks;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPicture() {
        return foodPicture;
    }

    public void setFoodPicture(String foodPicture) {
        this.foodPicture = foodPicture;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodMarks() {
        return foodMarks;
    }

    public void setFoodMarks(String foodMarks) {
        this.foodMarks = foodMarks;
    }
}

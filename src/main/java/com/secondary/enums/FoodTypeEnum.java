package com.secondary.enums;

/**
 * Java Enum
 * Created By Secondary
 * On 2019/11/5 16:51
 * Description: 食品类型
 */
public enum FoodTypeEnum {

    BREAKFAST(1, "早餐"),
    LUNCH(2, "午餐"),
    DINNER(3, "晚餐");

    private int code;

    private String message;

    FoodTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

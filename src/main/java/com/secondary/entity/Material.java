package com.secondary.entity;

import java.io.Serializable;

/**
 * Java Class
 * Created By FeiYun
 * On 2019/12/22 16:20
 * Description: 食物材料
 */
public class Material implements Serializable {

    /** 主键id */
    private String materialId;

    /** 食物材料名称 */
    private String materialName;

    /** 食物材料类型 */
    private String materType;

    /** 食物材料描述 */
    private String description;

    public Material(){}

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterType() {
        return materType;
    }

    public void setMaterType(String materType) {
        this.materType = materType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    private static class MaterialSingletonHolder {
//        private static Material material = new Material();
//    }
//
//    public static Material getInstance() {
//        return MaterialSingletonHolder.material;
//    }
}

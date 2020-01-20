package com.secondary.service.impl;

import com.secondary.entity.Material;
import com.secondary.service.MaterialService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 9:37
 */
@Slf4j
public class MaterialServiceImpl implements MaterialService {

    @Override
    public List<Material> selectMaterials(Material material) {
        log.info("[MaterialService] into [selectMaterials] right now");
        return null;
    }

}

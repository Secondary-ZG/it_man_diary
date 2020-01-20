package com.secondary.service;

import com.secondary.entity.Material;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 9:35
 */
@Component
public interface MaterialService {

    /** 查询 */
    List<Material> selectMaterials(Material material);

}

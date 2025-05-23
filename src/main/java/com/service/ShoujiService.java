package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShoujiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShoujiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShoujiView;


/**
 * 手机
 *
 * @author 
 * @email 
 * @date 2024-03-24 15:04:56
 */
public interface ShoujiService extends IService<ShoujiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShoujiVO> selectListVO(Wrapper<ShoujiEntity> wrapper);
   	
   	ShoujiVO selectVO(@Param("ew") Wrapper<ShoujiEntity> wrapper);
   	
   	List<ShoujiView> selectListView(Wrapper<ShoujiEntity> wrapper);
   	
   	ShoujiView selectView(@Param("ew") Wrapper<ShoujiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShoujiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShoujiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShoujiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShoujiEntity> wrapper);

    List<Map<String, Object>> priceSectionStat(Map<String, Object> params,Wrapper<ShoujiEntity> wrapper);


}


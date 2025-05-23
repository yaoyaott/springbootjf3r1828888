package com.dao;

import com.entity.ShoujiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShoujiVO;
import com.entity.view.ShoujiView;


/**
 * 手机
 * 
 * @author 
 * @email 
 * @date 2024-03-24 15:04:56
 */
public interface ShoujiDao extends BaseMapper<ShoujiEntity> {
	
	List<ShoujiVO> selectListVO(@Param("ew") Wrapper<ShoujiEntity> wrapper);
	
	ShoujiVO selectVO(@Param("ew") Wrapper<ShoujiEntity> wrapper);
	
	List<ShoujiView> selectListView(@Param("ew") Wrapper<ShoujiEntity> wrapper);

	List<ShoujiView> selectListView(Pagination page,@Param("ew") Wrapper<ShoujiEntity> wrapper);

	
	ShoujiView selectView(@Param("ew") Wrapper<ShoujiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShoujiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShoujiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShoujiEntity> wrapper);

    List<Map<String, Object>> priceSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShoujiEntity> wrapper);


}

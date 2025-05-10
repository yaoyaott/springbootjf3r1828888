package com.dao;

import com.entity.DiscussshoujiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshoujiVO;
import com.entity.view.DiscussshoujiView;


/**
 * shouji评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-24 15:04:57
 */
public interface DiscussshoujiDao extends BaseMapper<DiscussshoujiEntity> {
	
	List<DiscussshoujiVO> selectListVO(@Param("ew") Wrapper<DiscussshoujiEntity> wrapper);
	
	DiscussshoujiVO selectVO(@Param("ew") Wrapper<DiscussshoujiEntity> wrapper);
	
	List<DiscussshoujiView> selectListView(@Param("ew") Wrapper<DiscussshoujiEntity> wrapper);

	List<DiscussshoujiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshoujiEntity> wrapper);

	
	DiscussshoujiView selectView(@Param("ew") Wrapper<DiscussshoujiEntity> wrapper);
	

}

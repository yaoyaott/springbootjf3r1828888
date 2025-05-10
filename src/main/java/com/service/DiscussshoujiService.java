package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshoujiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshoujiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshoujiView;


/**
 * shouji评论表
 *
 * @author 
 * @email 
 * @date 2024-03-24 15:04:57
 */
public interface DiscussshoujiService extends IService<DiscussshoujiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshoujiVO> selectListVO(Wrapper<DiscussshoujiEntity> wrapper);
   	
   	DiscussshoujiVO selectVO(@Param("ew") Wrapper<DiscussshoujiEntity> wrapper);
   	
   	List<DiscussshoujiView> selectListView(Wrapper<DiscussshoujiEntity> wrapper);
   	
   	DiscussshoujiView selectView(@Param("ew") Wrapper<DiscussshoujiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshoujiEntity> wrapper);

   	

}


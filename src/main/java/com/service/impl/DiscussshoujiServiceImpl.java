package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussshoujiDao;
import com.entity.DiscussshoujiEntity;
import com.service.DiscussshoujiService;
import com.entity.vo.DiscussshoujiVO;
import com.entity.view.DiscussshoujiView;

@Service("discussshoujiService")
public class DiscussshoujiServiceImpl extends ServiceImpl<DiscussshoujiDao, DiscussshoujiEntity> implements DiscussshoujiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshoujiEntity> page = this.selectPage(
                new Query<DiscussshoujiEntity>(params).getPage(),
                new EntityWrapper<DiscussshoujiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshoujiEntity> wrapper) {
		  Page<DiscussshoujiView> page =new Query<DiscussshoujiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussshoujiVO> selectListVO(Wrapper<DiscussshoujiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshoujiVO selectVO(Wrapper<DiscussshoujiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshoujiView> selectListView(Wrapper<DiscussshoujiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshoujiView selectView(Wrapper<DiscussshoujiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

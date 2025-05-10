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


import com.dao.ShoujiDao;
import com.entity.ShoujiEntity;
import com.service.ShoujiService;
import com.entity.vo.ShoujiVO;
import com.entity.view.ShoujiView;

@Service("shoujiService")
public class ShoujiServiceImpl extends ServiceImpl<ShoujiDao, ShoujiEntity> implements ShoujiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShoujiEntity> page = this.selectPage(
                new Query<ShoujiEntity>(params).getPage(),
                new EntityWrapper<ShoujiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShoujiEntity> wrapper) {
		  Page<ShoujiView> page =new Query<ShoujiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShoujiVO> selectListVO(Wrapper<ShoujiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShoujiVO selectVO(Wrapper<ShoujiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShoujiView> selectListView(Wrapper<ShoujiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShoujiView selectView(Wrapper<ShoujiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ShoujiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ShoujiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ShoujiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> priceSectionStat(Map<String, Object> params, Wrapper<ShoujiEntity> wrapper) {
        return baseMapper.priceSectionStat(params, wrapper);
    }



}

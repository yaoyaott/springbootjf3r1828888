package com.entity.view;

import com.entity.DiscussshoujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * shouji评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-24 15:04:57
 */
@TableName("discussshouji")
public class DiscussshoujiView  extends DiscussshoujiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshoujiView(){
	}
 
 	public DiscussshoujiView(DiscussshoujiEntity discussshoujiEntity){
 	try {
			BeanUtils.copyProperties(this, discussshoujiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

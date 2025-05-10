package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 手机
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-24 15:04:56
 */
@TableName("shouji")
public class ShoujiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShoujiEntity() {
		
	}
	
	public ShoujiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 标题
	 */
					
	private String title;
	
	/**
	 * 图片
	 */
					
	private String picture;
	
	/**
	 * 价格
	 */
					
	private Double price;
	
	/**
	 * 付款人数
	 */
					
	private String realsales;
	
	/**
	 * 商家
	 */
					
	private String shopname;
	
	/**
	 * 机身颜色
	 */
					
	private String jcolor;
	
	/**
	 * 存储容量
	 */
					
	private String ccsize;
	
	/**
	 * 型号
	 */
					
	private String xinghao;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 分辨率
	 */
					
	private String fenbianlv;
	
	/**
	 * 3C证书编号
	 */
					
	private String bianhao;
	
	/**
	 * 来源
	 */
					
	private String laiyuan;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 评论数
	 */
					
	private Integer discussnum;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：付款人数
	 */
	public void setRealsales(String realsales) {
		this.realsales = realsales;
	}
	/**
	 * 获取：付款人数
	 */
	public String getRealsales() {
		return realsales;
	}
	/**
	 * 设置：商家
	 */
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	/**
	 * 获取：商家
	 */
	public String getShopname() {
		return shopname;
	}
	/**
	 * 设置：机身颜色
	 */
	public void setJcolor(String jcolor) {
		this.jcolor = jcolor;
	}
	/**
	 * 获取：机身颜色
	 */
	public String getJcolor() {
		return jcolor;
	}
	/**
	 * 设置：存储容量
	 */
	public void setCcsize(String ccsize) {
		this.ccsize = ccsize;
	}
	/**
	 * 获取：存储容量
	 */
	public String getCcsize() {
		return ccsize;
	}
	/**
	 * 设置：型号
	 */
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	/**
	 * 获取：型号
	 */
	public String getXinghao() {
		return xinghao;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：分辨率
	 */
	public void setFenbianlv(String fenbianlv) {
		this.fenbianlv = fenbianlv;
	}
	/**
	 * 获取：分辨率
	 */
	public String getFenbianlv() {
		return fenbianlv;
	}
	/**
	 * 设置：3C证书编号
	 */
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	/**
	 * 获取：3C证书编号
	 */
	public String getBianhao() {
		return bianhao;
	}
	/**
	 * 设置：来源
	 */
	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}
	/**
	 * 获取：来源
	 */
	public String getLaiyuan() {
		return laiyuan;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：评论数
	 */
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}

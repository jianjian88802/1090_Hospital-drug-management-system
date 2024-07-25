package com.entity.view;

import com.entity.YaopinChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yaopin_churu_inout_list")
public class YaopinChuruInoutListView extends YaopinChuruInoutListEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 yaopin
			/**
			* 药品名称
			*/
			private String yaopinName;
			/**
			* 药品类型
			*/
			private Integer yaopinTypes;
				/**
				* 药品类型的值
				*/
				private String yaopinValue;
			/**
			* 药品库存
			*/
			private Integer yaopinKucunNumber;
			/**
			* 药品单位
			*/
			private Integer danweiTypes;
				/**
				* 药品单位的值
				*/
				private String danweiValue;
			/**
			* 现价
			*/
			private Double yaopinNewMoney;
			/**
			* 详情
			*/
			private String yaopinContent;
			/**
			* 逻辑删除
			*/
			private Integer yaopinDelete;

		//级联表 yaopin_churu_inout
			/**
			* 出入库流水号
			*/
			private String yaopinChuruInoutUuidNumber;
			/**
			* 出入库名称
			*/
			private String yaopinChuruInoutName;
			/**
			* 出入库类型
			*/
			private Integer yaopinChuruInoutTypes;
				/**
				* 出入库类型的值
				*/
				private String yaopinChuruInoutValue;
			/**
			* 备注
			*/
			private String yaopinChuruInoutContent;

	public YaopinChuruInoutListView() {

	}

	public YaopinChuruInoutListView(YaopinChuruInoutListEntity yaopinChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, yaopinChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set yaopin

					/**
					* 获取： 药品名称
					*/
					public String getYaopinName() {
						return yaopinName;
					}
					/**
					* 设置： 药品名称
					*/
					public void setYaopinName(String yaopinName) {
						this.yaopinName = yaopinName;
					}

					/**
					* 获取： 药品类型
					*/
					public Integer getYaopinTypes() {
						return yaopinTypes;
					}
					/**
					* 设置： 药品类型
					*/
					public void setYaopinTypes(Integer yaopinTypes) {
						this.yaopinTypes = yaopinTypes;
					}


						/**
						* 获取： 药品类型的值
						*/
						public String getYaopinValue() {
							return yaopinValue;
						}
						/**
						* 设置： 药品类型的值
						*/
						public void setYaopinValue(String yaopinValue) {
							this.yaopinValue = yaopinValue;
						}

					/**
					* 获取： 药品库存
					*/
					public Integer getYaopinKucunNumber() {
						return yaopinKucunNumber;
					}
					/**
					* 设置： 药品库存
					*/
					public void setYaopinKucunNumber(Integer yaopinKucunNumber) {
						this.yaopinKucunNumber = yaopinKucunNumber;
					}

					/**
					* 获取： 药品单位
					*/
					public Integer getDanweiTypes() {
						return danweiTypes;
					}
					/**
					* 设置： 药品单位
					*/
					public void setDanweiTypes(Integer danweiTypes) {
						this.danweiTypes = danweiTypes;
					}


						/**
						* 获取： 药品单位的值
						*/
						public String getDanweiValue() {
							return danweiValue;
						}
						/**
						* 设置： 药品单位的值
						*/
						public void setDanweiValue(String danweiValue) {
							this.danweiValue = danweiValue;
						}

					/**
					* 获取： 现价
					*/
					public Double getYaopinNewMoney() {
						return yaopinNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setYaopinNewMoney(Double yaopinNewMoney) {
						this.yaopinNewMoney = yaopinNewMoney;
					}

					/**
					* 获取： 详情
					*/
					public String getYaopinContent() {
						return yaopinContent;
					}
					/**
					* 设置： 详情
					*/
					public void setYaopinContent(String yaopinContent) {
						this.yaopinContent = yaopinContent;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getYaopinDelete() {
						return yaopinDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setYaopinDelete(Integer yaopinDelete) {
						this.yaopinDelete = yaopinDelete;
					}


				//级联表的get和set yaopin_churu_inout

					/**
					* 获取： 出入库流水号
					*/
					public String getYaopinChuruInoutUuidNumber() {
						return yaopinChuruInoutUuidNumber;
					}
					/**
					* 设置： 出入库流水号
					*/
					public void setYaopinChuruInoutUuidNumber(String yaopinChuruInoutUuidNumber) {
						this.yaopinChuruInoutUuidNumber = yaopinChuruInoutUuidNumber;
					}

					/**
					* 获取： 出入库名称
					*/
					public String getYaopinChuruInoutName() {
						return yaopinChuruInoutName;
					}
					/**
					* 设置： 出入库名称
					*/
					public void setYaopinChuruInoutName(String yaopinChuruInoutName) {
						this.yaopinChuruInoutName = yaopinChuruInoutName;
					}

					/**
					* 获取： 出入库类型
					*/
					public Integer getYaopinChuruInoutTypes() {
						return yaopinChuruInoutTypes;
					}
					/**
					* 设置： 出入库类型
					*/
					public void setYaopinChuruInoutTypes(Integer yaopinChuruInoutTypes) {
						this.yaopinChuruInoutTypes = yaopinChuruInoutTypes;
					}


						/**
						* 获取： 出入库类型的值
						*/
						public String getYaopinChuruInoutValue() {
							return yaopinChuruInoutValue;
						}
						/**
						* 设置： 出入库类型的值
						*/
						public void setYaopinChuruInoutValue(String yaopinChuruInoutValue) {
							this.yaopinChuruInoutValue = yaopinChuruInoutValue;
						}

					/**
					* 获取： 备注
					*/
					public String getYaopinChuruInoutContent() {
						return yaopinChuruInoutContent;
					}
					/**
					* 设置： 备注
					*/
					public void setYaopinChuruInoutContent(String yaopinChuruInoutContent) {
						this.yaopinChuruInoutContent = yaopinChuruInoutContent;
					}













}

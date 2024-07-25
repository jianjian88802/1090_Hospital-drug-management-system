package com.entity.view;

import com.entity.QuyaojiluEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 取退记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("quyaojilu")
public class QuyaojiluView extends QuyaojiluEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String quyaojiluValue;



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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

		//级联表 yuangong
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 联系方式
			*/
			private String yuangongPhone;
			/**
			* 假删
			*/
			private Integer yuangongDelete;

	public QuyaojiluView() {

	}

	public QuyaojiluView(QuyaojiluEntity quyaojiluEntity) {
		try {
			BeanUtils.copyProperties(this, quyaojiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getQuyaojiluValue() {
				return quyaojiluValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setQuyaojiluValue(String quyaojiluValue) {
				this.quyaojiluValue = quyaojiluValue;
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













				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}





				//级联表的get和set yuangong

					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYuangongDelete() {
						return yuangongDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYuangongDelete(Integer yuangongDelete) {
						this.yuangongDelete = yuangongDelete;
					}




}

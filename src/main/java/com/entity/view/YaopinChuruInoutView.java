package com.entity.view;

import com.entity.YaopinChuruInoutEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yaopin_churu_inout")
public class YaopinChuruInoutView extends YaopinChuruInoutEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 出入库类型的值
		*/
		private String yaopinChuruInoutValue;



	public YaopinChuruInoutView() {

	}

	public YaopinChuruInoutView(YaopinChuruInoutEntity yaopinChuruInoutEntity) {
		try {
			BeanUtils.copyProperties(this, yaopinChuruInoutEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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











}

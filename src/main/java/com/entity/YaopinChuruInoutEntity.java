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
 * 出入库
 *
 * @author 
 * @email
 */
@TableName("yaopin_churu_inout")
public class YaopinChuruInoutEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaopinChuruInoutEntity() {

	}

	public YaopinChuruInoutEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 出入库流水号
     */
    @TableField(value = "yaopin_churu_inout_uuid_number")

    private String yaopinChuruInoutUuidNumber;


    /**
     * 出入库名称
     */
    @TableField(value = "yaopin_churu_inout_name")

    private String yaopinChuruInoutName;


    /**
     * 出入库类型
     */
    @TableField(value = "yaopin_churu_inout_types")

    private Integer yaopinChuruInoutTypes;


    /**
     * 备注
     */
    @TableField(value = "yaopin_churu_inout_content")

    private String yaopinChuruInoutContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：出入库流水号
	 */
    public String getYaopinChuruInoutUuidNumber() {
        return yaopinChuruInoutUuidNumber;
    }
    /**
	 * 获取：出入库流水号
	 */

    public void setYaopinChuruInoutUuidNumber(String yaopinChuruInoutUuidNumber) {
        this.yaopinChuruInoutUuidNumber = yaopinChuruInoutUuidNumber;
    }
    /**
	 * 设置：出入库名称
	 */
    public String getYaopinChuruInoutName() {
        return yaopinChuruInoutName;
    }
    /**
	 * 获取：出入库名称
	 */

    public void setYaopinChuruInoutName(String yaopinChuruInoutName) {
        this.yaopinChuruInoutName = yaopinChuruInoutName;
    }
    /**
	 * 设置：出入库类型
	 */
    public Integer getYaopinChuruInoutTypes() {
        return yaopinChuruInoutTypes;
    }
    /**
	 * 获取：出入库类型
	 */

    public void setYaopinChuruInoutTypes(Integer yaopinChuruInoutTypes) {
        this.yaopinChuruInoutTypes = yaopinChuruInoutTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getYaopinChuruInoutContent() {
        return yaopinChuruInoutContent;
    }
    /**
	 * 获取：备注
	 */

    public void setYaopinChuruInoutContent(String yaopinChuruInoutContent) {
        this.yaopinChuruInoutContent = yaopinChuruInoutContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YaopinChuruInout{" +
            "id=" + id +
            ", yaopinChuruInoutUuidNumber=" + yaopinChuruInoutUuidNumber +
            ", yaopinChuruInoutName=" + yaopinChuruInoutName +
            ", yaopinChuruInoutTypes=" + yaopinChuruInoutTypes +
            ", yaopinChuruInoutContent=" + yaopinChuruInoutContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}

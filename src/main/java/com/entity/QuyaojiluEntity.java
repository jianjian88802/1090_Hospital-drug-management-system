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
 * 取退记录
 *
 * @author 
 * @email
 */
@TableName("quyaojilu")
public class QuyaojiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QuyaojiluEntity() {

	}

	public QuyaojiluEntity(T t) {
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
     * 药品
     */
    @TableField(value = "yaopin_id")

    private Integer yaopinId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 员工
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 取药数量
     */
    @TableField(value = "quyaojilu_number")

    private Integer quyaojiluNumber;


    /**
     * 类型
     */
    @TableField(value = "quyaojilu_types")

    private Integer quyaojiluTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "quyaojilu_delete")

    private Integer quyaojiluDelete;


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
	 * 设置：药品
	 */
    public Integer getYaopinId() {
        return yaopinId;
    }
    /**
	 * 获取：药品
	 */

    public void setYaopinId(Integer yaopinId) {
        this.yaopinId = yaopinId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：取药数量
	 */
    public Integer getQuyaojiluNumber() {
        return quyaojiluNumber;
    }
    /**
	 * 获取：取药数量
	 */

    public void setQuyaojiluNumber(Integer quyaojiluNumber) {
        this.quyaojiluNumber = quyaojiluNumber;
    }
    /**
	 * 设置：类型
	 */
    public Integer getQuyaojiluTypes() {
        return quyaojiluTypes;
    }
    /**
	 * 获取：类型
	 */

    public void setQuyaojiluTypes(Integer quyaojiluTypes) {
        this.quyaojiluTypes = quyaojiluTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getQuyaojiluDelete() {
        return quyaojiluDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setQuyaojiluDelete(Integer quyaojiluDelete) {
        this.quyaojiluDelete = quyaojiluDelete;
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
        return "Quyaojilu{" +
            "id=" + id +
            ", yaopinId=" + yaopinId +
            ", yonghuId=" + yonghuId +
            ", yuangongId=" + yuangongId +
            ", quyaojiluNumber=" + quyaojiluNumber +
            ", quyaojiluTypes=" + quyaojiluTypes +
            ", quyaojiluDelete=" + quyaojiluDelete +
            ", createTime=" + createTime +
        "}";
    }
}

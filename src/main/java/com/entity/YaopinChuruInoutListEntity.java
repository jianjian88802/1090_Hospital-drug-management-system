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
 * 出入库详情
 *
 * @author 
 * @email
 */
@TableName("yaopin_churu_inout_list")
public class YaopinChuruInoutListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaopinChuruInoutListEntity() {

	}

	public YaopinChuruInoutListEntity(T t) {
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
     * 出入库
     */
    @TableField(value = "yaopin_churu_inout_id")

    private Integer yaopinChuruInoutId;


    /**
     * 药品
     */
    @TableField(value = "yaopin_id")

    private Integer yaopinId;


    /**
     * 操作数量
     */
    @TableField(value = "yaopin_churu_inout_list_number")

    private Integer yaopinChuruInoutListNumber;


    /**
     * 操作时间
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
	 * 设置：出入库
	 */
    public Integer getYaopinChuruInoutId() {
        return yaopinChuruInoutId;
    }
    /**
	 * 获取：出入库
	 */

    public void setYaopinChuruInoutId(Integer yaopinChuruInoutId) {
        this.yaopinChuruInoutId = yaopinChuruInoutId;
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
	 * 设置：操作数量
	 */
    public Integer getYaopinChuruInoutListNumber() {
        return yaopinChuruInoutListNumber;
    }
    /**
	 * 获取：操作数量
	 */

    public void setYaopinChuruInoutListNumber(Integer yaopinChuruInoutListNumber) {
        this.yaopinChuruInoutListNumber = yaopinChuruInoutListNumber;
    }
    /**
	 * 设置：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：操作时间
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
        return "YaopinChuruInoutList{" +
            "id=" + id +
            ", yaopinChuruInoutId=" + yaopinChuruInoutId +
            ", yaopinId=" + yaopinId +
            ", yaopinChuruInoutListNumber=" + yaopinChuruInoutListNumber +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}

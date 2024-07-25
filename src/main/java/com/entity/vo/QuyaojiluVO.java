package com.entity.vo;

import com.entity.QuyaojiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 取退记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("quyaojilu")
public class QuyaojiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

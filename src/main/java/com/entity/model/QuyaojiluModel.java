package com.entity.model;

import com.entity.QuyaojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 取退记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QuyaojiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 药品
     */
    private Integer yaopinId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 取药数量
     */
    private Integer quyaojiluNumber;


    /**
     * 类型
     */
    private Integer quyaojiluTypes;


    /**
     * 逻辑删除
     */
    private Integer quyaojiluDelete;


    /**
     * 创建时间 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：药品
	 */
    public Integer getYaopinId() {
        return yaopinId;
    }


    /**
	 * 设置：药品
	 */
    public void setYaopinId(Integer yaopinId) {
        this.yaopinId = yaopinId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：员工
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：取药数量
	 */
    public Integer getQuyaojiluNumber() {
        return quyaojiluNumber;
    }


    /**
	 * 设置：取药数量
	 */
    public void setQuyaojiluNumber(Integer quyaojiluNumber) {
        this.quyaojiluNumber = quyaojiluNumber;
    }
    /**
	 * 获取：类型
	 */
    public Integer getQuyaojiluTypes() {
        return quyaojiluTypes;
    }


    /**
	 * 设置：类型
	 */
    public void setQuyaojiluTypes(Integer quyaojiluTypes) {
        this.quyaojiluTypes = quyaojiluTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getQuyaojiluDelete() {
        return quyaojiluDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setQuyaojiluDelete(Integer quyaojiluDelete) {
        this.quyaojiluDelete = quyaojiluDelete;
    }
    /**
	 * 获取：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

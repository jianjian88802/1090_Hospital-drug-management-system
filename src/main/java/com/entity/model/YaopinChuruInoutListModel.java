package com.entity.model;

import com.entity.YaopinChuruInoutListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出入库详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YaopinChuruInoutListModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 出入库
     */
    private Integer yaopinChuruInoutId;


    /**
     * 药品
     */
    private Integer yaopinId;


    /**
     * 操作数量
     */
    private Integer yaopinChuruInoutListNumber;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：出入库
	 */
    public Integer getYaopinChuruInoutId() {
        return yaopinChuruInoutId;
    }


    /**
	 * 设置：出入库
	 */
    public void setYaopinChuruInoutId(Integer yaopinChuruInoutId) {
        this.yaopinChuruInoutId = yaopinChuruInoutId;
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
	 * 获取：操作数量
	 */
    public Integer getYaopinChuruInoutListNumber() {
        return yaopinChuruInoutListNumber;
    }


    /**
	 * 设置：操作数量
	 */
    public void setYaopinChuruInoutListNumber(Integer yaopinChuruInoutListNumber) {
        this.yaopinChuruInoutListNumber = yaopinChuruInoutListNumber;
    }
    /**
	 * 获取：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：操作时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

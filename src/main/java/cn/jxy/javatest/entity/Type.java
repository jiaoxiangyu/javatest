package cn.jxy.javatest.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.jxy.javatest.util.DateSwitch;
/**
 * 
 * @author 焦
 * @Description 试题集-实体类  
 *
 */

public class Type {
    private Integer id;

    private String name;//名称

    private String describe;//描述

    private String updateDate;//更新时间

    /**
     * 
     * 临时属性
     */
    private int qtNum;//试题集题数
    
    private int solvedNum;//已解决题数
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getUpdateDate() {
    	return updateDate;
		
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

	/**
	 * @return the qtNum
	 */
	public int getQtNum() {
		return qtNum;
	}

	/**
	 * @param qtNum the qtNum to set
	 */
	public void setQtNum(int qtNum) {
		this.qtNum = qtNum;
	}

	/**
	 * @return the solvedNum
	 */
	public int getSolvedNum() {
		return solvedNum;
	}

	/**
	 * @param solvedNum the solvedNum to set
	 */
	public void setSolvedNum(int solvedNum) {
		this.solvedNum = solvedNum;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", describe=" + describe + ", updateDate=" + updateDate
				+ ", QtNum=" + qtNum + ", solvedNum=" + solvedNum + "]";
	}
    
}
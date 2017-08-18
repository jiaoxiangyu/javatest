package cn.jxy.javatest.entity;

import java.util.Date;
/**
 * 
 * @author 焦
 * @Description 试题-实体类  
 *
 */

public class Question {
    private Integer id;

    private String name;//名称
   
    private String content;//内容

    private Integer typeId;//试题集id

    private String type;//试题集名称

    private String keyword;//关键字

    private String createDate;//添加时间
    
    /** 
     * 临时属性
     */
    private String status;//试题状态（该用户是否做过）

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", content=" + content + ", typeId=" + typeId + ", type="
				+ type + ", keyword=" + keyword + ", createDate=" + createDate + ", status=" + status + "]";
	}
    
}
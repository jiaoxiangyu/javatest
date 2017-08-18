package cn.jxy.javatest.entity;

/**
 * 
 * @author 焦
 * @Description 答题结果-实体类  
 *
 */

public class Response {
    private Integer id;

    private Integer qtId;//试题id

    private String qtName;//试题名称

    private Integer userId;//用户id

    private String userName;//用户名称
    
    private Integer typeId;//试题集id

    private String typeName;//试题集名称

    private String answer;//回答答案

    private String status;//试题状态（未正确，正确）

    private Integer score;//得分

    private Integer time;//程序运行时间

    private Integer memory;//程序使用内存大小

    private String writeDate;//回答时间

    
    
    /**
	 * 
	 */
	public Response() {
		super();
	}

	
	
	/**
	 * @param qtId
	 * @param qtName
	 * @param userId
	 * @param userName
	 * @param typeId
	 * @param typeName
	 * @param status
	 * @param writeDate
	 */
	public Response(Integer qtId, String qtName, Integer userId, String userName, Integer typeId, String typeName,
			String status, String writeDate) {
		super();
		this.qtId = qtId;
		this.qtName = qtName;
		this.userId = userId;
		this.userName = userName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.status = status;
		this.writeDate = writeDate;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtId() {
        return qtId;
    }

    public void setQtId(Integer qtId) {
        this.qtId = qtId;
    }

    public String getQtName() {
        return qtName;
    }

    public void setQtName(String qtName) {
        this.qtName = qtName == null ? null : qtName.trim();
    }   

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }
    @Override
	public String toString() {
		return "Response [id=" + id + ", qtId=" + qtId + ", qtName=" + qtName + ", userId=" + userId + ", userName="
				+ userName + ", typeId=" + typeId + ", typeName=" + typeName + ", answer=" + answer + ", status="
				+ status + ", score=" + score + ", time=" + time + ", memory=" + memory + ", writeDate=" + writeDate
				+ "]";
	}
}
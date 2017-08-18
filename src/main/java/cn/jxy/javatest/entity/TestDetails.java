package cn.jxy.javatest.entity;
/**
 * 
 * @author 焦
 * @Description 答题结果详情-实体类  
 *
 */
public class TestDetails {
    private Integer id;

    private Integer resId;//回答id
    
    private Integer orderId;//次数（第几次检测）

    private Integer qtId;//试题id

    private String qtName;//试题名称

    private Integer userId;//用户id

    private String userName;//用户名称

    private String result;//测试结果

    private Integer score;//得分

    private Integer time;//程序运行时间

    private Integer memory;//程序使用内存

    
    
    /**
	 * 
	 */
	public TestDetails() {
		super();
	}
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
	 * @return the resId
	 */
	public Integer getResId() {
		return resId;
	}

	/**
	 * @param resId the resId to set
	 */
	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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

	@Override
	public String toString() {
		return "TestDetails [id=" + id + ", resId=" + resId + ", order=" + orderId + ", qtId=" + qtId + ", qtName="
				+ qtName + ", userId=" + userId + ", userName=" + userName + ", result=" + result + ", score=" + score
				+ ", time=" + time + ", memory=" + memory + "]";
	}
	
	/**
	 * @param resId
	 * @param qtId
	 * @param qtName
	 * @param userId
	 * @param userName
	 */
	public void toInitialize(Integer resId, Integer qtId, String qtName, Integer userId, String userName) {
		this.resId = resId;
		this.qtId = qtId;
		this.qtName = qtName;
		this.userId = userId;
		this.userName = userName;
	}
    
}
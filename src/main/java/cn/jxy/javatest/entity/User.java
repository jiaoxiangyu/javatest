package cn.jxy.javatest.entity;

/**
 * 
 * @author 焦
 * @Description 用户-实体类  
 *
 */

public class User {
    private Integer id;

    private String username;//用户名

    private String password;

    private String type;//用户类型（user、admin）

    private String createDate;

    private String name;//昵称

    private String email;
    
    private String phone;

    private Integer register;//是否通过注册（0、1）
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the register
	 */
	public Integer getRegister() {
		return register;
	}

	/**
	 * @param register the register to set
	 */
	public void setRegister(Integer register) {
		this.register = register;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", createDate=" + createDate + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", register=" + register + "]";
	}
    
}
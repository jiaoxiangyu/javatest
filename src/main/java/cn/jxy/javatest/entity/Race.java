package cn.jxy.javatest.entity;

public class Race {
    private Integer id;

    private String name;

    private String startDate;

    private String endDate;
    
    /**
     * 以下是不存数据库属性
     */
    private String join;
    
    private int score;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

	/**
	 * @return the join
	 */
	public String getJoin() {
		return join;
	}

	/**
	 * @param join the join to set
	 */
	public void setJoin(String join) {
		this.join = join;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", join="
				+ join + ", score=" + score + "]";
	}
    
    
}
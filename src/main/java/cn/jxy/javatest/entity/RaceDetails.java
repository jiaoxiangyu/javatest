package cn.jxy.javatest.entity;

public class RaceDetails {
    private Integer id;

    private Integer raceId;

    private String raceName;

    private Integer qtId;

    private String qtName;
    
    /**
     * 以下是不存数据库属性
     */
    private String status;//试题状态
    
    private int score;//得分
    
    private String writeTime;//做题时间 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName == null ? null : raceName.trim();
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

	/**
	 * @return the writeTime
	 */
	public String getWriteTime() {
		return writeTime;
	}

	/**
	 * @param writeTime the writeTime to set
	 */
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
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
		return "RaceDetails [id=" + id + ", raceId=" + raceId + ", raceName=" + raceName + ", qtId=" + qtId
				+ ", qtName=" + qtName + ", status=" + status + ", score=" + score + ", writeTime=" + writeTime + "]";
	}
    
}
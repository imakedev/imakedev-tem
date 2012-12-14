package th.co.imake.tem.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TemCallDetailRecordPk implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tcdrMsIsdnFrom;
	private Timestamp tcdrUsedTime;
	private Integer ttId;

	public String getTcdrMsIsdnFrom() {
		return tcdrMsIsdnFrom;
	}

	public void setTcdrMsIsdnFrom(String tcdrMsIsdnFrom) {
		this.tcdrMsIsdnFrom = tcdrMsIsdnFrom;
	}

	public Timestamp getTcdrUsedTime() {
		return tcdrUsedTime;
	}

	public void setTcdrUsedTime(Timestamp tcdrUsedTime) {
		this.tcdrUsedTime = tcdrUsedTime;
	}

	public Integer getTtId() {
		return ttId;
	}

	public void setTtId(Integer ttId) {
		this.ttId = ttId;
	}

}

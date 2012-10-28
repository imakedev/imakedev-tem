package th.co.imake.tem.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "TEM_CALL_DETAIL_RECORD")
public class TemCallDetailRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "TCDR_MSISDN_FROM")
	private String tcdrMsIsdnFrom;
	@Column(name = "TCDR_MSISDN_TO")
	private String tcdrMsIsdnTo;
	@Column(name = "TCDR_USED_COUNT")
	private Double tcdrUsedCount;
	@Column(name = "TCDR_USED_TIME")
	private Timestamp tcdrUsedTime;
	@ManyToOne
	@Column(name = "TT_ID")
	private TemType temType;

	public String getTcdrMsIsdnFrom() {
		return tcdrMsIsdnFrom;
	}

	public void setTcdrMsIsdnFrom(String tcdrMsIsdnFrom) {
		this.tcdrMsIsdnFrom = tcdrMsIsdnFrom;
	}

	public String getTcdrMsIsdnTo() {
		return tcdrMsIsdnTo;
	}

	public void setTcdrMsIsdnTo(String tcdrMsIsdnTo) {
		this.tcdrMsIsdnTo = tcdrMsIsdnTo;
	}

	public Double getTcdrUsedCount() {
		return tcdrUsedCount;
	}

	public void setTcdrUsedCount(Double tcdrUsedCount) {
		this.tcdrUsedCount = tcdrUsedCount;
	}

	public Timestamp getTcdrUsedTime() {
		return tcdrUsedTime;
	}

	public void setTcdrUsedTime(Timestamp tcdrUsedTime) {
		this.tcdrUsedTime = tcdrUsedTime;
	}

	public TemType getTemType() {
		return temType;
	}

	public void setTemType(TemType temType) {
		this.temType = temType;
	}

}

package th.co.imake.tem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEM_CALL_DETAIL_RECORD")
public class TemCallDetailRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private TemCallDetailRecordPk temCallDetailRecordPk;
	@Column(name = "TCDR_MSISDN_TO")
	private String tcdrMsIsdnTo;
	@Column(name = "TCDR_USED_COUNT")
	private Double tcdrUsedCount;
//	@ManyToOne
//	@Column(name = "TT_ID")
//	private TemType temType;

	public TemCallDetailRecordPk getTemCallDetailRecordPk() {
		return temCallDetailRecordPk;
	}

	public void setTemCallDetailRecordPk(
			TemCallDetailRecordPk temCallDetailRecordPk) {
		this.temCallDetailRecordPk = temCallDetailRecordPk;
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

//	public TemType getTemType() {
//		return temType;
//	}
//
//	public void setTemType(TemType temType) {
//		this.temType = temType;
//	}

}

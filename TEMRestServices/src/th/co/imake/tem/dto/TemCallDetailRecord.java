package th.co.imake.tem.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temCallDetailRecordDTO")
public class TemCallDetailRecord extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("tcdrMsIsdnFrom")
	private String tcdrMsIsdnFrom;
	@XStreamAlias("tcdrMsIsdnTo")
	private String tcdrMsIsdnTo;
	@XStreamAlias("tcdrUsedCount")
	private Double tcdrUsedCount;
	@XStreamAlias("tcdrUsedTime")
	private Timestamp tcdrUsedTime;
	@XStreamAlias("temTypeDTO")
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

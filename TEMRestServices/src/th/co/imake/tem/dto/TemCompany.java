package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temCompanyDTO")
public class TemCompany implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("tcId")
	private Integer tcId;
	@XStreamAlias("tcName")
	private String tcName;

	public Integer getTcId() {
		return tcId;
	}

	public void setTcId(Integer tcId) {
		this.tcId = tcId;
	}

	public String getTcName() {
		return tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

}

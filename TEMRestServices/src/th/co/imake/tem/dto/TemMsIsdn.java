package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temMsIsdnDTO")
public class TemMsIsdn implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("msIsdn")
	private String msIsdn;
	@XStreamAlias("temCompanyDTO")
	private TemCompany temCompany;

	public String getMsIsdn() {
		return msIsdn;
	}

	public void setMsIsdn(String msIsdn) {
		this.msIsdn = msIsdn;
	}

	public TemCompany getTemCompany() {
		return temCompany;
	}

	public void setTemCompany(TemCompany temCompany) {
		this.temCompany = temCompany;
	}

}

package th.co.imake.tem.dto;

import java.io.Serializable;
import java.sql.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temMsIsdnDTO")
public class TemMsIsdn extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("msIsdn")
	private String msIsdn;
	@XStreamAlias("temCompanyDTO")
	private TemCompany temCompany;
	@XStreamAlias("onTheBill")
	private Date onTheBill;
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

	public Date getOnTheBill() {
		return onTheBill;
	}

	public void setOnTheBill(Date onTheBill) {
		this.onTheBill = onTheBill;
	}

}

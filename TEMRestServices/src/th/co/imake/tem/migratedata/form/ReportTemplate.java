package th.co.imake.tem.migratedata.form;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReportTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	private String groupFrom;
	private String companyFrom;
	private String providerFrom;
	private String msIsdnFrom;
	private String groupTo;
	private String companyTo;
	private String msIsdnTo;
	private Timestamp usedTime;
	private String callTo;
	private Double usedCount;
	private Double price;

	public String getGroupFrom() {
		return groupFrom;
	}

	public void setGroupFrom(String groupFrom) {
		this.groupFrom = groupFrom;
	}

	public String getCompanyFrom() {
		return companyFrom;
	}

	public void setCompanyFrom(String companyFrom) {
		this.companyFrom = companyFrom;
	}

	public String getProviderFrom() {
		return providerFrom;
	}

	public void setProviderFrom(String providerFrom) {
		this.providerFrom = providerFrom;
	}

	public String getMsIsdnFrom() {
		return msIsdnFrom;
	}

	public void setMsIsdnFrom(String msIsdnFrom) {
		this.msIsdnFrom = msIsdnFrom;
	}

	public String getGroupTo() {
		return groupTo;
	}

	public void setGroupTo(String groupTo) {
		this.groupTo = groupTo;
	}

	public String getCompanyTo() {
		return companyTo;
	}

	public void setCompanyTo(String companyTo) {
		this.companyTo = companyTo;
	}

	public String getMsIsdnTo() {
		return msIsdnTo;
	}

	public void setMsIsdnTo(String msIsdnTo) {
		this.msIsdnTo = msIsdnTo;
	}

	public Timestamp getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(Timestamp usedTime) {
		this.usedTime = usedTime;
	}

	public String getCallTo() {
		return callTo;
	}

	public void setCallTo(String callTo) {
		this.callTo = callTo;
	}

	public Double getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Double usedCount) {
		this.usedCount = usedCount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

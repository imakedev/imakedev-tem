package th.co.imake.tem.migratedata.form;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class CDRTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	private String msIsdnFrom;
	private String msIsdnFromProvider;
	private String msIsdnFromCompany;
	private String msIsdnTo;
	private String msIsdnToProvider;
	private Double usedCount;
	private String usedType;
	private Date usedDate;
	private Time usedTime;
	private Double price;
	private String msIsdnToLocation;
	private String msIsdnFromLocation;
	private String callTo;
	private Date billCycle;

	public String getMsIsdnFrom() {
		return msIsdnFrom;
	}

	public void setMsIsdnFrom(String msIsdnFrom) {
		this.msIsdnFrom = msIsdnFrom;
	}

	public String getMsIsdnFromProvider() {
		return msIsdnFromProvider;
	}

	public void setMsIsdnFromProvider(String msIsdnFromProvider) {
		this.msIsdnFromProvider = msIsdnFromProvider;
	}

	public String getMsIsdnFromCompany() {
		return msIsdnFromCompany;
	}

	public void setMsIsdnFromCompany(String msIsdnFromCompany) {
		this.msIsdnFromCompany = msIsdnFromCompany;
	}

	public String getMsIsdnTo() {
		return msIsdnTo;
	}

	public void setMsIsdnTo(String msIsdnTo) {
		this.msIsdnTo = msIsdnTo;
	}

	public String getMsIsdnToProvider() {
		return msIsdnToProvider;
	}

	public void setMsIsdnToProvider(String msIsdnToProvider) {
		this.msIsdnToProvider = msIsdnToProvider;
	}

	public Double getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Double usedCount) {
		this.usedCount = usedCount;
	}

	public String getUsedType() {
		return usedType;
	}

	public void setUsedType(String usedType) {
		this.usedType = usedType;
	}

	public Date getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(Date usedDate) {
		this.usedDate = usedDate;
	}

	public Time getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(Time usedTime) {
		this.usedTime = usedTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMsIsdnToLocation() {
		return msIsdnToLocation;
	}

	public void setMsIsdnToLocation(String msIsdnToLocation) {
		this.msIsdnToLocation = msIsdnToLocation;
	}

	public String getMsIsdnFromLocation() {
		return msIsdnFromLocation;
	}

	public void setMsIsdnFromLocation(String msIsdnFromLocation) {
		this.msIsdnFromLocation = msIsdnFromLocation;
	}
public String getCallTo() {
		return callTo;
	}

	public void setCallTo(String callTo) {
		this.callTo = callTo;
	}

	public Date getBillCycle() {
		return billCycle;
	}

	public void setBillCycle(Date billCycle) {
		this.billCycle = billCycle;
	}

}

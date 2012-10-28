package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temMsIsdnPackageDetailDTO")
public class TemMsIsdnPackageDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("msIsdn")
	private String msIsdn;
	@XStreamAlias("temPackageDetailDTO")
	private TemPackageDetail temPackageDetail;

	public String getMsIsdn() {
		return msIsdn;
	}

	public void setMsIsdn(String msIsdn) {
		this.msIsdn = msIsdn;
	}

	public TemPackageDetail getTemPackageDetail() {
		return temPackageDetail;
	}

	public void setTemPackageDetail(TemPackageDetail temPackageDetail) {
		this.temPackageDetail = temPackageDetail;
	}

}

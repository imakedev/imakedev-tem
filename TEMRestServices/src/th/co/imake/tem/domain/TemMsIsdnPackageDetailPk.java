package th.co.imake.tem.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TemMsIsdnPackageDetailPk implements Serializable {
	private static final long serialVersionUID = 1L;
	private String msIsdn;
	private Integer tpdId;

	public String getMsIsdn() {
		return msIsdn;
	}

	public void setMsIsdn(String msIsdn) {
		this.msIsdn = msIsdn;
	}

	public Integer getTpdId() {
		return tpdId;
	}

	public void setTpdId(Integer tpdId) {
		this.tpdId = tpdId;
	}

}

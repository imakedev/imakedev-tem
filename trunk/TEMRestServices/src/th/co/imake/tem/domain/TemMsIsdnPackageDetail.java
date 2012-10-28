package th.co.imake.tem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "TEM_MSISDN_PACKAGE_DETAIL")
public class TemMsIsdnPackageDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MSISDN")
	private String msIsdn;
	@ManyToOne
	@JoinColumn(name="TPD_ID")
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

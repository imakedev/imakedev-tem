package th.co.imake.tem.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEM_MSISDN_PACKAGE_DETAIL")
public class TemMsIsdnPackageDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk;
//	@ManyToOne
//	@JoinColumn(name = "TPD_ID")
//	private TemPackageDetail temPackageDetail;

	public TemMsIsdnPackageDetailPk getTemMsIsdnPackageDetailPk() {
		return temMsIsdnPackageDetailPk;
	}

	public void setTemMsIsdnPackageDetailPk(
			TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk) {
		this.temMsIsdnPackageDetailPk = temMsIsdnPackageDetailPk;
	}

//	public TemPackageDetail getTemPackageDetail() {
//		return temPackageDetail;
//	}
//
//	public void setTemPackageDetail(TemPackageDetail temPackageDetail) {
//		this.temPackageDetail = temPackageDetail;
//	}

}

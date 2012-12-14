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
@Table(name = "TEM_PACKAGE_DETAIL")
public class TemPackageDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TPD_ID")
	private Integer tpdId;
	@Column(name = "TPD_NAME")
	private String tpdName;
	@Column(name = "TPD_CALL_PRICE")
	private String tpdCallPrice;
	@Column(name = "TPD_SMS_PRICE")
	private String tpdSmsPrice;
	@Column(name = "TPD_DATA_PRICE")
	private String tpdDataPrice;
	@ManyToOne
	@JoinColumn(name = "TPT_ID")
	private TemPackageType temPackageType;

	public Integer getTpdId() {
		return tpdId;
	}

	public void setTpdId(Integer tpdId) {
		this.tpdId = tpdId;
	}

	public String getTpdName() {
		return tpdName;
	}

	public void setTpdName(String tpdName) {
		this.tpdName = tpdName;
	}

	public String getTpdCallPrice() {
		return tpdCallPrice;
	}

	public void setTpdCallPrice(String tpdCallPrice) {
		this.tpdCallPrice = tpdCallPrice;
	}

	public String getTpdSmsPrice() {
		return tpdSmsPrice;
	}

	public void setTpdSmsPrice(String tpdSmsPrice) {
		this.tpdSmsPrice = tpdSmsPrice;
	}

	public String getTpdDataPrice() {
		return tpdDataPrice;
	}

	public void setTpdDataPrice(String tpdDataPrice) {
		this.tpdDataPrice = tpdDataPrice;
	}

	public TemPackageType getTemPackageType() {
		return temPackageType;
	}

	public void setTemPackageType(TemPackageType temPackageType) {
		this.temPackageType = temPackageType;
	}

}

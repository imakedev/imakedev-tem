package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temPackageDetailDTO")
public class TemPackageDetail extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("tpdId")
	private Integer tpdId;
	@XStreamAlias("tpdName")
	private String tpdName;
	@XStreamAlias("tpdCallPrice")
	private String tpdCallPrice;
	@XStreamAlias("tpdSmsPrice")
	private String tpdSmsPrice;
	@XStreamAlias("tpdDataPrice")
	private String tpdDataPrice;
	@XStreamAlias("temPackageTypeDTO")
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

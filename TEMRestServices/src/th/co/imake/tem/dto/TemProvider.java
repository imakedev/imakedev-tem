package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temProviderDTO")
public class TemProvider extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("tpId")
	private Integer tpId;
	@XStreamAlias("tpName")
	private String tpName;

	public Integer getTpId() {
		return tpId;
	}

	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}

	public String getTpName() {
		return tpName;
	}

	public void setTpName(String tpName) {
		this.tpName = tpName;
	}

}

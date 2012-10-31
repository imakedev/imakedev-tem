package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temPackageTypeDTO")
public class TemPackageType extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("tptId")
	private Integer tptId;
	@XStreamAlias("tptName")
	private String tptName;
	@XStreamAlias("temProviderDTO")
	private TemProvider temProvider;

	public Integer getTptId() {
		return tptId;
	}

	public void setTptId(Integer tptId) {
		this.tptId = tptId;
	}

	public String getTptName() {
		return tptName;
	}

	public void setTptName(String tptName) {
		this.tptName = tptName;
	}

	public TemProvider getTemProvider() {
		return temProvider;
	}

	public void setTemProvider(TemProvider temProvider) {
		this.temProvider = temProvider;
	}

}

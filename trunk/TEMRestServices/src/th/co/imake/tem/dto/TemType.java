package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temTypeDTO")
public class TemType extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("ttId")
	private Integer ttId;
	@XStreamAlias("ttName")
	private String ttName;

	public Integer getTtId() {
		return ttId;
	}

	public void setTtId(Integer ttId) {
		this.ttId = ttId;
	}

	public String getTtName() {
		return ttName;
	}

	public void setTtName(String ttName) {
		this.ttName = ttName;
	}

}

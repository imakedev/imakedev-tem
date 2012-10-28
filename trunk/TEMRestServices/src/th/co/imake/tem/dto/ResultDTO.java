package th.co.imake.tem.dto;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("resultDTO")
public class ResultDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("baseDTO")
	private BaseDTO baseDTO;
	@XStreamAlias("resultList")
	@SuppressWarnings("rawtypes")
	private List resultList;

	public BaseDTO getBaseDTO() {
		return baseDTO;
	}

	public void setBaseDTO(BaseDTO baseDTO) {
		this.baseDTO = baseDTO;
	}

	@SuppressWarnings("rawtypes")
	public List getResultList() {
		return resultList;
	}

	@SuppressWarnings("rawtypes")
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

}

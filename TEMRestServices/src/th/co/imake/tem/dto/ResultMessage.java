package th.co.imake.tem.dto;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("resultMessage")
public class ResultMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("lastPage")
	private String lastPage;
	@XStreamAlias("maxRow")
	private String maxRow;
	@XStreamAlias("resultDTO")
	private ResultDTO resultDTO;
	@SuppressWarnings("rawtypes")
	private List resultList;

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	public String getMaxRow() {
		return maxRow;
	}

	public void setMaxRow(String maxRow) {
		this.maxRow = maxRow;
	}

	public ResultDTO getResultDTO() {
		return resultDTO;
	}

	public void setResultDTO(ResultDTO resultDTO) {
		this.resultDTO = resultDTO;
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

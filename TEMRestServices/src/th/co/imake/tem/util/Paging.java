package th.co.imake.tem.util;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("pagingDTO")
public class Paging implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("orderBy")
	private String orderBy;
	@XStreamAlias("pageNo")
	private Integer pageNo = 1;
	@XStreamAlias("pageSize")
	private Integer pageSize = 20;
	@XStreamAlias("totalRecord")
	private Integer totalRecord;

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

}

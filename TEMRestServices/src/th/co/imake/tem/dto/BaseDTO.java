package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import th.co.imake.tem.util.Paging;
@XStreamAlias("baseDTO")
public class BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("serviceName")
	private String serviceName;
	@XStreamAlias("pagingDTO")
	private Paging paging;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}

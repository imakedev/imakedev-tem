package th.co.imake.tem.dto;

import java.io.Serializable;

import th.co.imake.tem.util.Paging;

public class ServiceXml implements Serializable {
	private static final long serialVersionUID = 1L;
	private String serviceName;
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

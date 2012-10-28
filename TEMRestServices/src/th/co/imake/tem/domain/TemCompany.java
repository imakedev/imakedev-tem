package th.co.imake.tem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TEM_COMPANY")
public class TemCompany implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TC_ID")
	private Integer tcId;
	@Column(name = "TC_NAME")
	private String tcName;

	public Integer getTcId() {
		return tcId;
	}

	public void setTcId(Integer tcId) {
		this.tcId = tcId;
	}

	public String getTcName() {
		return tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

}

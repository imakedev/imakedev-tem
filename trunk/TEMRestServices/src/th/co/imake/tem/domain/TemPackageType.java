package th.co.imake.tem.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "TEM_PACKAGE_TYPE")
public class TemPackageType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TPT_ID")
	private Integer tptId;
	@Column(name = "TPT_NAME")
	private String tptName;
	@ManyToOne
	@JoinColumn(name = "TP_ID")
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

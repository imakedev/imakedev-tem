package th.co.imake.tem.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TEM_SPECIAL_LIST")
public class TemSpecialList implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private TemSpecialListPk temSpecialListPk;
	public TemSpecialListPk getTemSpecialListPk() {
		return temSpecialListPk;
	}
	public void setTemSpecialListPk(TemSpecialListPk temSpecialListPk) {
		this.temSpecialListPk = temSpecialListPk;
	}
	
	

}

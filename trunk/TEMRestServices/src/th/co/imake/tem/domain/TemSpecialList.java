package th.co.imake.tem.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "TEM_CALL_DETAIL_RECORD")
public class TemSpecialList implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tslMsisdn;
	private String tslMsisdnFriend;

	public String getTslMsisdn() {
		return tslMsisdn;
	}

	public void setTslMsisdn(String tslMsisdn) {
		this.tslMsisdn = tslMsisdn;
	}

	public String getTslMsisdnFriend() {
		return tslMsisdnFriend;
	}

	public void setTslMsisdnFriend(String tslMsisdnFriend) {
		this.tslMsisdnFriend = tslMsisdnFriend;
	}

}

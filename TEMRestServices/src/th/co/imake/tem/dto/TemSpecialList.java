package th.co.imake.tem.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("temSpecialListDTO")
public class TemSpecialList extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@XStreamAlias("tslMsisdn")
	private String tslMsisdn;
	@XStreamAlias("tslMsisdnFriend")
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

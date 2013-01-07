package th.co.imake.tem.migratedata.form;

import java.io.Serializable;

public class GroupTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	private String group;
	private String company;
	private String no;
	private String packageType;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

}

package th.co.imake.tem.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExportReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExportReport exportReport = new ExportReport(); 
		exportReport.getDataReport("True", 4, "0848810484");
	}
	
	public Connection createConnection() {
		Connection con = null;

		String DB_CONN_STRING = "jdbc:mysql://localhost:3306/test";
		String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
		String USER_NAME = "root";
		String PASSWORD = "password";

		try {
			Class.forName(DRIVER_CLASS_NAME).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(DB_CONN_STRING, USER_NAME,
					PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public void getDataReport(String group, Integer company, String msIsdn) {
		String query = "select t1.tc_group_name group_from, t1.tc_name company_from, t1.tp_name provider_from, tcdr.tcdrMsIsdnFrom, t2.tc_group_name group_to, t2.tc_name company_to, tcdr.tcdr_msisdn_to, tcdr.tcdrUsedTime, tcdr.tcdr_call_to, tcdr.tcdr_used_count, tcdr.tcdr_value from test.tem_call_detail_record tcdr left join ( select isdn.msisdn, company.tc_id, company.tc_name, company.tc_group_name, provider.tp_name from test.tem_msisdn isdn left join test.tem_company company on isdn.tc_id=company.tc_id left join test.tem_provider provider on isdn.tp_id=provider.tp_id) t1 on tcdr.tcdrmsisdnfrom=t1.msisdn left join (select isdn.msisdn, company.tc_name, company.tc_group_name, provider.tp_name from test.tem_msisdn isdn left join test.tem_company company on isdn.tc_id=company.tc_id left join test.tem_provider provider on isdn.tp_id=provider.tp_id) t2 on tcdr.tcdr_msisdn_to=t2.msisdn where tcdr.ttid=1 and tcdr.tcdr_source=0 and t1.tc_group_name='"+group+"' and t1.tc_id="+company+" and tcdr.tcdrMsisdnFrom='"+msIsdn+"'";
		Connection connection = createConnection();
		ResultSet resultSet = selectStatement(connection, query);
		try {
			while (resultSet.next()) {
//				try {
//					String title = new String(resultSet.getString("title").getBytes(),"UTF-8");
					System.out.println(resultSet.getString("group_from")+"\t"+resultSet.getString("company_from")+"\t"+resultSet.getString("provider_from")+"\t"+resultSet.getString("tcdrMsIsdnFrom")+"\t"+resultSet.getString("group_to")+"\t"+resultSet.getString("company_to")+"\t"+resultSet.getString("tcdr_msisdn_to")+"\t"+resultSet.getTimestamp("tcdrUsedTime")+"\t"+resultSet.getString("tcdr_call_to")+"\t"+resultSet.getString("tcdr_used_count")+"\t"+resultSet.getString("tcdr_value"));
//					out.write("\n");
//					out.newLine();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
			resultSet.close();
			connection.close();
//			out.close();
//			outFile.close();
		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	private ResultSet selectStatement(Connection connection, String query) {
		ResultSet rs = null;
		if (connection != null) {
			try {
				PreparedStatement pst1 = connection.prepareStatement(query);
				rs = pst1.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

}

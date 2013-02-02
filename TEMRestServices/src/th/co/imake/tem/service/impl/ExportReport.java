package th.co.imake.tem.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import th.co.imake.tem.migratedata.form.ReportTemplate;

public class ExportReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExportReport exportReport = new ExportReport();
		List list = exportReport.getDataReport("True", 4, "0848810484");
		exportReport.exportToExcel(list);
	}

	public void exportToExcel(List list) {
		try {
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			
			String header[] = {"กลุ่ม ต้นทาง","บริษัท ต้นทาง","เครือข่าย ต้นทาง","หมายเลข ต้นทาง","กลุ่ม ปลายทาง","บริษัท ปลายทาง","หมายเลข ปลายทาง","วันเดือนปี","เวลา","เรียกไป/เรียกจาก","ครั้ง/นาที","จำนวนเงิน"};
			
			int indexRow = 0;
			Row row = sheet.createRow(indexRow);
			row = sheet.createRow(indexRow);
			
			for(int i=0;i<header.length;i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(header[i]);
				sheet.autoSizeColumn(i);
			}
			
			indexRow++;
			System.out.println(list.size());
			
			CellStyle cellStyleTime = wb.createCellStyle();
			HSSFDataFormat dateFormat = wb.createDataFormat();
			
			CellStyle cellStyleDate = wb.createCellStyle();
			cellStyleDate.setDataFormat(dateFormat.getFormat("dd/MM/yyyy"));
			//cellStyleTime.setDataFormat(dateFormat.getFormat("HH:mm:ss a")); h:mm AM/PM
			cellStyleTime.setDataFormat(dateFormat.getFormat("HH:MM:SS AM/PM"));
			 
			//DateFormat dFormat = new SimpleDateFormat("hh:mm:ss a", new Locale("en","EN"));
			DateFormat dFormat = new SimpleDateFormat("hh,mm,ss", new Locale("en","EN"));
		//	cellStyleTime.setDataFormat(dateFormat.getFormat("h:mm:ss AM/PM"));
			
			 HSSFCellStyle cellStyle = wb.createCellStyle();
			    HSSFDataFormat format = wb.createDataFormat();
			    cellStyle.setDataFormat(format.getFormat("m/d/yy h:mm:ss AM/PM"));
			
			CellStyle cellStyleTimeUsed = wb.createCellStyle();
			
			cellStyleTimeUsed.setDataFormat(dateFormat.getFormat("00:mm:ss")); //h:mm:ss
			for(int i=0;i<list.size();i++) {
				row = sheet.createRow(indexRow);
				indexRow++;
				
				ReportTemplate template = (ReportTemplate)list.get(i);
				
				Cell cell0 = row.createCell(0);
				cell0.setCellValue(template.getGroupFrom());
				
				Cell cell1 = row.createCell(1);
				cell1.setCellValue(template.getCompanyFrom());
				
				Cell cell2 = row.createCell(2);
				cell2.setCellValue(template.getProviderFrom());
				
				Cell cell3 = row.createCell(3);
				cell3.setCellValue(template.getMsIsdnFrom());
				
				Cell cell4 = row.createCell(4);
				cell4.setCellValue(template.getGroupTo());
				
				Cell cell5 = row.createCell(5);
				cell5.setCellValue(template.getCompanyTo());
				
				Cell cell6 = row.createCell(6);
				cell6.setCellValue(template.getMsIsdnTo());
				
				
				Calendar calendar = new GregorianCalendar(new Locale("th","TH"));
				calendar.setTime(template.getUsedTime());
				
				Calendar calendar2 = new GregorianCalendar(new Locale("th","TH"));
				calendar2.setTimeInMillis(template.getUsedTime().getTime());
				
				
				
				Cell cell8 = row.createCell(8);
			//	cell7.setCellValue(dFormat.format(calendar.getTime()));
				//HSSFDateUtil.setCalendar(calendar, wholeDays, millisecondsInDay, use1904windowing)
				cell8.setCellValue(calendar);
				cell8.setCellStyle(cellStyleDate);
			
				
				//dateFormat.g
				Cell cell9 = row.createCell(9);
				
			/*	SimpleDateFormat _24HourFormat = new SimpleDateFormat("HH:mm");
				Date date=null;
				try {
					date = _24HourFormat.parse("49:12");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				cell9.setCellFormula("TIME("+dFormat.format(calendar.getTime())+")"); 
				//cell9.setCellValue(date);
				cell9.setCellStyle(cellStyleTime);
				 Calendar cal = Calendar.getInstance();
				 /* cal.set(Calendar.YEAR, 1970);
				  cal.set(Calendar.MONTH, 0);
				  cal.set(Calendar.DATE, 1);*/
				  //you can set the time you need here ...
				/*  cell9.setCellValue(cal);
				  cell9.setCellStyle(cellStyleTime);*/
				//calendar2.set(0,0, 0);
				//cell9.setCellValue(calendar2);
				/*try {
					cell9.setCellValue(dFormat.parse("10:10:00 AM"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				//cell9.setCellStyle(cellStyleTime);
				//cell9.setCellType(0);
			
			
				/*calendar.set(Calendar.HOUR, 12);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, template.getUsedCount().intValue());
				calendar.set(Calendar.MILLISECOND, 0);*/
				calendar.set(Calendar.HOUR, 0);
				calendar.set(Calendar.MINUTE, 3);
				calendar.set(Calendar.SECOND,0);
				calendar.set(Calendar.MILLISECOND, 0);
				Cell cell10 = row.createCell(10); 
			
				//cellStyleTime.setDataFormat(dateFormat.getFormat("h:mm:ss"));
				
				cell10.setCellValue("00:10:00");
				//cell10.setTime(HSSFDateUtil.getJavaDate(calendar.getTime().getTime()));
		           /*cellText =
		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		           cellText = cal.get(Calendar.MONTH)+1 + "/" +
		                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                      cellText;*/
				//cell10.setCellStyle(cellStyleTimeUsed);
				
				Cell cell11 = row.createCell(11);
				cell11.setCellValue(template.getPrice());
			}
			
			//File file = new File("D:/temp.xls");
			File file = new File("/tmp/temp.xls");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			wb.write(fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection createConnection() {
		Connection con = null;

		String DB_CONN_STRING = "jdbc:mysql://localhost:3306/BLUECODE_DB2";
		String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
		String USER_NAME = "root";
	//	String PASSWORD = "password";
		String PASSWORD = "015482543a6e";

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

	public List getDataReport(String group, Integer company, String msIsdn) {
		/* 
select t1.tc_group_name group_from,
        t1.tc_name company_from,
        t1.tp_name provider_from, 
        tcdr.tcdrMsIsdnFrom, 
  
        t2.tc_group_name group_to,
        t2.tc_name company_to,
		t2.tp_name provider_to, 
		tcdr.tcdr_msisdn_to,
        tcdr.tcdrUsedTime,
        tcdr.tcdr_call_to, 
		tcdr.tcdr_used_count,
        tcdr.tcdr_value 
		from TEM_CALL_DETAIL_RECORD tcdr left join
	(select isdn.msisdn, company.tc_id, company.tc_name,
     company.tc_group_name,provider.tp_name 
     from TEM_MSISDN isdn left join TEM_COMPANY company 
     on isdn.tc_id=company.tc_id left join TEM_PROVIDER provider 
     on isdn.tp_id=provider.tp_id) t1 on 
	 tcdr.tcdrmsisdnfrom=t1.msisdn left join
	(select isdn.msisdn, company.tc_name, company.tc_group_name,
     provider.tp_name from TEM_MSISDN isdn left join 
    TEM_COMPANY company on isdn.tc_id=company.tc_id left join 
	TEM_PROVIDER provider on isdn.tp_id=provider.tp_id) t2 on 
    tcdr.tcdr_msisdn_to=t2.msisdn where tcdr.ttid=1 and 
	tcdr.tcdr_source=0 
		 */
		String query = "select t1.tc_group_name group_from, t1.tc_name company_from, t1.tp_name provider_from, tcdr.tcdrMsIsdnFrom, t2.tc_group_name group_to, t2.tc_name company_to, tcdr.tcdr_msisdn_to, tcdr.tcdrUsedTime, tcdr.tcdr_call_to, tcdr.tcdr_used_count, tcdr.tcdr_value from test.tem_call_detail_record tcdr left join ( select isdn.msisdn, company.tc_id, company.tc_name, company.tc_group_name, provider.tp_name from test.tem_msisdn isdn left join test.tem_company company on isdn.tc_id=company.tc_id left join test.tem_provider provider on isdn.tp_id=provider.tp_id) t1 on tcdr.tcdrmsisdnfrom=t1.msisdn left join (select isdn.msisdn, company.tc_name, company.tc_group_name, provider.tp_name from test.tem_msisdn isdn left join test.tem_company company on isdn.tc_id=company.tc_id left join test.tem_provider provider on isdn.tp_id=provider.tp_id) t2 on tcdr.tcdr_msisdn_to=t2.msisdn where tcdr.ttid=1 and tcdr.tcdr_source=0 and t1.tc_group_name='"
				+ group
				+ "' and t1.tc_id="
				+ company
				+ " and tcdr.tcdrMsisdnFrom='" + msIsdn + "'";
		Connection connection = createConnection();
		ResultSet resultSet = selectStatement(connection, query);
		List list = new ArrayList();
		ReportTemplate template = null;
		try {
			while (resultSet.next()) {
				template = new ReportTemplate();
				template.setGroupFrom(resultSet.getString("group_from"));
				template.setCompanyFrom(resultSet.getString("company_from"));
				template.setProviderFrom(resultSet.getString("provider_from"));
				template.setMsIsdnFrom(resultSet.getString("tcdrMsIsdnFrom"));
				template.setGroupTo(resultSet.getString("group_to"));
				template.setCompanyTo(resultSet.getString("company_to"));
				template.setMsIsdnTo(resultSet.getString("tcdr_msisdn_to"));
				template.setUsedTime(resultSet.getTimestamp("tcdrUsedTime"));
				template.setCallTo(resultSet.getString("tcdr_call_to"));
				template.setUsedCount(resultSet.getDouble("tcdr_used_count"));
				template.setPrice(resultSet.getDouble("tcdr_value"));
				// try {
				// String title = new
				// String(resultSet.getString("title").getBytes(),"UTF-8");
				System.out.println(resultSet.getString("group_from") + "\t"
						+ resultSet.getString("company_from") + "\t"
						+ resultSet.getString("provider_from") + "\t"
						+ resultSet.getString("tcdrMsIsdnFrom") + "\t"
						+ resultSet.getString("group_to") + "\t"
						+ resultSet.getString("company_to") + "\t"
						+ resultSet.getString("tcdr_msisdn_to") + "\t"
						+ resultSet.getTimestamp("tcdrUsedTime") + "\t"
						+ resultSet.getString("tcdr_call_to") + "\t"
						+ resultSet.getString("tcdr_used_count") + "\t"
						+ resultSet.getString("tcdr_value"));
				// out.write("\n");
				// out.newLine();
				// } catch (IOException e) {
				// e.printStackTrace();
				// }
				
				list.add(template);
			}
			resultSet.close();
			connection.close();
			// out.close();
			// outFile.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// } catch (IOException e) {
			// e.printStackTrace();
		}
		return list;
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

package th.co.imake.tem.migratedata;

import java.io.FileInputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import th.co.imake.tem.domain.TemCallDetailRecord;
import th.co.imake.tem.domain.TemCallDetailRecordPk;
import th.co.imake.tem.domain.TemCompany;
import th.co.imake.tem.domain.TemMsIsdn;
import th.co.imake.tem.domain.TemProvider;
import th.co.imake.tem.domain.TemType;
import th.co.imake.tem.migratedata.form.CDRTemplate;
import th.co.imake.tem.service.TemService;
import th.co.imake.tem.service.impl.TemServiceImpl;
import th.co.imake.tem.util.Paging;
import th.co.imake.tem.util.Util;

public class MigrateData {
	
	public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = readExcel(Util.getProperty("MIGRATE_DATA_FILE"));
		TemService temService = new TemServiceImpl();
		TemType temType = new TemType();
		List listType = temService.searchTemType(temType, null);
		TemProvider temProvider = new TemProvider();
		List listProvider = temService.searchTemProvider(temProvider, null);
		TemCompany temCompany = new TemCompany();
		List listCompany = temService.searchTemCompany(temCompany, null);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			CDRTemplate cdrTemplate = (CDRTemplate)list.get(i);
			System.out.println(cdrTemplate.getMsIsdnFrom()+"\t"+cdrTemplate.getMsIsdnTo());
			if(cdrTemplate.getMsIsdnFrom() != null && cdrTemplate.getMsIsdnFrom().trim().length() > 0) {
				TemMsIsdn temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(cdrTemplate.getMsIsdnFrom());
				List list2 = temService.searchTemMsIsdn(temMsIsdn, null);
				if(list2 != null && list2.size() == 2 && !list2.get(1).equals(0)) {
					
				} else {
					int providerSize = (Integer)listProvider.get(1);
					List providers = (List)listProvider.get(0);
					for(int j=0;j<providerSize;j++) {
						TemProvider provider = (TemProvider)providers.get(j);
						if(cdrTemplate.getMsIsdnFromProvider().equalsIgnoreCase(provider.getTpName())) {
							temMsIsdn.setTemProvider(provider);
							break;
						}
					}
					int companySize = (Integer)listCompany.get(1);
					List companys = (List)listCompany.get(0);
					for(int j=0;j<companySize;j++) {
						TemCompany company = (TemCompany)companys.get(j);
						if(cdrTemplate.getMsIsdnFromCompany().equalsIgnoreCase(company.getTcName())) {
							temMsIsdn.setTemCompany(company);
							break;
						}
					}
					temService.insertTemMsIsdn(temMsIsdn);
				}
			}
			
			if(cdrTemplate.getMsIsdnTo() != null && cdrTemplate.getMsIsdnTo().trim().length() > 0) {
				TemMsIsdn temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(cdrTemplate.getMsIsdnTo());
				List list2 = temService.searchTemMsIsdn(temMsIsdn, null);
				if(list2 != null && list2.size() == 2 && !list2.get(1).equals(0)) {
					
				} else {
					int providerSize = (Integer)listProvider.get(1);
					List providers = (List)listProvider.get(0);
					for(int j=0;j<providerSize;j++) {
						TemProvider provider = (TemProvider)providers.get(j);
						if(cdrTemplate.getMsIsdnToProvider().equalsIgnoreCase(provider.getTpName())) {
							temMsIsdn.setTemProvider(provider);
							break;
						}
					}
					int companySize = (Integer)listCompany.get(1);
					List companys = (List)listCompany.get(0);
					for(int j=0;j<companySize;j++) {
						TemCompany company = (TemCompany)companys.get(j);
						if(cdrTemplate.getMsIsdnFromCompany().equalsIgnoreCase(company.getTcName())) {
							temMsIsdn.setTemCompany(company);
							break;
						}
					}
					temService.insertTemMsIsdn(temMsIsdn);
				}
			}
			
			TemCallDetailRecord temCallDetailRecord = new TemCallDetailRecord();
			TemMsIsdn temMsIsdnTo = new TemMsIsdn();
			temMsIsdnTo.setMsIsdn(cdrTemplate.getMsIsdnTo());
			temCallDetailRecord.setTcdrMsIsdnTo(temMsIsdnTo);
			temCallDetailRecord.setTcdrUsedCount(cdrTemplate.getUsedCount());
			TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
			temCallDetailRecordPk.setTcdrMsIsdnFrom(cdrTemplate.getMsIsdnFrom());
			temCallDetailRecordPk.setTcdrUsedTime(new Timestamp(cdrTemplate.getUsedDate().getTime()));
			temCallDetailRecordPk.setTtId(1);
			temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
			temService.insertTemCallDetailRecord(temCallDetailRecord);
		}
//		String date = "30/08/2005";
//		try {
//			System.out.println(dateFormat.parse(date));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}*/
	
	/*public void migrateData(TemService temService) {
		List list = readExcel(Util.getProperty("MIGRATE_DATA_FILE"));
		Paging paging = new Paging();
		TemType temType = new TemType();
		List listType = temService.searchTemType(temType, paging);
		TemProvider temProvider = new TemProvider();
		List listProvider = temService.searchTemProvider(temProvider, paging);
		TemCompany temCompany = new TemCompany();
		List listCompany = temService.searchTemCompany(temCompany, paging);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			CDRTemplate cdrTemplate = (CDRTemplate)list.get(i);
			System.out.println(cdrTemplate.getMsIsdnFrom()+"\t"+cdrTemplate.getMsIsdnTo());
			if(cdrTemplate.getMsIsdnFrom() != null && cdrTemplate.getMsIsdnFrom().trim().length() > 0) {
				TemMsIsdn temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(cdrTemplate.getMsIsdnFrom());
				List list2 = temService.searchTemMsIsdn(temMsIsdn, paging);
//				System.out.println(list2+" : "+list2.size()+" : "+(Integer)list2.get(1));
				if(list2 != null && list2.size() == 2 && (Integer.parseInt(list2.get(1).toString())) > 0) {
				} else {
					int providerSize = Integer.parseInt(listProvider.get(1).toString());
					List providers = (List)listProvider.get(0);
					for(int j=0;j<providerSize;j++) {
						TemProvider provider = (TemProvider)providers.get(j);
						if(cdrTemplate.getMsIsdnFromProvider().equalsIgnoreCase(provider.getTpName())) {
							temMsIsdn.setTemProvider(provider);
							break;
						}
					}
					int companySize = Integer.parseInt(listCompany.get(1).toString());
					List companys = (List)listCompany.get(0);
					for(int j=0;j<companySize;j++) {
						TemCompany company = (TemCompany)companys.get(j);
						if(cdrTemplate.getMsIsdnFromCompany() != null && cdrTemplate.getMsIsdnFromCompany().trim().length() > 0 && cdrTemplate.getMsIsdnFromCompany().equalsIgnoreCase(company.getTcName())) {
							temMsIsdn.setTemCompany(company);
							break;
						}
					}
					temService.insertTemMsIsdn(temMsIsdn);
				}
			}
			
			if(cdrTemplate.getMsIsdnTo() != null && cdrTemplate.getMsIsdnTo().trim().length() > 0) {
				TemMsIsdn temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(cdrTemplate.getMsIsdnTo());
				List list2 = temService.searchTemMsIsdn(temMsIsdn, paging);
				if(list2 != null && list2.size() == 2 && (Integer.parseInt(list2.get(1).toString())) > 0) {
					System.out.println("################## If #######################");
				} else {
					System.out.println("################## Else #######################"+cdrTemplate.getMsIsdnTo()+" : "+cdrTemplate.getMsIsdnToProvider());
					int providerSize = Integer.parseInt(listProvider.get(1).toString());
					List providers = (List)listProvider.get(0);
					for(int j=0;j<providerSize;j++) {
						TemProvider provider = (TemProvider)providers.get(j);
						if(cdrTemplate.getMsIsdnToProvider().equalsIgnoreCase(provider.getTpName())) {
							temMsIsdn.setTemProvider(provider);
							break;
						}
					}
					System.out.println("Before");
					temService.insertTemMsIsdn(temMsIsdn);
					System.out.println("After");
				}
			}
			
			TemCallDetailRecord temCallDetailRecord = new TemCallDetailRecord();
			TemMsIsdn temMsIsdnTo = new TemMsIsdn();
			temMsIsdnTo.setMsIsdn(cdrTemplate.getMsIsdnTo());
			temCallDetailRecord.setTcdrMsIsdnTo(temMsIsdnTo);
			temCallDetailRecord.setTcdrUsedCount(cdrTemplate.getUsedCount());
			TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
			temCallDetailRecordPk.setTcdrMsIsdnFrom(cdrTemplate.getMsIsdnFrom());
			temCallDetailRecordPk.setTcdrUsedTime(new Timestamp(cdrTemplate.getUsedDate().getTime()));
			int typeSize = Integer.parseInt(listType.get(1).toString());
			List types = (List)listType.get(0);
			for(int j=0;j<typeSize;j++) {
				TemType type = (TemType)types.get(j);
				if(cdrTemplate.getUsedType().equalsIgnoreCase(type.getTtName())) {
					temCallDetailRecordPk.setTtId(type.getTtId());
					break;
				}
			}
			temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
			System.out.println("Before");
			temService.insertTemCallDetailRecord(temCallDetailRecord);
			System.out.println("After");
		}
//		String date = "30/08/2005";
//		try {
//			System.out.println(dateFormat.parse(date));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}*/

	public static List readExcel(String fileName) {
		List list = new ArrayList();

		try {
			FileInputStream myInput = new FileInputStream(fileName);

			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

			HSSFSheet mySheet = myWorkBook.getSheetAt(0);

			Iterator rowIter = mySheet.rowIterator();
			CDRTemplate cdrTemplate = null;
			rowIter.next();
			while (rowIter.hasNext()) {
				cdrTemplate = new CDRTemplate();
				HSSFRow myRow = (HSSFRow) rowIter.next();
				
				HSSFCell from = (HSSFCell) myRow.getCell(0);
				cdrTemplate.setMsIsdnFrom(from.toString());
				HSSFCell fromProvider = (HSSFCell) myRow.getCell(1);
				cdrTemplate.setMsIsdnFromProvider(fromProvider.toString());
				HSSFCell company = (HSSFCell) myRow.getCell(2);
				if(company != null && company.toString().trim().length() > 0) {
					cdrTemplate.setMsIsdnFromCompany(company.toString());
				}
				HSSFCell to = (HSSFCell) myRow.getCell(3);
				if(to != null && to.toString().trim().length() > 0) {
					cdrTemplate.setMsIsdnTo(to.toString());
				}
				HSSFCell toProvider = (HSSFCell) myRow.getCell(4);
				if(toProvider != null && toProvider.toString().trim().length() > 0) {
					cdrTemplate.setMsIsdnToProvider(toProvider.toString());
				}
				HSSFCell usedCount = (HSSFCell) myRow.getCell(5);
				cdrTemplate.setUsedCount(usedCount.getNumericCellValue());
				HSSFCell type = (HSSFCell) myRow.getCell(7);
				cdrTemplate.setUsedType(type.toString());
				HSSFCell date = (HSSFCell) myRow.getCell(8);
				Date usedDate = new Date();
				if(date != null && date.toString().trim().length() > 0) {
					usedDate = dateFormat.parse(date.toString());
				}
				cdrTemplate.setUsedDate(usedDate);
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(usedDate);
				
				HSSFCell time = (HSSFCell) myRow.getCell(9);
				Time usedTime = new Time(calendar.getTime().getTime());
				if(time != null && time.toString().trim().length() > 0) {
					String[] timeSplit = time.toString().split(":");
					calendar.set(Calendar.HOUR, Integer.parseInt(timeSplit[0]));
					calendar.set(Calendar.MINUTE, Integer.parseInt(timeSplit[1]));
					calendar.set(Calendar.SECOND, Integer.parseInt(timeSplit[2]));
				}
				usedTime.setTime(calendar.getTime().getTime());
				cdrTemplate.setUsedTime(usedTime);
				HSSFCell price = (HSSFCell) myRow.getCell(10);
//				System.out.println("Price : " + price);
				if(price != null && price.toString().trim().length() > 0) {
					cdrTemplate.setPrice(Double.parseDouble(price.toString()));
				}
				list.add(cdrTemplate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

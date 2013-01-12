package th.co.imake.tem.migratedata;

import java.io.FileInputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.hibernate.Session;

import th.co.imake.tem.domain.TemCallDetailRecord;
import th.co.imake.tem.domain.TemCallDetailRecordPk;
import th.co.imake.tem.domain.TemCompany;
import th.co.imake.tem.domain.TemGroup;
import th.co.imake.tem.domain.TemMsIsdn;
import th.co.imake.tem.domain.TemMsIsdnPackageDetail;
import th.co.imake.tem.domain.TemMsIsdnPackageDetailPk;
import th.co.imake.tem.domain.TemPackageDetail;
import th.co.imake.tem.domain.TemProvider;
import th.co.imake.tem.domain.TemType;
import th.co.imake.tem.migratedata.form.CDRTemplate;
import th.co.imake.tem.migratedata.form.GroupTemplate;
import th.co.imake.tem.service.TemService;
import th.co.imake.tem.service.impl.TemServiceImpl;
import th.co.imake.tem.service.impl.TemServiceImplImport;
import th.co.imake.tem.util.ConnectionUtil;
import th.co.imake.tem.util.Paging;
import th.co.imake.tem.util.Util;

public class MigrateData {

	public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",
			Locale.US);
	public static DecimalFormat phoneFormat = new DecimalFormat("0000000000");
	
	public static Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2} \\d{6} \\w.*");
	public static Pattern usedPattern = Pattern.compile("\\d{1,2}:\\d{2}:\\d{2}");
	public static Pattern phonePattern = Pattern.compile("\\d{0,2}.\\d{0,10}E\\d{0,2}");
	public static Pattern patternTOT = Pattern.compile("\\d{1,2}:\\d{2}:\\d{2} \\d{2}/\\d{2}/\\d{4} \\w.*");
	
	public static DateFormat dateFormatTrue = new SimpleDateFormat("dd/MM/yy hhmmss", new Locale("th", "TH"));
	public static DateFormat dateFormatTOT = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy", new Locale("th", "TH"));
	
	public static void main(String[] args) {
		/* Migrate Call Detail Record from Excel */
//		migrateData();
//		migrateGroup();
//		System.out.println(phoneFormat.format(Long.parseLong("848810484")));
		List listDataTrue = readTrueTemplate(Util.getProperty("MIGRATE_DATA_TRUE"));
		migrateData(listDataTrue);
		List listDataTOT = readTOTTemplate(Util.getProperty("MIGRATE_DATA_TOT"));
		migrateData(listDataTOT);
//		String date = "19/10/55 185012 Mobile in BKK. Area";
//		Pattern pattern2 = Pattern.compile("\\d{2}/\\d{2}/\\d{2} \\d{6} \\w.*");
//		Matcher matcher = pattern2.matcher(date.toString());
//		boolean b = matcher.matches();
//		System.out.println(b);
	}

	public static void migrateData() {
		TemService temService = new TemServiceImplImport();
		List list = readExcel(Util.getProperty("MIGRATE_DATA_FILE"));
		Session session = ConnectionUtil.getSession();
		Paging paging = new Paging();
		TemType temType = new TemType();
		List listType = temService.searchTemType(session, temType, paging);
		TemProvider temProvider = new TemProvider();
		List listProvider = temService.searchTemProvider(session, temProvider,
				paging);
		TemCompany temCompany = new TemCompany();
		List listCompany = temService.searchTemCompany(session, temCompany,
				paging);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			CDRTemplate cdrTemplate = (CDRTemplate) list.get(i);
			System.out.println(cdrTemplate.getMsIsdnFrom() + "\t"
					+ cdrTemplate.getMsIsdnTo());
			if (cdrTemplate.getMsIsdnFrom() != null
					&& cdrTemplate.getMsIsdnFrom().trim().length() > 0) {
				TemMsIsdn temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(cdrTemplate.getMsIsdnFrom());
				List list2 = temService.searchTemMsIsdn(session, temMsIsdn,
						paging);
				if (list2 != null && list2.size() == 2
						&& (Integer.parseInt(list2.get(1).toString())) > 0) {
				} else {
					int providerSize = Integer.parseInt(listProvider.get(1)
							.toString());
					List providers = (List) listProvider.get(0);
					for (int j = 0; j < providerSize; j++) {
						TemProvider provider = (TemProvider) providers.get(j);
						if (cdrTemplate.getMsIsdnFromProvider()
								.equalsIgnoreCase(provider.getTpName())) {
							temMsIsdn.setTemProvider(provider);
							break;
						}
					}
					int companySize = Integer.parseInt(listCompany.get(1)
							.toString());
					List companys = (List) listCompany.get(0);
					for (int j = 0; j < companySize; j++) {
						TemCompany company = (TemCompany) companys.get(j);
						if (cdrTemplate.getMsIsdnFromCompany() != null
								&& cdrTemplate.getMsIsdnFromCompany().trim()
										.length() > 0
								&& cdrTemplate.getMsIsdnFromCompany()
										.equalsIgnoreCase(company.getTcName())) {
							temMsIsdn.setTemCompany(company);
							break;
						}
					}
					temService.insertTemMsIsdn(session, temMsIsdn);
				}
			}

			if (cdrTemplate.getMsIsdnTo() != null
					&& cdrTemplate.getMsIsdnTo().trim().length() > 0) {
				TemMsIsdn temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(cdrTemplate.getMsIsdnTo());
				List list2 = temService.searchTemMsIsdn(session, temMsIsdn,
						paging);
				if (list2 != null && list2.size() == 2
						&& (Integer.parseInt(list2.get(1).toString())) > 0) {
				} else {
					int providerSize = Integer.parseInt(listProvider.get(1)
							.toString());
					List providers = (List) listProvider.get(0);
					for (int j = 0; j < providerSize; j++) {
						TemProvider provider = (TemProvider) providers.get(j);
						if (cdrTemplate.getMsIsdnToProvider().equalsIgnoreCase(
								provider.getTpName())) {
							temMsIsdn.setTemProvider(provider);
							break;
						}
					}
					temService.insertTemMsIsdn(session, temMsIsdn);
				}
			}

			TemCallDetailRecord temCallDetailRecord = new TemCallDetailRecord();
			temCallDetailRecord.setTcdrMsIsdnTo(cdrTemplate.getMsIsdnTo());
			temCallDetailRecord.setTcdrUsedCount(cdrTemplate.getUsedCount());
			TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
			temCallDetailRecordPk
					.setTcdrMsIsdnFrom(cdrTemplate.getMsIsdnFrom());
			Date date = cdrTemplate.getUsedDate();
			Time time = cdrTemplate.getUsedTime();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.setTimeInMillis(time.getTime());
			Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
			temCallDetailRecordPk.setTcdrUsedTime(new Timestamp(cdrTemplate
					.getUsedTime().getTime()));
			int typeSize = Integer.parseInt(listType.get(1).toString());
			List types = (List) listType.get(0);
			for (int j = 0; j < typeSize; j++) {
				TemType type = (TemType) types.get(j);
				if (cdrTemplate.getUsedType()
						.equalsIgnoreCase(type.getTtName())) {
					temCallDetailRecordPk.setTtId(type.getTtId());
					break;
				}
			}
			temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
			temService.insertTemCallDetailRecord(session, temCallDetailRecord);
		}
		session.close();
	}
	
	public static void migrateData(List list) {
		TemService temService = new TemServiceImplImport();
		Session session = ConnectionUtil.getSession();
		
		Paging paging = new Paging();
		TemType temType = new TemType();
		List listType = temService.searchTemType(session, temType, paging);
		
		for (int i = 0; i < list.size(); i++) {
			CDRTemplate cdrTemplate = (CDRTemplate) list.get(i);
			
			TemCallDetailRecord temCallDetailRecord = new TemCallDetailRecord();
			temCallDetailRecord.setTcdrMsIsdnTo(cdrTemplate.getMsIsdnTo());
			temCallDetailRecord.setTcdrUsedCount(cdrTemplate.getUsedCount());
			TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
			temCallDetailRecordPk
					.setTcdrMsIsdnFrom(cdrTemplate.getMsIsdnFrom());
			Date date = cdrTemplate.getUsedDate();
			Time time = cdrTemplate.getUsedTime();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.setTimeInMillis(time.getTime());
			temCallDetailRecordPk.setTcdrUsedTime(new Timestamp(cdrTemplate
					.getUsedTime().getTime()));
			int typeSize = Integer.parseInt(listType.get(1).toString());
			List types = (List) listType.get(0);
			for (int j = 0; j < typeSize; j++) {
				TemType type = (TemType) types.get(j);
				if (cdrTemplate.getUsedType()
						.equalsIgnoreCase(type.getTtName())) {
					temCallDetailRecordPk.setTtId(type.getTtId());
					break;
				}
			}
			temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
			temService.insertTemCallDetailRecord(session, temCallDetailRecord);
		}
		session.close();
	}
	
	public static void migrateGroup() {
		TemService temService = new TemServiceImplImport();
		List list = readGroupTemplate(Util.getProperty("MIGRATE_GROUP_FILE"));
		Session session = ConnectionUtil.getSession();
		Paging paging = new Paging();
		for (int i = 0; i < list.size(); i++) {
			GroupTemplate groupTemplate = (GroupTemplate) list.get(i);
			
			TemGroup temGroup = new TemGroup();
			temGroup.setTgName(groupTemplate.getGroup());
			try {
				temService.insertTemGroup(session, temGroup);
			} catch (Exception e) {
//				e.printStackTrace();
			}
			
			TemCompany temCompany = new TemCompany();
			temCompany.setTcName(groupTemplate.getCompany());
			temCompany.setTgName(groupTemplate.getGroup());
			List listCompany = temService.searchTemCompany(session, temCompany,
					paging);
			int companySize = Integer.parseInt(listCompany.get(1)
					.toString());
			if(listCompany != null && companySize > 0) {
				
			} else {
				temCompany = new TemCompany();
				temCompany.setTgName(groupTemplate.getGroup());
				temCompany.setTcName(groupTemplate.getCompany());
				temService.insertTemCompany(session, temCompany);
			}
			
			TemPackageDetail temPackageDetail = new TemPackageDetail();
			temPackageDetail.setTpdName(groupTemplate.getPackageType());
			List listPackage = temService.searchTemPackageDetail(session, temPackageDetail, paging);
			int packageSize = Integer.parseInt(listPackage.get(1)
					.toString());
			if(listPackage != null && packageSize > 0) {
				
			} else {
				temPackageDetail = new TemPackageDetail();
				temPackageDetail.setTpdName(groupTemplate.getPackageType());
				temService.insertTemPackageDetail(session, temPackageDetail);
			}
			
			TemMsIsdn temMsIsdn = new TemMsIsdn();
			temMsIsdn.setMsIsdn(groupTemplate.getNo());
			List listMsIsdn = temService.searchTemMsIsdn(session, temMsIsdn, paging);
			int msIsdnSize = Integer.parseInt(listMsIsdn.get(1)
					.toString());
			if(listMsIsdn != null && msIsdnSize > 0) {
				
			} else {
				temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(groupTemplate.getNo());
				
				temCompany = new TemCompany();
				temCompany.setTcName(groupTemplate.getCompany());
				temCompany.setTgName(groupTemplate.getGroup());
				listCompany = temService.searchTemCompany(session, temCompany,
						paging);
				companySize = Integer.parseInt(listCompany.get(1)
						.toString());
				if(listCompany != null && companySize > 0) {
					List list2 = (List)listCompany.get(0);
					temCompany = (TemCompany)list2.get(0);
					temMsIsdn.setTemCompany(temCompany);
				} 
				temService.insertTemMsIsdn(session, temMsIsdn);
				
				TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = new TemMsIsdnPackageDetailPk();
				temMsIsdnPackageDetailPk.setMsIsdn(groupTemplate.getNo());
				TemMsIsdnPackageDetail temMsIsdnPackageDetail = new TemMsIsdnPackageDetail();
				temMsIsdnPackageDetail.setTemMsIsdnPackageDetailPk(temMsIsdnPackageDetailPk);
				
				List listMsIsdnPackage = temService.searchTemMsIsdnPackageDetail(session, temMsIsdnPackageDetail, paging);
				int msIsdnPackageSize = Integer.parseInt(listMsIsdnPackage.get(1)
						.toString());
				
				temPackageDetail = new TemPackageDetail();
				temPackageDetail.setTpdName(groupTemplate.getPackageType());
				listPackage = temService.searchTemPackageDetail(session, temPackageDetail, paging);
				packageSize = Integer.parseInt(listPackage.get(1)
						.toString());
				if(listPackage != null && packageSize > 0) {
					List list2 = (List)listPackage.get(0);
					temPackageDetail = (TemPackageDetail)list2.get(0);
					temMsIsdnPackageDetailPk.setTpdId(temPackageDetail.getTpdId());
				}
				
				if(listMsIsdnPackage != null && msIsdnPackageSize > 0) {
					temService.updateTemMsIsdnPackageDetail(session, temMsIsdnPackageDetail);
				} else {
					temService.insertTemMsIsdnPackageDetail(session, temMsIsdnPackageDetail);
				}
			}
			
		}	
		session.close();
	}
	
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
				if (company != null && company.toString().trim().length() > 0) {
					cdrTemplate.setMsIsdnFromCompany(company.toString());
				}
				HSSFCell to = (HSSFCell) myRow.getCell(3);
				if (to != null && to.toString().trim().length() > 0) {
					cdrTemplate.setMsIsdnTo(to.toString());
				}
				HSSFCell toProvider = (HSSFCell) myRow.getCell(4);
				if (toProvider != null
						&& toProvider.toString().trim().length() > 0) {
					cdrTemplate.setMsIsdnToProvider(toProvider.toString());
				}
				
				HSSFCell type = (HSSFCell) myRow.getCell(5);
				cdrTemplate.setUsedType(type.toString());
				
				HSSFCell date = (HSSFCell) myRow.getCell(6);
				Date usedDate = new Date();
				if (date != null && date.toString().trim().length() > 0) {
					usedDate = dateFormat.parse(date.toString());
				}
				cdrTemplate.setUsedDate(usedDate);
				
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(usedDate);
				HSSFCell time = (HSSFCell) myRow.getCell(7);
				Time usedTime = new Time(calendar.getTime().getTime());
				if (time != null && time.toString().trim().length() > 0) {
					String[] timeSplit = time.toString().split(":");
					calendar.set(Calendar.HOUR, Integer.parseInt(timeSplit[0]));
					calendar.set(Calendar.MINUTE,
							Integer.parseInt(timeSplit[1]));
					calendar.set(Calendar.SECOND,
							Integer.parseInt(timeSplit[2]));
				}
				usedTime.setTime(calendar.getTime().getTime());
				cdrTemplate.setUsedTime(usedTime);
				
				HSSFCell usedCount = (HSSFCell) myRow.getCell(8);
				Double used = 0.0;
				if(type.toString().trim().equalsIgnoreCase("call")) {
					if(usedCount.toString().trim().indexOf(":") >= 0) {
						String[] timeSplit = usedCount.toString().trim().split(":");
						if(timeSplit.length == 3) {
							used = (Double.parseDouble(timeSplit[0])+(Double.parseDouble(timeSplit[1])/100)+(Double.parseDouble(timeSplit[2])/1000));
						} else {
							used = (Double.parseDouble(timeSplit[0])+(Double.parseDouble(timeSplit[1])/100));
						}
						
					} else {
						used = Double.parseDouble(usedCount.toString().trim());
					}
				} else {
					used = Double.parseDouble(usedCount.toString().trim());
				}
				cdrTemplate.setUsedCount(used);
				
				HSSFCell price = (HSSFCell) myRow.getCell(11);
				// System.out.println("Price : " + price);
				if (price != null && price.toString().trim().length() > 0) {
					cdrTemplate.setPrice(Double.parseDouble(price.toString()));
				}
				list.add(cdrTemplate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List readTrueTemplate(String fileName) {
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
				Matcher phoneMatcher = phonePattern.matcher(from.toString());
				String fromStr = "";
				if(phoneMatcher.matches()) {
					fromStr = from.toString().replace(".", "");
					fromStr = fromStr.substring(0, fromStr.indexOf("E"));
				} else {
					fromStr = from.toString();
				}
//				cdrTemplate.setMsIsdnFrom(phoneFormat.format(Long.parseLong(fromStr)));
				cdrTemplate.setMsIsdnFrom("0".concat(fromStr));
				
				HSSFCell to = (HSSFCell) myRow.getCell(1);
				if (to != null && to.toString().trim().length() > 0) {
					phoneMatcher = phonePattern.matcher(to.toString());
					String toStr = "";
					if(phoneMatcher.matches()) {
						toStr = to.toString().replace(".", "");
						toStr = toStr.substring(0, toStr.indexOf("E"));
					} else {
						toStr = to.toString();
					}
//					cdrTemplate.setMsIsdnTo(phoneFormat.format(Long.parseLong(toStr)));
					cdrTemplate.setMsIsdnTo("0".concat(toStr));
				}
				
				HSSFCell date = (HSSFCell) myRow.getCell(2);
				
				Matcher matcher = pattern.matcher(date.toString());
				boolean b = matcher.matches();
				
				HSSFCell usedCount = (HSSFCell) myRow.getCell(3);
				Double used = 0.0;
				Matcher usedMatcher = usedPattern.matcher(usedCount.toString());
				if(usedMatcher.matches()) {
					String[] useSplit = usedCount.toString().trim().split(":");
					used = ((Double.parseDouble(useSplit[0])*60)+(Double.parseDouble(useSplit[1]))+(Double.parseDouble(useSplit[2])/100));
				}
				cdrTemplate.setUsedCount(used);
				cdrTemplate.setUsedType("call");
				
				if(b) {
					String dateStr = date.toString();
					String dateSplit[] = dateStr.split(" ");
					Date usedDate = dateFormatTrue.parse(dateSplit[0]+" "+dateSplit[1]);
					cdrTemplate.setUsedDate(usedDate);
					
					Time usedTime = new Time(usedDate.getTime());
					cdrTemplate.setUsedTime(usedTime);
					
					list.add(cdrTemplate);
				} else {
					System.err.println("Format not support.");
				}
				
				System.out.println(cdrTemplate.getMsIsdnFrom()+"\t"+cdrTemplate.getMsIsdnTo()+"\t"+cdrTemplate.getUsedDate()+"\t"+cdrTemplate.getUsedTime()+"\t"+cdrTemplate.getUsedCount());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List readTOTTemplate(String fileName) {
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
				Matcher phoneMatcher = phonePattern.matcher(from.toString());
				String fromStr = "";
				if(phoneMatcher.matches()) {
					fromStr = from.toString().replace(".", "");
					fromStr = fromStr.substring(0, fromStr.indexOf("E"));
				} else {
					fromStr = from.toString();
				}
//				cdrTemplate.setMsIsdnFrom(phoneFormat.format(Long.parseLong(fromStr)));
				cdrTemplate.setMsIsdnFrom("0".concat(fromStr));
				
				HSSFCell to = (HSSFCell) myRow.getCell(1);
				if (to != null && to.toString().trim().length() > 0) {
					phoneMatcher = phonePattern.matcher(to.toString());
					String toStr = "";
					if(phoneMatcher.matches()) {
						toStr = to.toString().replace(".", "");
						toStr = toStr.substring(0, toStr.indexOf("E"));
					} else {
						toStr = to.toString();
					}
//					cdrTemplate.setMsIsdnTo(phoneFormat.format(Long.parseLong(toStr)));
					cdrTemplate.setMsIsdnTo("0".concat(toStr));
				}
				
				HSSFCell date = (HSSFCell) myRow.getCell(2);
				
				HSSFCell usedCount = (HSSFCell) myRow.getCell(4);
				Double used = 0.0;
				used = Double.parseDouble(usedCount.toString());
				cdrTemplate.setUsedCount(used);
				cdrTemplate.setUsedType("call");
				
				Matcher matcher = patternTOT.matcher(date.toString());
				boolean b = matcher.matches();
				
				if(b) {
					String dateStr = date.toString();
					String dateSplit[] = dateStr.split(" ");
					Date usedDate = dateFormatTOT.parse(dateSplit[0]+" "+dateSplit[1]);
					cdrTemplate.setUsedDate(usedDate);
					
					Time usedTime = new Time(usedDate.getTime());
					cdrTemplate.setUsedTime(usedTime);
					list.add(cdrTemplate);
				} else {
					System.err.println("Format not support.");
				}
//				System.out.println(cdrTemplate.getMsIsdnFrom()+"\t"+cdrTemplate.getMsIsdnTo()+"\t"+cdrTemplate.getUsedDate()+"\t"+cdrTemplate.getUsedTime()+"\t"+cdrTemplate.getUsedCount());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List readGroupTemplate(String fileName) {
		List list = new ArrayList();

		try {
			FileInputStream myInput = new FileInputStream(fileName);

			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

			HSSFSheet mySheet = myWorkBook.getSheetAt(0);

			Iterator rowIter = mySheet.rowIterator();
			GroupTemplate groupTemplate = null;
			rowIter.next();
			while (rowIter.hasNext()) {
				groupTemplate = new GroupTemplate();
				HSSFRow myRow = (HSSFRow) rowIter.next();

				HSSFCell group = (HSSFCell) myRow.getCell(0);
				groupTemplate.setGroup(group.toString());
				HSSFCell company = (HSSFCell) myRow.getCell(1);
				groupTemplate.setCompany(company.toString());
				HSSFCell no = (HSSFCell) myRow.getCell(2);
				groupTemplate.setNo(no.toString());
				HSSFCell packageType = (HSSFCell) myRow.getCell(3);
				groupTemplate.setPackageType(packageType.toString());
				list.add(groupTemplate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

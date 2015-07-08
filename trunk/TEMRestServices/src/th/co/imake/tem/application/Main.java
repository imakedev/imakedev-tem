package th.co.imake.tem.application;

import org.restlet.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		final ApplicationContext springContext = new ClassPathXmlApplicationContext(
				new String[] {
						"th/co/imake/tem/application/config/applicationContext-common.xml",
						"th/co/imake/tem/application/config/applicationContext-hibernate.xml",
						"th/co/imake/tem/application/config/applicationContext-resource.xml",
						"th/co/imake/tem/application/config/applicationContext-root-router.xml",
						"th/co/imake/tem/application/config/applicationContext-server.xml" });

		((Component) springContext.getBean("top")).start();
		//TemService temService = (TemService)springContext.getBean("temService");
		
//		saveTemProvider(temService);
//		searchTemProvider(temService);
//		
//		saveTemType(temService);
//		searchTemType(temService);
//		
//		saveTemCompany(temService);
//		searchTemCompany(temService);
//		
//		saveTemMsIsdn(temService);
//		searchTemMsIsdn(temService);
		
//		saveTemSpecialList(temService);
//		searchTemSpecialList(temService);
		
//		saveTemCallDetailRecord(temService);
//		searchTemCallDetailRecord(temService);
//		MigrateData migrateData = new MigrateData();
//		migrateData.migrateData(temService);
		
	}
	
	/*public static void saveTemProvider(TemService temService) {
		TemProvider temProvider = new TemProvider();
		temProvider.setTpName("True");
		TemProvider temProvider2 = new TemProvider();
		temProvider2.setTpName("Dtac");
		TemProvider temProvider3 = new TemProvider();
		temProvider3.setTpName("AIS");
		temService.insertTemProvider(temProvider);
		temService.insertTemProvider(temProvider2);
		temService.insertTemProvider(temProvider3);
	}
	
	public static void searchTemProvider(TemService temService) {
		TemProvider temProvider = new TemProvider();
		Paging paging = new Paging();
		List list = temService.searchTemProvider(temProvider, paging);
		if(list != null && list.size() == 2) {
			List listObj = (List)list.get(0);
			for(int i=0;i<listObj.size();i++) {
				temProvider = (TemProvider)listObj.get(i);
				System.out.println(temProvider.getTpId()+" : "+temProvider.getTpName());
			}
		}
	}
	
	public static void saveTemType(TemService temService) {
		TemType temType = new TemType();
		temType.setTtName("Call");
		TemType temType2 = new TemType();
		temType2.setTtName("SMS");
		TemType temType3 = new TemType();
		temType3.setTtName("Data");
		temService.insertTemType(temType);
		temService.insertTemType(temType2);
		temService.insertTemType(temType3);
	}
	
	public static void searchTemType(TemService temService) {
		TemType temType = new TemType();
		Paging paging = new Paging();
		List list = temService.searchTemType(temType, paging);
		if(list != null && list.size() == 2) {
			List listObj = (List)list.get(0);
			for(int i=0;i<listObj.size();i++) {
				temType = (TemType)listObj.get(i);
				System.out.println(temType.getTtId()+" : "+temType.getTtName());
			}
		}
	}
	
	public static void saveTemCompany(TemService temService) {
		TemCompany temCompany = new TemCompany();
		temCompany.setTcName("VLink");
		temService.insertTemCompany(temCompany);
	}
	
	public static void searchTemCompany(TemService temService) {
		TemCompany temCompany = new TemCompany();
		Paging paging = new Paging();
		List list = temService.searchTemCompany(temCompany, paging);
		if(list != null && list.size() == 2) {
			List listObj = (List)list.get(0);
			for(int i=0;i<listObj.size();i++) {
				temCompany = (TemCompany)listObj.get(i);
				System.out.println(temCompany.getTcId()+" : "+temCompany.getTcName());
			}
		}
	}
	
	public static void saveTemMsIsdn(TemService temService) {
		TemMsIsdn temMsIsdn = new TemMsIsdn();
		TemCompany temCompany = new TemCompany();
		temCompany.setTcId(1);
		temMsIsdn.setTemCompany(temCompany);
		temMsIsdn.setMsIsdn("027197999");
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		temMsIsdn.setOnTheBill(new java.sql.Date(calendar.getTime().getTime()));
		temService.insertTemMsIsdn(temMsIsdn);
	}
	
	public static void searchTemMsIsdn(TemService temService) {
		TemMsIsdn temMsIsdn = new TemMsIsdn();
		Paging paging = new Paging();
		List list = temService.searchTemMsIsdn(temMsIsdn, paging);
		if(list != null && list.size() == 2) {
			List listObj = (List)list.get(0);
			for(int i=0;i<listObj.size();i++) {
				temMsIsdn = (TemMsIsdn)listObj.get(i);
				System.out.println(temMsIsdn.getMsIsdn()+" : "+temMsIsdn.getOnTheBill());
			}
		}
	}
	
	public static void saveTemSpecialList(TemService temService) {
		TemSpecialList temSpecialList = new TemSpecialList();
		TemSpecialListPk temSpecialListPk = new TemSpecialListPk();
		temSpecialListPk.setTslMsisdn("0800000002");
		temSpecialListPk.setTslMsisdnFriend("0869999999");
		temSpecialList.setTemSpecialListPk(temSpecialListPk);
		temService.insertTemSpecialList(temSpecialList);
	}
	
	public static void searchTemSpecialList(TemService temService) {
		TemSpecialList temSpecialList = new TemSpecialList();
		Paging paging = new Paging();
		List list = temService.searchTemSpecialList(temSpecialList, paging);
		if(list != null && list.size() == 2) {
			List listObj = (List)list.get(0);
			for(int i=0;i<listObj.size();i++) {
				temSpecialList = (TemSpecialList)listObj.get(i);
				TemSpecialListPk temSpecialListPk = temSpecialList.getTemSpecialListPk();
				System.out.println(temSpecialListPk.getTslMsisdn()+" : "+temSpecialListPk.getTslMsisdnFriend());
			}
		}
	}
	
	public static void saveTemCallDetailRecord(TemService temService) {
		TemMsIsdn msIsdnFrom = new TemMsIsdn();
		msIsdnFrom.setMsIsdn("0812138998");
		TemMsIsdn msIsdnTo = new TemMsIsdn();
		msIsdnTo.setMsIsdn("027197999");
		TemCallDetailRecord temCallDetailRecord = new TemCallDetailRecord();
		TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
		temCallDetailRecordPk.setTcdrMsIsdnFrom("0812138998");
		temCallDetailRecordPk.setTcdrUsedTime(new Timestamp(new Date().getTime()));
		temCallDetailRecordPk.setTtId(1);
		temCallDetailRecord.setTcdrMsIsdnTo(msIsdnTo);
		temCallDetailRecord.setTcdrUsedCount(1.0);
		temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
		temService.insertTemCallDetailRecord(temCallDetailRecord);
	}
	
	public static void searchTemCallDetailRecord(TemService temService) {
		TemCallDetailRecord temCallDetailRecord = new TemCallDetailRecord();
		Paging paging = new Paging();
		List list = temService.searchTemCallDetailRecord(temCallDetailRecord, paging);
		if(list != null && list.size() == 2) {
			List listObj = (List)list.get(0);
			System.out.println(listObj.size());
			for(int i=0;i<listObj.size();i++) {
				temCallDetailRecord = (TemCallDetailRecord)listObj.get(i);
				TemCallDetailRecordPk temCallDetailRecordPk = temCallDetailRecord.getTemCallDetailRecordPk();
				System.out.println(temCallDetailRecordPk.getTcdrMsIsdnFrom()+" : "+temCallDetailRecord.getTcdrMsIsdnTo().getMsIsdn()+" : "+temCallDetailRecordPk.getTcdrUsedTime());
			}
		}
	}
	
	public static void saveTemMsIsdnPackageDetail(TemService temService) {
		TemMsIsdnPackageDetail temMsIsdnPackageDetail = new TemMsIsdnPackageDetail();
		TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = new TemMsIsdnPackageDetailPk();
		temMsIsdnPackageDetailPk.setMsIsdn("0800000002");
		temMsIsdnPackageDetailPk.setTpdId(1);
		temMsIsdnPackageDetail.setTemMsIsdnPackageDetailPk(temMsIsdnPackageDetailPk);
		temService.insertTemMsIsdnPackageDetail(temMsIsdnPackageDetail);
	}
	
	public static void searchTemMsIsdnPackageDetail(TemService temService) {
		TemMsIsdnPackageDetail temMsIsdnPackageDetail = new TemMsIsdnPackageDetail();
		Paging paging = new Paging();
		List list = temService.searchTemMsIsdnPackageDetail(temMsIsdnPackageDetail, paging);
		if(list != null && list.size() == 2) {
			List listObj = (List)list.get(0);
			for(int i=0;i<listObj.size();i++) {
				temMsIsdnPackageDetail = (TemMsIsdnPackageDetail)listObj.get(i);
				TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = temMsIsdnPackageDetail.getTemMsIsdnPackageDetailPk();
				System.out.println(temMsIsdnPackageDetailPk.getMsIsdn()+" : "+temMsIsdnPackageDetailPk.getTpdId());
			}
		}
	}*/
}

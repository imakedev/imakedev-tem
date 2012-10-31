package th.co.imake.tem.application;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.restlet.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import th.co.imake.tem.domain.TemCallDetailRecord;
import th.co.imake.tem.domain.TemCallDetailRecordPk;
import th.co.imake.tem.domain.TemMsIsdnPackageDetail;
import th.co.imake.tem.domain.TemMsIsdnPackageDetailPk;
import th.co.imake.tem.domain.TemProvider;
import th.co.imake.tem.domain.TemSpecialList;
import th.co.imake.tem.domain.TemSpecialListPk;
import th.co.imake.tem.domain.TemType;
import th.co.imake.tem.service.TemService;
import th.co.imake.tem.util.Paging;

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
		TemService temService = (TemService)springContext.getBean("temService");
		
//		saveTemProvider(temService);
//		searchTemProvider(temService);
		
//		saveTemType(temService);
//		searchTemType(temService);
		
//		saveTemSpecialList(temService);
//		searchTemSpecialList(temService);
		
		saveTemCallDetailRecord(temService);
		searchTemCallDetailRecord(temService);
		
	}
	
	public static void saveTemProvider(TemService temService) {
		TemProvider temProvider = new TemProvider();
		temProvider.setTpName("AIS");
		temService.insertTemProvider(temProvider);
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
		temType.setTtName("Data");
		temService.insertTemType(temType);
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
		TemCallDetailRecord temCallDetailRecord = new TemCallDetailRecord();
		TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
		temCallDetailRecordPk.setTcdrMsIsdnFrom("0800000002");
		temCallDetailRecordPk.setTcdrUsedTime(new Timestamp(new Date().getTime()));
		temCallDetailRecordPk.setTtId(1);
		temCallDetailRecord.setTcdrMsIsdnTo("0869999999");
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
			for(int i=0;i<listObj.size();i++) {
				temCallDetailRecord = (TemCallDetailRecord)listObj.get(i);
				TemCallDetailRecordPk temCallDetailRecordPk = temCallDetailRecord.getTemCallDetailRecordPk();
				System.out.println(temCallDetailRecordPk.getTcdrMsIsdnFrom()+" : "+temCallDetailRecordPk.getTcdrUsedTime());
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
	}
}

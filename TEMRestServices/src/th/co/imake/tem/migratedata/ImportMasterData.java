package th.co.imake.tem.migratedata;

import java.sql.Time;

import org.hibernate.Session;

import th.co.imake.tem.domain.TemCompany;
import th.co.imake.tem.domain.TemMsIsdnPackageDetail;
import th.co.imake.tem.domain.TemMsIsdnPackageDetailPk;
import th.co.imake.tem.domain.TemPackageDetail;
import th.co.imake.tem.domain.TemPackageType;
import th.co.imake.tem.domain.TemProvider;
import th.co.imake.tem.domain.TemSpecialList;
import th.co.imake.tem.domain.TemSpecialListPk;
import th.co.imake.tem.domain.TemType;
import th.co.imake.tem.service.TemService;
import th.co.imake.tem.service.impl.TemServiceImplImport;
import th.co.imake.tem.util.ConnectionUtil;

public class ImportMasterData {
	public static void main(String[] args) {
		/* Insert Master Data */
		Session session = ConnectionUtil.getSession();
//		System.out.println(session);
		saveTemProvider(session);
		saveTemType(session);
		saveTemCompany(session);
		
		saveTemPackageType(session);
		saveTemPackageDetail(session);
		saveTemMsIsdnPackageDetail(session);
		saveTemSpecialList(session);
		session.close();
	}
	
	public static void saveTemProvider(Session session) {
		TemProvider temProvider = new TemProvider();
		temProvider.setTpName("True");
		TemProvider temProvider2 = new TemProvider();
		temProvider2.setTpName("Dtac");
		TemProvider temProvider3 = new TemProvider();
		temProvider3.setTpName("AIS");
		TemService temService = new TemServiceImplImport();
		temService.insertTemProvider(session, temProvider);
		temService.insertTemProvider(session, temProvider2);
		temService.insertTemProvider(session, temProvider3);
	}

	public static void saveTemType(Session session) {
		TemType temType = new TemType();
		temType.setTtName("Call");
		TemType temType2 = new TemType();
		temType2.setTtName("SMS");
		TemType temType3 = new TemType();
		temType3.setTtName("Data");
		TemService temService = new TemServiceImplImport();
		temService.insertTemType(session, temType);
		temService.insertTemType(session, temType2);
		temService.insertTemType(session, temType3);
	}

	public static void saveTemCompany(Session session) {
		TemCompany temCompany = new TemCompany();
		temCompany.setTcName("VLink");
		TemService temService = new TemServiceImplImport();
		temService.insertTemCompany(session, temCompany);
	}
	
	public static void saveTemPackageType(Session session) {
		TemPackageType temPackageType = new TemPackageType();
		temPackageType.setTptName("A");
		TemProvider temProvider = new TemProvider();
		temProvider.setTpId(3);
		temPackageType.setTemProvider(temProvider);
		TemService temService = new TemServiceImplImport();
		temService.insertTemPackageType(session, temPackageType);
	}
	
	public static void saveTemPackageDetail(Session session) {
		TemPackageDetail temPackageDetail = new TemPackageDetail();
		temPackageDetail.setTpdName("AA");
		TemPackageType temPackageType = new TemPackageType();
		temPackageType.setTptId(1);
		temPackageDetail.setTemPackageType(temPackageType);
		temPackageDetail.setTpdCallPrice("0.75");
		temPackageDetail.setTpdDataPrice("39");
		temPackageDetail.setTpdStartPeriod(new Time(5,0,0));
		temPackageDetail.setTpdEndPeriod(new Time(17,0,0));
		temPackageDetail.setTpdSmsPrice("3");
		TemService temService = new TemServiceImplImport();
		temService.insertTemPackageDetail(session, temPackageDetail);
	}
	
	public static void saveTemMsIsdnPackageDetail(Session session) {
		TemMsIsdnPackageDetail temMsIsdnPackageDetail = new TemMsIsdnPackageDetail();
		TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = new TemMsIsdnPackageDetailPk();
		temMsIsdnPackageDetailPk.setMsIsdn("0899999999");
		temMsIsdnPackageDetailPk.setTpdId(1);
		temMsIsdnPackageDetail.setTemMsIsdnPackageDetailPk(temMsIsdnPackageDetailPk);
		TemService temService = new TemServiceImplImport();
		temService.insertTemMsIsdnPackageDetail(session, temMsIsdnPackageDetail);
	}
	
	public static void saveTemSpecialList(Session session) {
		TemSpecialList temSpecialList = new TemSpecialList();
		TemSpecialListPk temSpecialListPk = new TemSpecialListPk();
		temSpecialListPk.setTslMsisdn("0899999999");
		temSpecialListPk.setTslMsisdnFriend("0833333333");
		temSpecialList.setTemSpecialListPk(temSpecialListPk);
		TemService temService = new TemServiceImplImport();
		temService.insertTemSpecialList(session, temSpecialList);
	}
}

package th.co.imake.tem.service;

import java.util.List;

import org.hibernate.Session;

import th.co.imake.tem.domain.TemCallDetailRecord;
import th.co.imake.tem.domain.TemCompany;
import th.co.imake.tem.domain.TemGroup;
import th.co.imake.tem.domain.TemMsIsdn;
import th.co.imake.tem.domain.TemMsIsdnPackageDetail;
import th.co.imake.tem.domain.TemPackageDetail;
import th.co.imake.tem.domain.TemPackageType;
import th.co.imake.tem.domain.TemProvider;
import th.co.imake.tem.domain.TemSpecialList;
import th.co.imake.tem.domain.TemType;
import th.co.imake.tem.util.Paging;

public interface TemService {
	public void insertTemCallDetailRecord(Session session, TemCallDetailRecord temCallDetailRecord);
	public void updateTemCallDetailRecord(Session session, TemCallDetailRecord temCallDetailRecord);
	public void deleteTemCallDetailRecord(Session session, TemCallDetailRecord temCallDetailRecord);
	public List searchTemCallDetailRecord(Session session, TemCallDetailRecord temCallDetailRecord, Paging paging);
	
	public void insertTemCompany(Session session, TemCompany temCompany);
	public void updateTemCompany(Session session, TemCompany temCompany);
	public void deleteTemCompany(Session session, TemCompany temCompany);
	public List searchTemCompany(Session session, TemCompany temCompany, Paging paging);
	
	public void insertTemGroup(Session session, TemGroup temGroup);
	public void updateTemGroup(Session session, TemGroup temGroup);
	public void deleteTemGroup(Session session, TemGroup temGroup);
	public List searchTemGroup(Session session, TemGroup temGroup, Paging paging);
	
	public void insertTemMsIsdn(Session session, TemMsIsdn temMsIsdn);
	public void updateTemMsIsdn(Session session, TemMsIsdn temMsIsdn);
	public void deleteTemMsIsdn(Session session, TemMsIsdn temMsIsdn);
	public List searchTemMsIsdn(Session session, TemMsIsdn temMsIsdn, Paging paging);
	
	public void insertTemProvider(Session session, TemProvider temProvider);
	public void updateTemProvider(Session session, TemProvider temProvider);
	public void deleteTemProvider(Session session, TemProvider temProvider);
	public List searchTemProvider(Session session, TemProvider temProvider, Paging paging);
	
	public void insertTemType(Session session, TemType temType);
	public void updateTemType(Session session, TemType temType);
	public void deleteTemType(Session session, TemType temType);
	public List searchTemType(Session session, TemType temType, Paging paging);
	
	public void insertTemMsIsdnPackageDetail(Session session, TemMsIsdnPackageDetail temMsIsdnPackageDetail);
	public void updateTemMsIsdnPackageDetail(Session session, TemMsIsdnPackageDetail temMsIsdnPackageDetail);
	public void deleteTemMsIsdnPackageDetail(Session session, TemMsIsdnPackageDetail temMsIsdnPackageDetail);
	public List searchTemMsIsdnPackageDetail(Session session, TemMsIsdnPackageDetail temMsIsdnPackageDetail, Paging paging);
	
	public void insertTemPackageDetail(Session session, TemPackageDetail temPackageDetail);
	public void updateTemPackageDetail(Session session, TemPackageDetail temPackageDetail);
	public void deleteTemPackageDetail(Session session, TemPackageDetail temPackageDetail);
	public List searchTemPackageDetail(Session session, TemPackageDetail temPackageDetail, Paging paging);
	
	public void insertTemPackageType(Session session, TemPackageType temPackageType);
	public void updateTemPackageType(Session session, TemPackageType temPackageType);
	public void deleteTemPackageType(Session session, TemPackageType temPackageType);
	public List searchTemPackageType(Session session, TemPackageType temPackageType, Paging paging);
	
	public void insertTemSpecialList(Session session, TemSpecialList temSpecialList);
	public void updateTemSpecialList(Session session, TemSpecialList temSpecialList);
	public void deleteTemSpecialList(Session session, TemSpecialList temSpecialList);
	public List searchTemSpecialList(Session session, TemSpecialList temSpecialList, Paging paging);
	
	public void insertTemCallDetailRecord(TemCallDetailRecord temCallDetailRecord);
	public void updateTemCallDetailRecord(TemCallDetailRecord temCallDetailRecord);
	public void deleteTemCallDetailRecord(TemCallDetailRecord temCallDetailRecord);
	public List searchTemCallDetailRecord(TemCallDetailRecord temCallDetailRecord, Paging paging);
	
	public void insertTemCompany(TemCompany temCompany);
	public void updateTemCompany(TemCompany temCompany);
	public void deleteTemCompany(TemCompany temCompany);
	public List searchTemCompany(TemCompany temCompany, Paging paging);
	
	public void insertTemMsIsdn(TemMsIsdn temMsIsdn);
	public void updateTemMsIsdn(TemMsIsdn temMsIsdn);
	public void deleteTemMsIsdn(TemMsIsdn temMsIsdn);
	public List searchTemMsIsdn(TemMsIsdn temMsIsdn, Paging paging);
	
	public void insertTemProvider(TemProvider temProvider);
	public void updateTemProvider(TemProvider temProvider);
	public void deleteTemProvider(TemProvider temProvider);
	public List searchTemProvider(TemProvider temProvider, Paging paging);
	
	public void insertTemType(TemType temType);
	public void updateTemType(TemType temType);
	public void deleteTemType(TemType temType);
	public List searchTemType(TemType temType, Paging paging);
	
	public void insertTemMsIsdnPackageDetail(TemMsIsdnPackageDetail temMsIsdnPackageDetail);
	public void updateTemMsIsdnPackageDetail(TemMsIsdnPackageDetail temMsIsdnPackageDetail);
	public void deleteTemMsIsdnPackageDetail(TemMsIsdnPackageDetail temMsIsdnPackageDetail);
	public List searchTemMsIsdnPackageDetail(TemMsIsdnPackageDetail temMsIsdnPackageDetail, Paging paging);
	
	public void insertTemPackageDetail(TemPackageDetail temPackageDetail);
	public void updateTemPackageDetail(TemPackageDetail temPackageDetail);
	public void deleteTemPackageDetail(TemPackageDetail temPackageDetail);
	public List searchTemPackageDetail(TemPackageDetail temPackageDetail, Paging paging);
	
	public void insertTemPackageType(TemPackageType temPackageType);
	public void updateTemPackageType(TemPackageType temPackageType);
	public void deleteTemPackageType(TemPackageType temPackageType);
	public List searchTemPackageType(TemPackageType temPackageType, Paging paging);
	
	public void insertTemSpecialList(TemSpecialList temSpecialList);
	public void updateTemSpecialList(TemSpecialList temSpecialList);
	public void deleteTemSpecialList(TemSpecialList temSpecialList);
	public List searchTemSpecialList(TemSpecialList temSpecialList, Paging paging);
	
}

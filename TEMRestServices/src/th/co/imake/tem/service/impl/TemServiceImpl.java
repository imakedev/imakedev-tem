package th.co.imake.tem.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.co.imake.tem.domain.TemCallDetailRecord;
import th.co.imake.tem.domain.TemCallDetailRecordPk;
import th.co.imake.tem.domain.TemCompany;
import th.co.imake.tem.domain.TemMsIsdn;
import th.co.imake.tem.domain.TemMsIsdnPackageDetail;
import th.co.imake.tem.domain.TemMsIsdnPackageDetailPk;
import th.co.imake.tem.domain.TemPackageDetail;
import th.co.imake.tem.domain.TemPackageType;
import th.co.imake.tem.domain.TemProvider;
import th.co.imake.tem.domain.TemSpecialList;
import th.co.imake.tem.domain.TemSpecialListPk;
import th.co.imake.tem.domain.TemType;
import th.co.imake.tem.migratedata.MigrateData;
import th.co.imake.tem.migratedata.form.CDRTemplate;
import th.co.imake.tem.service.TemService;
import th.co.imake.tem.util.Paging;
import th.co.imake.tem.util.Util;

@Repository
@Transactional
public class TemServiceImpl implements TemService {

	private SessionFactory sessionAnnotationFactory;

	public SessionFactory getSessionAnnotationFactory() {
		return sessionAnnotationFactory;
	}

	public void setSessionAnnotationFactory(
			SessionFactory sessionAnnotationFactory) {
		this.sessionAnnotationFactory = sessionAnnotationFactory;
	}

	public void insertTemType(Session session, TemType temType) {
			session.beginTransaction();
			Transaction transaction = session.getTransaction();
			session.save(temType);
			transaction.commit();
	}

	public void updateTemType(Session session, TemType temType) {
			session.update(temType);
	}

	public void deleteTemType(Session session, TemType temType) {
			session.delete(temType);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemType(Session session, TemType temType, Paging paging) {
		List transList = new ArrayList();
		try {
			StringBuffer queryStr = new StringBuffer("from TemType temType ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temType) from  TemType temType ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			Integer ttId = temType.getTtId();
			String ttName = temType.getTtName();

			if (ttId != null) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temType.ttId=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temType.ttId=? ");
				map.put("" + paramindex++, ttId);
				haveCondition = true;
			}
			if (ttName != null && ttName.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temType.ttName=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temType.ttName=? ");
				map.put("" + paramindex++, ttName);
				haveCondition = true;
			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temType." + paging.getOrderBy()
						+ " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}

	public void insertTemCompany(Session session, TemCompany temCompany) {
			session.beginTransaction();
			Transaction transaction = session.getTransaction();
			session.save(temCompany);
			transaction.commit();
	}

	public void updateTemCompany(Session session, TemCompany temCompany) {
			session.update(temCompany);
	}

	public void deleteTemCompany(Session session, TemCompany temCompany) {
			session.delete(temCompany);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemCompany(Session session, TemCompany temCompany, Paging paging) {
		List transList = new ArrayList();
		try {
			session = sessionAnnotationFactory.openSession();
			StringBuffer queryStr = new StringBuffer(
					"from TemCompany temCompany ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temCompany) from  TemCompany temCompany ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			Integer tcId = temCompany.getTcId();
			String tcName = temCompany.getTcName();

			if (tcId != null) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temCompany.tcId=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temCompany.tcId=? ");
				map.put("" + paramindex++, tcId);
				haveCondition = true;
			}
			if (tcName != null && tcName.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temCompany.tcName=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temCompany.tcName=? ");
				map.put("" + paramindex++, tcName);
				haveCondition = true;
			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temCompany." + paging.getOrderBy()
						+ " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}

	public void insertTemMsIsdn(Session session, TemMsIsdn temMsIsdn) {
			session.beginTransaction();
			Transaction transaction = session.getTransaction();
			session.save(temMsIsdn);
			transaction.commit();
	}

	public void updateTemMsIsdn(Session session, TemMsIsdn temMsIsdn) {
			session.update(temMsIsdn);
	}

	public void deleteTemMsIsdn(Session session, TemMsIsdn temMsIsdn) {
			session.delete(temMsIsdn);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemMsIsdn(Session session, TemMsIsdn temMsIsdn, Paging paging) {
		List transList = new ArrayList();
		try {
			session = sessionAnnotationFactory.openSession();
			StringBuffer queryStr = new StringBuffer(
					"from TemMsIsdn temMsIsdn ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temMsIsdn) from  TemMsIsdn temMsIsdn ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			String msIsdn = temMsIsdn.getMsIsdn();
			TemCompany temCompany = temMsIsdn.getTemCompany();

			if (temCompany != null && temCompany.getTcId() != null) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temMsIsdn.temCompany.tcId=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temMsIsdn.temCompany.tcId=? ");
				map.put("" + paramindex++, temCompany.getTcId());
				haveCondition = true;
			}
			if (msIsdn != null && msIsdn.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temMsIsdn.msIsdn=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temMsIsdn.msIsdn=? ");
				map.put("" + paramindex++, msIsdn);
				haveCondition = true;
			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temMsIsdn." + paging.getOrderBy()
						+ " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}

	public void insertTemPackageType(TemPackageType temPackageType) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.save(temPackageType);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemPackageType(TemPackageType temPackageType) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.update(temPackageType);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemPackageType(TemPackageType temPackageType) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.delete(temPackageType);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemPackageType(TemPackageType temPackageType,
			Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.openSession();
			StringBuffer queryStr = new StringBuffer(
					"from TemType temPackageType ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temPackageType) from  TemType temPackageType ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			Integer tptId = temPackageType.getTptId();
			String tptName = temPackageType.getTptName();
			TemProvider temProvider = temPackageType.getTemProvider();

			if (tptId != null) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temPackageType.tptId=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temPackageType.tptId=? ");
				map.put("" + paramindex++, tptId);
				haveCondition = true;
			}
			if (tptName != null && tptName.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temPackageType.tptName=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temPackageType.tptName=? ");
				map.put("" + paramindex++, tptName);
				haveCondition = true;
			}
			if (temProvider != null && temProvider.getTpId() != null) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temPackageType.temProvider.tpId=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temPackageType.temProvider.tpId=? ");
				map.put("" + paramindex++, temProvider.getTpId());
				haveCondition = true;
			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temPackageType."
						+ paging.getOrderBy() + " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}

	public void insertTemProvider(Session session, TemProvider temProvider) {
			session.beginTransaction();
			Transaction transaction = session.getTransaction();
			session.save(temProvider);
			transaction.commit();
	}

	public void updateTemProvider(Session session, TemProvider temProvider) {
			session.update(temProvider);
	}

	public void deleteTemProvider(Session session, TemProvider temProvider) {
			session.delete(temProvider);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemProvider(Session session, TemProvider temProvider, Paging paging) {
		List transList = new ArrayList();
		try {
			StringBuffer queryStr = new StringBuffer(
					"from TemProvider temProvider ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temProvider) from  TemProvider temProvider ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			Integer tpId = temProvider.getTpId();
			String tpName = temProvider.getTpName();

			if (tpId != null) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temProvider.tpId=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temProvider.tpId=? ");
				map.put("" + paramindex++, tpId);
				haveCondition = true;
			}
			if (tpName != null && tpName.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temProvider.tpName=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temProvider.tpName=? ");
				map.put("" + paramindex++, tpName);
				haveCondition = true;
			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temProvider." + paging.getOrderBy()
						+ " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}

	public void insertTemSpecialList(TemSpecialList temSpecialList) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.save(temSpecialList);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemSpecialList(TemSpecialList temSpecialList) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.update(temSpecialList);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemSpecialList(TemSpecialList temSpecialList) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.delete(temSpecialList);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public List searchTemSpecialList(TemSpecialList temSpecialList,
			Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.openSession();
			StringBuffer queryStr = new StringBuffer(
					"from TemSpecialList temSpecialList ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temSpecialList.temSpecialListPk.tslMsisdn) from  TemSpecialList temSpecialList ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			TemSpecialListPk temSpecialListPk = temSpecialList.getTemSpecialListPk();
			String tslMsisdn = temSpecialListPk!=null?temSpecialListPk.getTslMsisdn():null;
			String tslMsisdnFriend = temSpecialListPk!=null?temSpecialListPk.getTslMsisdnFriend():null;

			if (temSpecialListPk != null && tslMsisdn != null && tslMsisdn.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temSpecialList.tslMsisdn=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temSpecialList.tslMsisdn=? ");
				map.put("" + paramindex++, tslMsisdn);
				haveCondition = true;
			}
			if (temSpecialListPk != null && tslMsisdnFriend != null && tslMsisdnFriend.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temSpecialList.tslMsisdnFriend=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temSpecialList.tslMsisdnFriend=? ");
				map.put("" + paramindex++, tslMsisdnFriend);
				haveCondition = true;
			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temSpecialList." + paging.getOrderBy()
						+ " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}

	public void insertTemPackageDetail(TemPackageDetail temPackageDetail) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.save(temPackageDetail);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemPackageDetail(TemPackageDetail temPackageDetail) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.update(temPackageDetail);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemPackageDetail(TemPackageDetail temPackageDetail) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.delete(temPackageDetail);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public List searchTemPackageDetail(TemPackageDetail temPackageDetail,
			Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.openSession();
			StringBuffer queryStr = new StringBuffer(
					"from TemPackageDetail temPackageDetail ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temPackageDetail) from  TemPackageDetail temPackageDetail ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			Integer tpdId = temPackageDetail.getTpdId();
			String tpdName = temPackageDetail.getTpdName();
//			TemPackageType temPackageType = temPackageDetail.getTemPackageType();

			if (tpdId != null) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temPackageDetail.tpdId=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temPackageDetail.tpdId=? ");
				map.put("" + paramindex++, tpdId);
				haveCondition = true;
			}
			if (tpdName != null && tpdName.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temPackageDetail.tpdName=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temPackageDetail.tpdName=? ");
				map.put("" + paramindex++, tpdName);
				haveCondition = true;
			}
//			if (temPackageType != null && temPackageType.getTptId() != null) {
//				queryStr.append((haveCondition ? " and " : " where ")
//						+ " temPackageDetail.temPackageType.tptId=? ");
//				queryCount.append((haveCondition ? " and " : " where ")
//						+ " temPackageDetail.temPackageType.tptId=? ");
//				map.put("" + paramindex++, temPackageType.getTptId());
//				haveCondition = true;
//			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temPackageDetail." + paging.getOrderBy()
						+ " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}

	public void insertTemCallDetailRecord(Session session, 
			TemCallDetailRecord temCallDetailRecord) {
			session.beginTransaction();
			Transaction transaction = session.getTransaction();
			session.save(temCallDetailRecord);
			transaction.commit();
	}

	public void updateTemCallDetailRecord(Session session, 
			TemCallDetailRecord temCallDetailRecord) {
			session.update(temCallDetailRecord);
	}

	public void deleteTemCallDetailRecord(Session session, 
			TemCallDetailRecord temCallDetailRecord) {
			session.delete(temCallDetailRecord);
	}

	public List searchTemCallDetailRecord(Session session, 
			TemCallDetailRecord temCallDetailRecord, Paging paging) {
		List transList = new ArrayList();
		try {
			StringBuffer queryStr = new StringBuffer(
					"from TemCallDetailRecord temCallDetailRecord ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temCallDetailRecord.temCallDetailRecordPk.tcdrMsIsdnFrom) from  TemCallDetailRecord temCallDetailRecord ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			String tcdrMsIsdnTo = temCallDetailRecord.getTcdrMsIsdnTo();
//			String tcdrMsIsdnTo = temCallDetailRecord.getTcdrMsIsdnTo() != null?temCallDetailRecord.getTcdrMsIsdnTo().getMsIsdn():null;
//			TemType temType = temCallDetailRecord.getTemType();
			TemCallDetailRecordPk temCallDetailRecordPk = temCallDetailRecord.getTemCallDetailRecordPk();

			if (tcdrMsIsdnTo != null && tcdrMsIsdnTo.trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temCallDetailRecord.tcdrMsIsdnTo=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temCallDetailRecord.tcdrMsIsdnTo=? ");
				map.put("" + paramindex++, tcdrMsIsdnTo);
				haveCondition = true;
			}
//			if (temType != null && temType.getTtId() != null) {
//				queryStr.append((haveCondition ? " and " : " where ")
//						+ " temCallDetailRecord.temType.ttId=? ");
//				queryCount.append((haveCondition ? " and " : " where ")
//						+ " temCallDetailRecord.temType.ttId=? ");
//				map.put("" + paramindex++, temType.getTtId());
//				haveCondition = true;
//			}
			if (temCallDetailRecordPk != null && temCallDetailRecordPk.getTcdrMsIsdnFrom() != null && temCallDetailRecordPk.getTcdrMsIsdnFrom().trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temCallDetailRecord.temCallDetailRecordPk.tcdrMsIsdnFrom=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temCallDetailRecord.temCallDetailRecordPk.tcdrMsIsdnFrom=? ");
				map.put("" + paramindex++, temCallDetailRecordPk.getTcdrMsIsdnFrom());
				haveCondition = true;
			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temCallDetailRecord." + paging.getOrderBy()
						+ " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}

	public void insertTemMsIsdnPackageDetail(
			TemMsIsdnPackageDetail temMsIsdnPackageDetail) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.save(temMsIsdnPackageDetail);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemMsIsdnPackageDetail(
			TemMsIsdnPackageDetail temMsIsdnPackageDetail) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.update(temMsIsdnPackageDetail);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemMsIsdnPackageDetail(
			TemMsIsdnPackageDetail temMsIsdnPackageDetail) {
		Session session = sessionAnnotationFactory.openSession();
		try {
			session.delete(temMsIsdnPackageDetail);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public List searchTemMsIsdnPackageDetail(
			TemMsIsdnPackageDetail temMsIsdnPackageDetail, Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.openSession();
			StringBuffer queryStr = new StringBuffer(
					"from TemMsIsdnPackageDetail temMsIsdnPackageDetail ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temMsIsdnPackageDetail.temMsIsdnPackageDetailPk.msIsdn) from  TemMsIsdnPackageDetail temMsIsdnPackageDetail ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = temMsIsdnPackageDetail.getTemMsIsdnPackageDetailPk();

			if (temMsIsdnPackageDetailPk != null && temMsIsdnPackageDetailPk.getMsIsdn() != null && temMsIsdnPackageDetailPk.getMsIsdn().trim().length() > 0) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temMsIsdnPackageDetail.temMsIsdnPackageDetailPk.msIsdn=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temMsIsdnPackageDetail.temMsIsdnPackageDetailPk.msIsdn=? ");
				map.put("" + paramindex++, temMsIsdnPackageDetailPk.getMsIsdn());
				haveCondition = true;
			}
			if (temMsIsdnPackageDetailPk != null && temMsIsdnPackageDetailPk.getTpdId() != null) {
				queryStr.append((haveCondition ? " and " : " where ")
						+ " temMsIsdnPackageDetail.temPackageDetail.tpdId=? ");
				queryCount.append((haveCondition ? " and " : " where ")
						+ " temMsIsdnPackageDetail.temPackageDetail.tpdId=? ");
				map.put("" + paramindex++, temMsIsdnPackageDetailPk.getTpdId());
				haveCondition = true;
			}
			if (paging.getOrderBy() != null
					&& paging.getOrderBy().trim().length() > 0) {
				queryStr.append(" Order By temMsIsdnPackageDetail." + paging.getOrderBy()
						+ " asc");
			}
			Query query = session.createQuery(queryStr.toString());
			Query queryC = session.createQuery(queryCount.toString());
			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				query.setParameter(Integer.parseInt(key), map.get(key));
				queryC.setParameter(Integer.parseInt(key), map.get(key));
			}
			query.setFirstResult(paging.getPageSize()
					* (paging.getPageNo() - 1));
			query.setMaxResults(paging.getPageSize());
			List list = query.list();

			int count = Integer.parseInt(queryC.uniqueResult().toString());
			transList.add(list);
			transList.add(count + "");
			return transList;
		} catch (Exception re) {
			re.printStackTrace();
		}
		return null;
	}
	
	public void migrateData() {
		List list = new MigrateData().readExcel(Util.getProperty("MIGRATE_DATA_FILE"));
		Paging paging = new Paging();
		TemType temType = new TemType();
		Session session = sessionAnnotationFactory.openSession();
		List listType = searchTemType(session, temType, paging);
		TemProvider temProvider = new TemProvider();
		List listProvider = searchTemProvider(session, temProvider, paging);
		TemCompany temCompany = new TemCompany();
		List listCompany = searchTemCompany(session, temCompany, paging);
//		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			CDRTemplate cdrTemplate = (CDRTemplate)list.get(i);
//			System.out.println(cdrTemplate.getMsIsdnFrom()+"\t"+cdrTemplate.getMsIsdnTo());
			if(cdrTemplate.getMsIsdnFrom() != null && cdrTemplate.getMsIsdnFrom().trim().length() > 0) {
				TemMsIsdn temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(cdrTemplate.getMsIsdnFrom());
				List list2 = searchTemMsIsdn(session, temMsIsdn, paging);
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
					insertTemMsIsdn(session, temMsIsdn);
				}
			}
			
			if(cdrTemplate.getMsIsdnTo() != null && cdrTemplate.getMsIsdnTo().trim().length() > 0) {
				TemMsIsdn temMsIsdn = new TemMsIsdn();
				temMsIsdn.setMsIsdn(cdrTemplate.getMsIsdnTo());
				List list2 = searchTemMsIsdn(session, temMsIsdn, paging);
				if(list2 != null && list2.size() == 2 && (Integer.parseInt(list2.get(1).toString())) > 0) {
//					System.out.println("################## If #######################");
				} else {
//					System.out.println("################## Else #######################"+cdrTemplate.getMsIsdnTo()+" : "+cdrTemplate.getMsIsdnToProvider());
					int providerSize = Integer.parseInt(listProvider.get(1).toString());
					List providers = (List)listProvider.get(0);
					for(int j=0;j<providerSize;j++) {
						TemProvider provider = (TemProvider)providers.get(j);
						if(cdrTemplate.getMsIsdnToProvider().equalsIgnoreCase(provider.getTpName())) {
							temMsIsdn.setTemProvider(provider);
							break;
						}
					}
					insertTemMsIsdn(session, temMsIsdn);
				}
			}
			
			TemCallDetailRecord temCallDetailRecord = new TemCallDetailRecord();
//			TemMsIsdn temMsIsdnTo = new TemMsIsdn();
//			temMsIsdnTo.setMsIsdn(cdrTemplate.getMsIsdnTo());
			temCallDetailRecord.setTcdrMsIsdnTo(cdrTemplate.getMsIsdnTo());
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
			insertTemCallDetailRecord(session, temCallDetailRecord);
		}
		session.close();
	}

}

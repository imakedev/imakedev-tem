package th.co.imake.tem.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import th.co.imake.tem.service.TemService;
import th.co.imake.tem.util.Paging;

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

	public void insertTemType(TemType temType) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.save(temType);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemType(TemType temType) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.update(temType);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemType(TemType temType) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.delete(temType);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemType(TemType temType, Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.getCurrentSession();
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

	public void insertTemCompany(TemCompany temCompany) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.save(temCompany);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemCompany(TemCompany temCompany) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.update(temCompany);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemCompany(TemCompany temCompany) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.delete(temCompany);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemCompany(TemCompany temCompany, Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.getCurrentSession();
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

	public void insertTemMsIsdn(TemMsIsdn temMsIsdn) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.save(temMsIsdn);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemMsIsdn(TemMsIsdn temMsIsdn) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.update(temMsIsdn);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemMsIsdn(TemMsIsdn temMsIsdn) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.delete(temMsIsdn);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemMsIsdn(TemMsIsdn temMsIsdn, Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.getCurrentSession();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.save(temPackageType);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemPackageType(TemPackageType temPackageType) {
		Session session = sessionAnnotationFactory.getCurrentSession();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
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
			session = sessionAnnotationFactory.getCurrentSession();
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

	public void insertTemProvider(TemProvider temProvider) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.save(temProvider);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemProvider(TemProvider temProvider) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.update(temProvider);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemProvider(TemProvider temProvider) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.delete(temProvider);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searchTemProvider(TemProvider temProvider, Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.getCurrentSession();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.save(temSpecialList);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemSpecialList(TemSpecialList temSpecialList) {
		Session session = sessionAnnotationFactory.getCurrentSession();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
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
			session = sessionAnnotationFactory.getCurrentSession();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.save(temPackageDetail);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemPackageDetail(TemPackageDetail temPackageDetail) {
		Session session = sessionAnnotationFactory.getCurrentSession();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
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
			session = sessionAnnotationFactory.getCurrentSession();
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

	public void insertTemCallDetailRecord(
			TemCallDetailRecord temCallDetailRecord) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.save(temCallDetailRecord);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void updateTemCallDetailRecord(
			TemCallDetailRecord temCallDetailRecord) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.update(temCallDetailRecord);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public void deleteTemCallDetailRecord(
			TemCallDetailRecord temCallDetailRecord) {
		Session session = sessionAnnotationFactory.getCurrentSession();
		try {
			session.delete(temCallDetailRecord);
		} finally {
			if (session != null) {
				session = null;
			}
		}
	}

	public List searchTemCallDetailRecord(
			TemCallDetailRecord temCallDetailRecord, Paging paging) {
		List transList = new ArrayList();
		Session session = null;
		try {
			session = sessionAnnotationFactory.getCurrentSession();
			StringBuffer queryStr = new StringBuffer(
					"from TemCallDetailRecord temCallDetailRecord ");
			StringBuffer queryCount = new StringBuffer(
					"select count(temCallDetailRecord.temCallDetailRecordPk.tcdrMsIsdnFrom) from  TemCallDetailRecord temCallDetailRecord ");
			Map map = new HashMap();
			boolean haveCondition = false;
			int paramindex = 0;

			String tcdrMsIsdnTo = temCallDetailRecord.getTcdrMsIsdnTo();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
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
		Session session = sessionAnnotationFactory.getCurrentSession();
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
			session = sessionAnnotationFactory.getCurrentSession();
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

}

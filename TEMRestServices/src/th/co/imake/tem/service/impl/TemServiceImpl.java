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

import th.co.imake.tem.domain.TemCompany;
import th.co.imake.tem.domain.TemMsIsdn;
import th.co.imake.tem.domain.TemPackageType;
import th.co.imake.tem.domain.TemProvider;
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

}

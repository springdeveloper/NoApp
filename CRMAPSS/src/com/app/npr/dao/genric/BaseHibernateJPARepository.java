package com.app.npr.dao.genric;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Generic CRUD Repository class functionality with Hibernate Session Factory
 *
 * Created by Y.Kamesh on 8/2/2015.
 */
public abstract class BaseHibernateJPARepository<T extends Entity, ID extends Serializable>
		implements BaseJPARepository<T, ID> {
	protected @Autowired SessionFactory sessionFactory;

	protected Class<T> clazz;

	@SuppressWarnings("unchecked")
	public void setupEntityClass(Class clazz) {
		this.clazz = clazz;
	}

	public void delete(T object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@Transactional
	public T insert(T object) {
		sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
		sessionFactory.getCurrentSession().save(object);
		sessionFactory.getCurrentSession().flush();
		return object;
	}

	@Transactional
	public T update(T object) {
		sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
		sessionFactory.getCurrentSession().update(object);
		sessionFactory.getCurrentSession().flush();
		return object;
	}

	@Transactional
	public T insertOrUpdate(T object) {
		sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
		sessionFactory.getCurrentSession().saveOrUpdate(object);
		sessionFactory.getCurrentSession().flush();
		return object;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T findById(ID id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findAll() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
		c.setMaxResults(countPerPage);
		c.setFirstResult(pageNum * countPerPage);
		return c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> c, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(c, id);
	}

	@Override
	public T get(String hql) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public T get(String hql, Map<String, Object> params) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public List<T> find(String hql) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Long count(String hql) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	@Override
	public List<Object[]> findBySql(String sql) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return q.list();
	}

	@Override
	public List<Object[]> findBySql(String sql, int page, int rows) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<Object[]> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public int executeSql(String sql) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	@Override
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	@Override
	public BigInteger countBySql(String sql) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return (BigInteger) q.uniqueResult();
	}

	@Override
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (BigInteger) q.uniqueResult();
	}

}

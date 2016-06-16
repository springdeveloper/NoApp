package com.app.npr.service.Impl.util.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.Order;
import com.app.npr.dao.genric.BaseHibernateJPARepository;
import com.app.npr.model.City;
import com.app.npr.model.Country;
import com.app.npr.model.State;
import com.app.npr.model.Tag;
import com.app.npr.service.util.common.UtilsService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

@Service("utilsServiceImpl")
@Transactional
public class UtilsServiceImpl implements UtilsService {
	protected @Autowired SessionFactory sessionFactory;

	@Override
	public void createCountry(Country country) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createState(State state) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public List<Country> getAllCountry() {
		//org.hibernate.Cache cache = sessionFactory.getCache();

//		if (cache != null) {
//		    cache.evictAllRegions(); // Evict data from all query regions.
//		}
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}

	@Override
	// @Cacheable("state")
	public List<State> getAllCity() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(State.class).list();

	}

	// @Cacheable("city")
	public List<City> getAllState() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(City.class).list();

	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findByQuery(String sql, Map<String, Object> params) {
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Country> getAllCountry(String param) {
		Criteria crt = sessionFactory.getCurrentSession().createCriteria(Country.class);
		crt.add(Restrictions.ilike("countryName", param + "%"));
		crt.addOrder(Order.asc("countryName"));
		return crt.list();
	}

	@SuppressWarnings("unchecked")
	public List<State> findStateByCountryId(int param) {
		Criteria crt = sessionFactory.getCurrentSession().createCriteria(State.class);
		crt.add(Restrictions.eq("countryId", param));
		crt.addOrder(Order.asc("stateName"));
		return crt.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> findCityByStateId(int param) {
		Criteria crt = sessionFactory.getCurrentSession().createCriteria(City.class);
		crt.add(Restrictions.eq("stateId", param));
		crt.addOrder(Order.asc("cityName"));
		return crt.list();
	}

	@Override
	public State findStateById(int id) {
	
		return (State) sessionFactory.getCurrentSession().get(State.class, id);
	}

	@Override
	public City findCityById(int id) {
		// TODO Auto-generated method stub
		 	return (City) sessionFactory.getCurrentSession().get(City.class, id);
	}

}

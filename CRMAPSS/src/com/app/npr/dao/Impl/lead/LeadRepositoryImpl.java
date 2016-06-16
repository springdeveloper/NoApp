package com.app.npr.dao.Impl.lead;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.npr.dao.genric.BaseHibernateJPARepository;
import com.app.npr.dao.lead.LeadRepository;
import com.app.npr.model.lead.Lead;

@Repository("leadRepositoryImpl")
public class LeadRepositoryImpl extends BaseHibernateJPARepository<Lead, Long> implements LeadRepository {
	private static Logger LOG = LoggerFactory.getLogger(LeadRepositoryImpl.class);

	@Override
	public Lead findByEmail(String email) {
		return (Lead) sessionFactory.getCurrentSession().createQuery("from Lead u where u.emails = :email")
				.setParameter("emails", email).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Lead> getAllLead(int iDisplayStart, int iDisplayLength, String keyword, int coloumn, String sort) {
		// TODO Auto-generated method stub

		try {
			List<Lead> users = new ArrayList<Lead>();
			if (!"".equals(keyword)) {
				users = sessionFactory.getCurrentSession()
						.createQuery(
								"FROM Lead WHERE  lastName :keyword OR firstName like :keyword OR leadOwner like :keyword order by "
										+ coloumn + " " + sort)
						.setParameter("keyword", "%" + keyword + "%").setMaxResults(iDisplayLength)
						.setFirstResult(iDisplayStart).list();
			} else {
				users = sessionFactory.getCurrentSession().createQuery("from Lead order by " + coloumn + " " + sort)
						.setMaxResults(iDisplayLength).setFirstResult(iDisplayStart).list();
			}

			return users;

		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("Erro update " + e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Lead> getLeadByStringkey(String keyword) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(
							"FROM Lead WHERE lastName like :keyword OR firstName like :keyword OR mobile like :keyword")
					.setParameter("keyword", "%" + keyword + "%").list();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println("Erro update " + e.getMessage());
			return null;
		}
	}
}

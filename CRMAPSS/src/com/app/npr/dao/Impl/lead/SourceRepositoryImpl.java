package com.app.npr.dao.Impl.lead;

import org.springframework.stereotype.Repository;

import com.app.npr.dao.genric.BaseHibernateJPARepository;
import com.app.npr.dao.lead.SourceRepository;
import com.app.npr.model.lead.LeadSource;

@Repository("SourceRepositoryImpl")
public class SourceRepositoryImpl extends BaseHibernateJPARepository<LeadSource, Integer> implements SourceRepository {

}

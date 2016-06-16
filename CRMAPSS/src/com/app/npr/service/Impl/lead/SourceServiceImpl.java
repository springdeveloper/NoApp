package com.app.npr.service.Impl.lead;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.npr.dao.genric.BaseJPAServiceImpl;
import com.app.npr.dao.lead.SourceRepository;
import com.app.npr.model.lead.LeadSource;
import com.app.npr.service.lead.SourceService;
@Service("SourceServiceImpl")
@Transactional
public class SourceServiceImpl extends BaseJPAServiceImpl<LeadSource, Integer> implements SourceService{

	  private @Autowired
	  SourceRepository sourceRepository;

	    @PostConstruct
	    public void setupService() {
	        this.baseJpaRepository = sourceRepository;
	        this.entityClass = LeadSource.class;
	        this.baseJpaRepository.setupEntityClass(LeadSource.class);
	    }

}

package com.app.npr.service.Impl.lead;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.npr.dao.genric.BaseJPAServiceImpl;
import com.app.npr.dao.lead.LeadRepository;
import com.app.npr.model.lead.Lead;
import com.app.npr.service.lead.LeadService;



@Transactional
@Service("leadSericeImpl")
public class LeadSericeImpl extends BaseJPAServiceImpl<Lead, Long> implements LeadService{
	  private @Autowired 
	  LeadRepository leadRepository;

	    @PostConstruct
	    public void setupService() {
	        this.baseJpaRepository = leadRepository;
	        this.entityClass = Lead.class;
	        this.baseJpaRepository.setupEntityClass(Lead.class);
	    }

		@Override
		public Lead findByEmail(String email) {
			   Lead user = leadRepository.findByEmail(email);

		        if(user != null) {
		            return user;
		        } else {
		        	 return user;
		        }
		    }

		@Override
	
		public List<Lead> getAllLead(int iDisplayStart, int iDisplayLength, String keyword, int coloumn, String sort) {
			// TODO Auto-generated method stub
			return leadRepository.getAllLead(iDisplayStart, iDisplayLength, keyword, coloumn, sort);
		}

		@Override
		public List<Lead> getLeadByStringkey(String keyword) {
			// TODO Auto-generated method stub
			return leadRepository.getLeadByStringkey(keyword);
		}
		

}



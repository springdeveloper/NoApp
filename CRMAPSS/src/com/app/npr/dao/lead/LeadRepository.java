package com.app.npr.dao.lead;


import java.util.List;

import com.app.npr.dao.genric.BaseJPARepository;
import com.app.npr.model.lead.Lead;


public interface LeadRepository extends BaseJPARepository<Lead, Long> {
    public Lead findByEmail(String email);
	public List<Lead> getAllLead(int iDisplayStart,int iDisplayLength, String keyword,int coloumn,String sort);
	public List<Lead> getLeadByStringkey(String keyword);
}

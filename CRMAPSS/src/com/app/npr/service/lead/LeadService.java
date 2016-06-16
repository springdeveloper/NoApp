package com.app.npr.service.lead;

import java.util.List;

import com.app.npr.dao.genric.BaseService;
import com.app.npr.model.lead.Lead;

public interface LeadService extends BaseService<Lead, Long> {
    public Lead findByEmail(String email) ;
    public List<Lead> getAllLead(int iDisplayStart,int iDisplayLength, String keyword,int coloumn,String sort);
	public List<Lead> getLeadByStringkey(String keyword);

}

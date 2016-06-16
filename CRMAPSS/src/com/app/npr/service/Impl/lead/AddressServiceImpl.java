package com.app.npr.service.Impl.lead;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.npr.dao.genric.BaseJPAServiceImpl;
import com.app.npr.dao.lead.AddressRepository;
import com.app.npr.dao.lead.LeadRepository;
import com.app.npr.model.lead.Address;
import com.app.npr.model.lead.Lead;
import com.app.npr.service.lead.AddressService;

@Service("addressServiceImpl")
@Transactional
public class AddressServiceImpl extends BaseJPAServiceImpl<Address, Long> implements AddressService{

	  private @Autowired
	  AddressRepository addressRepository;

	    @PostConstruct
	    public void setupService() {
	        this.baseJpaRepository = addressRepository;
	        this.entityClass = Address.class;
	        this.baseJpaRepository.setupEntityClass(Address.class);
	    }

}

package com.app.npr.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.app.npr.dto.LeadForm;
import com.app.npr.enums.LeadEnum.IndustryType;
import com.app.npr.enums.LeadEnum.LeadSourceType;
import com.app.npr.enums.LeadEnum.LeadStatus;
import com.app.npr.model.lead.Lead;
import com.app.npr.service.lead.LeadService;
import com.app.npr.util.UrlApi;
import com.app.npr.util.*;

@Controller
@RequestMapping("/lead")
public class LeadController {

	@Autowired(required = true)
	private LeadService leadService;
	@SuppressWarnings("unused")
	private static Logger LOG = LoggerFactory.getLogger(LeadController.class);

	@RequestMapping(value = UrlApi.LEAD_HOME, method = RequestMethod.GET)
	public String LeadHome() {

		return "index";
	}

	@RequestMapping(value = UrlApi.LEAD_LIST, method = RequestMethod.GET)
	public String LeadList(ModelMap model) {
		model.addAttribute(UrlApi.LEAD_PAGE_NAME, UrlApi.LEAD_LIST_FORM);
		model.addAttribute(UrlApi.PAGE_TITLE, UrlApi.LEAD_LST_TITLE);
		return UrlApi.LEAD_TEMPLATE;
	}

	@RequestMapping(value = UrlApi.CREATE_LEAD, method = RequestMethod.GET)
	public String createLead(ModelMap model)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		model.addAttribute("lead", new LeadForm());
		model.addAttribute(UrlApi.LEAD_PAGE_NAME, UrlApi.LEAD_FORM);
		model.addAttribute("source_list", LeadSourceType.values());
		model.addAttribute("leadStatus", LeadStatus.values());
		model.addAttribute("Industrylist", IndustryType.values());
		model.addAttribute(UrlApi.PAGE_TITLE, UrlApi.LEAD_CR_TITLE);

		return UrlApi.LEAD_TEMPLATE;
	}

	@RequestMapping(value = UrlApi.CREATE_LEAD, method = RequestMethod.POST)
	public ModelAndView saveLead(@Valid LeadForm form, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute(UrlApi.LEAD_PAGE_NAME, UrlApi.LEAD_FORM);
			return new ModelAndView(UrlApi.LEAD_TEMPLATE);
		}
		try {
			if (form.getId() != null) {
				leadService.update(LeadForm.getPopulateBean(form));
			} else {
				leadService.insert(LeadForm.getPopulateBean(form));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(UrlApi.HOME_REDIRECT);
	}

	@RequestMapping(value = UrlApi.EDIT_LEAD, method = RequestMethod.GET)
	public String eitLead(ModelMap model, @RequestParam Long ids) throws NumberFormatException, Exception  {
		  
		model.addAttribute("lead", LeadForm.getLeadData(leadService.findById(ids)));
		model.addAttribute(UrlApi.LEAD_PAGE_NAME, UrlApi.LEAD_FORM);
		model.addAttribute("source_list", LeadSourceType.values());
		model.addAttribute("leadStatus", LeadStatus.values());
		model.addAttribute("Industrylist", IndustryType.values());
		model.addAttribute(UrlApi.PAGE_TITLE, UrlApi.LEAD_EDT_TITLE);
		return UrlApi.LEAD_TEMPLATE;
	}

	@RequestMapping(value = UrlApi.LEAD_PAGINATION, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String showUser(HttpServletRequest request, HttpServletResponse response) {

		String start = request.getParameter("start");
		String draw = request.getParameter("draw");
		String length = request.getParameter("length");
		String search = request.getParameter("search[value]");
		String order = request.getParameter("order[0][dir]");
		String column = request.getParameter("order[0][column]");

		JsonObject<Lead> data = new JsonObject<Lead>();
		List<Lead> lead2 = leadService.getLeadByStringkey(search);
		List<Lead> leads = new ArrayList<Lead>();

		leads = leadService.getAllLead(Integer.parseInt(start), Integer.parseInt(length), search,
				(Integer.parseInt(column) + 1), order);

		data.setAaData(leads);
		data.setiTotalDisplayRecords(lead2.size());
		data.setiTotalRecords(lead2.size());
		data.setsEcho(Integer.parseInt(draw));
		return BusinessUtils.toJson(data);

	}

}

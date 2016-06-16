package com.app.npr.util;

public class UrlApi {

	/*
	 * Commong Api Country Sate and City Controller Url Mapping CommonController
	 */
	public static final String HOME_PAGE = "index";
	public static final String HOME_REDIRECT = "redirect:/";
	public static final String GET_COUNTRY_LIST = "/api/getCountry";
	public static final String GET_STATE_LIST_BY_COUNTRY_ID = "/api/getState";
	public static final String GET_CITY_LIST_BY_STATE_ID = "/api/getCity";
	public static final String GET_CITY_BY_ID = "/api/getCityById";
	public static final String GET_STATE_BY_ID = "/api/getStateById";

	/*
	 * Lead Controller----------- Url Mapping Start LeadController
	 */

	/* Url Maping */
	public static final String CREATE_LEAD = "/_createLead";
	public static final String EDIT_LEAD = "/_editLead";
	public static final String LEAD_HOME = "/";
	public static final String LEAD_LIST = "/lead_page";
	public static final String LEAD_PAGINATION = "/lead_api";
	/* Page Maping */
	public static final String LEAD_TEMPLATE = "lead/lead_template";
	public static final String LEAD_LIST_TEMPLATES = "LEAD/_lead_list";
	public static final String LEAD_DASHBORD = "/";

	/* Lead variable maping */
	public static final String LEAD_FORM = "_create_lead";
	public static final String LEAD_LIST_FORM = "_lead_list";
	public static final String LEAD_PAGE_NAME = "view_title";
	public static final String PAGE_TITLE = "pageTitle";

	/* LEAD PAGE TITE NAME */

	public static final String LEAD_CR_TITLE = "CREATE LEAD";
	public static final String LEAD_LST_TITLE = "LEAD LIST";
	public static final String LEAD_VIW_TITLE = "DETAILS OF LEAD";
	public static final String LEAD_EDT_TITLE = "EDIT LEAD";

	/* Lead Controller------------ Url Mapping End */

	/*
	 * Account Controller Url Maping Start
	 */
	public static final String ACCOUNT_HOME = "/";
	public static final String CREATE_ACCOUNT = "/_create_account";
       
	/* END OF ACCOUNT CONTROLLER URL MAPING */

	/* START PAGE URL MAPING OF ACCOUNT CONTROLLER */
	
	public static final String ACCOUNT_TEMPLATES = "account/account_template";
	public static final String ACCOUNT_CREATE_PAGE = "_create_account";

	/* END PAGE URL MAPING OF ACCOUNT CONTROLLER */
	/* ACCOUNT TITILE AND CONTENT */
   public static final String ACC_CREATE_PAGE_TITLE="acc_pageTitle";
   public static final Object ACC_CREATE_PAGE_TITLE_NAME = "CREATE ACCOUNT";

   public static final String ACC_TEMPLATE_TITLE="acc_title";
}
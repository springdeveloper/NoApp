package com.app.npr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.npr.model.City;
import com.app.npr.model.Country;
import com.app.npr.model.State;
import com.app.npr.service.util.common.UtilsService;
import com.app.npr.util.UrlApi;

@RestController
@RequestMapping("/common")
public class CommonController {
	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private UtilsService utilsService;

	@RequestMapping(value = UrlApi.GET_COUNTRY_LIST, method = RequestMethod.GET)
	public @ResponseBody List<Country> getCityList( HttpServletResponse response) throws IOException {
		
		return utilsService.getAllCountry();

	}

	@RequestMapping(value = UrlApi.GET_STATE_LIST_BY_COUNTRY_ID, method = RequestMethod.GET)
	public @ResponseBody List<State> getStateByCountryId(@RequestParam int id) {
		return utilsService.findStateByCountryId(id);

	}
	
	@RequestMapping(value = UrlApi.GET_STATE_BY_ID, method = RequestMethod.GET)
	public @ResponseBody State getStateById(@RequestParam String id) {
		return utilsService.findStateById(Integer.parseInt(id));

	}

	@RequestMapping(value = UrlApi.GET_CITY_LIST_BY_STATE_ID, method = RequestMethod.GET)
	public @ResponseBody List<City> getCityByStateId(@RequestParam int id) {
		return utilsService.findCityByStateId(id);

	}
	
	@RequestMapping(value = UrlApi.GET_CITY_BY_ID, method = RequestMethod.GET)
	public @ResponseBody City getCity(@RequestParam int id) {
		return utilsService.findCityById(id);

	}

}

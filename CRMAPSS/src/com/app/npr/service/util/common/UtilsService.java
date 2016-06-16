package com.app.npr.service.util.common;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.app.npr.model.City;
import com.app.npr.model.Country;
import com.app.npr.model.State;
import com.app.npr.model.Tag;

public interface UtilsService {
public void createCountry(Country country);
public void createState(State state);
public List<Country> getAllCountry();
public List<State> getAllCity();
public State findStateById(int id);
public City findCityById(int id);
public List<Object[]> findByQuery(String sql, Map<String, Object> params);
public List<Country> getAllCountry(String param);
public List<State> findStateByCountryId(int param);
public List<City> findCityByStateId(int param);
}

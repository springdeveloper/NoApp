package com.app.npr.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BusinessUtils {
	

	@SuppressWarnings("unused")
	public static String toJson(JsonObject<?> dt) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(dt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public static final String LEAD_BEAN = "com.app.npr.dto.LeadForm";

	public static Object getBeanObject(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class cls = Class.forName(className);
		Object obj = cls.newInstance();

		return obj;
	}

	public static Object getBeanReference(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class cls = Class.forName(className);
		Object obj = null;

		return obj;
	}
	
}

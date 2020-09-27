package com.example.eshopping.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

		public static String toJson(Object obj) {
			String jsonInString=null;
			try{
			ObjectMapper mapper = new ObjectMapper();
		    jsonInString = mapper.writeValueAsString(obj);
			}catch(Exception e){
				e.printStackTrace();
			}
			return jsonInString;
		}

}

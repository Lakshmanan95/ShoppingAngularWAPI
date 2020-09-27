package com.example.eshopping.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EshoppingLogger {

	private static Logger log;

	public static void logInfo(Class<?> clazz, String message) {
		log = LogManager.getLogger(clazz);
		log.info(message);
	}
	
	public static void logDebug(Class<?> clazz, String message, Throwable t) {
		log = LogManager.getLogger(clazz);
		log.debug(message, t);
	}
	
	public static void logError(Class<?> clazz, String message, Throwable t) {
		log = LogManager.getLogger(clazz);
		log.error(message, t);
	}
}

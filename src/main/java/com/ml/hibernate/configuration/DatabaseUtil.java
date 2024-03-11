package com.ml.hibernate.configuration;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

public class DatabaseUtil {

	private static final Logger LOG = LoggerFactory.getLogger(DatabaseUtil.class);

	private DatabaseUtil() {
		// private default constructor
	}

	public static void getDetailedStackTrace(Throwable t) {
		Optional.ofNullable(t).ifPresent(e -> {
			StringBuilder msg = new StringBuilder(e.getMessage());
			Throwable cause = e.getCause();
			while (cause != null) {
				msg = msg.append(cause.getMessage());
				cause = cause.getCause();
			}
			DatabaseUtil.configureLogging();
			LOG.error(msg.toString());
		});
	}

	private static void configureLogging() {
		ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger) LoggerFactory
				.getLogger(Logger.ROOT_LOGGER_NAME);

		// Set the desired log level (INFO, ERROR, DEBUG, TRACE, etc.)
		rootLogger.setLevel(Level.INFO);
	}
}

package org.example.design.patterns.pattern.created;

/**
 * @author clx 4/7/2018
 */
public class FactoryMethod {

	public static void main(String[] args) {
		new FactoryMethod().run();
	}

	/**
	 * run
	 */
	private void run() {
		LoggerFactory factory = new FileLoggerFactory();
		Logger logger = factory.createLogger();
		logger.writeLog();
	}

	/**
	 * logger factory
	 */
	interface LoggerFactory {
		/**
		 * create logger
		 * 
		 * @return
		 */
		Logger createLogger();
	}

	/**
	 * concrete logger factory
	 */
	class FileLoggerFactory implements LoggerFactory {
		@Override
		public Logger createLogger() {
			return new FileLogger();
		}
	}

	/**
	 * logger interface
	 */
	interface Logger {
		/**
		 * write log
		 */
		void writeLog();
	}

	/**
	 * concrete logger
	 */
	class FileLogger implements Logger {
		@Override
		public void writeLog() {
			System.out.println("write file log.");
		}
	}
}

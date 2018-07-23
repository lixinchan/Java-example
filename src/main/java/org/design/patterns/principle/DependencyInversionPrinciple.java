package org.design.patterns.principle;

/**
 * DIP,
 * 
 * @author clx 2018/7/23.
 */
public class DependencyInversionPrinciple {

	class ConsumerDao {

		/**
		 * add consumer
		 */
		void addConsumer(AbstractDataConverter dataConverter) {
			// read file config TxtDataConverter or ExcelDataConverter
		}
	}

	abstract class AbstractDataConverter {
		/**
		 * converter
		 */
		abstract void converter();
	}

	class TxtDataConverter extends AbstractDataConverter {
		@Override
		void converter() {

		}
	}

	class ExcelDataConverter extends AbstractDataConverter {
		@Override
		void converter() {

		}
	}
}

/**
 * before refactor
 */
class ConsumerDao {

	/**
	 * add consumer
	 */
	void addConsumer() {
		TxtDataConverter.converter();
		// ExcelDataConverter.converter();
	}
}

/**
 * before refactor
 */
class TxtDataConverter {
	/**
	 * txt converter
	 */
	static void converter() {
	}
}

/**
 * before refactor
 */
class ExcelDataConverter {

	/**
	 * excel converter
	 */
	static void converter() {
	}
}

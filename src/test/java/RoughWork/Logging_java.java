package RoughWork;

import org.apache.log4j.Logger;

public class Logging_java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");

		 APPLICATION_LOGS.debug("hello");
			APPLICATION_LOGS.debug("We are wrinting in  file");
			APPLICATION_LOGS.debug("starting the test case xyz test");

	}

}

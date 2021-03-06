package maverick.ogs.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SeleniumTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SeleniumTests.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		if (result.getFailureCount() == 0) {
			System.out.println("All Selenium tests are passing.");
		}
	}
}

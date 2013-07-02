package teammates.test.cases.ui;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import teammates.common.datatransfer.DataBundle;
import teammates.common.util.Config;
import teammates.ui.controller.ControllerServlet;

public class StudentCourseJoinActionTest extends BaseActionTest {

	DataBundle dataBundle;

	
	@BeforeClass
	public static void classSetUp() throws Exception {
		printTestClassHeader();
		URI = Config.PAGE_STUDENT_JOIN_COURSE;
		sr.registerServlet(URI, ControllerServlet.class.getName());
	}

	@BeforeMethod
	public void methodSetUp() throws Exception {
		dataBundle = getTypicalDataBundle();
		restoreTypicalDataInDatastore();
	}
	
	@Test
	public void testAccessControl() throws Exception{
		
		String[] submissionParams = new String[]{
					Config.PARAM_REGKEY, "sample-key"
				};
		
		verifyOnlyLoggedInUsersCanAccess(submissionParams);
		
	}
	
	@Test
	public void testExecuteAndPostProcess() throws Exception{
		
		//TODO: implement this
		
	}

	
}
package teammates.ui.controller;

import java.util.logging.Logger;

import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Config;
import teammates.logic.GateKeeper;

public class InstructorEvalEditPageAction extends Action {
	Logger log = Config.getLogger();

	@Override
	protected ActionResult execute() 
			throws EntityDoesNotExistException,	InvalidParametersException {
		
		String courseId = getRequestParam(Config.PARAM_COURSE_ID);
		Assumption.assertNotNull(courseId);
		String evalName = getRequestParam(Config.PARAM_EVALUATION_NAME);
		Assumption.assertNotNull(evalName);
		
		new GateKeeper().verifyAccessible(
				logic.getInstructorForGoogleId(courseId, account.googleId),
				logic.getEvaluation(courseId, evalName));
		
		InstructorEvalEditPageData data = new InstructorEvalEditPageData(account);
		
		data.evaluation = logic.getEvaluation(courseId, evalName);

		if(data.evaluation == null){
			throw new EntityDoesNotExistException("The evaluation \""+evalName+"\" in course "+courseId+" does not exist");
		}
		
		statusToAdmin = "Editing Evaluation <span class=\"bold\">(" + data.evaluation.name + 
				")</span> for Course <span class=\"bold\">[" + data.evaluation.courseId + "]</span>.<br>" +
				"<span class=\"bold\">From:</span> " + data.evaluation.startTime + 
				"<span class=\"bold\"> to</span> " + data.evaluation.endTime + "<br>" +
				"<span class=\"bold\">Peer feedback:</span> " + (data.evaluation.p2pEnabled== true ? "enabled" : "disabled") + 
				"<br><br><span class=\"bold\">Instructions:</span> " + data.evaluation.instructions;
		
		return createShowPageResult(Config.JSP_INSTRUCTOR_EVAL_EDIT, data);

	}

}
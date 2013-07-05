package teammates.common.util;

public class EmailTemplates {

	public static String STUDENT_EVALUATION_ = FileHelper.readResourseFile("studentEmailTemplate-evaluation_.html");
	public static String STUDENT_EVALUATION_PUBLISHED = FileHelper.readResourseFile("studentEmailTemplate-evaluationPublished.html");
	public static String STUDENT_COURSE_JOIN = FileHelper.readResourseFile("studentEmailTemplate-courseJoin.html");
	public static String FRAGMENT_STUDENT_COURSE_JOIN = FileHelper.readResourseFile("studentEmailFragment-courseJoin.html");
	public static String USER_FEEDBACK_SESSION = FileHelper.readResourseFile("userEmailTemplate-feedbackSession.html");
	public static String USER_FEEDBACK_SESSION_PUBLISHED = FileHelper.readResourseFile("userEmailTemplate-feedbackSessionPublished.html");
	public static String SYSTEM_ERROR = FileHelper.readResourseFile("systemErrorEmailTemplate.html");

}
package Users;

import java.util.Vector;

import Attributes.Course;
import Attributes.DataBase;
import Attributes.News;
import Attributes.Operation;
import Attributes.Request;
import Attributes.Transcript;
import Enums.ManagerType;
import Interfaces.Student_Manager;

public class Manager extends Employee implements Student_Manager {
	
	private ManagerType type;
	
	public Manager(String password, String firstName, String lastName, int age, ManagerType type) {
		super(password, firstName, lastName, age);
		this.type = type;
	}
	
	public ManagerType getType() {
	    return type;
	}

	public void setType(ManagerType type) {
	    this.type = type;
	}

	public void assignCourseToTeacher(Course course, Teacher teacher) {
	    teacher.manageCourse(course);
	}
	
	public Vector<Course> viewCourses(){
		return DataBase.getCourses();
	}
	
	public Transcript viewTranscript(Student student) {
		return student.getTranscript();
	}
	
	public void manageNews(News news) {
		DataBase.addNews(news);
		DataBase.addlogFile(new Operation(this, "ADDED NEWS\n" + news.toString()));
	}
	
	public void addCourses(Course course) {
		DataBase.addCourse(course);
		DataBase.addlogFile(new Operation(this, "ADDED COURSE\n" + course.toString()));
	}
	
	public Vector<Request> viewRequests(){
		return DataBase.getAllRequests();
	}
	
	public void addRequest(Request request) {
		DataBase.addRequest(request);
		DataBase.addlogFile(new Operation(this, "ADDED REQUEST\n" + request.toString()));
	}

	@Override
    public String viewTeachersInfo(Teacher teacher) {
    	return teacher.viewProfile();
    }
}

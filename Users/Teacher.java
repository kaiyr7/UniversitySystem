package Users;

import Attributes.Course;
import Attributes.DataBase;
import Attributes.Mark;
import Attributes.Request;
import Attributes.ResearchPaper;
import Attributes.ResearchProject;
import Enums.School;
import Enums.TeacherType;
import Interfaces.Researchable;
import Interfaces.Student_Teacher_Manager;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class Teacher extends Employee implements Cloneable, Serializable, Researchable , Student_Teacher_Manager{
	private double rate;
    private TeacherType type;
    private School school;
    private int rateCounter = 0;
    private boolean researchStatus = false;
    private Vector<ResearchPaper> researchPapers = new Vector<>(); 
    private HashMap<Course, Vector<Student>> courses = new HashMap();

    public Teacher(String password, String firstName, String lastName, int age,TeacherType type,School school) {
    	super(password, firstName, lastName, age);
        this.type = type;
        this.school = school;
      
        if (this.type.equals(TeacherType.PROFESSOR)) {
           setResearchStatus(true);
        }
        
     }
   
    public void setResearchStatus(boolean status) {
	   this.researchStatus = status;
    }
   
    public TeacherType getType() {
    	return type;
    }

    public void setType(TeacherType type) {
        this.type = type;
    }

    public School getSchool() {
    	return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    public int getRateCounter() {
	    return this.rateCounter;
    }

    public void setRateCounter(int rateCounter) {
	    this.rateCounter = rateCounter;
    }

    public Vector<Course> getCourses() {
        return new Vector<>(courses.keySet());
    }

    public boolean putMark(Course course,Student student, Mark mark) {
        Vector<Student> enrolledStudents = courses.get(course);
        if (enrolledStudents != null) {
            if (enrolledStudents.contains(student)) {
                student.getJournal().addMark(course, mark);
                return true;
            }
        }
        return false;
    }
   
    public void manageCourse(Course course) {
    	courses.putIfAbsent(course, new Vector<Student>());
    }

    public void sendRequest(Request request) {
      DataBase.addRequest(request);
    }


    public boolean equals(Object o) {
        return super.equals(o);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), school, rate/(double)rateCounter);
    }

    public int compareTo(User u) {
        return super.compareTo(u);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public String viewProfile() {
        return super.viewProfile() + "\n-\n" + "Teacher type: " + type + "\nSchool: " + school + "\n-\n" + "Teacher rate: " + rate / (double)rateCounter;
    }

    public String toString() {
        return super.toString() + "\n-\n" + "Teacher type: " + type + "\nSchool: " + school + "\n-\n" + "Teacher rate: " + rate / (double)rateCounter;
    }

    public double calculateHIndex() {
    	if(!researchStatus) {
    		return 0;
    	}
        Vector<Integer> citationsVec = new Vector<>();
        for (ResearchPaper researchPaper : researchPapers) {
            citationsVec.add(researchPaper.getCitations());
        }
        Collections.sort(citationsVec, Collections.reverseOrder());

        int hIndex = 0;
        for (int i = 0; i < citationsVec.size(); i++) {
            if (citationsVec.get(i) >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }


    public Vector<ResearchPaper> getResearchPapers() { 
    	return researchPapers; 
    }
    public void doResearchPapers(ResearchPaper researchPaper) { 
    	researchPapers.add(researchPaper);
    }
    
    public void printResearchPapers(Comparator<ResearchPaper> comparator) {
        Collections.sort(researchPapers, comparator);
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper.getName() + " - Published on: " + paper.getDatePublished() +
                               " - Citations: " + paper.getCitations() +
                               " - Pages: " + paper.getPages());
        }
    }
    
    public void addRate(double rate) {
    	this.rate += rate;
    	rateCounter++;
    }
    
    public boolean addStudent(Course course, Student student) {

        Vector<Student> enrolledStudents = courses.get(course);

        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            return true;
        }

        return false;
    }
    
    public boolean putFirstAttestation(Course course, Student student, double points) {
        Vector<Student> enrolledStudents = courses.get(course);
        if (enrolledStudents != null && enrolledStudents.contains(student)) {
          if(points <= 60)
          student.getTranscript().getLastSemester().getAttestation(course).setFirstAttestation(points);
        }
        return false;
    }
    
    public boolean putSecondAttestation(Course course, Student student, double points) {
        Vector<Student> enrolledStudents = courses.get(course);
        if (enrolledStudents != null && enrolledStudents.contains(student)) {
        	if(student.getTranscript().getLastSemester().getAttestation(course).getFirstAttestation()+ points <=60)
        	student.getTranscript().getLastSemester().getAttestation(course).setSecondAttestation(points);
        }
        return false;
    }
    public boolean putFinalExam(Course course, Student student, double points) {
        Vector<Student> enrolledStudents = courses.get(course);
        if (enrolledStudents != null && enrolledStudents.contains(student)) {
        	if(points <= 40)
        	student.getTranscript().getLastSemester().getAttestation(course).setFinalExam(points);
        }
        return false;
    }

	@Override
    public Vector<Course> viewCourses() {
        Vector<Course> courseList = new Vector<>();
        courseList.addAll(courses.keySet());
        return courseList;
    }
	
	public void sendComplaint(Request request) {
		Rector.getInstance().addOrder(request);
	}

    
}


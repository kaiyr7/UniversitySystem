package Users;

import Attributes.*;
import Enums.Degree;
import Enums.School;
import Interfaces.Researchable;
import Interfaces.Student_Manager;
import Interfaces.Student_Teacher_Manager;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Student extends User implements Researchable, Student_Manager , Student_Teacher_Manager {
    private Degree degree;
    private School school;
    private int yearOfStudy;
    private Vector<Course> courses = new Vector<>();
    private Organization organization;
    private Transcript transcript = new Transcript();
    private Journal journal = new Journal();
    private boolean researchStatus = false;
    private Vector<ResearchPaper> researchPapers = new Vector<>();
    
    public Student(String password, String firstName, String lastName, int age, int yearOfStudy, Degree degree, School school) {
        super(password, firstName, lastName, age);
        this.yearOfStudy = yearOfStudy;
        this.degree = degree;
        this.school = school;
        this.researchStatus = (degree == Degree.PHD || degree == Degree.MASTER);
        this.setId(this.idGenerator());
    }

    @Override
    public String idGenerator() {
        int currentYear = LocalDate.now().getYear();
        String yearPart = Integer.toString(currentYear - yearOfStudy);
        String degreePart = degree.toString();
        String hashCodePart = Integer.toString(this.hashCode());

        return yearPart + degreePart + hashCodePart;
    }

    // Getter and setter methods
    public Degree getDegree() { 
    	return degree; 
    }
    public void setDegree(Degree degree) { 
    	this.degree = degree; 
    }

    public School getSchool() { 
    	return school; 
    }
    public void setSchool(School school) { 
    	this.school = school; 
    }

    public int getYearOfStudy() { 
    	return yearOfStudy; 
    }
    public void setYearOfStudy(int yearOfStudy) { 
    	this.yearOfStudy = yearOfStudy; 
    }

    public double getGPA() { 
    	return transcript.getTotalGPA();
    }

    public Vector<Course> getmyCourses() { 
    	return courses; 
    }
    
    public Vector<Course> getAllCourses(){
    	return DataBase.getCourses();
    }
    
    public void addCourses(Course course) { 
    	courses.add(course);
    }

    public Organization getOrganization() { 
    	return organization; 
    }
    public void createOrganization(String name) {
    	Organization org = new Organization(this,name);
    	this.organization = org;
    	DataBase.addOrganization(org);
    }
    
    public void joinOrganization(Organization organization) { 
    	this.organization = organization;
    	DataBase.joinOrganization(this, organization);
    }

    public Transcript getTranscript() { 
    	return transcript; 
    }
    public void setTranscript(Transcript transcript) { 
    	this.transcript = transcript; 
    }

    public Journal getJournal() { 
    	return journal; 
    }
    public void setJournal(Journal journal) { 
    	this.journal = journal; 
    }

    public boolean isResearchStatus() { 
    	return researchStatus; 
    }
    public void setResearchStatus(boolean researchStatus) { 
    	this.researchStatus = researchStatus; 
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
    	if(!researchStatus) {
    		return null;
    	}
    	return researchPapers; 
    }
    public void doResearchPapers(ResearchPaper researchPaper) { 
    	if(!researchStatus) {
    		return ;
    	}
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
    
    
    public String viewTeachersInfo(Teacher teacher) {
    	return teacher.viewProfile();
    }
    public void rateTeacher(Teacher teacher, double rate) {
    	teacher.addRate(rate);
    }

    public boolean registerToCourse(Course course) {
        if (transcript == null) {
            transcript = new Transcript();
        }

        if (courses.contains(course)) {
            return false;
        }

        if (transcript.getSemesters().isEmpty()) {
            transcript.addSemester(new Semester());
        }

        if (transcript.getLastSemester().getCredits() + course.getCredits() > 21) {
            return false;
        }

        courses.add(course);
        transcript.getLastSemester().addCourse(course);

        return true;
    }

	public Transcript viewTranscript(Student student) {
		return getTranscript();
	}

	@Override
	public Vector<Course> viewCourses() {
		return courses;
	}



    
    
}

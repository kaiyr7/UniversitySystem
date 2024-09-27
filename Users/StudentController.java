package Users;

package Users;

import java.util.Scanner;
import java.util.Vector;
import Attributes.*;
import Enums.Degree;
import Enums.School;

public class StudentController {

    private final Student student;
    private final Scanner scanner;

    public StudentController(Student student) {
        this.student = student;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
    	DataBase.deserializeData();
        boolean running = true;
        while (running) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. View My Courses\n2. View All Courses\n3. Register to Course\n4. Create Organization\n5. Join Organization\n6. View Journal\n7. View Transcript\n8. View My Info\n9. View Teacher's Info\n10. Rate Teacher\n11. View Research Papers\n12. Log out");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    viewMyCourses();
                    break;
                case 2:
                    viewAllCourses();
                    break;
                case 3:
                    System.out.print("Enter the name of the course to register for: ");
                    String courseName = scanner.nextLine();
                    boolean courseFound = false;

                    Vector<Course> courses = DataBase.getCourses();
                    for (Course course : courses) {
                        if (course.getName().equalsIgnoreCase(courseName)) {
                            courseFound = true;
                            if (student.registerToCourse(course)) {
                                System.out.println("Successfully registered for " + course.getName());
                            } else {
                                System.out.println("Failed to register for the course. You might already be registered.");
                            }
                            break;
                        }
                    }
                    
                    if (!courseFound) {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the organization to create: ");
                    String orgName = scanner.nextLine();
                    createOrganization(orgName);
                    System.out.println("Organization '" + orgName + "' created successfully.");
                    break;
                case 5:
                    System.out.print("Enter the name of the organization to join: ");
                    String orgName1 = scanner.nextLine();
                    DataBase.deserializeData();
                    Vector<Organization> organizations = DataBase.getAllOrganizations();
                    boolean organizationFound = false;
                    DataBase.serializeData();
                    for (Organization organization : organizations) {
                        if (organization.getName().equals(orgName1)) {
                            student.joinOrganization(organization);
                            System.out.println("Successfully joined the organization '" + orgName1 + "'.");
                            organizationFound = true;
                            break;
                        }
                    }
                    
                    break;
                case 6:
                    viewJournal(course);
                    break;
                case 7:
                    viewTranscript();
                    break;
                case 8:
                    viewMyInfo();
                    break;
                case 9:
                    viewTeacherInfo(teacher);
                    break;
                case 10:
                    rateTeacher(teacher,rate);
                    break;
                case 11:
                    viewResearchPapers();
                    break;
                case 12:
                    running = false;
                    System.out.println("Logging out...");
                	DataBase.serializeData();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void viewMyCourses() {
    	DataBase.deserializeData();
        Vector<Course> courses = student.getmyCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            System.out.println("Your Courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
        }
        DataBase.serializeData();
    }


    private void viewAllCourses() {
    	DataBase.deserializeData();
        Vector<Course> courses = DataBase.getCourses();
        for (Course course : courses) {
            System.out.println(course);
        }
        DataBase.serializeData();
    }

    private void registerToCourse(Course course) {
    	DataBase.deserializeData();
        student.registerToCourse(course);
        DataBase.serializeData();
    }

    private void createOrganization(String name) {
    	DataBase.deserializeData();
    	student.createOrganization(name);
    	DataBase.addlogFile(new Operation(student,"CREATE ORG : " + name));
    	DataBase.serializeData();
    }

    private void joinOrganization(Organization organization) {
    	DataBase.deserializeData();
    	student.joinOrganization(organization);
    	DataBase.addlogFile(new Operation(student, student.getUserName() + " JOINED ORGANIZATION: " + organization.getName()));
    	DataBase.serializeData();
    }

    private void viewJournal(Course course) {
        Vector<Mark> courseMarks = student.getJournal().getMarks(course);
        
        if (courseMarks.isEmpty()) {
            System.out.println("No marks available for the course: " + course.getName());
        } else {
            System.out.println("Marks for " + course.getName() + ":");
            for (Mark mark : courseMarks) {
                System.out.println(mark);
            }
        }
    }


    private void viewTranscript() {
        Transcript transcript = student.getTranscript();
        System.out.println(transcript);
    }

    private void viewMyInfo() {
        System.out.println(student.viewProfile());
    }

    private void viewTeacherInfo(Teacher teacher) {
        student.viewTeachersInfo(teacher);
    }

    private void rateTeacher(Teacher teacher, double rate) {
    	student.rateTeacher(teacher, rate);
    }

    private void viewResearchPapers() {
        Vector<ResearchPaper> researchPapers = student.getResearchPapers();
        if(!student.isResearchStatus()) {
        	System.out.println("Student is not a researcher");
        }
        else if (researchPapers == null || researchPapers.isEmpty()) {
            System.out.println("No research papers found for the student.");
        } 
        else {
            System.out.println("Research Papers:");
            for (ResearchPaper paper : researchPapers) {
                System.out.println(paper);
            }
        }
    }

    public static void main(String[] args) {
        // Assuming a student instance is created and passed to the controller
        Student student = new Student("password123", "John", "Doe", 20, 3, Degree.BACHELOR, School.SITE);
        StudentController studentController = new StudentController(student);
        studentController.run();
    }
}

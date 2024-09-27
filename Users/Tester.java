package Users;

import Attributes.Course;
import Attributes.Journal;
import Attributes.Mark;
import Enums.CourseType;
import Enums.Degree;
import Enums.School;
import Enums.TeacherType;
import Users.Student;


public class Tester {

  public static void main(String[] args) {
    Student st = new Student("123","Pakizar","Shamoi", 19, 2,Degree.BACHELOR,School.SITE);
    Course cs = new Course("PP", 4, CourseType.REQUIRED, School.SITE);
    Course cs1 = new Course("Research Methods", 5, CourseType.REQUIRED, School.ISE);
    Teacher tc = new Teacher("2004", "Atshushi", "Tokpanova", 190, TeacherType.TUTOR, School.SITE);
    tc.manageCourse(cs1);
    st.registerToCourse(cs1);
    st.setResearchStatus(true);
    tc.setResearchStatus(true);
    tc.addStudent(cs1, st);
    tc.addStudent(cs1, st);
    Mark mk = new Mark(tc, 7, "s");
    Journal jr = new Journal();
    tc.putMark(cs1, st, mk);
    System.out.println(st);
    System.out.println(st.getAllCourses());
    System.out.println(st.getPasswordHash());
    System.out.println(st.registerToCourse(cs));
    System.out.println(st.registerToCourse(cs1));
    System.out.println(st.getmyCourses());
    System.out.println(tc.getId());
    System.out.println(tc.putMark(cs1, st, mk));
    System.out.println(st.getJournal().getTotal(cs1));
    System.out.println(st.getTranscript().getTotalGPA());
    System.out.println(tc.getHireDate());
    tc.putFirstAttestation(cs1, st, 0);
    tc.putSecondAttestation(cs1, st, 7);
    tc.putFinalExam(cs1, st, 0);
    System.out.println(st.getTranscript().getTotalGPA());
    
  }

}
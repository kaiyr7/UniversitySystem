package Attributes;

import java.io.Serializable;
import java.util.Vector;

public class Transcript implements Serializable {
   private Vector<Semester> semesters = new Vector<>();

   public Vector<Semester> getSemesters() {
      return semesters;
   }

   public void setSemesters(Vector<Semester> semesters) {
      this.semesters = semesters;
   }

   public double getTotalGPA() {
      double totalCreditsGPAProduct = 0.0;
      int totalCredits = 0;

      for (Semester semester : semesters) {
         totalCreditsGPAProduct += semester.getCredits() * semester.getGPA();
         totalCredits += semester.getCredits();
      }

      if (totalCredits == 0) {
         return 0.0;
      }
      
      return totalCreditsGPAProduct / totalCredits;
   }

   public int getTotalCredits() {
      int totalCredits = 0;

      for (Semester semester : semesters) {
         totalCredits += semester.getCredits();
      }

      return totalCredits;
   }
   public Semester getLastSemester() {
	   return semesters.lastElement();

   }
   
   public void addSemester(Semester semester) {
	   semesters.add(semester);

   }
   
   public void addCourse(Course course) {
	   semesters.lastElement().addCourse(course);
   }


}


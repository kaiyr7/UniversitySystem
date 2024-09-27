package Attributes;

import java.io.Serializable;

public class Attestation implements Serializable {
   private Course course;
   private double firstAttestation = 0;
   private double secondAttestation = 0;
   private double finalExam = 0;

   public Attestation(Course course, double firstAttestation, double secondAttestation, double finalExam) {
      this.course = course;
      this.firstAttestation = firstAttestation;
      this.secondAttestation = secondAttestation;
      this.finalExam = finalExam;
   }

   public String toString() {
      return course.getName() + ": " +
             "First att: " + firstAttestation + ", " +
             "Second att: " + secondAttestation + ", " +
             "Final: " + finalExam;
   }

   public double getFirstAttestation() {
      return firstAttestation;
   }

   public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
   }

   public double getSecondAttestation() {
	   
      return secondAttestation;
   }

   public void setSecondAttestation(double secondAttestation) {
      this.secondAttestation = secondAttestation;
   }

   public double getFinalExam() {
      return finalExam;
   }

   public void setFinalExam(double finalExam) {
      this.finalExam = finalExam;
   }

   public Course getCourse() {
      return course;
   }

   public void setCourse(Course course) {
      this.course = course;
   }

   public double getGPA() {
	   double totalScore = firstAttestation + secondAttestation + finalExam;
	    if (totalScore > 95.0) {
	        return 4.0;
	    }
	    if (totalScore > 90.0) {
	        return 3.67;
	    }
	    if (totalScore > 85.0) {
	        return 3.33;
	    }
	    if (totalScore > 80.0) {
	        return 3.0;
	    }
	    if (totalScore > 75.0) {
	        return 2.67;
	    }
	    if (totalScore > 70.0) {
	        return 2.33;
	    }
	    if (totalScore > 65.0) {
	        return 2.0;
	    }
	    if (totalScore > 60.0) {
	        return 1.67;
	    }
	    if (totalScore > 55.0) {
	        return 1.33;
	    }
	    if (totalScore > 50.0) {
	        return 1.0;
	    }
	    
	    return 0.0;
	}

   
}

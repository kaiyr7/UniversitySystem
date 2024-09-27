package Attributes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Semester implements Serializable {
   private HashMap<Course, Attestation> attestations = new HashMap<>();
   private int credits = 0;
   
   public Semester() {
	   
   }

   public int getCredits() {
	   return credits;
   }
   
   public void addCredits(int credits) {
	   this.credits += credits;
	   
   }   
	public void addCourse(Course course) {
	    attestations.putIfAbsent(course, new Attestation(course, 0, 0, 0));
	    addCredits(course.getCredits());
	}
	public double getGPA() {
        double totalGradePoints = 0;

        for (Map.Entry<Course, Attestation> entry : attestations.entrySet()) {
            Course course = entry.getKey();
            Attestation attestation = entry.getValue();
            double courseGPA = attestation.getGPA();
            totalGradePoints += courseGPA * course.getCredits();
        }
        if (credits == 0) {
            return 0;
        }

        return totalGradePoints / credits;
    }
	
	
    public Attestation getAttestation(Course course) {
        return attestations.get(course);
    }
    
    
}

package Attributes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class Journal implements Serializable {
   private HashMap<Course, Vector<Mark>> marks = new HashMap<>();
   
   public void addMark(Course course, Mark mark) {
       Vector<Mark> courseMarks = marks.get(course);

       if (courseMarks == null) {
           courseMarks = new Vector<>();
           marks.put(course, courseMarks);
       }
       
       courseMarks.add(mark);
   }
   
   public void addCourse(Course course) {
	   
   }
   
   public double getTotal(Course course) {
      double total = 0.0D;

      for (Map.Entry<Course, Vector<Mark>> entry : marks.entrySet()) {
         Course c = entry.getKey();
         if (c.getName().equals(course.getName())) {
            Vector<Mark> courseMarks = entry.getValue();
            for (Mark mark : courseMarks) {
               total += mark.getMark();
            }
            break;
         }
      }

      return total;
   }
   public Vector<Mark> getMarks(Course course) {
	   return marks.get(course);
	}

   public void clear() {
      marks.clear();
   }
}

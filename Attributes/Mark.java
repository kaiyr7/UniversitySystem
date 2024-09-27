package Attributes;

import java.io.Serializable;
import java.util.GregorianCalendar;
import Users.Teacher;

public class Mark implements Serializable {
   private Teacher teacher;
   private double mark;
   private String description;
   private GregorianCalendar date;
   private final String[] monthNames = new String[]{
      "Jan", "Feb", "Mar", "Apr", "May", "Jun",
      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
   };

   public Mark() {
   }

   public Mark(Teacher teacher, double mark, String description) {
      this.teacher = teacher;
      this.mark = mark;
      this.date = new GregorianCalendar();
      this.description = description;
   }

   public double getMark() {
      return mark;
   }

   public void setMark(double mark) {
      this.mark = mark;
   }

   public GregorianCalendar getDate() {
      return date;
   }

   public void setDate(GregorianCalendar date) {
      this.date = date;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Teacher getTeacher() {
      return teacher;
   }

   public void setTeacher(Teacher teacher) {
      this.teacher = teacher;
   }

   @Override
   public String toString() {
      int year = date.get(GregorianCalendar.YEAR);
      int month = date.get(GregorianCalendar.MONTH);
      int day = date.get(GregorianCalendar.DAY_OF_MONTH);

      return "Mark = " + mark + ", description = " + description +
             ", date = " + monthNames[month] + " " + day + ", " + year +
             ", by " + teacher.getLastName();
   }
}

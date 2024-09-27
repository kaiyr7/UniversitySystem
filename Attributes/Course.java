package Attributes;

import Enums.School;
import Enums.CourseType;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class Course implements Serializable {
    private final String name;
    private int credits;
    private CourseType type;
    private School school;

    public Course(String name, int credits, CourseType type, School school) {
        this.name = name;
        this.credits = credits;
        this.type = type;
        this.school = school;
    }

    public Course(Course course) {
        this.name = course.getName();
        this.credits = course.getCredits();
        this.type = course.getType();
        this.school = course.getSchool();
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public CourseType getType() {
        return this.type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public School getSchool() {
        return this.school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    public String getName() {
        return this.name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course other = (Course) o;
        return this.credits == other.credits && this.school == other.school && Objects.equals(this.name, other.name) &&
        this.type == other.type;
    }

    public int hashCode() {
        return Objects.hash(this.credits, this.school, this.name, this.type);
    }

    @Override
    public Course clone() throws CloneNotSupportedException {
        return (Course) super.clone();
    }
    
    public String toString() {
        return this.name + ": Credits number: " + this.credits + ", Type: " + this.type + ", School: " + this.school;
    }
}


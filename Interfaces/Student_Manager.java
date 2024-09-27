package Interfaces;
import Attributes.Transcript;
import Users.Student;
import Users.Teacher;

public interface Student_Manager {
	Transcript viewTranscript(Student student);
    String viewTeachersInfo(Teacher teacher);
}

package Users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Vector;

import Attributes.DataBase;
import Attributes.Message;
import Attributes.Request;

public abstract class Employee extends User implements Cloneable, Serializable{
	private LocalDate hireDate = LocalDate.now();
    private Vector<Message> messages = new Vector<>();

    public Employee(String password, String firstName, String lastName, int age) {
        super(password, firstName, lastName, age);
        this.setId(this.idGenerator());
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String idGenerator() {
        String year = String.valueOf(hireDate.getYear());
        return  year + "EMP" + hashCode();
    }

    public Vector<Message> getMessages() {
        return messages;
    }

    public void viewStudentInfo(Student student) {
        System.out.println(student.toString());
    }

    public void sendMessage(Employee e, Message m) {
        e.getMessages().add(m);
    }

    public void sendRequest(Request request) {
        DataBase.addRequest(request);
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Employee e = (Employee) o;
        return this.hireDate.equals(e.hireDate) && this.messages.equals(e.messages);
    }

    public int hashCode() {
        return super.hashCode() + Objects.hash(hireDate);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return super.toString() + "\n-\n" + "Hire date: " + hireDate;
    }
}

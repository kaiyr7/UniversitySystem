package Attributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import Users.Student;

public class Organization implements Comparable<Organization>{
	Student head;
	Vector<Student> members = new Vector<>();
	String name;
	public Organization() {
		
	}
	
	public Organization(Student head, String name) {
		this.head = head;
		this.name = name;
	}
	public boolean addMember(Student student) {
		return members.add(student);
	}
	public Student getHead() {
		return head;
	}

	public void setHead(Student head) {
		this.head = head;
	}

	public Vector<Student> getMembers() {
		return members;
	}

	public void setMembers(Vector<Student> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(head, members, name);
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Organization other = (Organization) obj;
        return Objects.equals(name, other.name) &&
               Objects.equals(head, other.head) &&
               Objects.equals(members, other.members);
    }

	@Override
	public String toString() {
	    // Extract student names from the members vector
	    List<String> memberNames = new ArrayList<>();
	    for (Student student : members) {
	        memberNames.add(student.getFirstName()); // Assuming getFirstName() returns the name.
	    }

	    // Join the member names with a comma and space delimiter
	    String membersString = String.join(", ", memberNames);

	    // Create the final string representation
	    return "Head " + head.getFirstName() + " Members: " + membersString + " Name:" + name;
	}


	@Override
	public int compareTo(Organization organization) {
		if(members.size() < organization.members.size()) {
			return -1;
		}
		if(members.size() > organization.members.size()) {
			return 1;
		}
		return 0;
	}
}

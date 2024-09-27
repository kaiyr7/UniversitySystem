package Users;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import Attributes.DataBase;
import Attributes.News;
import Attributes.ResearchProject;

public abstract class User implements Cloneable, Comparable<User>, Serializable {
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
    private int age;
    private boolean status = true;
    private boolean journalsubscription = false;

    public User() {}

    public User(String password, String firstName, String lastName, int age) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = firstName.substring(0, 1).toLowerCase() + "_" + lastName.toLowerCase();
    }

    public abstract String idGenerator();
    
    public String getUserName() {
    	return username;
    }

    public void setUserName(String username) {
    	this.username = username;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public int getPasswordHash() {
        return Objects.hash(password);
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isJournalsubscription() {
        return journalsubscription;
    }

    public void subscribeJournal() {
        this.journalsubscription = true;
    }

    public void unsubscribeJournal() {
        this.journalsubscription = false;
    }

    public Vector<News> seeNews() {
        return DataBase.getAllNews();
    }

    public Vector<ResearchProject> seeJournal() {
        if (journalsubscription) {
            return DataBase.getAllResearchProjects();
        }
        return new Vector<>();
    }

    public String viewProfile() {
        return "User ID: " + id + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nAge: " + age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int compareTo(User other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "User{" +
               "ID='" + id + '\'' +
               ", First Name='" + firstName + '\'' +
               ", Last Name='" + lastName + '\'' +
               ", Age=" + age +
               ", Status=" + status +
               ", Journal Subscription=" + journalsubscription +
               '}';
    }
}


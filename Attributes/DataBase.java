package Attributes;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import Users.Teacher;
import Users.TechSupportSpecialist;
import Enums.UserType;
import Users.Student;
import Users.User;
import Users.Admin;
import Users.Manager;
import Users.Rector;

public class DataBase {
	private static HashSet<Course> courses = new HashSet<>();
    private static Vector<ResearchProject> researchJournal = new Vector<>();
    private static Vector<News> news = new Vector<>();
    private static HashMap<UserType, HashSet<User>> users = new HashMap<>();
    private static Vector<Request> requests = new Vector<>();
    private static Vector<Operation> logFiles = new Vector<>();
    private static Vector<Organization> organizations = new Vector<>();
    {
        deserializeCourses();
        deserializeNews();
        deserializeUsers();
        deserializeLogFiles();
        deserializeRequests();
        deserializeResearchJournal();
        deserializeOrganizations();
    }
    // Existing serialization and deserialization methods for courses
    public static void serializeCourses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("courses.ser"))) {
            oos.writeObject(courses);
            oos.close();
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialization method for courses
    public static void deserializeCourses() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("courses.ser"))) {
            courses = (HashSet<Course>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void serializeOrganizations() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("organizations.ser"))) {
            oos.writeObject(organizations);
            oos.close();
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialization method for organizations
    public static void deserializeOrganizations() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("organizations.ser"))) {
            organizations = (Vector<Organization>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    // Serialization and Deserialization for ResearchJournal
    public static void serializeResearchJournal() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("researchJournal.ser"))) {
            oos.writeObject(researchJournal);
            oos.close();
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeResearchJournal() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("researchJournal.ser"))) {
            researchJournal = (Vector<ResearchProject>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Serialization and Deserialization for News
    public static void serializeNews() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("news.ser"))) {
            oos.writeObject(news);
            oos.close();
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeNews() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("news.ser"))) {
            news = (Vector<News>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Serialization and Deserialization for Users
    public static void serializeUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.ser"))) {
            oos.writeObject(users);
            oos.close();
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.ser"))) {
            users = (HashMap<UserType, HashSet<User>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Serialization and Deserialization for Requests
    public static void serializeRequests() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("requests.ser"))) {
            oos.writeObject(requests);
            oos.close();
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeRequests() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("requests.ser"))) {
            requests = (Vector<Request>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void serializeLogFiles() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("logFiles.ser"))) {
            oos.writeObject(logFiles);
             oos.close();
             oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeLogFiles() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("logFiles.ser"))) {
            logFiles = (Vector<Operation>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //USER
    public static boolean deleteUser(User user) {
        for (HashSet<User> userSet : users.values()) {
            if (userSet.contains(user)) {
                userSet.remove(user);
                return true;
            }
        }
        return false;
    }

    public static Vector<User> getUsers() {
        Vector<User> allUsers = new Vector<>();
        for (HashSet<User> userSet : users.values()) {
            allUsers.addAll(userSet);
        }
        return allUsers;
    }

    public static boolean addUser(User user, UserType userType) {
        HashSet<User> userSet = users.get(userType);
        if (userSet == null) {
            userSet = new HashSet<>();
            users.put(userType, userSet);
        }
        if (userSet.contains(user)) {
            return false;
        }
        userSet.add(user);
        return true;
    }
    
    public static void blockUser(User user) {
        boolean userExists = getUsers().contains(user);
        if (userExists) {
            user.setStatus(false);
        }
    }
    public static void updatePassword(User user, String newPassword) {
        if (user != null && newPassword != null && !newPassword.isEmpty()) {
            user.setPassword(newPassword);
        }
    }
    
    //COURSE
    public static Vector<Course> getCourses() {
        return new Vector<>(courses);
    }
    
    public static void addCourse(Course course) {
        if (course != null) {
            courses.add(course);
        }
    }
    
	public static void printCourses(){
	  for(var el: courses){
	      System.out.println(el);
	  	}
	}
    
    
    //RESEARCHPAPERS
    public static Vector<ResearchProject> getAllResearchProjects() {
        return researchJournal;
    }
    
    public static void addResearchProject(ResearchProject researchProject) {
        if (researchProject != null) {
            researchJournal.add(researchProject);
        }
    }
    
    
    //NEWS
    public static Vector<News> getAllNews() {
        return news;
    }

    public static void addNews(News newsItem) {
        if (newsItem != null) {
            news.add(newsItem);
        }
    }
    
    
    
    //LOG FILES
    public static Vector<Operation> getlogFiles(){
    	return logFiles;
    }

    public static void addlogFile(Operation e){
        logFiles.add(e);
    }
    
    
    //REQUESTS
    public static Vector<Request> getAllRequests() {
        return requests;
    }

    public static void addRequest(Request request) {
        if (request != null) {
            requests.add(request);
        }
    }
    
    //ORGANIZATIONS
    public static Vector<Organization> getAllOrganizations() {
        return organizations;
    }

    public static void addOrganization(Organization organization) {
        if (organization != null) {
            organizations.add(organization);
        }
    }

    public static boolean joinOrganization(Student student, Organization organization) {
        if (organization != null && student != null) {
            return organization.addMember(student);
        }
        return false;
    }
    
    
    //STUDENTS
    public static Vector<Student> getAllStudents() {
        Vector<Student> students = new Vector<>();
        HashSet<User> userSet = users.get(UserType.STUDENT);

        if (userSet != null) {
            for (User user : userSet) {
                if (user instanceof Student) {
                    students.add((Student) user);
                }
            }
        }

        return students;
    }

    //TEACHERS
    public static Vector<Teacher> getTeachers() {
        Vector<Teacher> teachers = new Vector<>();
        HashSet<User> userSet = users.get(UserType.TEACHER);

        if (userSet != null) {
            for (User user : userSet) {
                if (user instanceof Teacher) {
                    teachers.add((Teacher) user);
                }
            }
        }

        return teachers;
    }
    
    
    //MANAGERS
    public static Vector<Manager> getManagers() {
        Vector<Manager> managers = new Vector<>();
        HashSet<User> userSet = users.get(UserType.MANAGER);

        if (userSet != null) {
            for (User user : userSet) {
                if (user instanceof Manager) {
                    managers.add((Manager) user);
                }
            }
        }

        return managers;
    }
    
    
    public static Vector<TechSupportSpecialist> getTechSupportSpecialists() {
        Vector<TechSupportSpecialist> techSupportSpecialists = new Vector<>();
        HashSet<User> userSet = users.get(UserType.TECHSUPPORTSPECIALIST);

        if (userSet != null) {
            for (User user : userSet) {
                if (user instanceof TechSupportSpecialist) {
                    techSupportSpecialists.add((TechSupportSpecialist) user);
                }
            }
        }

        return techSupportSpecialists;
    }
    
    
    public static Rector getRector() {
        HashSet<User> userSet = users.get(UserType.RECTOR);
        if (userSet != null && !userSet.isEmpty()) {
            for (User user : userSet) {
                if (user instanceof Rector) {
                    return (Rector) user;
                }
            }
        }
        return null;
    }
    
    public static Admin getAdmin() {
        HashSet<User> userSet = users.get(UserType.ADMIN);
        if (userSet != null && !userSet.isEmpty()) {
            for (User user : userSet) {
                if (user instanceof Admin) {
                    return (Admin) user;
                }
            }
        }
        return null;
    }

    public static void deserializeData() {
        deserializeCourses();
        deserializeNews();
        deserializeUsers();
        deserializeLogFiles();
        deserializeRequests();
        deserializeResearchJournal();
        deserializeOrganizations();
    }
    
    public static void serializeData() {
        serializeCourses();
        serializeNews();
        serializeUsers();
        serializeLogFiles();
        serializeRequests();
        serializeResearchJournal();
        serializeOrganizations();
    }
    
    
}

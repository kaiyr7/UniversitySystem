package Users;

import java.util.Vector;

import Attributes.*;
import Enums.*;
import Users.*;

public class TEST {

    public static void main(String[] args) {
    	DataBase.deserializeCourses();
        DataBase.deserializeNews();
        DataBase.deserializeUsers();
        DataBase.deserializeLogFiles();
        DataBase.deserializeRequests();
        DataBase.deserializeResearchJournal();
        DataBase.deserializeOrganizations();
        
        
    		Admin admin = Admin.getInstance();
        Rector rector = Rector.getInstance();
        DataBase.addUser(rector, UserType.RECTOR);
        DataBase.addUser(admin, UserType.ADMIN);
        DataBase.addUser(new Student("123","Kaiyrzhan","Seitkarim", 19, 2,Degree.BACHELOR,School.SITE), UserType.STUDENT);
        DataBase.serializeCourses();
        DataBase.serializeUsers();
        DataBase.serializeRequests();
        DataBase.serializeNews();
        DataBase.serializeResearchJournal();
        DataBase.serializeOrganizations();
        DataBase.serializeLogFiles();
    	DataBase.deserializeData();
        Vector<User> users = DataBase.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}

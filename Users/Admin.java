package Users;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import Attributes.Request;
import Attributes.DataBase;
import Attributes.Operation;
import Enums.UserType;

public final class Admin extends User implements Cloneable, Serializable {
    private static Admin instance = null;

    private Admin(String password, String firstName, String lastName, int age) {
        super(password, firstName, lastName, age);
        this.setId(this.idGenerator());
        this.setUserName("ADMIN");
    }

    public static synchronized Admin getInstance() {
        if (instance == null) {
            instance = new Admin("ADMIN", "ADMIN", "ADMIN", 0);
        }
        return instance;
    }
    
    public Vector<Operation> getLogFiles() {
        return DataBase.getlogFiles();
    }

    public void addLogFiles(Operation operation) {
        DataBase.addlogFile(operation);
    }

    public void addUser(User user) {
        if (user instanceof Student) {
            DataBase.addUser(user, UserType.STUDENT);
        } else if (user instanceof Teacher) {
            DataBase.addUser(user, UserType.TEACHER);
        }
    }

    public void updatePassword(User user, String newPassword) {
        DataBase.updatePassword(user, newPassword);
    }

    public void removeUser(User user) {
        DataBase.deleteUser(user);
    }

    public void blockUser(User user) {
        DataBase.blockUser(user);
    }

    @Override
    public String idGenerator() {
        return "ADMIN";
    }

	public boolean equals(Object obj) {
	    return super.equals(obj);
	}

	public int hashCode() {
	    return super.hashCode();
	}

	
	protected Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}

package Users;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Attributes.*;
import Enums.Degree;
import Enums.ManagerType;
import Enums.School;
import Enums.TeacherType;
import Enums.UserType;

public class AdminController {

    private BufferedReader reader;
    private Scanner scanner;

    public AdminController() {
    	this.scanner = new Scanner(System.in);
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;
        menuLoop:
        while (running) {
            System.out.println("Admin Menu:");
            System.out.println("1. View Users\n2. Add User\n3. Remove User\n4. Block User\n5. Change User Password\n6. View Courses\n7. Add Course\n8. View News\n9. Add News\n10. View Log Files\n11. View Requests\n12. Manage Organizations\n13. View Research Projects\n14. Log out");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    viewUsers();
                    break;
                case 2:
                    System.out.println("Enter first name: ");
                    String fmInput = reader.readLine();
                    String fm = fmInput;
                    System.out.println("Enter last name: ");
                    String lmInput = reader.readLine();
                    String lm = lmInput;
                    System.out.println("Enter password: ");
                    String passInput = reader.readLine();
                    String pass = passInput;
                    System.out.println("Enter age: ");
                    int ageInput = Integer.parseInt(reader.readLine());
                    int age = ageInput;
                    System.out.println("Which type of user do you want to add?");
                    String userTypeInp = reader.readLine();
                    String chosUserType = userTypeInp;
                    UserType userType = UserType.valueOf(chosUserType);
                    User user = null;
                    if(userType == UserType.MANAGER) {
                    	userType = UserType.MANAGER;
                    	System.out.println("What type of manager?");
                    	String managerTypeInp = reader.readLine();
                    	String chosManagType = managerTypeInp;
                    	ManagerType managerType = ManagerType.valueOf(chosManagType);
                    	if(managerType == ManagerType.OR) {
                    		managerType = ManagerType.OR;
                    		user = new Manager(pass, fm, lm, age, managerType);
                    	} else if(managerType == ManagerType.DEPARTMENT) {
                    		managerType = ManagerType.DEPARTMENT;
                    		user = new Manager(pass, fm, lm, age, managerType);
                    	}
                    } else if(userType == UserType.TEACHER) {
                    	userType = UserType.TEACHER;
                    	System.out.println("What type of teacher?");
                    	String teachTypeInp = reader.readLine();
                    	String chosTeachType = teachTypeInp;
                    	TeacherType teacherType = TeacherType.valueOf(chosTeachType);
                    	if(teacherType == TeacherType.LECTOR) {
                    		teacherType = TeacherType.LECTOR;
                    		System.out.println("What type of school?");
                    		String schTypeInp = reader.readLine();
                    		String chosSchType = schTypeInp;
                    		School school = School.valueOf(chosSchType);
                    		if(school == School.BS) {
                    			school = School.BS;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.ISE) {
                    			school = School.ISE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.KMA) {
                    			school = School.KMA;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SAM) {
                    			school = School.SAM;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SCE) {
                    			school = School.SCE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SG) {
                    			school = School.SG;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SITE) {
                    			school = School.SITE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		}
                    	} else if(teacherType == TeacherType.PROFESSOR) {
                    		teacherType = TeacherType.PROFESSOR;
                    		System.out.println("What type of school?");
                    		String schTypeInp = reader.readLine();
                    		String chosSchType = schTypeInp;
                    		School school = School.valueOf(chosSchType);
                    		if(school == School.BS) {
                    			school = School.BS;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.ISE) {
                    			school = School.ISE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.KMA) {
                    			school = School.KMA;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SAM) {
                    			school = School.SAM;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SCE) {
                    			school = School.SCE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SG) {
                    			school = School.SG;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SITE) {
                    			school = School.SITE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		}
                    	} else if(teacherType == TeacherType.SENIOR_LECTOR) {
                    		teacherType = TeacherType.SENIOR_LECTOR;
                    		System.out.println("What type of school?");
                    		String schTypeInp = reader.readLine();
                    		String chosSchType = schTypeInp;
                    		School school = School.valueOf(chosSchType);
                    		if(school == School.BS) {
                    			school = School.BS;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.ISE) {
                    			school = School.ISE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.KMA) {
                    			school = School.KMA;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SAM) {
                    			school = School.SAM;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SCE) {
                    			school = School.SCE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SG) {
                    			school = School.SG;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SITE) {
                    			school = School.SITE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		}
                    	} else if(teacherType == TeacherType.TUTOR) {
                    		teacherType = TeacherType.TUTOR;
                    		System.out.println("What type of school?");
                    		String schTypeInp = reader.readLine();
                    		String chosSchType = schTypeInp;
                    		School school = School.valueOf(chosSchType);
                    		if(school == School.BS) {
                    			school = School.BS;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.ISE) {
                    			school = School.ISE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.KMA) {
                    			school = School.KMA;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SAM) {
                    			school = School.SAM;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SCE) {
                    			school = School.SCE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SG) {
                    			school = School.SG;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		} else if(school == School.SITE) {
                    			school = School.SITE;
                    			user = new Teacher(pass, fm, lm, age, teacherType, school);
                    		}
                    	}
                    } else if(userType == UserType.STUDENT) {
                    	userType = UserType.STUDENT;
                    	System.out.println("What year of study?");
                    	int yosInp = Integer.parseInt(reader.readLine());
                    	int yos = yosInp;
                    	System.out.println("What degree?");
                		String degInp = reader.readLine();
                		String chosDeg = degInp;
                		Degree degree = Degree.valueOf(chosDeg);
                		if(degree == Degree.BACHELOR) {
                			degree = Degree.BACHELOR;
                    		System.out.println("What type of school?");		
                    		String schTypeInp = reader.readLine();
                    		String chosSchType = schTypeInp;
                    		School school = School.valueOf(chosSchType);
                    		if(school == School.BS) {
                    			school = School.BS;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.ISE) {
                    			school = School.ISE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.KMA) {
                    			school = School.KMA;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SAM) {
                    			school = School.SAM;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SCE) {
                    			school = School.SCE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SG) {
                    			school = School.SG;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SITE) {
                    			school = School.SITE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		}
                		} else if(degree == Degree.MASTER) {
                			degree = Degree.MASTER;
                    		System.out.println("What type of school?");
                    		String schTypeInp = reader.readLine();
                    		String chosSchType = schTypeInp;
                    		School school = School.valueOf(chosSchType);
                    		if(school == School.BS) {
                    			school = School.BS;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.ISE) {
                    			school = School.ISE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.KMA) {
                    			school = School.KMA;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SAM) {
                    			school = School.SAM;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SCE) {
                    			school = School.SCE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SG) {
                    			school = School.SG;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SITE) {
                    			school = School.SITE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		}
                		} else if(degree == Degree.PHD) {
                			degree = Degree.PHD;
                    		System.out.println("What type of school?");
                    		String schTypeInp = reader.readLine();
                    		String chosSchType = schTypeInp;
                    		School school = School.valueOf(chosSchType);
                    		if(school == School.BS) {
                    			school = School.BS;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.ISE) {
                    			school = School.ISE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.KMA) {
                    			school = School.KMA;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SAM) {
                    			school = School.SAM;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SCE) {
                    			school = School.SCE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SG) {
                    			school = School.SG;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		} else if(school == School.SITE) {
                    			school = School.SITE;
                    			user = new Student(pass, fm, lm, age, yos, degree, school);
                    		}
                		}
                    	
                    } else if(userType == UserType.RESEARCHER) {
                    	userType = UserType.RESEARCHER;
                    	user = new Researcher(pass, fm, lm, age);
                    } else if(userType == UserType.TECHSUPPORTSPECIALIST) {
                    	userType = UserType.TECHSUPPORTSPECIALIST;
                    	user = new TechSupportSpecialist(pass,fm,lm,age);
                    }
                    addUser(user, userType);
                    
                    
                    break;
                case 3:
                	System.out.println("Enter the usernameo of a user whose password you want to update:");
                	String username = reader.readLine();
                	System.out.println("Enter new password:");
                	String newPass = reader.readLine();
                	if(!updatePassword(username, newPass)) {
                		System.out.println("Failed to update password");
                	} else {
                		updatePassword(username, newPass);
                	}
                	continue menuLoop;
                case 4:
                	System.out.println("Enter the username of a user you want to remove:");
                	String remUsername = reader.readLine();
                	if(!removeUser(remUsername)) {
                		System.out.println("Couldn't remove user");
                	} else {
                		removeUser(remUsername);
                	}
                	continue menuLoop;
                case 5:
                	System.out.println("Enter the username of a user you want to block");
                	String blockUsername = reader.readLine();
                	if(!block(blockUsername)) {
                		System.out.println("You couldn't block the user");
                	} else {
                		block(blockUsername);
                	}
                	continue menuLoop;
                case 6:
                	seeLogFiles();
                case 14:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void viewUsers() {
      DataBase.deserializeData();
      
        Vector<User> users = DataBase.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        DataBase.serializeData();
    }

    private void addUser(User user, UserType type) {
      DataBase.deserializeData();
      DataBase.addUser(user, type);
      DataBase.addlogFile(new Operation(Admin.getInstance(),"ADDED USER : " + user.getUserName()));
      DataBase.serializeData();
    }
    
    private boolean updatePassword(String username, String password) {
      DataBase.deserializeData();
      Vector<User> users = DataBase.getUsers();
      for(User user : users) {
        if(user.getUserName().equals(username)) {
          user.setPassword(password);
          DataBase.addlogFile(new Operation(Admin.getInstance(),"UPD USER PASSWORD : " + user.getUserName()));
          return true;
        }
      }
      DataBase.serializeData();
      return false;
    }
    private boolean removeUser(String username) {
      DataBase.deserializeData();
      Vector<User> users = DataBase.getUsers();
      for(User user : users) {
        if(user.getUserName().equals(username)) {
          DataBase.deleteUser(user);
          DataBase.addlogFile(new Operation(Admin.getInstance(),"DLT USER : " + user.getUserName()));
          return true;
        }
      }
      DataBase.serializeData();
      return false;
    }
    private boolean block(String username) {
      DataBase.deserializeData();
      Vector<User> users = DataBase.getUsers();
      for(User user : users) {
        if(user.getUserName().equals(username)) {
          user.setStatus(false);
          DataBase.addlogFile(new Operation(Admin.getInstance(),"BLOCK USER : " + user.getUserName()));
          return true;
        }
      }
      DataBase.serializeData();
      return false;
    }
    private void seeLogFiles() {
      DataBase.deserializeData();
      
        Vector<Operation> operations = DataBase.getlogFiles();
        for (Operation operation : operations) {
            System.out.println(operation);
        }
        DataBase.serializeData();
    }

    public static void main(String[] args) throws IOException {
        AdminController adminController = new AdminController();
        adminController.run();
    }
}


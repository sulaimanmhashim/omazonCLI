import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Product product = new Product("Test","Description", 50.5, 2500, 0);
        Product.SaveToFile(product);
        User activeUser = greetingscreen();
        System.out.println(activeUser.getUsername()+" is logged in.");
    }
    public static User greetingscreen(){
        Scanner s = new Scanner(System.in);
        User blankUser = new User("Guest","Guest", "Guest");
        System.out.println("\t\t\t\t============================================");
        System.out.println("\t\t\t\t Welcome user! Please login or register");
        System.out.println("\t\t\t\t 1. Login");
        System.out.println("\t\t\t\t 2. Register");
        System.out.println("\t\t\t\t Press any other key to quit.");
        System.out.println("\t\t\t\t============================================");
        if(s.next().equals("1")){
            return login();
        } else if(s.next().equals("2")){
            register();
        }else{

        }
        return blankUser;
    }
    public static User login(){
        String username;
        String password;
        Scanner s = new Scanner(System.in);
        User blankUser = new User("Blank","blank", "blankk");
        System.out.println("\t\t\t\t**==============================================================**");
        System.out.println("\t\t\t\t Welcome user! Please enter your username and then password");
        System.out.println("\t\t\t\t**==============================================================**");
        username = s.next();
        password = s.next();
        File folder = new File("C:\\Testu\\USERNAMES");
        for(File fileEntry : folder.listFiles()){
            User u = (User) User.ReadFromFile(fileEntry.getAbsolutePath());
            if(username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                    return u;
            }else{
                System.out.println("Wrong username or password!");
            }

        }
    return blankUser;

    }
    public static void register(){
        Scanner s = new Scanner(System.in);
        System.out.println("\t\t\t\t**==========================================================================**");
        System.out.println("\t\t\t\t Welcome user! Please enter your username, password, and email to register!");
        System.out.println("\t\t\t\t**==========================================================================**");
        String username;
        String password;
        String email;
        System.out.println("Please enter your username: ");
        username = s.next();
        System.out.println("Please enter your password: ");
        password = s.next();
        System.out.println("Please enter your email: ");
        email = s.next();

        User user = new User(username, password, email);
        User.SaveToFile(user);




    }
}

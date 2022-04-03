package Service;

import exception.Validate;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    static Scanner sc = new Scanner(System.in);


    public User getUserFromPhonenumber(ArrayList<User> users , String phoneNumber){
        User user = null;
        for (User u : users){
            if (u.getPhoneNumber().equals(phoneNumber)){
                user = u;
                break;

            }
        }
        return user;
    }

    public String getUserIdFromPhoneNumber(String phoneNumber,ArrayList<User> users){
        String id="";
        for (User u: users){
            if (u.getPhoneNumber().equals(phoneNumber)){
                id=u.getId();
                break;
            }
        }
        return id;
    }

    public String passwordInput(){
        String password="";
        boolean isContinue=false;
        while (!isContinue){
            password= sc.nextLine();
            if(Validate.isLength(password.length()) && Validate.isContainUppercase(password) && Validate.isSpecialCharacter(password)){
                isContinue=true;
            }
            else {
                System.out.println("Password từ 6 đến 15 ký tự, chứa ký tự in hoa và đặc biệt");
            }
        }
        return password;
    }

}

package exception;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    static Scanner sc = new Scanner(System.in);
    public static int inputNumber(){
        int number=0;
        boolean isContinue=true;
        while (isContinue){
            try {
                number = Integer.parseInt(sc.nextLine());
                isContinue = false;
            } catch (NumberFormatException e){
                System.out.println("vui lòng nhập số");
            }
        }
        return number;
    }

    public static String isPhoneNumber(){
        String PHONE_PATTERN =
                "^0+\\d{9}$";
        String phoneNumber="";
        boolean isContinue=true;
        while (isContinue){
            phoneNumber= sc.nextLine();
            if (!Pattern.matches(PHONE_PATTERN,phoneNumber)){
                System.out.println("Số điện thoại không hợp lệ");
            }
            else {
                isContinue=false;
            }
        }
        return phoneNumber;
    }
    // mk
    public static boolean isLength(int length){
        return  (length<=15&&length>6);
    }

    public static boolean isContainUppercase(String password){
        boolean isFound=false;
        for (int i=0;i<password.length();i++){
            if (Character.isUpperCase(password.charAt(i))){
                isFound=true;
                break;
            }
        }
        return isFound;
    }

    public static boolean isSpecialCharacter(String password){
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        return b;
    }
}

package controller;

import Service.Data;
import Service.UserService;
import exception.Validate;
import model.AccountTransfers;
import model.TransactionHistory;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Scanner sc = new Scanner(System.in);

    static Data data = new Data();
    static ArrayList<User> users = data.getAllUser();
    static ArrayList<AccountTransfers> accountTransfers= data.getAllAccountTransfers();
    static User activeUser = new User("", "", "", "", 0);
    static ArrayList<TransactionHistory> transactionHistory = new ArrayList<>();
    static UserService userService = new UserService();


    public static void login(){
        System.out.println("xin chào, để giao dịch vui lòng đăng nhập " );
        System.out.println("1- đăng nhập");
        System.out.println("0- thoát chương trình");
    }

    public static void program(){
        boolean isCheck=true;
        while (isCheck){
            login();
            int x= Validate.inputNumber();

            switch (x){
                case 1:
                    System.out.println("nhập số điện thoại");
                    String phoneNumber= Validate.isPhoneNumber();
                    System.out.println("Nhập password");
                    String password= sc.nextLine();
                    int found=0;
                    for (User u : users){
                        if (u.getPhoneNumber().equals(phoneNumber) && u.getPassword().equals(password) ){
                            found++;
                        }
                    }
                    if (found >0){
                        isCheck= false;
                        activeUser = userService.getUserFromPhonenumber(users, phoneNumber);
                        userProgram();
                    }
                    else {
                        System.out.println("Số điện thoại hoặc mật khẩu không đúng");
                        forgetPasswordProgram();
                    }
                    break;
                case 0:
                    System.out.println("tạm biệt");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;

            }
        }
    }


    public static void userMenu(){
        System.out.println("xin chào " + activeUser.getPhoneNumber()+ " - số tk" + activeUser.getAccount());
        System.out.println("bạn có thể thực hiện");
        System.out.println("1- truy vấn số dư tài khoản");
        System.out.println("2- chuyển tiền");
        System.out.println("3- xem lịch sử dao dịch ");
        System.out.println("0- thoát chương trình");
    }

    public static void userProgram(){
        boolean isCheck=true;
        while (isCheck){
            userMenu();
            int x=Validate.inputNumber();
            switch (x){
                case 1:
                    System.out.println(
                            "tài khoản" + activeUser.getAccount() + " của bạn"+ " có số dư hiện tại"+ activeUser.getBalance());
                    break;
                case 2:
                    System.out.println("chuyển tiền");
                    System.out.println("nhập tài khoản người nhận");
                    String account = sc.nextLine();
                    System.out.println("nhập nội dung chuyển tiền");
                    String content = sc.nextLine();
                    System.out.println("nhập số tiền muốn chuyển ");
                    double money = sc.nextDouble();
                    sc.nextLine();
                    int found =0;
                    for (AccountTransfers a :Controller.accountTransfers){
                        if (a.getAccountTransfers().equals(account) && a.getIdUser().equals(activeUser.getId())){
                            found ++;
                            break;
                        } else {
                            System.out.println("kiểm tra lại tài khoản nhận");
                        }

                    }
                    if (found>0){
                        if (50000<money && money < activeUser.getBalance()-50000){
                            activeUser.setBalance(activeUser.getBalance()-money);
                            System.out.println("chuyển tiền thành công ");
                            LocalDate timeNewTransfers = LocalDate.now();
                            TransactionHistory newTransaction = new TransactionHistory(1, activeUser.getId(), content,timeNewTransfers,account,money);
                            transactionHistory.add(newTransaction);
                        } else {
                            System.out.println("kiểm tra lại số tiền muốn chuyển");
                        }
                    }


                    break;
                case 3:
                    System.out.println("lịch sử giao dịch: ");
                    for (TransactionHistory t : transactionHistory){
                        System.out.println(t);
                    }
                    break;
                case 0:
                    System.out.println("tạm biệt");
                    System.exit(0);
                    break;
                default:
                    System.out.println("không có lựa chọn này");

            }

        }
    }


    public static void forgetPasswordMenu(){
        System.out.println("1 - Quên mật khẩu");
        System.out.println("2 - Đăng nhập lại");
        System.out.println("Lựa chọn của bạn là");
    }

    public static void forgetPasswordProgram(){
        boolean isCheck=true;
        while (isCheck){
            forgetPasswordMenu();
            int x=Validate.inputNumber();
            switch (x){
                case 1:
                    System.out.println("nhập số điện thoại của bạn");
                    String phoneCheck= Validate.isPhoneNumber();
                    int found=0;
                    for (User u : Controller.users){
                        if (u.getPhoneNumber().equals(phoneCheck)){
                            found++;
                            break;
                        }
                    }
                    if (found>0){

                        System.out.println("nhập mk mới");
                        String newPassword = userService.passwordInput();
                        String userId = userService.getUserIdFromPhoneNumber(phoneCheck, Controller.users);
                        for (User u:Controller.users){
                            if (u.getId().equals(userId)){
                                u.setPassword(newPassword);
                            }
                        }
                        System.out.println("Cập nhật mật khẩu thành công");

                    }
                    else {
                        System.out.println("SĐT không đúng");
                    }
                    isCheck=false;
                    break;
                case 2:
                    isCheck=false;
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        }
    }
}

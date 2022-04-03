package model;

public class User {
    private String id;
    private String phoneNumber;
    private String password;
    private String account;
    private double balance;



    public User(String id, String phoneNumber, String password, String account, double balance) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.account = account;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return id + "-" + phoneNumber + "-" +password+"-"+ account +"-"+ balance;
    }
}

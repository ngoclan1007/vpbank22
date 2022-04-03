package model;

import java.time.LocalDate;

public class TransactionHistory {

    private int id;
    private String idUser;
    private String content;
    private LocalDate date;
    private String account;
    private double money;


    public TransactionHistory(int id, String idUser, String content, LocalDate date, String account, double money) {
        this.id = id;
        this.idUser = idUser;
        this.content = content;
        this.date = date;
        this.account = account;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return id + "-"+ date +"-" +content+"-" + account + "-"+ money;
    }
}

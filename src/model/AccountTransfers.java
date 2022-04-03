package model;

public class AccountTransfers {

    private String id;
    private String accountTransfers;
    private String idUser;

    public AccountTransfers(String id, String accountReceive, String idUser) {
        this.id = id;
        this.accountTransfers = accountReceive;
        this.idUser = idUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountTransfers() {
        return accountTransfers;
    }

    public void setAccountTransfers(String accountTransfers) {
        this.accountTransfers = accountTransfers;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return id+ "-"+ accountTransfers + "-"+idUser;
    }
}

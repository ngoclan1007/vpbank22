package Service;

import model.AccountTransfers;
import model.User;

import java.util.ArrayList;

public class Data {
    public ArrayList<User> getAllUser (){
        ArrayList<User> listUser= new ArrayList<>();
        listUser.add(new User("123", "0986216922", "123Lan@", "243445663",800000));
        listUser.add(new User("124", "0985688888", "hoa@789", "249876542", 10000000));
        listUser.add(new User("125", "0989999666", "anan10!", "243098888",500000));
        return listUser;
    }

    public ArrayList<AccountTransfers> getAllAccountTransfers(){
        ArrayList<AccountTransfers> listAccountTransfer= new ArrayList<>();
        listAccountTransfer.add(new AccountTransfers("1", "021704060161444", "123"));
        listAccountTransfer.add(new AccountTransfers("2", "19032179083", "123"));
        listAccountTransfer.add(new AccountTransfers("3", "021704060162888", "124"));
        listAccountTransfer.add(new AccountTransfers("4", "1903465789", "125"));

        return  listAccountTransfer;

    }
}

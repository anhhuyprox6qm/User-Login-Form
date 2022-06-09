package com.example.t2009m1helloworld.service;

import com.example.t2009m1helloworld.entity.Account;
import util.SHA512Hasher;

public class AccountService {
    private AccountModel accountModel;

    public AccountService() {
        this.accountModel=new MySqlAccountModel();
    }
    public Account register(Account account){
        //generate salt
        String salt = SHA512Hasher.randomString(7);
        //hash password
        String passwordHash=SHA512Hasher.encode(account.getPassword(),salt);
        account.setPassword(passwordHash+"."+salt);//nối muối vào password.
        accountModel.save(account);
        return account;
    }
    public Account login(String username,String password){
        Account account = accountModel.findByUsername(username);
        if (account != null && SHA512Hasher.checkPassword(account.getPassword(),password)){
            return account;
        }
        return null;
    }
}

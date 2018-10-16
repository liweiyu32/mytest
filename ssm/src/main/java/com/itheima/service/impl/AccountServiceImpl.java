package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll(){
        List<Account> list = accountDao.findAll();
        System.out.println("业务层，查询所有账户");
        return list;
    }

    public void saveAccount(Account account){
        System.out.println("业务层，保存账户");
        accountDao.saveAccount(account);
    }
}

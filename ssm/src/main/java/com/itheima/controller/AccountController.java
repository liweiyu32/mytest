package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("表现层，查询所有账户");
        List<Account> list = accountService.findAll();
        System.out.println(list);
        return "list";
    }

    @RequestMapping("/save")
    public void saveAccount(HttpServletRequest request, HttpServletResponse response,Account account) throws IOException {
        System.out.println("表现层，保存账户");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }
}

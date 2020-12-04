package com.hisense.test;

import com.hisense.dao.IAccountDao;
import com.hisense.domain.Account;
import com.hisense.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @NAME:AccountServiceTest
 * @Author:ChenYao
 * @DATE: 2020/11/4 16:01
 **/
/*
* 使用Junit单元测试
* */
public class AccountServiceTest {
    @Test
    public void testFindAll() throws SQLException {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        /*查询所有*/
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }


    @Test
    public void testSave() throws SQLException {
        Account account = new Account();
        account.setName("ccc");
        account.setMoney(1000f);
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        /*保存*/
        as.saveAccount(account);

    }

}

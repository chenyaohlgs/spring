package com.hisense.dao.impl;

/**
 * @version 1.0
 * @NAME:AccountDaoimpl
 * @Author:ChenYao
 * @DATE: 2020/10/23 10:56
 **/

import com.hisense.dao.IAccountDao;
import com.hisense.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoimpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount()  {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return (Account) runner.query("select * from account where id = ?",new BeanListHandler<Account>(Account.class),accountId);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        try {
            runner.update("delete from account where id=?",acccountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



//    @PostConstruct//初始化注解
//    public void init(){
//        System.out.println("初始化程序。。。。");
//    }
//
//    @PreDestroy    //销毁注解
//    public void destroy(){
//        System.out.println("销毁程序。。。。");
//    }
}

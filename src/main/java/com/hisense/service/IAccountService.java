package com.hisense.service;

import com.hisense.domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @NAME:IAccountService
 * @Author:ChenYao
 * @DATE: 2020/10/23 10:46
 **/

/*
 * 业务层接口
 * */
public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount() throws SQLException;

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);

}


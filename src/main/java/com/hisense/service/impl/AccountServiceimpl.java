package com.hisense.service.impl;

import com.hisense.dao.IAccountDao;
import com.hisense.domain.Account;
import com.hisense.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * 基于注解的依赖注入
 * @NAME:AccountServiceimpl
 * @Author:ChenYao
 * @DATE: 2020/10/23 10:57
 * 注解类型分四种：
 * 用于创建对象的
 *   作用于xml配置文件中编写一个<bean>标签实现的功能一样
 *   Component
 *        作用：用于当前类对象存入spring容器中
 *        属性：value——指定bean的id，默认当前类首字母小写
 *   Controller：一般用在表现层
 *   Service：一般用在业务层
 *   Repository：一般用在持久层
 *   以上三个注解他们的作用与Component一模一样,
 *   他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *
 * 用于注入数据的
 *   作用和xml文件中bean标签中写一个<property>标签作用一样
 *   Autowired:
 *          作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入陈宫
 *          出现位置：
 *              变量或者方法上    
 *   Qualifier:
 *          作用：在按照类中注入的基础之上再按照名称注入，他在给类成员注入时不能单向度使用，但是再给方法参数注入时可以
 *          属性：value  用于指定注入bean的id
 *   Resource（jdk11以后没有了）
 *          作用：直接按照bean的id注入，它可以独立使用
 *          属性： name：用于指定bean的id
 *   以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *   另外，集合类型注入只能通过xml来实现
 *
 *   Value
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值，可以使用spring中SpEL（el表达式）
 *              SpEL表达式写法：${表达式}
 *
 * 用于改变作用范围的
 *   作用和bean标签使用scope属性实现功能一样
 *   Scope
 *        作用：用于指定bean的作用范围
 *        常用：singleton prototype
 *
 * 和生命周期相关的
 *   作用和bean标签使用init-method和destory-method作用一样
 *   PreDestroy:指定销毁方法
 *
 *   PostConstruct:指定初始化方法
 *
 **/
//@Component
    @Service("accountService")
public class AccountServiceimpl implements IAccountService {
        @Autowired
        private IAccountDao accountDao;

        @Override
        public List<Account> findAllAccount() throws SQLException {
            return accountDao.findAllAccount();
        }

        @Override
        public Account findAccountById(Integer accountId) {

            return accountDao.findAccountById(accountId);
        }

        @Override
        public void saveAccount(Account account){

            accountDao.saveAccount(account);
        }


        @Override
        public void updateAccount(Account account) {
            accountDao.updateAccount(account);
        }

        @Override
        public void deleteAccount(Integer acccountId) {
            accountDao.deleteAccount(acccountId);
        }
}

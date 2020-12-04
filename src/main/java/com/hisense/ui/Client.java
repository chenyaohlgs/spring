package com.hisense.ui;

import com.hisense.dao.IAccountDao;
import com.hisense.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.ls.LSOutput;

/**
 * 模拟一个表现层，用于调用业务层
 * @version 1.0
 * @NAME:Client
 * @Author:ChenYao
 * @DATE: 2020/10/23 11:02
 **/
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService)ac.getBean("accountServiceimpl");

        System.out.println(as);

        IAccountDao at = ac.getBean(IAccountDao.class,"accountDaoimpl");

        System.out.println(at);

        ac.close();

//        as.saveAccount(null);
    }

}

package com.chy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private final static  SessionFactory sessionFactory;
    static{
        //获取到配置信息
        Configuration conf=new Configuration().configure();
        //创建一个标准的建造器
        StandardServiceRegistryBuilder ssb = new StandardServiceRegistryBuilder();
        //得到ServiceRegistry的实例（一定需要传入configuration.getProperties()）
        StandardServiceRegistry ssr = ssb.applySettings(conf.getProperties()).build();
        //得到SessionFactory工厂
        sessionFactory= conf.buildSessionFactory(ssr);
    }
    public static Session getSession(){
        return sessionFactory.openSession();
    }
}

package com.github.siemen.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by 西门 on 2017/2/15 0015.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;

    /*读取配置初始化*/
    static {
/*        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        StandardServiceRegistry ssr = ssrb.build();
        sessionFactory = config.buildSessionFactory(ssr);*/

        //Configuration config = new Configuration().configure();
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    /**
     * 获取sessionFactory
     * */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    /**
     * 获取session
     * */
    public static Session getSession(){
        session = sessionFactory.openSession();
        return session;
    }

    /**
     * 关闭session
     * */
    public static void closeSession(){
        session.close();
        sessionFactory.close();
    }
}

package com.mariusz.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtils {

    private static SessionFactory factory;

    private HibernateUtils() {
    }

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("Failed to create session factory.");
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}

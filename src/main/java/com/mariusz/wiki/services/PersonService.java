package com.mariusz.wiki.services;

import com.mariusz.utils.HibernateUtils;
import com.mariusz.wiki.entities.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonService {
    private SessionFactory sessionFactory;



    public PersonService() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    public Person checkPassword(String login, String pass){
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Person as p where p.login = :login and p.pass = :pass");
        query.setParameter("login",login);
        query.setParameter("pass",pass);

        Person result = (Person) query.uniqueResult();

        tran.commit();
        session.close();

        return result;
    }

    public boolean checkLoginUsage(String login){
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Person as p where p.login = :login");
        query.setParameter("login",login);

        Person result = (Person) query.uniqueResult();

        tran.commit();
        session.close();

        return result!=null;
    }


    public void registerNewUser(Person person) {
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();

        session.save(person);

        tran.commit();
        session.close();

    }


}

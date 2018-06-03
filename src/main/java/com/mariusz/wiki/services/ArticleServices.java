package com.mariusz.wiki.services;

import com.mariusz.utils.HibernateUtils;
import com.mariusz.wiki.entities.Article;
import com.mariusz.wiki.entities.Content;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ArticleServices {

    SessionFactory sessionFactory;

    public ArticleServices() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    public List<Article> getAllArticles(){
        Session sesion = sessionFactory.openSession();
        Transaction tran = sesion.beginTransaction();
        Query query = sesion.createQuery("FROM Article a inner join fetch a.content order by a.lastUpdate DESC");

        List<Article> articles = query.list();

        tran.commit();
        sesion.close();
        return articles;
    }


    public List<Article> getXnewestArticles(int numberOfArticles){
        Session sesion = sessionFactory.openSession();
        Transaction tran = sesion.beginTransaction();
        Query query =  sesion.createQuery("FROM Article a inner join fetch a.content order by a.lastUpdate DESC");
        query.setMaxResults(numberOfArticles);
        List<Article> articles = query.list();

        tran.commit();
        sesion.close();
        return articles;
    }

    public Article getArticleById(int id) {
        Session sesion = sessionFactory.openSession();
        Transaction tran = sesion.beginTransaction();

        Query query = sesion.createQuery("FROM Article a inner join fetch a.content where a.id = :id");
        query.setParameter("id",id);

        Article art = (Article) query.uniqueResult();
        tran.commit();
        sesion.close();
        return art;

    }

    public void saveArticle(Article art, Content content){
        Session sesion = sessionFactory.openSession();
        Transaction tran = sesion.beginTransaction();

        sesion.persist(content);
        art.setContent(content);
        sesion.save(art);
        tran.commit();
        sesion.close();

    }
}

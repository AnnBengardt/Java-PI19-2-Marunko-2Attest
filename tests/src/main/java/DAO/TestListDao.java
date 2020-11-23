package DAO;

import models.TestList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestListDao implements Dao<TestList> {

    private List<TestList> testLists = new ArrayList<>();

    public TestListDao(){

    }

    public TestList findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        TestList testList = session.get(TestList.class, id);
        session.close();
        return testList;
    }

    @Override
    public Optional<TestList> get(int id) {
        return Optional.ofNullable(testLists.get((int) id));
    }

    @Override
    public List<TestList> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<TestList>) session.createQuery("From TestList").list();
    }

    @Override
    public void save(TestList testList){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(testList);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(TestList testList) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(testList);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(TestList testList){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(testList);
        tx1.commit();
        session.close();
    }


}

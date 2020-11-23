package DAO;

import models.StudentAnswer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentAnswerDao implements Dao<StudentAnswer> {

    private List<StudentAnswer> studentAnswers = new ArrayList<>();

    public StudentAnswerDao(){

    }

    public StudentAnswer findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        StudentAnswer studentAnswer = session.get(StudentAnswer.class, id);
        session.close();
        return studentAnswer;
    }

    @Override
    public Optional<StudentAnswer> get(int id) {
        return Optional.ofNullable(studentAnswers.get((int) id));
    }

    @Override
    public List<StudentAnswer> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<StudentAnswer>) session.createQuery("From StudentAnswer").list();
    }

    @Override
    public void save(StudentAnswer studentAnswer){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(studentAnswer);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(StudentAnswer studentAnswer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(studentAnswer);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(StudentAnswer studentAnswer){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(studentAnswer);
        tx1.commit();
        session.close();
    }

}

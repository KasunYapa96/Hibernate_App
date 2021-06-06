package com.codes;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TraineeDAO {
	
	SessionFactory factory;
	
	public TraineeDAO() {
		factory =HibernateUtil.getSessionFactory(); // get a return object by dbutil class
	}

	public void addTrainee(Trainee e) {
		
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        System.out.println("Trainee has been added successfully!");
	
	}
	
	public Trainee getTraineeById(int id) {
		 SessionFactory factory=HibernateUtil.getSessionFactory(); 
		 Session session=factory.getCurrentSession();
		 session.beginTransaction();
		 Trainee ob=(Trainee)session.get(Trainee.class, id); //here we passing entity class and Id
		 session.getTransaction().commit();
		 return ob;
		
	}
	
	public void deleteTrainee(int tno) {

        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Trainee t=(Trainee) session.get(Trainee.class, tno);
        
        if(t==null) {
        	System.out.println("record does not exist!");
        }else session.delete(t); 	System.out.println("Employee deleted successfully");
        
        session.getTransaction().commit();
        
	}
	
	public void updateTrainee(int traineeId,String course) {
		
		String hql="update Trainee set course=:course where traineeId =:traineeId";
		SessionFactory factory=HibernateUtil.getSessionFactory(); 
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Query q=session.createQuery(hql);
		q.setParameter("course", course);
		q.setParameter("traineeId", traineeId);
		q.executeUpdate();
		session.getTransaction().commit();

	
		
		
	}
	
public List<Trainee> getAllTrainees(){
	
	String hql="from Trainee";
	Session session=factory.getCurrentSession();
    session.beginTransaction();
    Query q=session.createQuery(hql);
    List<Trainee> list=q.list();
    session.getTransaction().commit();
    
	return list;
	
}
	
		
	}
	
	
	


package com.codes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.save(new Trainee("Kasun Yapa","Embedded","9087887658"));
        session.getTransaction().commit();
        System.out.println("Trainee has been added successfully!");
        
	}

}

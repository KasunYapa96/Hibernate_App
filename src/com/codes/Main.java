package com.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainee.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        
        System.out.println("Enter name :");
        String name=br.readLine();
        
        System.out.println("Enter preferred course :");
        String course=br.readLine();
        
        System.out.println("Enter mobile number :");
        String mobile=br.readLine();
        
        
        session.save(new Trainee(name,course,mobile).toString());
        session.getTransaction().commit();
        System.out.println("Trainee has been added successfully!");
        
	}

}

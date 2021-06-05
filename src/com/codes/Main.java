package com.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		TraineeDAO dao=new TraineeDAO();
		
		Trainee tr=dao.getTraineeById(1);
		System.out.println(tr);
		
		List<Trainee> list=dao.getAllTrainees();
		System.out.println("***************************************");
		for(Trainee t:list) {
			
			System.out.println(t);
			
		}
	
		/*
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainee.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		String hql="from Trainee";
		
	    session.beginTransaction();
	    Query q=session.createQuery(hql);
	    List<Trainee> list=q.list();
	    session.getTransaction().commit();
	    
	    
		System.out.println("***************************************");
		for(Trainee t:list) {
			
			System.out.println(t);
		}
		
		*/
		
		
/*		
		Trainee t =dao.getTraineeById(1);
		System.out.println(t);
		
		
		
        System.out.println("Enter name :");
        String namex=br.readLine();
        
        System.out.println("Enter preferred course :");
        String coursex=br.readLine();
        
        System.out.println("Enter mobile number :");
        String mobile=br.readLine();
        
        dao.addTrainee(new Trainee(namex,coursex,mobile));
      */
		
		
		
		
     
	}

}

/* 
	A Session is used to get a physical connection with a database. 
	The Session object is lightweight and designed to be instantiated each time an interaction
	is needed with the database. Persistent objects are saved and retrieved 
	through a Session object.
	
	A Transaction is a sequence of operation which works as an atomic unit. 
	A transaction only completes if all the operations completed successfully. 
	
	A Transaction is a unit of work in which all the operations must be executed or 
	none of them. To understand the importance of transaction, 
	think of an example which applies on all of us i.e. Transferring Amount from one account
	to another as this operation includes the below two steps:

Deduct the balance from the senderís bank account
Add the amount to the receiverís bank account

Now think a situation where the amount is deducted from senderís account but is not 
delivered to receiverís account due to some errors. 
Such issues are managed by the transaction management where both steps are performed 
in a single unit. In the case of a failure, the transaction should be roll-backed.

*/
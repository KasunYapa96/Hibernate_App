package com.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		TraineeDAO dao=new TraineeDAO();
		
		
		
		
		

		do {
		System.out.println("Menu\n");
		System.out.println("1.Insert Trainee");
		System.out.println("2.Display Records");
		System.out.println("3.Update Trainee's Course by Id");
		System.out.println("4.Delete Trainee by Id");
		System.out.println("5.Display Trainee and University");
		System.out.println("6.Exit");
		System.out.println("Enter choice");
		int ch=Integer.parseInt(br.readLine());
		switch(ch) {
		case 1:
			
			System.out.println("Enter the user details---------------");
			
			/*
			String input = sc.nextLine();
			String[] inputArr = input.split(",");
			
			User user = new User(Long.parseLong(inputArr[0]), inputArr[1], inputArr[2], inputArr[3],inputArr[4]);
			dao.insertDetails(user);
			*/
			
			 	System.out.println("Enter name :");
		        String name=br.readLine();
		        
		        System.out.println("Enter preferred course :");
		        String course=br.readLine();
		        
		        System.out.println("Enter mobile number :");
		        String mobile=br.readLine();
		        
		        System.out.println("Enter University Name :");
		        String uni=br.readLine();
		        
		        System.out.println("Enter City :");
		        String city=br.readLine();
		        
		        University u1=new University(uni, city);
				Trainee tr1=new Trainee(name, course, mobile,u1 );
				
				dao.addTrainee(tr1);
			
			
			System.out.println("------------------User added successfully------------------------------");
			
			break;
		case 2:
			
			System.out.println("--------------------User Details are shown below-----------------------\n");
		
			
			
			List<Trainee> list1 = new ArrayList<>();
			list1 = dao.getAllTrainees();
			
			System.out.format("%-5s %-10s %-15s %-10s \n","Id","Name","Course","Contact Detail");
			
			for(Trainee tr: list1) {
				System.out.format("%-5s %-10s %-15s %-10s \n", tr.getTraineeId(), tr.getName(),
						tr.getCourse(), tr.getMobileNumber());
			}
			
			System.out.format("\n");
			
			break;
			
		case 3:
				
			System.out.println("Enter the Trainee Id:");
			int id = Integer.parseInt(br.readLine());
			
			Trainee tr2 = dao.getTraineeById(id);
			
			
			
			if(tr2!=null) {
				System.out.format("%-5s %-10s %-15s %-10s \n","Id","Name","Course","Contact Detail");
				System.out.format("%-5s %-10s %-15s %-10s \n", tr2.getTraineeId(), tr2.getName(),
						tr2.getCourse(), tr2.getMobileNumber());
				
				System.out.println("Enter the Course to be updated:");
				String course1 = br.readLine();
				
				dao.updateTrainee(tr2.getTraineeId(), course1);
				
				Trainee tr2Up = dao.getTraineeById(id);
				System.out.format("%-5s %-10s %-15s %-10s \n","Id","Name","Course","Contact Detail");
				System.out.format("%-5s %-10s %-15s %-10s \n", tr2Up.getTraineeId(), tr2Up.getName(),
						tr2Up.getCourse(), tr2Up.getMobileNumber());
				
			}else {
				System.out.println("No such user is present");
			}
			
			System.out.format("\n");
			
			break;	

		case 4:
			
			System.out.println("Enter the username to be deleted:");
			
			
			int tno=Integer.parseInt(br.readLine());
			
			dao.deleteTrainee(tno);
			
			break;
		case 5:
			
			System.out.println("--------------------User and Location details are shown below-----------------------\n");
			
			
			
			List<Trainee> list3 = new ArrayList<>();
			list3 = dao.getAllTrainees();
			
			System.out.format("%-5s %-15s %s\n\n","Name","University","City");
			
			for(Trainee tr3: list3) {
//				System.out.format("%-5s %s\n",userl.getName(),userl.l.getCity_name());
				
//				System.out.println(userl.getName()+"    "+userl.getCity());
				System.out.format("%-5s %-15s %s\n",tr3.getName(),tr3.getUniversity().uniName,tr3.getUniversity().uniCity);
				
			}
			
			System.out.format("\n");
			
			break;
		case 6:
			
			System.exit(0);
			
			break;
		default:
			System.out.println("Invalid choice");
		}
	}while(true);
}

}

		
		
		
		
		
		
		
		
		
		
//		University u1=new University("NSBM", "Homagama");
//		Trainee tr1=new Trainee("Calana", "CS", "0777",u1 );
//		
//		University u2=new University("NSBM", "Homagama");
//		Trainee tr2=new Trainee("Akin", "CS", "0777",u2 );
//		
//		University u3=new University("NSBM", "Homagama");
//		Trainee tr3=new Trainee("Yasas", "CS", "0777",u3 );
//		
//		
//		dao.addTrainee(tr1);
//		dao.addTrainee(tr2);
//		dao.addTrainee(tr3);
		
//		dao.deleteTrainee(23);
//		
	
		
//		List<Trainee> list=dao.getAllTrainees();
//		System.out.println("***************************************");
//		for(Trainee t:list) {
//			
//			System.out.println(t);
//			
//		}
	
		/*
		SQL> set line 1000;
		SQL> select * from University;
		 
		 Trainee tr=dao.getTraineeById(1);
		System.out.println(tr);
		
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

Deduct the balance from the sender’s bank account
Add the amount to the receiver’s bank account

Now think a situation where the amount is deducted from sender’s account but is not 
delivered to receiver’s account due to some errors. 
Such issues are managed by the transaction management where both steps are performed 
in a single unit. In the case of a failure, the transaction should be roll-backed.

*/
package com.codes;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
private static SessionFactory factory=null;
	
	public static SessionFactory getSessionFactory(){
		
		if(factory==null) {
		 factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainee.class).buildSessionFactory();
		}
		return factory;

}
}

/*We made it singleton , only 1 SessionFactory object will be created 
 *Created a private static factory variable and made it null
 *In getsess.factory method if the SessionFactory is null one SessionFactory object will be created
 * 
 * 
 * 
 */
 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Instructor;
import com.aku.jdbc.InstructorDetail;
import com.aku.jdbc.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int theId =1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor:" + instructor);
			
			if(instructor != null) {
				System.out.println("DELETING:" + instructor);
				
				//NOTE: this will also delete the associated detail object 
				// due to CascadeType = ALL
				
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		}
		finally {
			factory.close();
		}

	}

}

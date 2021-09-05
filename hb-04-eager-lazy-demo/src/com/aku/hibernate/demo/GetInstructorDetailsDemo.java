 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Instructor;
import com.aku.jdbc.InstructorDetail;
import com.aku.jdbc.Student;

public class GetInstructorDetailsDemo {

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
			
			int theId =233;
			
			InstructorDetail instructor_detail = session.get(InstructorDetail.class, theId);
			
			
			if(instructor_detail != null) {
				
				System.out.println("Found Instructor Detail:" + instructor_detail);
				System.out.println("The associated Instructor is: "+instructor_detail.getInstructor());

			}
			else {
				System.out.println("There is no Instructor Detail with id:"+ theId);
			}
			
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

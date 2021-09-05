 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Course;
import com.aku.jdbc.Instructor;
import com.aku.jdbc.InstructorDetail;
import com.aku.jdbc.Student;

public class GetInstructorDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theID = 1;
			
			Instructor instructor = session.get(Instructor.class, theID);

			System.out.println("The courses assosciated with the instructor: "+theID+"are:"+ instructor.getCourses());
			
			//Commit Transaction
			
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		}
		finally {
			factory.close();
		}

	}

}

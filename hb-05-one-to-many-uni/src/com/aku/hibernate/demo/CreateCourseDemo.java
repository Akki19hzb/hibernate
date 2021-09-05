 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Course;
import com.aku.jdbc.Instructor;
import com.aku.jdbc.InstructorDetail;
import com.aku.jdbc.Student;

public class CreateCourseDemo {

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
			
			Course tempCourse1 = new Course("Guided Guitar!!!");
			Course tempCourse2 = new Course("Dance with the Drum!!!");
			
			instructor.add(tempCourse1);
			instructor.add(tempCourse2);
			
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			//Commit Transaction
			
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

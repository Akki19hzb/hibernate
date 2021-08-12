 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student object");
			
//			Student tempStudent = new Student("Raj", "Kumar", "rk.actor@gmail.com");
			
//			session.beginTransaction();
			
			System.out.println("Saving the student object");
//			System.out.println(tempStudent);
//			session.save(tempStudent);
			
			//Commit Transaction
			
//			session.getTransaction().commit();
//			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			//New Code
	//		session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 2);//tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("DONE!!!");
		}
		finally {
			factory.close();
		}

	}

}

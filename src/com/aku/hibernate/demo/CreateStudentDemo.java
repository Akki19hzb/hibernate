 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Student;

public class CreateStudentDemo {

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
			
			Student tempStudent = new Student("Vishal", "Mishra", "vm.music@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student object");
			
			session.save(tempStudent);
			
			//Commit Transaction
			
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		}
		finally {
			factory.close();
		}

	}

}

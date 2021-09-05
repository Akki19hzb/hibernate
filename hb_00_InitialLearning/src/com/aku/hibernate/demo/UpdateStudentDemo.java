 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Update the Student with id:1");
			
			int studentId = 2;
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);//tempStudent.getId());
			
			myStudent.setFirstName("Rajesh");
			System.out.println("Updating to: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			//New Code to update the Email Id
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Updating the email id for the Student with id =2");
			
			session.createQuery("Update Student set email='rm.tennis@gmail.com'"
					+ "where id = 2").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			System.out.println("DONE!!!");
			factory.close();
		}

	}

}

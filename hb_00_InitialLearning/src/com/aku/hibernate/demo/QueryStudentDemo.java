 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Student;
import java.util.List;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList(); 
			
			displayStudent(theStudents);
			//Commit Transaction
			
			
			
			System.out.println("Student with lastName starts with M");
			theStudents = session.createQuery("from Student where lastName like 'M%'")
					.getResultList(); 
			displayStudent(theStudents);
			
			session.getTransaction().commit();
		}
		finally {
			System.out.println("DONE!!!");
			factory.close();
		}

	}

	private static void displayStudent(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			
			System.out.println(tempStudent);
		}
	}

}

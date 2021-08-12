 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Delete the Student with id:4");
			
			int studentId = 4;
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);//tempStudent.getId());
			
			
			System.out.println("Deleting Student: " + myStudent);
			
			session.delete(myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			//New Code to update the Email Id
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Deleting the the Student with id =5");
			
			session.createQuery("delete from Student "
					+ "where id = 5").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			System.out.println("DONE!!!");
			factory.close();
		}

	}

}

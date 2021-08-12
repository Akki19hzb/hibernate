package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Student;

public class PrimaryKeyDemo {

		// TODO Auto-generated method stub
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
				
				Student tempStudent1 = new Student("Vishal", "Mishra", "vm.music@gmail.com");
				Student tempStudent2 = new Student("Amit", "Mishra", "am.cricket@gmail.com");
				Student tempStudent3 = new Student("Vinod", "Pandit", "vp.movie@gmail.com");
				
				session.beginTransaction();
				
				System.out.println("Saving the student object");
				
				session.save(tempStudent1);
				session.save(tempStudent2);
				session.save(tempStudent3);
				
				//Commit Transaction
				
				session.getTransaction().commit();
				
				System.out.println("DONE!!!");
			}
			finally {
				factory.close();
			}

	}

}

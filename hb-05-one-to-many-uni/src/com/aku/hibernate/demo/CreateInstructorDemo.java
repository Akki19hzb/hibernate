 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Course;
import com.aku.jdbc.Instructor;
import com.aku.jdbc.InstructorDetail;
import com.aku.jdbc.Student;

public class CreateInstructorDemo {

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
			/*
			Instructor instructor = new Instructor("Vishal", "Mishra", "vm.music@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/vmMusic", "Play Music");
			
			instructor.setInstrutorDetail(instructorDetail);
			
			*/
			
			Instructor instructor = new Instructor("Madhu", "Kumari", "mk.guitar@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/guitarFanatic", "Guitar Chaos");
			
			instructor.setInstrutorDetail(instructorDetail);
			
			session.beginTransaction();
			
			//NOTE: this will also save the details object
			// because of CascaseType.ALL
			
			System.out.println("SAVING Instructor: "+ instructor);
			session.save(instructor);
			
			//Commit Transaction
			
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
		}
		finally {
			factory.close();
		}

	}

}

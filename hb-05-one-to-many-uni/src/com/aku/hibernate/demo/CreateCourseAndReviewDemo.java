 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Course;
import com.aku.jdbc.Instructor;
import com.aku.jdbc.InstructorDetail;
import com.aku.jdbc.Review;
import com.aku.jdbc.Student;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
		
			
			Course tempCourse1 = new Course("Guided Piano!!!");
			
			Review review1 = new Review("Great Course");
			Review review2 = new Review("Begineers Paradise");
			Review review3 = new Review("Must have!!!");
			
			tempCourse1.addReview(review1);
			tempCourse1.addReview(review2);
			tempCourse1.addReview(review3);
			
			System.out.println(tempCourse1.getReviews());
			System.out.println("SAVING");
			
			session.save(tempCourse1);
			
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

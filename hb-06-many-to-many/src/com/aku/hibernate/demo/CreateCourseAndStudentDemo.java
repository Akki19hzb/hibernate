 package com.aku.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aku.jdbc.Course;
import com.aku.jdbc.Instructor;
import com.aku.jdbc.InstructorDetail;
import com.aku.jdbc.Review;
import com.aku.jdbc.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
		
			
			Course tempCourse1 = new Course("Guided Piano!!!");
			
			System.out.println("Saving the Course");
			session.save(tempCourse1);
			
			Student stud1 = new Student("Sumit","Sahu", "SS.piano@gmail.com");
			Student stud2 = new Student("Vivek","Raj", "vr.learn@gmail.com");
			
			tempCourse1.addStudent(stud1);
			tempCourse1.addStudent(stud2);
			System.out.println("SAVING the students");
			
			session.save(stud1);
			session.save(stud2);
			
			System.out.println("Saved Students:"+ tempCourse1.getStudents());
			
			
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

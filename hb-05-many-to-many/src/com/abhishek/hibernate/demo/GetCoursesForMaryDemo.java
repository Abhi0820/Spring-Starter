package com.abhishek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhishek.hibernate.demo.entity.Course;
import com.abhishek.hibernate.demo.entity.Instructor;
import com.abhishek.hibernate.demo.entity.InstructorDetail;
import com.abhishek.hibernate.demo.entity.Review;
import com.abhishek.hibernate.demo.entity.Student;

public class GetCoursesForMaryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// get the student Mary from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded Student: " + tempStudent);
			System.out.println("Course(s): " + tempStudent.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

package com.abhishek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhishek.hibernate.demo.entity.Course;
import com.abhishek.hibernate.demo.entity.Instructor;
import com.abhishek.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// get the instructor from the db
			int theId=1;
			Instructor tempTnstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: " + tempTnstructor);
			
			// get the courses
			System.out.println("Courses: " + tempTnstructor.getCourses());
			
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

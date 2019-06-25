package com.abhishek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhishek.hibernate.demo.entity.Course;
import com.abhishek.hibernate.demo.entity.Instructor;
import com.abhishek.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			// create some courses
			Course tempCourse1 = new Course("Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Guitar Masterclass");
			
			// add courses to instructor
			tempTnstructor.add(tempCourse1);
			tempTnstructor.add(tempCourse2);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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

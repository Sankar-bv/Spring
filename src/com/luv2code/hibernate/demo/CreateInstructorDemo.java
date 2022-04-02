package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//Create the objects
			Instructor instructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Video Games");
			instructor.setInstructorDetail(instructorDetail);
			
			//Start a transaction
			session.beginTransaction();
			
			//Save the object
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
		
	}

}

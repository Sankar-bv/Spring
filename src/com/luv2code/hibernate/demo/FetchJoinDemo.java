package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//Start a transaction
			session.beginTransaction();
			
			//Hibernate query with HQL
			
			//Get the instructor from db
			int theId = 1;
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+"JOIN FETCH i.courses "
					+"where i.id=:theInstructorId", Instructor.class);
			//Set parameter on query
			query.setParameter("theInstructorId", theId);
			//Execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Instructor: " + tempInstructor);

			//Get course for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			//Commit the transaction
			session.getTransaction().commit();
			
			session.close();
			System.out.println("\nluv2code: The session is now closed!\n");
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
		
	}

}

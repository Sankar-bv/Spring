package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			//Start a transaction
			session.beginTransaction();
			
			//Get the instructor detail object
			int id = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			//Print the instructor detail
			System.out.println("InstructorDetail: " + instructorDetail);
			//Print the associated instructor
			System.out.println("The associated instructor: " + instructorDetail.getInstructor());
			//Now let's delete the instructor detail
			System.out.println("Deleting instructorDetail: " + instructorDetail);
			session.delete(instructorDetail);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			//Close the database connection to prevent data leak
			session.close();
			factory.close();
		}
		
	}

}

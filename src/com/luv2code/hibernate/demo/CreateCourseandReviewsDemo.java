package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseandReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//Start a transaction
			session.beginTransaction();
			
			//Create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			//Add some reviews
			tempCourse.addReview(new Review("Great Course ... Loved it!"));
			tempCourse.addReview(new Review("Cool Course, job well done"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			
			//Save the course ... and leverage the cascade all :-)	
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
		
	}

}

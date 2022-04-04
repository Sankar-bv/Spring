package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//Start a transaction
			session.beginTransaction();
			
			//Get the student mary from database
			int studentId = 3;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Course: " + tempStudent.getCourses());
			
			//Create more courses
			Course tempCourse1 = new Course("Rubik's Cube - How To Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
			
			//Add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			//Save the courses
			System.out.println("\nSaving the courses ...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
		
	}

}

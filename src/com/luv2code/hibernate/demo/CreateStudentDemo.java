package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//Create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
			//Start a transaction
			session.beginTransaction();
			//Save the student object
			System.out.println("Saving the object");
			session.save(tempStudent);
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
		
	}

}

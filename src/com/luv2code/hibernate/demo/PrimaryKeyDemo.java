package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				//Or we can give just configure() which will default act as configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			//Create a student object
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student tempStudent3 = new Student("Bonita", "Applebaum", "bonita@luv2code.com");
			//Start a transaction
			session.beginTransaction();
			//Save the student object
			System.out.println("Saving the object");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
		
	}

}

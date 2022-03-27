package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			//Query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			//Query students: lastName = Doe
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);
			//Query students: lastName = Doe OR firstName = Daffy
			theStudents = session.createQuery("from Student s where s.firstName = 'Daffy' OR s.lastName = 'Doe'").getResultList();
			System.out.println("\n\nStudents who have first name of Daffy OR last name of Doe");
			displayStudents(theStudents);
			//Query students where email LIKE '%luv2code.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
			System.out.println("\n\nStudents who have email ends with luv2code.com");
			displayStudents(theStudents);
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
		
	}

	public static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}

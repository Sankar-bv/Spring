package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int studentId = 1;
			//Find out the student's id : primary key
			System.out.println("Saved student. Gennerated id: " + studentId);
			session = factory.getCurrentSession();
			session.beginTransaction();
			//Retrieve student based on id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			
			//Commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update email for all students");
			session.createQuery("update Student	set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
		
	}

}

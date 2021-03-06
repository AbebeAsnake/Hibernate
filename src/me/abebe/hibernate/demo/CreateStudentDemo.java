package me.abebe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.abebe.hibernate.entity.student;

public class CreateStudentDemo {

	public static void main(String[] args) {
// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(student.class)
				.buildSessionFactory();
		
		//create a session 
		Session session = factory.getCurrentSession();
		try {
			//use the session object to save java object
			
			//create a student object
			System.out.println("creating new student obejct");
			student tempStudent = new student("paul","wall","paul@gg.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("saving the student ....");
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		}
	}



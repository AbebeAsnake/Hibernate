package me.abebe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.abebe.hibernate.entity.student;

public class PrimaryKeyDemo {

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
					
					//create a=3 student object
					System.out.println("creating 3 student obejct");
					student tempStudent1 = new student("paul","wall","paul@gg.com");
					student tempStudent2 = new student("Jon","Doe","jon@gg.com");
					student tempStudent3 = new student("stay","ker","stacy@gg.com");
					//start a transaction
					session.beginTransaction();
					//save the student object
					System.out.println("saving 3 student ....");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);

					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
				}
	}



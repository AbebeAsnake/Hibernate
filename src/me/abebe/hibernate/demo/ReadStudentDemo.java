package me.abebe.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.abebe.hibernate.entity.student;

public class ReadStudentDemo {

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
			student tempStudent = new student("daffy","tag","daffy@gg.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("saving the student ....");
			System.out.println(tempStudent);
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			// new code
			
			// find out students id primary key
			System.out.println("saved student.generated id:"+ tempStudent.getId());
			
			//now get a new session and start transaction
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id , primary key
			System.out.println("/n getting student with id: " + tempStudent.getId());
			student myStudent = session.get(student.class, tempStudent.getId());
			
			System.out.println("get complete" + myStudent);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		}
	}



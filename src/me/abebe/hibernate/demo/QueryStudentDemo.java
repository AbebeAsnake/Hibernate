package me.abebe.hibernate.demo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.abebe.hibernate.entity.student;

public class QueryStudentDemo {

	public static void main(String[] args) {
// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(student.class)
				.buildSessionFactory();
		
		//create a session 
		Session session = factory.getCurrentSession();
		try {
			
			//start a transaction
			session.beginTransaction();
			// query students
			List<student> theStudents = session.createQuery("from student").getResultList();
			
			//display student
			displayStudents(theStudents);

			// query students : alstname ='Doe'
			
			theStudents = session.createQuery("from student s where s.lastName='Doe'").list();
			
			//display the students
			System.out.println("\n\nstudents who have last name of Doe");
			displayStudents(theStudents);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		}

	private static void displayStudents(List<student> theStudents) {
		for(student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
	}



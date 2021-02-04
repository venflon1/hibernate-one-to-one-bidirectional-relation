package com.roberto.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.roberto.hibernate.model.Instructor;
import com.roberto.hibernate.model.InstructorDetail;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(Instructor.class)
												.addAnnotatedClass(InstructorDetail.class)
												.buildSessionFactory();

		Session dbSession = sessionFactory.openSession();

		// ================== SELECT RECORD ================
		Instructor instructor1 = dbSession.get(Instructor.class, 20L);
		dbSession.close();
		
		// BIDIRECTIONAL RELATION  
		//
		// [Instructor  -------> DetailInstruct]
		InstructorDetail detail = instructor1.getInstructorDetail();
		System.out.println(detail);
		// [Instructor  <------- DetailInstruct]
		Instructor instructor = detail.getInstructor();
		System.out.println(instructor);
		 
		dbSession = sessionFactory.openSession();
		Transaction trx = dbSession.beginTransaction();
		// NOTE: delete also instructor associated because CascadeType.REMOVE
		dbSession.delete(detail);
		trx.commit();
		dbSession.close();
		sessionFactory.close();
	}
}

package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent1 = new Student("john", "rambo", "example@123");
			Student tempStudent2 = new Student("max", "marco", "example@123");
			Student tempStudent3 = new Student("henry", "williams", "example@123");
			session.beginTransaction();
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}

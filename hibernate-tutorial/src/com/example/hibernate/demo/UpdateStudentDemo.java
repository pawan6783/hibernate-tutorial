package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			student.setFirstName("scooby");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='example@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}

package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("john", "rambo", "example@123");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student result = session.get(Student.class, student.getId());
			session.getTransaction().commit();
			
			System.out.println(result.toString());
			
		} finally {
			factory.close();
		}
	}
}

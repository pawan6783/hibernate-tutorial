package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	
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
			session.delete(student);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=4").executeUpdate();
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}

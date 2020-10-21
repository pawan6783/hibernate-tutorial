package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Student> studentList = session.createQuery("from Student").list();
			
			System.out.println("List of students");
			for(Student item : studentList) {
				System.out.println(item.toString());
			}
			
			studentList = session.createQuery("from Student s where s.lastName='rambo'").list();
			
			System.out.println("List of students having last name 'rambo'");
			for(Student item : studentList) {
				System.out.println(item.toString());
			}
			
			studentList = session.createQuery("from Student s where"
								+" s.lastName='williams' or s.lastName='marco'").list();
			System.out.println("List of students having last name 'williams'or 'marco'");
			for(Student item : studentList) {
				System.out.println(item.toString());
			}
			
			studentList = session.createQuery("from Student s where"
								+" s.email LIKE '%@123'").list();
			System.out.println("List of students having email end with @123");
			for(Student item : studentList) {
				System.out.println(item.toString());
			}
		} finally {
			factory.close();
		}
	}
}

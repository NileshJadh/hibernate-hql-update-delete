package com.rocky.app;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.rocky.model.Student;

public class LaunchUpdate {

	public static void main(String args[]) {
		// Creating configuration 

		 SessionFactory sessionFactory =new 
				 Configuration().configure().
				 addAnnotatedClass(Student.class).
				 buildSessionFactory();
		 
		 Session session = null;
		 Transaction transaction = null;
		 boolean flag = false;
		 int rowsAffected = 0;
		 
		 try {
			 
			 session = sessionFactory.openSession();
			 
			 transaction = session.beginTransaction();

	            // HQL update query
	            Query query = session.createQuery("update Student set scity = :city where sid = :id");
	            query.setParameter("city", "London"); // Set parameter for city
	            query.setParameter("id", 1); // Set parameter for ID

	           // Execute the update query
	           rowsAffected = query.executeUpdate();
			 
			 flag = true;
			 
		 }
		 catch(HibernateException e) {
			 e.printStackTrace();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
			 if(flag==true) {
				 transaction.commit();
		            System.out.println("Number of rows updated: " + rowsAffected);
			 }
			 else {
				 transaction.rollback();
		            System.out.println("Number of rows updated: " + rowsAffected);
			 }
			 session.close();
			 sessionFactory.close();
		 }
		
	}
}

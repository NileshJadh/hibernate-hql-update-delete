package com.rocky.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.rocky.model.Student;

public class LaunchDelete {

	public static void main(String[] args) {

		SessionFactory sessionFactory =  new
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
			
            // Create HQL delete query
            Query query = session.createQuery("delete from Student where sid = :id");
            query.setParameter("id", 4);

            // Execute the query
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
			if (flag==true) {
				transaction.commit();
	            System.out.println("Number of rows deleted: " + rowsAffected);

			}
			else {
				transaction.rollback();
	            System.out.println("Number of rows deleted: " + rowsAffected);

			}
			session.close();
			sessionFactory.close();
		}
	}

}

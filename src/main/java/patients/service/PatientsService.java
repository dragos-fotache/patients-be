package patients.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import patients.model.Patient;

public enum PatientsService {

	INSTANCE;

	private static SessionFactory factory;

	public List<Patient> getArticles() {

		List<Patient> result = null;
		
		factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			result = (List<Patient>)session.createQuery("FROM Patient").getResultList();
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}


		return result;
	}

}

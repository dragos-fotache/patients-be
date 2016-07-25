package patients.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import patients.model.Insurance;
import patients.model.Patient;

public enum PatientsService {

	INSTANCE;

	private static SessionFactory factory;

	public List<Patient> getPatients() {

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

	public PatientSliceAndCount getPatientsSlice(LazyLoadData lazyLoadData) {
		
		factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Query searchQuery = session.createQuery("FROM Patient where lastName like ? or firstName like ?");
			searchQuery.setParameter(0, "%" + lazyLoadData.getSearchStringParam() + "%");
			searchQuery.setParameter(1, "%" + lazyLoadData.getSearchStringParam() + "%");
			List<Patient> patients = (List<Patient>)searchQuery
										   .setFirstResult(lazyLoadData.getFirst())
										   .setMaxResults(lazyLoadData.getRows())
										   .getResultList();
			
			Query countQuery = session.createQuery("select count(p) from Patient p where lastName like ? or firstName like ?");
			countQuery.setParameter(0, "%" + lazyLoadData.getSearchStringParam() + "%");
			countQuery.setParameter(1, "%" + lazyLoadData.getSearchStringParam() + "%");
			Long count = (Long) countQuery.getSingleResult();
			
			tx.commit();
			
			return new PatientSliceAndCount(patients, count);
			
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;

	}
	
	public InsuranceSliceAndCount getInsurancesSlice(LazyLoadData lazyLoadData) {
		
		factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Query searchQuery = session.createQuery("FROM Insurance where healthInsuranceName like ?");
			searchQuery.setParameter(0, "%" + lazyLoadData.getSearchStringParam() + "%");
			List<Insurance> insurances = (List<Insurance>)searchQuery
					.setFirstResult(lazyLoadData.getFirst())
					.setMaxResults(lazyLoadData.getRows())
					.getResultList();
			
			Query countQuery = session.createQuery("select count(i) from Insurance i where healthInsuranceName like ?");
			countQuery.setParameter(0, "%" + lazyLoadData.getSearchStringParam() + "%");
			Long count = (Long) countQuery.getSingleResult();
			
			tx.commit();
			
			return new InsuranceSliceAndCount(insurances, count);
			
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
		
	}

}

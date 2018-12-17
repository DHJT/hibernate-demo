package com.dhjt.hibernatesearch.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Resource
public class BaseDaoImp<T> implements BaseDao {

	 private SessionFactory factory = HSessionFactory.getHSF().getSessionFactory();

	@Override
	public void update(Object t) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			employeeID = (Integer) session.save(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Object t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List list(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

}

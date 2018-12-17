package com.dhjt.hibernatesearch.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 获取hibernate的sessionfactory
 * @author DHJT 2018年12月14日 下午2:10:04
 *
 */
public enum HibernateFactory {
	SESSIONFACTORY;

	/**
	 * 初始化
	 */
	private void init() {
		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public void getSF() {
	}
}

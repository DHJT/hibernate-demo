package com.dhjt.hibernatesearch.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 获取Hibernate的SessionFactory
 * @author DHJT 2018年12月14日 下午3:33:44
 * 本例采用了单例模式中的饿汉式
 * 	非线程安全
 *  非Lazy初始化
 */
public class HSessionFactory {

	private static HSessionFactory hsf = new HSessionFactory();
	private SessionFactory sessionFactory;

	private HSessionFactory() {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static HSessionFactory getHSF() {
		return hsf;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

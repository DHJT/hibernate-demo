package com.dhjt.hibernatesearch.sample;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.dhjt.hibernatesearch.bean.Student;
import com.dhjt.hibernatesearch.bean.Teacher;

/**
 * 测试样例——Hibernate的多对多关系
 * @author DHJT 2018年12月11日-下午7:05:56
 */
public class ManyToMany {

	public static void select() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		// 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// 操作
		String hql = "from Teacher";
		Query<Teacher> query = session.createQuery(hql);
		List<Teacher> results = query.list();
		Set<Student> student = results.get(0).getStudents();
		for (Student student2 : student) {
			System.out.println(student2.getId());
			System.out.println(student2.getName());
		}
		System.out.println("-----------" + results.size());

		hql = "from Student";
//		Query<Student> stuQ = session.createQuery(hql);
//		List<Student> stuResults = stuQ.list();
//
//		Set<Teacher> teachList = stuResults.get(0).getT();
//		for (Teacher teacher : teachList) {
//			System.out.println(teacher.getId());
//		}
//		System.out.println(stuResults.get(0).getName() + "-----------" + stuResults.size());

		// 提交事务，并关闭持久化接口对象
		session.getTransaction().commit();
		session.close();
	}

	public static void add() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		// 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// 操作
		Teacher t1 = new Teacher();
		t1.setName("张老师");
		Teacher t2 = new Teacher();
		t2.setName("李老师");

		Student s1 = new Student();
		s1.setName("张学生");
		s1.setBirthDay(new Date());
		Student s2 = new Student();
		s2.setName("李学生");
		s2.setBirthDay(new Date());

		// 维护外键(不执行外键维护的话，中间表没有数据)
//		s1.getT().add(t1);
//		s2.getT().add(t2);
		// 级联保存
		t1.getStudents().add(s1);
		t2.getStudents().add(s2);
		session.save(t1);
		session.save(t2);
		// 提交事务，并关闭持久化接口对象
		session.getTransaction().commit();
		session.close();
	}

	public static void del() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		// 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// 操作
		Student s = session.get(Student.class, 1);

		session.delete(s);
		// 提交事务，并关闭持久化接口对象
		session.getTransaction().commit();
		session.close();
	}

}

package com.dhjt.hibernatesearch.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import com.dhjt.hibernatesearch.bean.LuceneBean;
import com.dhjt.hibernatesearch.bean.Pageinfo;

public class SearchUtils {

	/**
	 * 高亮显示文章
	 *
	 * @param query {@link org.apache.lucene.search.Query}
	 * @param data 未高亮的数据
	 * @param fields 需要高亮的字段
	 * @return 高亮数据
	 */
	public static List<LuceneBean> hightLight(Query query, List<LuceneBean> data, String... fields) {
		List<LuceneBean> result = new ArrayList<LuceneBean>();
//		Formatter formatter = new SimpleHTMLFormatter("<bstyle=\"colr:red\">", "</b>");
//		QueryScorer
		return null;

	}

	/**
	 * 创建索引
	 * @param sessionFactory 传入session工厂
	 * @return
	 */
	public static boolean index(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			//查出结果
			List<Pageinfo> pageinfos = session.createCriteria(Pageinfo.class).list();
//			session.
			//依次建立索引
			for (Iterator iterator = pageinfos.iterator(); iterator.hasNext();) {
				Pageinfo pageinfo = (Pageinfo) iterator.next();
				fullTextSession.index(pageinfo);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * Hibernate Search 通用查询方法
	 * @param sessionFactory
	 * @return
	 */
	public static boolean search(SessionFactory sessionFactory) {
		return true;
	}
}

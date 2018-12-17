package com.dhjt.hibernatesearch.dao;

import java.util.List;

public interface BaseDao<T> {

	public void update(T t);

	public void delete(T t);

	public void add(T t);

	public List<T> list(T t);
}

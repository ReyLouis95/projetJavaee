package com.iut;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

	List<T> read() throws SQLException;
	T readById(int id) throws SQLException;
	void create(T objet) throws SQLException;
	void update(T objet) throws SQLException;
	void delete(int id) throws SQLException;
}

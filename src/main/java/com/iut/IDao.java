package com.iut;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

	List<T> read() throws SQLException;
	T readById(int id) throws SQLException;
	boolean create(T objet) throws SQLException;
	boolean update(T objet) throws SQLException;
	boolean delete(int id) throws SQLException;
}

package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

public abstract class Dao<T> {
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/eventos?autoReconnect=true&useSSL=false";

	Connection cn = null;
	PreparedStatement stmt;
	ResultSet rs = null;

	public static Connection criarConexao() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, "root", "root");
	}
	
	public abstract void incluir(T elemento) throws Exception;
	
	public abstract T buscar(int id) throws Exception;
	
	public abstract Set<T> listar(int... param) throws Exception;

}

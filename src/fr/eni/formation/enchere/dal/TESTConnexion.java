package fr.eni.formation.enchere.dal;

import java.sql.SQLException;

import fr.eni.formation.enchere.dal.jdbc.ConnectionProvider;

public class TESTConnexion {
	public static void main(String[] args)throws SQLException {
		System.out.println(ConnectionProvider.getConnection());
		
	}

}

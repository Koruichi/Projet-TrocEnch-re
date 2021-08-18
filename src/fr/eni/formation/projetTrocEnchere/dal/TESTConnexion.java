package fr.eni.formation.projetTrocEnchere.dal;

import java.sql.SQLException;

import fr.eni.formation.projetTrocEnchere.dal.jdbc.ConnectionProvider;

public class TESTConnexion {
	public static void main(String[] args)throws SQLException {
		System.out.println(ConnectionProvider.getConnection());
		
	}

}

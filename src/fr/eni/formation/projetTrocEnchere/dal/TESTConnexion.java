package fr.eni.formation.projetTrocEnchere.dal;

import java.sql.SQLException;

public class TESTConnexion {
	public static void main(String[] args)throws SQLException {
		System.out.println(ConnectionProvider.getConnection());
		
	}

}

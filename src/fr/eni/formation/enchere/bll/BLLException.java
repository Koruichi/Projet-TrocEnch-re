package fr.eni.formation.enchere.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception{
	
	List<String> messages;
	
	public BLLException() {
		messages = new ArrayList<String>();
	}
	public void ajoutMessage(String msg) {
		messages.add(msg);
	}
	
	public List<String> getMessages(){
		return messages;
	}
	
	public boolean estVide() {
		return messages.isEmpty();
	}
	

}

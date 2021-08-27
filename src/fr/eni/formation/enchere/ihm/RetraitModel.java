package fr.eni.formation.enchere.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.formation.enchere.bo.Retrait;

public class RetraitModel {

	private Retrait retrait;
	private List<Retrait> lstRetrait;

	public RetraitModel() {
		super();
		retrait = new Retrait();
		lstRetrait = new ArrayList<Retrait>();
	}

	public RetraitModel(Retrait retrait, List<Retrait> lstRetrait) {
		super();
		this.retrait = retrait;
		this.lstRetrait = lstRetrait;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public List<Retrait> getLstRetrait() {
		return lstRetrait;
	}

	public void setLstRetrait(List<Retrait> lstRetrait) {
		this.lstRetrait = lstRetrait;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetraitModel [retrait=");
		builder.append(retrait);
		builder.append(", lstRetrait=");
		builder.append(lstRetrait);
		builder.append("]");
		return builder.toString();
	}

}
package com.ingeniousafrica.android;

import java.io.Serializable;

public class Voiture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Creation des variables locales
	private String marque;
	private String modele;
	private String constructeur;
	
	private String img;
	
	
	public Voiture(String marque, String modele, String constructeur, String img) {
		super();
		this.marque=marque;
		this.modele=modele;
		this.constructeur=constructeur;
		this.img = img;
		
		
	}
	
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getConstructeur() {
		return constructeur;
	}
	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}

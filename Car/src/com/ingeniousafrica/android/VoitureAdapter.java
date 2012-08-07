package com.ingeniousafrica.android;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class VoitureAdapter extends BaseAdapter{
	
	List <Voiture> liste;
	
	//LayoutInflater a pour mission de charger notre fichier "Voitureinfos.xml" pour l'item
	LayoutInflater inflater;
	
	//Creation du constructeur par defaut pour prendre 2 parametres: une liste et un contexte
	
	public VoitureAdapter(Context context,List<Voiture> liste) {
		
		inflater = LayoutInflater.from(context);
		
		this.liste=liste;
	
	}
	
	//methode qui retournera le nombre d élements dans notre liste
	public int getCount() {
		// TODO Auto-generated method stub
		
		//getCount retourne la taille
		return liste.size();
	}

	//methode qui retournera notre objet voiture à la position indiquée
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		
		//pour retourner l item
		return liste.get(position);
	}

	//methode qui retournera l id de voiture
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		
		//pour retourner la position de l item
		return position;
	}

	//Creation d une class qui nous servira à mémoriser les éléments de la liste en mémoire pour qu’à chaque rafraichissement l’écran ne scintille pas
	private class ViewHolder{

		TextView marque;
		TextView modele;
		TextView constructeur;

	}
	
	//methode qui retournera la vue de l'item pour l'affichage
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ViewHolder holder;
		
		if (convertView == null){
			
			holder = new ViewHolder();
			
			convertView = inflater.inflate(R.layout.voitureinfos, null);
			
			holder.marque =(TextView)convertView.findViewById(R.id.marque);
			holder.modele = (TextView)convertView.findViewById(R.id.modele);
			holder.constructeur = (TextView)convertView.findViewById(R.id.constructeur);
			
			convertView.setTag(holder);
			
		}else{
			
			holder = (ViewHolder)convertView.getTag();
			
		}
		
		holder.marque.setText(liste.get(position).getMarque());
		holder.modele.setText(liste.get(position).getModele());
		holder.constructeur.setText(liste.get(position).getConstructeur());
		
		
		return convertView;
	}
	
	

}

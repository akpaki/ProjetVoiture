package com.ingeniousafrica.android;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;



public class InfosActivity extends Activity implements OnClickListener{

	private ListView infos;
	private Button buttonOui;
	
	List<Voiture> liste = new ArrayList<Voiture>();
	 
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.affichageinfos);
	       
	        //Création d'un objet de type "Bundle" qui permet d'extraire les informations de l'intent envoyé par le Bundle de l'activité pricipale : 
	        Bundle objetbunble  = this.getIntent().getExtras();
	        
	        liste.add((Voiture)objetbunble.getSerializable("voiture"));
	        
	        infos =(ListView)findViewById(R.id.infos);
	        
	        VoitureAdapter adapter = new VoitureAdapter(this, liste);
	      
	        infos.setAdapter(adapter);
	        
	      //on cherche le boutton creer dans le fichier xml
	         buttonOui = (Button)findViewById(R.id.buttonOui);
	      //On crée un écouteur d'évènement pour notre  Button
	         buttonOui.setOnClickListener((OnClickListener) this);
	 
	    }
	        
				//@Override
				 public void onClick(View v){
			    	
					 if(v==buttonOui){
					 
					 Intent intent = new Intent(InfosActivity.this, CarActivity.class);
					 //On démarre l'autre Activity
	        		 //Methode permettant d envoyer notre intent vers son destinateur
	        		 startActivity(intent);
			    	
					 }
			    }
	
}
package com.ingeniousafrica.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;



public class CarActivity extends Activity {
	
        private ListView maListViewPerso;
        
        Voiture toyota;
        Voiture benz;
        Voiture bmw;
        
        //cREATION de notre liste d'infos
        List<Voiture> liste = new ArrayList<Voiture>();
        
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
     
            //R�cup�ration de la listview cr��e dans le fichier main.xml
            maListViewPerso = (ListView) findViewById(R.id.listviewperso);
            
            //Creation des objets de voiture
            toyota = new Voiture("Marque: Toyota", "Modele: Toyota Yaris ", "Constructeur: TOYOTA", String.valueOf(R.drawable.voiture1));
            benz = new Voiture("Marque: Benz", "Modele: Benz C Class", "Constructeur: BENZ", String.valueOf(R.drawable.voiture2));
            bmw = new Voiture("Marque: BMW", "Modele: BMW serie 5", "Constructeur: BMW", String.valueOf(R.drawable.voiture3));
     
            //Cr�ation de la ArrayList qui nous permettra de remplir la listView
            ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
     
            //On d�clare la HashMap qui contiendra les informations pour un item
            HashMap<String, String> map;
     
            //Cr�ation d'une HashMap pour ins�rer les informations du premier item de notre listView
            map = new HashMap<String, String>();
            
            //on ins�re un �l�ment titre que l'on r�cup�rera dans le textView titre cr�� dans le fichier affichageitem.xml
            map.put("titre", toyota.getMarque());
            //on ins�re un �l�ment description que l'on r�cup�rera dans le textView description cr�� dans le fichier affichageitem.xml
            map.put("description", "(more...) ");
            //on ins�re la r�f�rence � l'image (convertit en String car normalement c'est un int) que l'on r�cup�rera dans l'imageView cr�� dans le fichier affichageitem.xml
            map.put("img", toyota.getImg());
            //enfin on ajoute cette hashMap dans la arrayList
            listItem.add(map);
     
            //On refait la manip plusieurs fois avec des donn�es diff�rentes pour former les items de notre ListView
     
            map = new HashMap<String, String>();
            map.put("titre", benz.getMarque());
            map.put("description", "(more...) ");
            map.put("img", benz.getImg());
            listItem.add(map);
     
            map = new HashMap<String, String>();
            map.put("titre", bmw.getMarque());
            map.put("description", "(more...) ");
            map.put("img", bmw.getImg());
            listItem.add(map);
     
            //Cr�ation d'un SimpleAdapter qui se chargera de mettre les items pr�sent dans notre list (listItem) dans la vue affichageitem
            SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.affichageitem,
                   new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});
     
            //On attribut � notre listView l'adapter que l'on vient de cr�er
            maListViewPerso.setAdapter(mSchedule);
     
            //Enfin on met un �couteur d'�v�nement sur notre listView
            maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
            	
    			@SuppressWarnings("unchecked")
             	public void onItemClick(AdapterView<?> a, View v, int position, long id) {
    				
    				//on r�cup�re la HashMap contenant les infos de notre item (titre, description, img)
            		HashMap<String, String> itemAtPosition = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
            		HashMap<String, String> map = itemAtPosition;
            		
            		//On cr�� un objet Bundle, c'est ce qui va nous permetre d'envoyer des donn�es � l'autre Activity
        			Bundle objetbunble = new Bundle();
         
        			//Mettons les infos � transporter par couple cle/valeur
        			//Cela fonctionne plus ou moins comme une HashMap, on entre une clef et sa valeur en face
        			objetbunble.putString("titre", map.get("titre"));
        			
        			if (map.get("titre").equals("Toyota")){
        				objetbunble.putSerializable("voiture", toyota);
        				
        			}else if (map.get("titre").equals("Benz")){
        				objetbunble.putSerializable("voiture", benz);
        				
        			}else //if (map.get("titre").equals("BMW"))
        				{
        				objetbunble.putSerializable("voiture", bmw);
        				
        			}
        			
         
        			/*On cr�� l'Intent avec 2 parametres qui va nous permettre d'afficher l'autre Activity: 
        			  Le second prametre correspond � la cible de notre intent( Le new activity)
        			  Mettons le nom de l'Activity dans laquelle nous sommes actuellement
        			 * 
        			 */
        			Intent intent = new Intent(CarActivity.this, InfosActivity.class);
         
        			/*On affecte � l'Intent le Bundle que l'on a cr��. La methode "putExtras" est appliqu� sur un objet de type intent permet 
        			 * de transporter des infos et ayant pour principe couple
        			 * cle/valeur---> A chaque valeur correspond une cl�.
        			
        			 */
        			intent.putExtras(objetbunble);
         
        			//On d�marre l'autre Activity
        			//Methode permettant d envoyer notre intent vers son destinateur
        			startActivity(intent);
            		
            	}
             });
    }
}
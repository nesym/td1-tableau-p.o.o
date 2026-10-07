public class dictionnaire{
	private int nb_mots;
	private mot_dict[] dict;
	private String nom;


public dictionnaire(int n, String nom) {
	this.dict=new mot_dict[n];
	this.nb_mots=0;
	this.nom=nom;
}

public void trier() {
	for(int i=0;i<nb_mots-1;i++) {
		for(int j=i+1;j<nb_mots;j++) {
			if(dict[j].getmot().charAt(0)> dict[j+1].getmot().charAt(0)) {
				mot_dict temp=dict[j];
				dict[j]=dict[j+1];
				dict[j+1]=temp;
			}
		}
	}
}

public void ajouter(mot_dict m) {
	if(nb_mots>=dict.length){
		System.out.println("dict plein");
		return;
	}
	dict[nb_mots]=m;
	nb_mots++;
	trier();
}

public void supprimer_mot() {
	for(int i=0;i<nb_mots;i++) {
		String mot1=dict[i].getmot();
		String mot2=m.getmot();
		boolean ok=true;
		if(mot1.length()!=mot2.length()) {
			ok=false;
		}
		else {
			for(int j=0;j<mot1.length();j++) {
				if(mot1.charAt(j)!=mot2.charAt(j)) {
					ok=false;
				}
			}
		}
		if(ok) {
			for(int j=i;j<nb_mots-1;j++) {
				dict[j]=dict[j+1];
			}
			dict[nb_mots-1]=null;
			nb_mots--;
			return;
		}
	}
	
}

public String recherche_dicho(String mot) {
	int d=0;
	int f=nb_mots-1;
	while(d<=f) {
		int m=(d+f)/2;
		char l1=dict[m].getmot().charAt(0);
		char l2=mot.charAt(0);
		if (l1==l2) {
			return dict[m].getdefinition();
		}
		if(l1<l2) {
			d=m+1;
		}
		else {
			f=m-1;
		}
	}
	return "mot introuvable";
}

public int nombre_synonyme(mot_dict m) {
	int comp=0;
	for(int i=0;i<nb_mots;i++) {
		String def1=dict[i].getdefinition();
		String def2=m.getdefinition();
		boolean ok=true;
		if(def1.length()!=def2.length()) {
			ok=false;
		}
		else {
			for(int j=0;j<def1.length();j++) {
				if(def1.charAt(j)!=def2.charAt(j)) {
					ok=false;
				}
			}
		}
		if (ok && dict[i].getmot().charAt(0) != m.getmot().charAt(0)) {
			comp++;
		}
	}
	return comp;
}

}

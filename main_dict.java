
public class main_dict {
	public static void main(String[] args) {
		dictionnaire d= new dictionnaire(10,"mon dictionnaire");
		mot_dict m1=new mot_dict("rapide","qui se deplace vite");
		mot_dict m2=new mot_dict("vite","qui se deplace vite");
		mot_dict m3=new mot_dict("lent","qui se deplace doucement");
		mot_dict m4=new mot_dict("maison","lieu ou une personne habite");
		
		d.ajouter(m1);
		d.ajouter(m2);
		d.ajouter(m3);
		d.ajouter(m4);
		
		System.out.println("=== dictionnaire ===");
		d.lister();
		
		System.out.println("\n=== recherche ===");
		System.out.println(d.recherche_dicho("maison"));
		
		System.out.println("=== synonymes ===");
		System.out.println("nbres de synonymes de rapide : "+d.nombre_synonyme(m1));
		
		d.supprimer_mot(m3);
		
		System.out.println("=== apres suppression ===");
		d.lister_dictionnaire();
		
		
	}
}

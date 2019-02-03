package application;

public class Joueur {
	
	public static int score = 0;
	public static String pseudo;
	
	//constructeur de la classe joueur
	private Joueur(){
	}
	
	private static Joueur joueur = null;
	
	// méthode qui crée une instance de la classe joueur.
	public static Joueur getInstance(){
		joueur = new Joueur();		
		return joueur;
	}
	
	//méthode qui met le score de la base de donnée d'un joueur à jour.
	public static void setScore(int sc, String login){
		int s = bdConnect.getScoreJoueur(login);
		s = s + sc;
		bdConnect.setScoreJoueur(s, login);
		Joueur.score = s;
	}
	
	//méthode qui donne la valeur de login à pseudo.
	public static void setPseudo(String login){
		pseudo = login;
	}
	
	//méthode qui donne la valeur du score enregistré dans la base de donnée à score pour un login précis.
	public static int getScore(String login){
		score = bdConnect.getScoreJoueur(login);
		return score;
	}
	
	//méthode qui retourne le pseudo.
	public static String getPseudo(){
		return pseudo;
	}
	
	//méthode qui initialize le score d'une instance de joueur avec le score de la base de donnée pour un login.
	public static void initializeScore(String login){
		Joueur.score = bdConnect.getScoreJoueur(login);
		bdConnect.setScoreJoueur(bdConnect.getScoreJoueur(login), login);		
	}
	
}

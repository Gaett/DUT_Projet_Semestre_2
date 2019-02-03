package application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
public class Connexion {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Button suivant;
	@FXML
	private Button creation;
	@FXML
	private TextField login;
	@FXML
	private TextField motDePasse;
	@FXML
	private Label info;
	@FXML
	private Button valider;
	
	@FXML
	public void suivant() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void create() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("creation.fxml"));
		rootPane.getChildren().setAll(pane);		
	}
	

	//méthode qui renvoie true si le login existe dans la base de donnée.
	public static boolean verifLogin(String pseudo){
		boolean res = false;
		res = bdConnect.exist(pseudo);
		return res;
	}
	
	//méthode qui renvoie true si le mot de passe correspond à celui du login dans la base de donnée.
	public static boolean verifMotDePasse(String pseudo,String mdp){
		if(verifLogin(pseudo) == true){
			if(mdp.equals(bdConnect.getPassWord(pseudo))){
				return true;
			}
			return false;
		}
		return false;
	}
	
	//méthode qui renvoie true si les deux méthodes précédente sont également à true, puis crée une instance de joueur.
	public static boolean validerConnection(String pseudo, String mdp, Label inf) {
		if(verifLogin(pseudo) && verifMotDePasse(pseudo,mdp)){
			Joueur.getInstance();
			Joueur.setPseudo(pseudo);
			Joueur.initializeScore(pseudo);
			inf.setText("Connexion réussite");
			return true;
		}
		else{
			if(verifLogin(pseudo) == false){
				inf.setText("Le nom est invalide");
				return false;
			}
			else{
				if(verifMotDePasse(pseudo,mdp) == false){
					inf.setText("Le mot de passe est incorrecte");
					return false;
				}
			}
		}
		return false;
	}
	
	@FXML
	public void validation(){
		String log = this.login.getText();
		String mdp = this.motDePasse.getText();
		if(Connexion.validerConnection(log, mdp, info)){
			Joueur.initializeScore(log);
		}
	}
	
	public static void main (String[]args){
	}
	
}

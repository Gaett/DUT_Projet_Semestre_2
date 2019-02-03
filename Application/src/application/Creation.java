package application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
public class Creation {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Button retour;
	@FXML
	private TextField login;
	@FXML
	private TextField motDePasse;
	@FXML
	private Button valider;
	@FXML
	private Label info;
	@FXML
	public void retour() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("connexion.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	//méthode qui renvoie false si le login n'est pas déjà présent dans la base de donnée.	
	public boolean verifLogin(){
		boolean res = false;
		for(int compteur = 0; compteur < bdConnect.getAllJoueur().length; ++compteur){
			if((login.getText().equals(bdConnect.getAllJoueur()[compteur]) == false) && login.getText().length() <= 10 ){
				res = false;
			}
			else{
				res = true;
				return res;
			}
		}
		return res;
	}
	
	
	//méthode qui renvoie true si le mot de passe contient entre 8 et 10 caractères.
	public boolean verifMotDePasse(){
		if(motDePasse.getText().length() >= 8 && motDePasse.getText().length() <= 10){
			return true;
		}
		return false;
	}
	
	
	//méthode qui crée dans la base de donnée un login et un mot de passe associé si les deux méthodes précédentes ont renvoyé true.
	public void validerInscription(){
		if(verifLogin() == false && verifMotDePasse() == true){
			bdConnect.insertPlayer(login.getText(), motDePasse.getText());
			info.setText("Inscription validé");;
		}
		else{
			if(verifLogin() == true){
				info.setText("Le nom est déjà utilisé");
			}
			else{
				if(verifMotDePasse() == false){
					info.setText("Le mot de passe doit contenir entre 8 et 10 caractères");
				}
			}
		}
		
	}
}

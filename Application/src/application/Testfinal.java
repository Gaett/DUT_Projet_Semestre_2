package application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
/**
 * Testfinal est la classe représentant le test pour passer au niveau suivant 
 * Cette classe contient:
 * <ul> 
 * <li> Plusieurs fx:id.
 * <li> Un attribut d'instance pour faire apparaitre le Button nivSuiv.
 * <li> Une méthode FXML qui permet de cacher le bouton pour accéder au niveau suivant et d'afficher les images.
 * <li> Une méthode FXML qui permet de revneir à l'interface du niveau.
 * <li> Une méthode FXML qui permet de vérifier la réponse qu'a donné le joueur, et de lui permettre de passer au nieveau suivant s'il a réussit
 * <li> Une méthode permettant de normaliser un texte
 * <li> Une méthode FXML qui renvoie sur l'interface du niveau suivant
 * </ul>
 *
 * @author Gaëtan BARRET
 * @author Enor-Anaïs CARRE
 * @version 20/06/18
 */
public class Testfinal {
	/**
	 * fx:id associé à l'AnchorPane de la scène
	 * @author Gaëtan BARRET
	 */
	@FXML
	private AnchorPane rootPane;
	/**
	 * fx:id associé au Button menant au menu du niveau
	 * @author Gaëtan BARRET
	 */
	@FXML
	private Button boutonRetourCarte;
	/**
	 * fx:id associé au Button permettant de déclencher la méthode reponse
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Button valid;
	/**
	 * fx:id associé au Button permettant d'accéder au niveau suivant
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Button nivSuiv;
	/**
	 * fx:id associé au TextField où le joueur entrera sa réponse
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private TextField repJoueur;
	/**
	 * fx:id associés aux ImageView affichant les images des hiraganas
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private ImageView hi1;
	@FXML
	private ImageView hi2;
	@FXML
	private ImageView hi3;
	@FXML
	private ImageView hi4;
	@FXML
	private ImageView hi5;
	/**
	 * fx:id associé au Label qui affiche un message au joueur
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Label msg;
	/**
	 * Attribut d'instance boolean qui permet de cacher ou faire apparaitre le Button nivSuiv
	 * @author Enor-Anaïs CARRE
	 */
	private boolean nivS = false;
	/**
	 * Attribut d'instance permettant que la méthode initialisation ne se déclenche qu'une fois 
	 * @author Enor-Anaïs CARRE
	 */
	private boolean ouvPage = true;
	/**
	 * Méthode FXML qui permet de cacher le bouton pour accéder au niveau suivant et d'afficher les images
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	public void initialisation(){
		if(this.ouvPage){
		this.nivSuiv.setVisible(this.nivS);
		int niv = Carte.getNiv();
		int id[] = new int[5];
		if(niv == 1){
			int idNiv[] = {8,3,10,3};
			id = idNiv;
		}
		if(niv == 2){
			int idNiv[] = {5,5,11,6};
			id = idNiv;
		}
		if(niv == 3){
			int idNiv[] = {28,8,5,6};
			id = idNiv;
		}
		if(niv == 4){
			int idNiv[] = {20,3,7,38,3};
			id = idNiv;
		}
		if(niv == 5){
			int idNiv[] = {22,30,45};
			id = idNiv;
		}
		this.hi1.setImage(bdConnect.getHiraganaId(id[0]));
		this.hi2.setImage(bdConnect.getHiraganaId(id[1]));
		this.hi3.setImage(bdConnect.getHiraganaId(id[2]));
		this.hi4.setImage(bdConnect.getHiraganaId(id[3]));
		this.hi5.setImage(bdConnect.getHiraganaId(id[4]));
		this.ouvPage = false;
		}
	}
	/**
	 * Méthode FXML qui renvoie sur l'interface niveau 
	 * @author Gaëtan BARRET
	 * @throws IOException
	 */
	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	/**
	 * Méthode FXML qui vérifie la réponse du joueur et qui affiche nivSuiv s'il a trouvé
	 * @author Enor-Anaïs CARRE
	 * @return repTrue	retourne true si la réponse à était trouvé, false sinon
	 */
	@FXML
	public boolean reponse(){
		String cont = this.repJoueur.getText();
		boolean repTrue = false;
		int niv = Carte.getNiv();
		int nivJ = bdConnect.niveauVu(Joueur.getPseudo());
		cont = normalisation(cont);
		this.repJoueur.setText("");
		this.msg.setText("");
		
		if(cont.equals(bdConnect.nomVille(niv))){
			repTrue = true;
		}
	
		if (repTrue){
			this.msg.setText("Bonne réponse !");
			this.nivS = true;
			if(niv == 5){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Fin des niveaux");
				alert.setHeaderText(null);
				alert.setContentText("Vous avez finis tous les niveaux");
				alert.showAndWait();
			}
			else{
				this.nivSuiv.setVisible(this.nivS);
				if(niv == nivJ){
					bdConnect.villeVu(Joueur.getPseudo(), nivJ + 1);
				}
			}
		}
		else{
			this.msg.setText("Mauvaise réponse");
		}
		return repTrue;
	}
	
	/**
	 * Méthode permettant de normaliser le texte en paramètre en lui retirant les espaces et mettant tous les caractères en capital
	 * @author Enor-Anaïs CARRE
	 * @param contenue	prend en paramètre une chaine de caractère 
	 * @return contenue	retourne la chaine de caractère passer en paramètre sans espace ni minuscule
	 */
	public String normalisation(String contenue){
		contenue = contenue.replaceAll(" ", "");
		contenue = contenue.toUpperCase();
		return contenue;
	}
	/**
	 * Méthode FXML qui renvoie sur l'interface du niveau en augmentant de 1 l'attribut static niv de la classe Carte, seulement si celui-ci est déjà compris entre 1 et 4 
	 * @author Enor-Anaïs CARRE
	 * @throws IOException
	 */
	@FXML
	public void accesNivSuiv() throws IOException{
		int niv = Carte.getNiv();
		if(niv < 5 && niv > 0){
			niv++;
		}
		Carte.setNiv(niv);
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	
}

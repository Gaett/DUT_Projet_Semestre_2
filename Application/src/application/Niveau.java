package application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Niveau est la classe représentant le menu du niveau à partir duquel on choisit un jeu, de voir les lignes du tableau ou de passer le test
 * Cette classe contient:
 * <ul> 
 * <li> Plusieurs fx:id.
 * <li> Un attribut de classe permettant de sauvegarder le jeu cliqué.
 * <li> Une méthode FXML permettant de modifier le titre de la page.
 * <li> Une méthode FXML permettant de retourner à l'interface de la carte.
 * <li> Trois méthodes FXML permettant d'accéder au jeu tout en gardant le nom dans l'attribut jeu.
 * <li> Une méthode FXML permettant d'accéder à l'interface du test.
 * <li> Une méthode FXML permettant d'accéder à l'interface de ligne.
 * <li> Un accesseur static de l'attribut niv.
 * <li> Une méthode FXML permettant d'afficher les images des lignes
 * </ul>
 *
 * @author Gaëtan BARRET
 * @author Enor-Anaïs CARRE
 * @version 20/06/18
 */
public class Niveau {
	/**
	 * fx:id associé à l'AnchorPane de la scène
	 * @author Gaëtan BARRET
	 */
	@FXML
	private AnchorPane rootPane;
	/**
	 * fx:id associé au Button menant au menu carte
	 * @author Gaëtan BARRET
	 */
	@FXML
	private Button boutonRetourCarte;
	/**
	 * fx:id associé aux Button menant au choix de la difficulté
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Button llt;
	@FXML
	private Button svar;
	@FXML
	private Button hm;
	/**
	 * fx:id associé au Button menant au test
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Button nivSuiv;
	/**
	 * fx:id associé au Button menant à l'interface de ligne
	 * @author Enor-Anaïs CARRE
	 */
	//@FXML
	//private Button ligne;
	/**
	 * fx:id associé au Label qui correspond au titre
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Label titre;
	/**
	 * fx:id associé à l'ImageView de la première ligne
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private ImageView lg1;
	/**
	 * fx:id associé à l'ImageView de la deuxième ligne
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private ImageView lg2;
	/**
	 * Attribut de classe servant à enregistrer le jeu choisit par le joueur
	 * @author Enor-Anaïs CARRE
	 */
	private static String jeu;
	/**
	 * Attribut d'instance permettant que la méthode initialisation ne se déclenche qu'une fois 
	 * @author Enor-Anaïs CARRE
	 */
	private boolean ouvPage = true;
	
	/**
	 * Méthodes FXML qui met à jour le titre de la page en fonction du niveau choisit par le joueur
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	public void nivLabel(){
		if(this.ouvPage){
			String s = "Niveau " + Carte.getNiv();
			this.titre.setText(s);
			afficherImg();
			this.ouvPage = false;
		}
	}
	/**
	 * Méthode FXML qui renvoie sur l'interface carte 
	 * @author Gaëtan BARRET
	 * @throws IOException
	 */
	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	/**
	 * Méthodes FXML qui renvoient sur l'interface de difficulté tout en modifiant l'attribut static jeu
	 * @author Enor-Anaïs CARRE
	 * @throws IOException
	 */
	@FXML
	public void llt() throws IOException {
		jeu = "llt";
		AnchorPane pane = FXMLLoader.load(getClass().getResource("difficulte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void svar() throws IOException {
		jeu = "svar";
		AnchorPane pane = FXMLLoader.load(getClass().getResource("difficulte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void hm() throws IOException {
		jeu = "hm";
		AnchorPane pane = FXMLLoader.load(getClass().getResource("difficulte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	/**
	 * Méthodes FXML qui renvoient sur l'interface du test
	 * @author Enor-Anaïs CARRE
	 * @throws IOException
	 */
	@FXML
	public void nivSuiv() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("testfinal.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	/**
	 * Méthodes FXML qui renvoient sur l'interface de ligne
	 * @author Enor-Anaïs CARRE
	 * @throws IOException
	 */
	//@FXML
	//public void ligne() throws IOException {
	//	AnchorPane pane = FXMLLoader.load(getClass().getResource("ligne.fxml"));
	//	rootPane.getChildren().setAll(pane);
	//}
	
	/**
	 * Accesseur static sur l'attribut de classe 
	 * 
	 * @author Enor-Anaïs CARRE
	 * @return jeu	retourne le jeu choisit par le joueur sous la forme d'un String
	 */
	public static String getJeu(){
		return jeu;
	}
	
	/**
	 * Méthode FXML permettant d'afficher les images de lignes
	 * 
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	public void afficherImg(){
		int niv = Carte.getNiv();
		this.lg1.setImage(bdConnect.getLigneNiveau(niv)[0]);
		this.lg2.setImage(bdConnect.getLigneNiveau(niv)[1]);
	}
	
}

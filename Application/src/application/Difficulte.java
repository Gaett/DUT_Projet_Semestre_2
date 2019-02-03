package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
/**
 * Difficulte est la classe permettant de choisir entre les trois niveaux de difficultés
 * Cette classe contient:
 * <ul> 
 * <li> Plusieurs fx:id.
 * <li> Un attribut de classe permettant de sauvegarder la difficulté cliqué.
 * <li> Une méthode FXML permettant de retourner sur l'interface niveau.
 * <li> Trois méthodes FXML permettant d'accéder au jeu tout en gardant la valeur de la difficulté dans l'attribut difficulte.
 * <li> Un accesseur static de l'attribut difficulte.
 * </ul>
 *
 * @author Gaëtan BARRET
 * @author Enor-Anaïs CARRE
 * @version 19/06/18
 */
public class Difficulte {
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
	 * fx:id associés aux Button menant aux différents jeux
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Button fac;
	@FXML
	private Button moy;
	@FXML
	private Button dif;
	/**
	 * Attribut de classe servant à enregistrer la difficulté choisit par le joueur
	 * @author Enor-Anaïs CARRE
	 */
	private static int difficulte;
	
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
	 * Méthodes FXML qui renvoient sur l'interface du jeu choisit dans l'interface niveau tout en modifiant l'attribut static difficulte
	 * @author Enor-Anaïs CARRE
	 * @throws IOException
	 */
	@FXML
	public void fac() throws IOException {
		String url = "" + Niveau.getJeu() + "1.fxml";
		difficulte = 1;
		AnchorPane pane = FXMLLoader.load(getClass().getResource(url));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void moy() throws IOException {
		String url = "" + Niveau.getJeu() + "1.fxml";
		difficulte = 2;
		AnchorPane pane = FXMLLoader.load(getClass().getResource(url));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void dif() throws IOException {
		String url = "" + Niveau.getJeu() + "1.fxml";
		difficulte = 3;
		AnchorPane pane = FXMLLoader.load(getClass().getResource(url));
		rootPane.getChildren().setAll(pane);
	}
	/**
	 * Accesseur static sur l'attribut de classe 
	 * 
	 * @author Enor-Anaïs CARRE
	 * @return difficulte	retourne la difficulté choisit par le joueur sous la forme d'un int
	 */
	public static int getDiff(){
		return difficulte;
	}
	
}

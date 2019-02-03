package application;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Carte est la classe représentant le menu principal sur lequel on choisit le niveau
 * Cette classe contient:
 * <ul> 
 * <li> Plusieurs fx:id.
 * <li> Deux attribut de classe permettant de sauvegarder le niveau cliqué et de sauvegarder le niveau du joueur.
 * <li> Un attribut d'instance
 * <li> Une méthode FXML qui initialise les Button et les Label de l'interface.
 * <li> Cinq méthodes FXML permettant d'accéder au niveau tout en gardant la valeur dans l'attribut niv.
 * <li> Un accesseur static et un modificateur static de l'attribut niv.
 * <li> Un accesseur static et un modificateur static de l'attribut nivJoueur.
 * </ul>
 *
 * @author Gaëtan BARRET
 * @author Enor-Anaïs CARRE
 * @version 21/06/18
 */

public class Carte {
	
	/**
	 * fx:id associé à l'AnchorPane de la scène
	 * @author Gaëtan BARRET
	 */
	@FXML
	private AnchorPane rootPane;
	/**
	 * fx:id associés aux Button menant aux différents niveaux
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Button niv1;
	@FXML 
	private Button niv2;
	@FXML
	private Button niv3;
	@FXML
	private Button niv4;
	@FXML
	private Button niv5;
	/**
	 * fx:id associé au Label affichant le pseudo du joueur
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Label pseudo;
	/**
	 * fx:id associé au Label affichant le score du joueur
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	private Label score;
	/**
	 * Attribut de classe servant à enregistrer le niveau choisit par le joueur
	 * @author Enor-Anaïs CARRE
	 */
	private static int niv = 1;
	/**
	 * Attribut de classe servant à enregistrer le niveau du joueur
	 * @author Enor-Anaïs CARRE
	 */
	//private static int nivJoueur = 1;
	/**
	 * Attribut d'instance permettant que la méthode initialisation ne se déclenche qu'une fois 
	 * @author Enor-Anaïs CARRE
	 */
	private boolean ouvPage = true;
	/**
	 * Méthode FXML qui empêche l'accès des niveaux auquels le joueur ne peut pas joué et affiche les informations du joueur
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	public void initialisation(){
		if(this.ouvPage){
			bdConnect.villeVu(Joueur.getPseudo(),1);
			System.out.print("" + bdConnect.niveauVu(Joueur.getPseudo()));
			Button[] nivBut = {niv1,niv2,niv3,niv4,niv5};
			for(int i = bdConnect.niveauVu(Joueur.getPseudo()); i < 5; i++){
				nivBut[i].setVisible(false);
			}
			String ps = "" + Joueur.getPseudo();
			this.pseudo.setText(ps);
			String sc = "" + bdConnect.getScoreJoueur(ps) + " points";
			this.score.setText(sc);
			this.ouvPage = false;
		}
	}
	
	/**
	 * Méthodes FXML qui renvoient sur l'interface du niveau tout en modifiant l'attribut static niv
	 * @author Enor-Anaïs CARRE
	 * @throws IOException
	 */
	@FXML
	public void niv1() throws IOException {
		niv = 1;
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void niv2() throws IOException {
		niv = 2;
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void niv3() throws IOException {
		niv = 3;
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void niv4() throws IOException {
		niv = 4;
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void niv5() throws IOException {
		niv = 5;
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	/**
	 * Accesseur static sur l'attribut de classe 
	 * 
	 * @author Enor-Anaïs CARRE
	 * @return niv	retourne le niveau choisit par le joueur 
	 */
	public static int getNiv(){
		return niv;
	}
	
	/**
	 * Modificateur static sur l'attribut de classe 
	 * 
	 * @author Enor-Anaïs CARRE
	 * @param nouvNiv	change le niveau choisit par le joueur par un nouveau niveau 
	 */
	public static void setNiv(int nouvNiv){
		niv = nouvNiv;
	}
	
	/**
	 * Accesseur static sur l'attribut de classe 
	 * 
	 * @author Enor-Anaïs CARRE
	 * @return nivJoueur	retourne le niveau du joueur 
	 */
	//public static int getNivJoueur(){
	//	return nivJoueur;
	//}
	
	/**
	 * Modificateur static sur l'attribut de classe 
	 * 
	 * @author Enor-Anaïs CARRE
	 * @param nouvNiv	change le niveau du joueur
	 */
	//public static void setNivJoueur(int nouvNiv){
	//	nivJoueur = nouvNiv;
	//}
}

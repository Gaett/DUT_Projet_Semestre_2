package application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
/**
 * Ligne est la classe permettant au joueur de visionner les deux lignes du niveau sélectionner dans la classe carte
 * Cette classe contient:
 * <ul> 
 * <li> Plusieurs fx:id.
 * <li> Une méthode permettent de retourner au menu du niveau
 * <li> Une méthode permettant d'afficher les images des lignes du tableau
 * </ul>
 *
 * @author Gaëtan BARRET
 * @uthor Enor-Anaïs CARRE
 * @version 20/06/18
 */
public class Ligne {
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
	 * Méthode FXML permettant de revenir au menu du niveau
	 * 
	 * @author Gaëtan BARRET
	 * @throws IOException
	 */
	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	/**
	 * Méthode FXML permettant d'afficher les images de lignes
	 * 
	 * @author Enor-Anaïs CARRE
	 */
	@FXML
	public void afficher(){
		int niv = Carte.getNiv();
		this.lg1.setImage(bdConnect.getLigneNiveau(niv)[0]);
		this.lg2.setImage(bdConnect.getLigneNiveau(niv)[1]);
			
	}
}

package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Llt1 {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Label labelTemps;
	@FXML
	private Button boutonRetourCarte;
	@FXML
	private Button boutonContinuer;
	@FXML
	private Button boutonSkip;
	@FXML
	private ImageView ligne1;
	@FXML
	private ImageView ligne2;
	
	private Chrono chrono;
	
	private Robot robot;
	
	private LigneRequete lr;
	
	private boolean pageOuverte = true;
	
	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void continuer() throws IOException{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("llt2.fxml"));
		rootPane.getChildren().setAll(pane);
		this.chrono.resetChrono();
	}
	
	public void chrono() throws AWTException{
		this.chrono = Chrono.getInstance();
		this.chrono.startChrono();
		this.boutonContinuer.setVisible(false);
		this.robot = new Robot();
		this.robot.keyPress(KeyEvent.VK_A);
		if (Difficulte.getDiff() == 1){
			if (this.chrono.seconds != 60){
				this.labelTemps.setText("Temps actuel : " + this.chrono.seconds + " secondes");
				this.boutonContinuer.setVisible(false);
				this.ligne1.setVisible(true);
				this.ligne2.setVisible(true);
			}
		
			if (this.chrono.seconds == 60){
				this.robot.keyRelease(KeyEvent.VK_A);
				this.boutonContinuer.setVisible(true);
				this.boutonContinuer.setDisable(false);
				this.labelTemps.setText("Temps écoulé !");
				this.ligne1.setVisible(false);
				this.ligne2.setVisible(false);
				this.chrono.stopChrono();
			}
		}
		
		else if (Difficulte.getDiff() == 2){
			if (this.chrono.seconds != 30){
				this.labelTemps.setText("Temps actuel : " + this.chrono.seconds + " secondes");
				this.boutonContinuer.setVisible(false);
				this.ligne1.setVisible(true);
				this.ligne2.setVisible(true);
			}
		
			if (this.chrono.seconds == 30){
				this.robot.keyRelease(KeyEvent.VK_A);
				this.boutonContinuer.setVisible(true);
				this.boutonContinuer.setDisable(false);
				this.labelTemps.setText("Temps écoulé !");
				this.ligne1.setVisible(false);
				this.ligne2.setVisible(false);
				this.chrono.stopChrono();
			}
		}
		
		else if (Difficulte.getDiff() == 3){
			if (this.chrono.seconds != 15){
				this.labelTemps.setText("Temps actuel : " + this.chrono.seconds + " secondes");
				this.boutonContinuer.setVisible(false);
				this.ligne1.setVisible(true);
				this.ligne2.setVisible(true);
			}
		
			if (this.chrono.seconds == 15){
				this.robot.keyRelease(KeyEvent.VK_A);
				this.boutonContinuer.setVisible(true);
				this.boutonContinuer.setDisable(false);
				this.labelTemps.setText("Temps écoulé !");
				this.ligne1.setVisible(false);
				this.ligne2.setVisible(false);
				this.chrono.stopChrono();
			}
		}
	}

	@FXML
	public void initialiserChrono() throws AWTException, IOException{
		this.chrono();
	}

	@FXML
	public void afficherLignes() throws IOException{
		if (this.pageOuverte == true){
		this.boutonContinuer.setVisible(false);
		lr = LigneRequete.getInstance();
		if (Carte.getNiv() == 1){
			this.ligne1.setImage(lr.getImage(1));
			this.ligne2.setImage(lr.getImage(2));
		}
		if (Carte.getNiv() == 2){
			this.ligne1.setImage(lr.getImage(3));
			this.ligne2.setImage(lr.getImage(4));
		}
		if (Carte.getNiv() == 3){
			this.ligne1.setImage(lr.getImage(5));
			this.ligne2.setImage(lr.getImage(6));
		}
		if (Carte.getNiv() == 4){
			this.ligne1.setImage(lr.getImage(7));
			this.ligne2.setImage(lr.getImage(8));
		}
		if (Carte.getNiv() == 5){
			this.ligne1.setImage(lr.getImage(9));
			this.ligne2.setImage(lr.getImage(10));
		}
		this.pageOuverte = false;
		}
	}
	
	public void skip(){
		this.labelTemps.setText("Temps écoulé !");
		this.boutonContinuer.setVisible(true);
		this.ligne1.setVisible(false);
		this.ligne2.setVisible(false);
		this.ligne2.setDisable(false);
		this.chrono.stopChrono();
		this.robot.keyRelease(KeyEvent.VK_A);
	}
}

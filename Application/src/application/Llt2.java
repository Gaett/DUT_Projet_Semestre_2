
package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Llt2 {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Label labelTemps;
	@FXML
	private Label labelScore;
	@FXML
	private Button boutonValider;
	@FXML
	private Button boutonRetourCarte;
	@FXML
	private Button boutonReset;
	@FXML
	private ChoiceBox<String> choiceBox1;
	@FXML
	private ChoiceBox<String> choiceBox2;
	@FXML
	private ChoiceBox<String> choiceBox3;
	@FXML
	private ChoiceBox<String> choiceBox4;
	@FXML
	private ChoiceBox<String> choiceBox5;
	@FXML
	private ImageView hira1;
	@FXML
	private ImageView hira2;
	@FXML
	private ImageView hira3;
	@FXML
	private ImageView hira4;
	@FXML
	private ImageView hira5;
	@FXML
	private Circle c1;
	@FXML
	private Circle c2;
	@FXML
	private Circle c3;
	@FXML
	private Circle c4;
	@FXML
	private Circle c5;
	@FXML
	private Label labelEssais;
	@FXML
	private Label labelTropNul;
	
	private Image img1;
	private Image img2;
	private Image img3;
	private Image img4;
	private Image img5;
	
	private int l1 = this.getRandomNumberInRange(0, 9);
	private int l2 = this.getRandomNumberInRange(0, 9);
	private int l3 = this.getRandomNumberInRange(0, 9);
	private int l4 = this.getRandomNumberInRange(0, 7);
	private int l5 = this.getRandomNumberInRange(0, 7);
	
	private String roma1;
	private String roma2;
	private String roma3;
	private String roma4;
	private String roma5;
	
	private Chrono chrono;
	
	private boolean antiCheat = false;
	
	private HiraganaRequete hr;
	
	private int essais;
	
	private RomajiRequete rr;
	
	private Robot robot;
	
	int score = 0;
	
	static ObservableList<String> romaji = FXCollections.observableArrayList("a","i","u","e","o","ka","ki","ku","ke","ko");
	static ObservableList<String> romaji2 = FXCollections.observableArrayList("sa","shi","su","se","so","ta","chi","tsu","te","to");
	static ObservableList<String> romaji3 = FXCollections.observableArrayList("na","ni","nu","ne","no","ha","hi","fu","he","ho");
	static ObservableList<String> romaji4 = FXCollections.observableArrayList("ma","mi","mu","me","mo","ya","yu","yo");
	static ObservableList<String> romaji5 = FXCollections.observableArrayList("ra","ri","ru","re","ro","wa","-n","wo");
	private boolean pageOuverte = true;
	
	
	
	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
		this.chrono.stopChrono();
		this.chrono.resetChrono();
		this.robot.keyRelease(KeyEvent.VK_A);
	}
	
	public void chrono() throws AWTException{
		this.robot = new Robot();
		this.chrono = Chrono.getInstance();
		this.chrono.startChrono();
		robot.keyPress(KeyEvent.VK_A);
		this.chrono.startChrono();
		if (this.chrono.seconds  < 60 ||this.chrono.seconds  == 60 || this.chrono.seconds  > 60 ){
			this.labelTemps.setText(chrono.hours + " : " + chrono.minutes + " : " + chrono.seconds);
			this.labelScore.setText("Votre score : " + this.score);
		}
	}
	
	@FXML
	public void initialiserChrono() throws AWTException{
		this.chrono();
	}
	
	@FXML
	public void beginGame(){
		if (this.pageOuverte == true){
			this.initialize();
			this.afficherHiragana();
			this.pageOuverte = false;
		}
	}
	
	public void initialize(){
		if (Carte.getNiv() == 1){
			this.choiceBox1.setItems(romaji);
			this.choiceBox2.setItems(romaji);
			this.choiceBox3.setItems(romaji);
			this.choiceBox4.setItems(romaji);
			this.choiceBox5.setItems(romaji);
		}
		
		else if (Carte.getNiv() == 2){
			this.choiceBox1.setItems(romaji2);
			this.choiceBox2.setItems(romaji2);
			this.choiceBox3.setItems(romaji2);
			this.choiceBox4.setItems(romaji2);
			this.choiceBox5.setItems(romaji2);
		}
		
		else if (Carte.getNiv() == 3){
			this.choiceBox1.setItems(romaji3);
			this.choiceBox2.setItems(romaji3);
			this.choiceBox3.setItems(romaji3);
			this.choiceBox4.setItems(romaji3);
			this.choiceBox5.setItems(romaji3);
		}
		
		else if (Carte.getNiv() == 4){
			this.choiceBox1.setItems(romaji4);
			this.choiceBox2.setItems(romaji4);
			this.choiceBox3.setItems(romaji4);
			this.choiceBox4.setItems(romaji4);
			this.choiceBox5.setItems(romaji4);
		}
		
		else if (Carte.getNiv() == 5){
			this.choiceBox1.setItems(romaji5);
			this.choiceBox2.setItems(romaji5);
			this.choiceBox3.setItems(romaji5);
			this.choiceBox4.setItems(romaji5);
			this.choiceBox5.setItems(romaji5);
		}
	}
	
	public void afficherHiragana(){
		this.img1 = this.getHira()[l1];
		this.img2 = this.getHira()[l2];
		this.img3 = this.getHira()[l3];
		this.img4 = this.getHira()[l4];
		this.img5 = this.getHira()[l5];
		
		this.roma1 = this.getRomaji()[l1];
		this.roma2 = this.getRomaji()[l2];
		this.roma3 = this.getRomaji()[l3];
		this.roma4 = this.getRomaji()[l4];
		this.roma5 = this.getRomaji()[l5];
		
		this.hira1.setImage(this.img1);
		this.hira2.setImage(this.img2);
		this.hira3.setImage(this.img3);
		this.hira4.setImage(this.img4);
		this.hira5.setImage(this.img5);
	}
	
	
	public Image[] getHira(){
		this.hr = HiraganaRequete.getInstance();
		this.hr.ajouterHiraParNiveau(Carte.getNiv());
		return hr.getTabHiragana();
	}
	
	public String[] getRomaji(){
		this.rr = RomajiRequete.getInstance();
		this.rr.ajouterParNiveau(Carte.getNiv());
		return rr.getTableauRomaji();
	}
	
	@FXML
	public void valider(){
		if (this.antiCheat == false){
			if (this.choiceBox1.getValue().toUpperCase().equals(this.roma1)){
				this.c1.setFill(javafx.scene.paint.Color.GREEN);
				this.score = score + 1;
			}
			else this.c1.setFill(javafx.scene.paint.Color.RED);
		
			if (this.choiceBox2.getValue().toUpperCase().equals(this.roma2)){
				this.c2.setFill(javafx.scene.paint.Color.GREEN);
				this.score = score + 1;
			}
			else this.c2.setFill(javafx.scene.paint.Color.RED);
		
			if (this.choiceBox3.getValue().toUpperCase().equals(this.roma3)){
				this.c3.setFill(javafx.scene.paint.Color.GREEN);
				this.score = score + 1;
			}
			else this.c3.setFill(javafx.scene.paint.Color.RED);
		
			if (this.choiceBox4.getValue().toUpperCase().equals(this.roma4)){
				this.c4.setFill(javafx.scene.paint.Color.GREEN);
				this.score = score + 1;
			}
			else this.c4.setFill(javafx.scene.paint.Color.RED);
		
			if (this.choiceBox5.getValue().toUpperCase().equals(this.roma5)){
				this.c5.setFill(javafx.scene.paint.Color.GREEN);
				this.score = score + 1;
			}
			else this.c5.setFill(javafx.scene.paint.Color.RED);
		
			if (this.antiCheat == false){
				Joueur.setScore(this.score,  Joueur.getPseudo());
				this.labelScore.setText("Votre score : " + this.score);
				this.antiCheat = true;
			}
		}
	}
	
	@FXML
	public void reload(){
		this.chrono.resetChrono();
		this.c1.setFill(javafx.scene.paint.Color.WHITE);
		this.c2.setFill(javafx.scene.paint.Color.WHITE);
		this.c3.setFill(javafx.scene.paint.Color.WHITE);
		this.c4.setFill(javafx.scene.paint.Color.WHITE);
		this.c5.setFill(javafx.scene.paint.Color.WHITE);
		this.choiceBox1.setValue(null);
		this.choiceBox2.setValue(null);
		this.choiceBox3.setValue(null);
		this.choiceBox4.setValue(null);
		this.choiceBox5.setValue(null);
		this.score = 0;
		this.essais++;
		this.labelEssais.setText("Nombre d'essais : " + this.essais);
		this.nombreEssais();
		Joueur.setScore(0,  Joueur.getPseudo());
		this.antiCheat = false;
	}
	
	private int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public void nombreEssais(){
		if (this.essais == 4){
			this.c1.setVisible(false);
			this.c2.setVisible(false);
			this.c3.setVisible(false);
			this.c4.setVisible(false);
			this.c5.setVisible(false);
			this.labelEssais.setVisible(false);
			this.labelScore.setVisible(false);
			this.labelTemps.setVisible(false);
			this.choiceBox1.setVisible(false);
			this.choiceBox2.setVisible(false);
			this.choiceBox3.setVisible(false);
			this.choiceBox4.setVisible(false);
			this.choiceBox5.setVisible(false);
			this.hira1.setVisible(false);
			this.hira2.setVisible(false);
			this.hira3.setVisible(false);
			this.hira4.setVisible(false);
			this.hira5.setVisible(false);
			this.boutonValider.setVisible(false);
			this.boutonReset.setVisible(false);
			this.labelTropNul.setText("Vu votre nombre d'essais, il faudrait réapprendre les lignes :)");
		}
	}
}

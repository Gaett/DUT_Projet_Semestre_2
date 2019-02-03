
package application;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
public class Svar1{
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Button boutonRetourCarte;
	@FXML
	private RadioButton radio1;
	@FXML
	private RadioButton radio2;
	@FXML
	private RadioButton radio3;
	@FXML
	private RadioButton radio4;
	@FXML 
	private ImageView hiraImage;
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	@FXML
	private Label label3;
	@FXML
	private Label label4;
	@FXML
	private Label labelRep;

	private Chrono chrono;

	@FXML
	private ToggleGroup groupRadio;

	private Robot robot;

	private boolean pageOuverte = true;
	

	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
		this.robot.keyRelease(KeyEvent.VK_A);
	}

	private RomajiRequete hrRomaji;
	private HiraganaRequete hrHiragana;

	//coefficient modifiant le temps en fonction de la difficulte
	private double coeff = 1;

	//liste des romajis des hiraganas du niveau
	private ArrayList <String> listeRomajis = new ArrayList <String> (); 

	//liste des romajis de 4 hiraganas du niveau organisee de maniere aleatoire et pouvant avoir des hiraganas supprimes
	private ArrayList <String> randomRomajis = new ArrayList <String> (); 

	//liste des romajis des hiraganas du niveau, reduite de 1 a chaque question posee, jusqu'a zero
	private ArrayList <String> questionsRomajis = new ArrayList <String> (); 

	//liste des images des hiraganas du niveau, reduite de 1 a chaque question posee, jusqu'a zero
	private ArrayList <Image> questionImagesHiraganas = new ArrayList <Image> (); 

	//liste des questions donnees lors de la parties, organisees dans l'ordre ou elles ont ete donne
	private ArrayList <String> questionsDonnees = new ArrayList <String> (); 

	//liste des reponses donnes lors de la partie, organisees dans l'ordre ou elles ont ete donne
	private ArrayList <String> reponsesDonnees = new ArrayList <String> (){}; 
	private String reponse1;
	private String reponse2;
	private String reponse3;
	private String reponse4;

	// romaji de l'Hiragana auquel correspond la question
	private String romajiQuestion; 

	// valeur servant a selectionner un Hiragana aleatoire
	private int randomIndex; 

	//valeur servant a determiner quel bouton aura la bonne reponse
	private int randomButton;

	// Boolen interdisant l'utilisation intensive d'une seule methode
	private boolean antiBug = true;

	public void setQuestions (){
		// Initialiser questionsRomajis avec les romajis des hiraganas du niveau
		this.hrRomaji = RomajiRequete.getInstance();
		this.hrRomaji.ajouterParNiveau(Carte.getNiv());
		this.questionsRomajis = new ArrayList<String>(Arrays.asList(hrRomaji.getTableauRomaji()));
		// Initialiser questionsImagesHiraganas avec les images des hiraganas du niveau
		this.hrHiragana = HiraganaRequete.getInstance();
		this.hrHiragana.ajouterHiraParNiveau(Carte.getNiv());
		this.questionImagesHiraganas = new ArrayList<Image>(Arrays.asList(hrHiragana.getTabHiragana()));
		this.listeRomajis.addAll(this.questionsRomajis);
	}

	public void pickRomaji(int index){
		//int index = ThreadLocalRandom.current().nextInt(0, this.questionsRomajis.size());
		this.romajiQuestion = this.questionsRomajis.get(index);
		this.questionsDonnees.add(this.romajiQuestion);
		this.questionsRomajis.remove(index);
	}

	public void pickImage(int index){
		//int index = ThreadLocalRandom.current().nextInt(0, this.questionImagesHiraganas.size() + 1);
		this.hiraImage.setImage(this.questionImagesHiraganas.get(index));
		this.questionImagesHiraganas.remove(index);
		System.out.print("pickImage   Ca fonctionne ----------------__-_-_-_-_-_-_-_-_-_-_-_");
	}

	public void randomIndexAndButton(){
		this.randomIndex = ThreadLocalRandom.current().nextInt(0, 4);
		this.randomButton = ThreadLocalRandom.current().nextInt(1, 5);
	}

	//retourne une ArrayList contenant 4 romajis servant a initialiser les radios button lors d'une question
	public void randomRomajis(){
		Random rand = new Random();
		ArrayList <String> copy = new ArrayList <String> ();
		copy.addAll(this.listeRomajis);
		copy.remove(this.romajiQuestion);
		this.randomRomajis.clear();
		String romaji1 = copy.get(rand.nextInt(copy.size()));
		this.randomRomajis.add(romaji1);
		copy.remove(romaji1);
		String romaji2 = copy.get(rand.nextInt(copy.size()));
		this.randomRomajis.add(romaji2);
		copy.remove(romaji2);
		String romaji3 = copy.get(rand.nextInt(copy.size()));
		this.randomRomajis.add(romaji3);
		copy.remove(romaji3);
		String romaji4 = copy.get(rand.nextInt(copy.size()));
		this.randomRomajis.add(romaji4);
		copy.remove(romaji4);
	}

	public void setDifficulte(){
		switch (Difficulte.getDiff()) {
		case 1:
			this.coeff = 1;
			break;

		case 2:
			this.coeff = 1.5;
			break;

		case 3:
			this.coeff = 3;
			break;

		default:
			break;
		}
	}

	@FXML
	public void beginGame() throws AWTException, InterruptedException{
		this.chrono = Chrono.getInstance();
		setQuestions ();
		System.out.println("begin game fonctionne");
		this.lancerQuestions();
		if (this.chrono.seconds > (84/this.coeff)){
			this.afficherLesReponses();
		}
	}

	@FXML
	public void initQuest() throws AWTException{
		if(this.pageOuverte){
			System.out.println("Coucou je suis appelé");
			setDifficulte();
			this.pageOuverte = false;
		}
	}

	public void lancerQuestions() throws AWTException{
		this.robot = new Robot();
		System.out.println("lancer questione fonctionne");
		this.robot.keyPress(KeyEvent.VK_A);
		if (this.chrono.seconds >= 0 && this.chrono.seconds < (6/this.coeff)){
			this.randomIndexAndButton();
			this.pickImage(this.randomIndex);
			this.pickRomaji(this.randomIndex);
			this.randomRomajis();
			System.out.println("1er changement effectue");
		}
		else if (this.chrono.seconds >= (6/this.coeff) && this.chrono.seconds < (21/this.coeff)){
			if(this.randomButton == 1){
				this.radio1.setText(this.romajiQuestion);
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 2){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.romajiQuestion);
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 3){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.romajiQuestion);
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 4){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.romajiQuestion);
			}
			if (this.radio1.isSelected() == true){ this.reponse1 = this.radio1.getText();}
			else if (this.radio2.isSelected() == true){ this.reponse1 = this.radio2.getText();}
			else if (this.radio3.isSelected() == true){ this.reponse1 = this.radio3.getText();}
			else if (this.radio4.isSelected() == true){ this.reponse1 = this.radio4.getText();}
		}
		else if (this.chrono.seconds >= (21/this.coeff) && this.chrono.seconds < (27/this.coeff)){
			this.randomIndexAndButton();
			this.pickImage(this.randomIndex);
			this.pickRomaji(this.randomIndex);
			this.randomRomajis();
			System.out.println("2e changement effectue");

		}
		else if (this.chrono.seconds >= (27/this.coeff) && this.chrono.seconds < (42/this.coeff)) {
			System.out.println("2e boucle entree");
			if(this.randomButton == 1){
				this.radio1.setText(this.romajiQuestion);
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 2){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.romajiQuestion);
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 3){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.romajiQuestion);
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 4){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.romajiQuestion);
			}
			else if (this.radio1.isSelected() == true){ this.reponse2 = this.radio1.getText();}
			else if (this.radio2.isSelected() == true){ this.reponse2 = this.radio2.getText();}
			else if (this.radio3.isSelected() == true){ this.reponse2 = this.radio3.getText();}
			else if (this.radio4.isSelected() == true){ this.reponse2 = this.radio4.getText();}
		}
		else if (this.chrono.seconds >= (42/this.coeff) && this.chrono.seconds < (57/this.coeff)){
			this.randomIndexAndButton();
			this.pickImage(this.randomIndex);
			this.pickRomaji(this.randomIndex);
			this.randomRomajis();
			System.out.println("3e changement effectue");

		}
		else if (this.chrono.seconds >= (57/this.coeff) && this.chrono.seconds < (63/this.coeff)){
			System.out.println("3e boucle entree");
			if(this.randomButton == 1){
				this.radio1.setText(this.romajiQuestion);
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 2){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.romajiQuestion);
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 3){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.romajiQuestion);
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 4){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.romajiQuestion);
			}

			if (this.radio1.isSelected() == true){ this.reponse3 = this.radio1.getText();}
			else if (this.radio2.isSelected() == true){ this.reponse3 = this.radio2.getText();}
			else if (this.radio3.isSelected() == true){ this.reponse3 = this.radio3.getText();}
			else if (this.radio4.isSelected() == true){ this.reponse3 = this.radio4.getText();}
		}
		else if (this.chrono.seconds >= (63/this.coeff) && this.chrono.seconds < (69/this.coeff)){
			this.randomIndexAndButton();
			this.pickImage(this.randomIndex);
			this.pickRomaji(this.randomIndex);
			this.randomRomajis();
			System.out.println("4e changement effectue");
		}
		else if (chrono.seconds >= (69/this.coeff) && chrono.seconds < (84/this.coeff)){
			System.out.println("4e boucle entree");
			if(this.randomButton == 1){
				this.radio1.setText(this.romajiQuestion);
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 2){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.romajiQuestion);
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 3){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.romajiQuestion);
				this.radio4.setText(this.randomRomajis.get(3));
			}
			else if(this.randomButton == 4){
				this.radio1.setText(this.randomRomajis.get(0));
				this.radio2.setText(this.randomRomajis.get(1));
				this.radio3.setText(this.randomRomajis.get(2));
				this.radio4.setText(this.romajiQuestion);
			}
			if (this.radio1.isSelected() == true){ this.reponse4 = this.radio1.getText();}
			else if (this.radio2.isSelected() == true){ this.reponse4 = this.radio2.getText();}
			else if (this.radio3.isSelected() == true){ this.reponse4 = this.radio3.getText();}
			else if (this.radio4.isSelected() == true){ this.reponse4 = this.radio4.getText();}
		} 
	} 

	public void afficherLesReponses() throws AWTException {
		System.out.println("Afficher les reponse fonctionne");
		this.chrono.stopChrono();
		this.robot.keyRelease(KeyEvent.VK_A);
		this.radio1.setVisible(false);
		this.radio2.setVisible(false);
		this.radio3.setVisible(false);
		this.radio4.setVisible(false);
		this.hiraImage.setVisible(false);
		this.labelRep.setText("Vos réponses sont " + this.reponse1 + ", " 
		                                           + this.reponse2 + ", "
				                                   + this.reponse3 + ", "
		                                           + this.reponse4 + "\n" + "\n" + "\n" 
				            + "Les bonnes réponses sont : " + this.questionsDonnees.get(0) + ", " 
		                                                    + this.questionsDonnees.get(1) + ", " 
				                                            + this.questionsDonnees.get(2) + ", " 
		                                                    + this.questionsDonnees.get(3));
	}
}
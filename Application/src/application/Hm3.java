package application;
import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
public class Hm3 {
	private static Object chrono;
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Button boutonRetourCarte;
	@FXML
	private Circle bon1;
	@FXML
	private Circle bon2;
	@FXML
	private Circle bon3;
	@FXML
	private Circle bon4;
	@FXML
	private Circle bon5;
	@FXML
	private Circle faux1;
	@FXML
	private Circle faux2;
	@FXML
	private Circle faux3;
	@FXML
	private Circle faux4;
	@FXML
	private Circle faux5;
	@FXML
	private Button correction;
	@FXML
	private RadioButton q01;
	@FXML
	private RadioButton q02;
	@FXML
	private RadioButton q03;
	@FXML
	private RadioButton q11;
	@FXML
	private RadioButton q12;
	@FXML
	private RadioButton q13;
	@FXML
	private RadioButton q21;
	@FXML
	private RadioButton q22;
	@FXML
	private RadioButton q23;
	@FXML
	private RadioButton q31;
	@FXML
	private RadioButton q32;
	@FXML
	private RadioButton q33;
	@FXML
	private RadioButton q41;
	@FXML
	private RadioButton q42;
	@FXML
	private RadioButton q43;
	@FXML
	private int br;
	@FXML
	private Label score;
	@FXML
	private Label point;
	@FXML
	private ImageView hiraq1;
	@FXML
	private ImageView hiraq2;
	@FXML
	private ImageView hiraq3;
	@FXML
	private ImageView hiraq4;
	@FXML
	private ImageView hiraq5;
	
	private boolean pageouverte = true;
	
	@FXML
	public void MiseEnPlaceBoutons(){
	ToggleGroup q1 = new ToggleGroup();
		this.q01.setToggleGroup(q1);
		this.q02.setToggleGroup(q1);
		this.q03.setToggleGroup(q1);
	ToggleGroup q2 = new ToggleGroup();
		this.q11.setToggleGroup(q2);
		this.q12.setToggleGroup(q2);
		this.q13.setToggleGroup(q2);
	ToggleGroup q3 = new ToggleGroup();
		this.q21.setToggleGroup(q3);
		this.q22.setToggleGroup(q3);
		this.q23.setToggleGroup(q3);
	ToggleGroup q4 = new ToggleGroup();
		this.q31.setToggleGroup(q4);
		this.q32.setToggleGroup(q4);
		this.q33.setToggleGroup(q4);
	ToggleGroup q5 = new ToggleGroup();
		this.q41.setToggleGroup(q5);
		this.q42.setToggleGroup(q5);
		this.q43.setToggleGroup(q5);	
	}
	
	@FXML
	public void Correction(){
		this.br =0 ;
		if(pageouverte == true){
		if(q01.isSelected()== true && q01.getText() == Hm2.getRoma1()){
			this.bon1.setVisible(true);
			this.br++;}
			else{
				if(q02.isSelected()== true && q02.getText() == Hm2.getRoma1()){
				this.bon1.setVisible(true);
			    this.br++;}
				else {
					  if(q03.isSelected()== true && q03.getText() == Hm2.getRoma1()){
					  this.bon1.setVisible(true);
			           this.br++;}
					  else{
						  this.faux1.setVisible(true);
					  }
				}
			}
		
		if(q11.isSelected()== true && q11.getText() == Hm2.getRoma2()){
			this.bon2.setVisible(true);
			this.br++;}
			else{
				if(q12.isSelected()== true && q12.getText() == Hm2.getRoma2()){
				this.bon2.setVisible(true);
			    this.br++;}
				else {
					  if(q13.isSelected()== true && q13.getText() == Hm2.getRoma2()){
					  this.bon2.setVisible(true);
			           this.br++;}
					  else{
						  this.faux2.setVisible(true);
					  }
				}
			}
		
		if(q21.isSelected()== true && q21.getText() == Hm2.getRoma3()){
			this.bon3.setVisible(true);
			this.br++;}
			else{
				if(q22.isSelected()== true && q22.getText() == Hm2.getRoma3()){
				this.bon3.setVisible(true);
			    this.br++;}
				else {
					  if(q23.isSelected()== true && q23.getText() == Hm2.getRoma3()){
					  this.bon3.setVisible(true);
			           this.br++;}
					  else{
						  this.faux3.setVisible(true);
					  }
				}
			}
		
		if(q31.isSelected()== true && q31.getText() == Hm2.getRoma4()){
			this.bon4.setVisible(true);
			this.br++;}
			else{
				if(q32.isSelected()== true && q32.getText() == Hm2.getRoma4()){
				this.bon4.setVisible(true);
			    this.br++;}
				else {
					  if(q33.isSelected()== true && q33.getText() == Hm2.getRoma4()){
					  this.bon4.setVisible(true);
			           this.br++;}
					  else{
						  this.faux4.setVisible(true);
					  }
				}
			}
		
		
		
		if(q41.isSelected()== true && q41.getText() == Hm2.getRoma5()){
			this.bon5.setVisible(true);
			this.br++;}
			else{
				if(q42.isSelected()== true && q42.getText() == Hm2.getRoma5()){
				this.bon5.setVisible(true);
			    this.br++;}
				else {
					  if(q43.isSelected()== true && q43.getText() == Hm2.getRoma5()){
					  this.bon5.setVisible(true);
			           this.br++;}
					  else{
						  this.faux5.setVisible(true);
					  }
				}
			}
		this.point.setVisible(true);
		this.score.setVisible(true);
		this.point.setText(""+this.br+"/ 5");
		Joueur.setScore(br, Joueur.getPseudo());
		Chrono chrono = Chrono.getInstance();
		chrono.stopChrono();
	}
		this.pageouverte = false;
}

	@FXML
	public void PrepareCorrection(){
		if (this.pageouverte == true){
		MiseEnPlaceBoutons();
		int rep1 = new Random().nextInt(3);
		this.hiraq1.setImage(Hm2.getHira1());
		this.hiraq2.setImage(Hm2.getHira2());
		this.hiraq3.setImage(Hm2.getHira3());
		this.hiraq4.setImage(Hm2.getHira4());
		this.hiraq5.setImage(Hm2.getHira5());
		this.q01.setText(RandomRoma());
		this.q02.setText(RandomRoma());
		this.q03.setText(RandomRoma());
		this.q11.setText(RandomRoma());
		this.q12.setText(RandomRoma());
		this.q13.setText(RandomRoma());
		this.q21.setText(RandomRoma());
		this.q22.setText(RandomRoma());
		this.q23.setText(RandomRoma());
		this.q31.setText(RandomRoma());
		this.q32.setText(RandomRoma());
		this.q33.setText(RandomRoma());
		this.q41.setText(RandomRoma());
		this.q42.setText(RandomRoma());
		this.q43.setText(RandomRoma());
		
		if(rep1 == 0){
			this.q01.setText(Hm2.getRoma1());
			this.q12.setText(Hm2.getRoma2());
			this.q23.setText(Hm2.getRoma3());
			this.q31.setText(Hm2.getRoma4());
			this.q42.setText(Hm2.getRoma5());
		}
	    if(rep1 == 1){
	    	this.q02.setText(Hm2.getRoma1());
	    	this.q13.setText(Hm2.getRoma2());
	    	this.q21.setText(Hm2.getRoma3());
	    	this.q32.setText(Hm2.getRoma4());
			this.q42.setText(RandomRoma());
	    	this.q43.setText(Hm2.getRoma5());
		}
		if(rep1 == 2){
			this.q03.setText(Hm2.getRoma1());
	    	this.q11.setText(Hm2.getRoma2());
	    	this.q22.setText(Hm2.getRoma3());
	    	this.q33.setText(Hm2.getRoma4());
	    	this.q41.setText(Hm2.getRoma5());
		}
		}
		
	}
	
	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public String RandomRoma(){
		int rl = new Random().nextInt(8);
		int rn = new Random().nextInt(5);
		String randomroma = bdConnect.getRomaji(rl)[rn];
		while(randomroma == null){
			rl = new Random().nextInt(8);
			rn = new Random().nextInt(5);
			randomroma = bdConnect.getRomaji(rl)[rn];;
		}
		return randomroma;
	}
}

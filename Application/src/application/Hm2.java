package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class Hm2 {
	
	
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Button boutonRetourCarte;
	@FXML
	private Button update;
	@FXML 
	private ImageView hira;
	@FXML 
	private static Image hira1;
	@FXML 
	private static Image hira2;
	@FXML 
	private static Image hira3;
	@FXML 
	private static Image hira4;
	@FXML 
	private static Image hira5;
	@FXML 
	private static String roma1;
	@FXML 
	private static String roma2;
	@FXML 
	private static String roma3;
	@FXML 
	private static String roma4;
	@FXML 
	private static String roma5;
	@FXML
	private Label roma;
	@FXML
	private Text text;
	@FXML
	private Button suivant;
	@FXML
	private Text text1;
	
	private Chrono chrono;
	
	private Robot robot;
	
	
	

	private int l1 = Hm2.getRandomNumberInRange(0, 7);
	private int l2 = Hm2.getRandomNumberInRange(0, 7);
	private int l3 = Hm2.getRandomNumberInRange(0, 7);
	private int l4 = Hm2.getRandomNumberInRange(0, 7);
	private int l5 = Hm2.getRandomNumberInRange(0, 7);
	
	private int n1 = new Random().nextInt(5);
	private int n2 = new Random().nextInt(5);
	private int n3 = new Random().nextInt(5);
	private int n4 = new Random().nextInt(5);
	private int n5 = new Random().nextInt(5);
	
	public ArrayList<Image> tab = new ArrayList<Image>();	
	
	public static Image getHira1() {
		return hira1;
	}

	public static Image getHira2() {
		return hira2;
	}

	public static Image getHira3() {
		return hira3;
	}

	public static Image getHira4() {
		return hira4;
	}

	public static Image getHira5() {
		return hira5;
	}

	public static String getRoma1() {
		return roma1;
	}

	public static String getRoma2() {
		return roma2;
	}

	public static String getRoma3() {
		return roma3;
	}

	public static String getRoma4() {
		return roma4;
	}

	public static String getRoma5() {
		return roma5;
	}

	public Label getRoma() {
		return roma;
	}

	
	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
		this.chrono.resetChrono();
		}
	
	
		@FXML
		public void deffilement() throws AWTException, IOException{
			this.tab.clear();
			this.robot = new Robot();
			this.robot.keyPress(KeyEvent.VK_A);
			this.chrono = Chrono.getInstance();
			this.chrono.startChrono();
			this.text.setVisible(false);
			int i = this.chrono.getSeconds();
		if (Difficulte.getDiff() == 2){
			if( i == 0 ){
			Hm2.hira1 = bdConnect.getHiraganaNiveau(n1)[l1];
			Hm2.roma1 = bdConnect.getRomaji(n1)[l1];
			while(Hm2.roma1 == null){
				n1 = new Random().nextInt(5);
				l1 = new Random().nextInt(9);
				Hm2.hira1 = bdConnect.getHiraganaNiveau(n1)[l1];
				Hm2.roma1 = bdConnect.getRomaji(n1)[l1];
			}
			tab.add(hira1);
			System.out.println(i );
			this.hira.setImage(hira1);
			this.roma.setText(Hm2.roma1);
			}
			
			if( i == 5 ){
			Hm2.hira2 = bdConnect.getHiraganaNiveau(n2)[l2];
			Hm2.roma2 = bdConnect.getRomaji(n2)[l2];
			while(tab.contains(hira2) || Hm2.roma2 == null){
				l2 = Hm2.getRandomNumberInRange(0, 8);
				n2 = Hm2.getRandomNumberInRange(0, 5);
				Hm2.hira1 = bdConnect.getHiraganaNiveau(n2)[l2];
				Hm2.roma1 = bdConnect.getRomaji(n2)[l2];
			}
			tab.add(hira2);
			System.out.println(i );
			this.hira.setImage(hira2);
			this.roma.setText(Hm2.roma2);
			}
			
			if(i == 10 ){
			Hm2.hira3 = bdConnect.getHiraganaNiveau(n3)[l3];
			Hm2.roma3 = bdConnect.getRomaji(n3)[l3];
			while(tab.contains(hira3) || Hm2.roma3 == null){
				l3 = Hm2.getRandomNumberInRange(0, 8);
				n3 = Hm2.getRandomNumberInRange(0, 5);
				Hm2.hira3 = bdConnect.getHiraganaNiveau(n3)[l3];
				Hm2.roma3 = bdConnect.getRomaji(n3)[l3];
			}
			tab.add(hira3);
			System.out.println(i);
			this.hira.setImage(hira3);	
			this.roma.setText(Hm2.roma3);
			}
			
			if(i == 15 ){
			Hm2.hira4 = bdConnect.getHiraganaNiveau(n4)[l4];
			Hm2.roma4 = bdConnect.getRomaji(n4)[l4];
			while(tab.contains(hira4) || Hm2.roma4 == null){
				l4 = Hm2.getRandomNumberInRange(0, 8);
				n4 = Hm2.getRandomNumberInRange(0, 5);
				Hm2.hira4 = bdConnect.getHiraganaNiveau(n4)[l4];
				Hm2.roma4 = bdConnect.getRomaji(n4)[l4];
			}
			tab.add(hira4);
			System.out.println(i);
			this.hira.setImage(hira4);	
			this.roma.setText(Hm2.roma4);
			}	
			
			if(i == 20 ){
			Hm2.hira5 = bdConnect.getHiraganaNiveau(n5)[l5];
			Hm2.roma5 = bdConnect.getRomaji(n5)[l5];
			if(tab.contains(hira5) || Hm2.roma5 == null){
				l1 = Hm2.getRandomNumberInRange(0, 8);
				n1 = Hm2.getRandomNumberInRange(0, 5);
				Hm2.hira5 = bdConnect.getHiraganaNiveau(n5)[l5];
				Hm2.roma5 = bdConnect.getRomaji(n5)[l5];
			}
			tab.add(hira1);
			System.out.println(i);
			this.hira.setImage(hira5);
			this.roma.setText(Hm2.roma5);
			}	
			
			if(i == 25){
			robot.keyRelease(KeyEvent.VK_A);
			this.suivant.setVisible(true);
			this.text1.setVisible(true);
			this.hira.setVisible(false);
			this.roma.setVisible(false);
			this.chrono.resetChrono();
			this.tab.clear();
			}
		}	
	
if(Difficulte.getDiff() == 1){
				if( i == 0 ){
				Hm2.hira1 = bdConnect.getHiraganaNiveau(n1)[l1];
				Hm2.roma1 = bdConnect.getRomaji(n1)[l1];
				while(Hm2.roma1 == null){
					n1 = new Random().nextInt(5);
					l1 = new Random().nextInt(10);
					Hm2.hira1 = bdConnect.getHiraganaNiveau(n1)[l1];
					Hm2.roma1 = bdConnect.getRomaji(n1)[l1];
				}
				tab.add(hira1);
				System.out.println(i );
				this.hira.setImage(hira1);
				this.roma.setText(Hm2.roma1);
				}
				
				if( i == 7 ){
				Hm2.hira2 = bdConnect.getHiraganaNiveau(n2)[l2];
				Hm2.roma2 = bdConnect.getRomaji(n2)[l2];
				while(tab.contains(hira2) || Hm2.roma2 == null){
					l2 = Hm2.getRandomNumberInRange(0, 9);
					n2 = Hm2.getRandomNumberInRange(0, 5);
					Hm2.hira1 = bdConnect.getHiraganaNiveau(n2)[l2];
					Hm2.roma1 = bdConnect.getRomaji(n2)[l2];
				}
				tab.add(hira2);
				System.out.println(i );
				this.hira.setImage(hira2);
				this.roma.setText(Hm2.roma2);
				}
				
				if(i == 14 ){
				Hm2.hira3 = bdConnect.getHiraganaNiveau(n3)[l3];
				Hm2.roma3 = bdConnect.getRomaji(n3)[l3];
				while(tab.contains(hira3) || Hm2.roma3 == null){
					l3 = Hm2.getRandomNumberInRange(0, 9);
					n3 = Hm2.getRandomNumberInRange(0, 5);
					Hm2.hira3 = bdConnect.getHiraganaNiveau(n3)[l3];
					Hm2.roma3 = bdConnect.getRomaji(n3)[l3];
				}
				tab.add(hira3);
				System.out.println(i);
				this.hira.setImage(hira3);	
				this.roma.setText(Hm2.roma3);
				}
				
				if(i == 21 ){
				Hm2.hira4 = bdConnect.getHiraganaNiveau(n4)[l4];
				Hm2.roma4 = bdConnect.getRomaji(n4)[l4];
				while(tab.contains(hira4) || Hm2.roma4 == null){
					l4 = Hm2.getRandomNumberInRange(0, 9);
					n4 = Hm2.getRandomNumberInRange(0, 5);
					Hm2.hira4 = bdConnect.getHiraganaNiveau(n4)[l4];
					Hm2.roma4 = bdConnect.getRomaji(n4)[l4];
				}
				tab.add(hira4);
				System.out.println(i);
				this.hira.setImage(hira4);	
				this.roma.setText(Hm2.roma4);
				}	
				
				if(i == 28 ){
				Hm2.hira5 = bdConnect.getHiraganaNiveau(n5)[l5];
				Hm2.roma5 = bdConnect.getRomaji(n5)[l5];
				while(tab.contains(hira5) || Hm2.roma5 == null){
					l1 = Hm2.getRandomNumberInRange(0, 9);
					n1 = Hm2.getRandomNumberInRange(0, 5);
					Hm2.hira5 = bdConnect.getHiraganaNiveau(n5)[l5];
					Hm2.roma5 = bdConnect.getRomaji(n5)[l5];
				}
				tab.add(hira1);
				System.out.println(i);
				this.hira.setImage(hira5);
				this.roma.setText(Hm2.roma5);
				}	
				
				if(i == 35){
				robot.keyRelease(KeyEvent.VK_A);
				this.suivant.setVisible(true);
				this.text1.setVisible(true);
				this.hira.setVisible(false);
				this.roma.setVisible(false);
				this.chrono.resetChrono();
				this.chrono.stopChrono();
				this.tab.clear();
				}
			}	
			
if(Difficulte.getDiff() == 3){

				if( i == 0 ){
				Hm2.hira1 = bdConnect.getHiraganaNiveau(n1)[l1];
				Hm2.roma1 = bdConnect.getRomaji(n1)[l1];
				while(Hm2.roma1 == null){
					n1 = new Random().nextInt(5);
					l1 = new Random().nextInt(9);
					Hm2.hira1 = bdConnect.getHiraganaNiveau(n1)[l1];
					Hm2.roma1 = bdConnect.getRomaji(n1)[l1];
				}
				tab.add(hira1);
				System.out.println(i );
				this.hira.setImage(hira1);
				this.roma.setText(Hm2.roma1);
				}
				
				if( i == 3 ){
				Hm2.hira2 = bdConnect.getHiraganaNiveau(n2)[l2];
				Hm2.roma2 = bdConnect.getRomaji(n2)[l2];
				while(tab.contains(hira2) || Hm2.roma2 == null){
					l2 = Hm2.getRandomNumberInRange(0, 9);
					n2 = Hm2.getRandomNumberInRange(0, 5);
					Hm2.hira1 = bdConnect.getHiraganaNiveau(n2)[l2];
					Hm2.roma1 = bdConnect.getRomaji(n2)[l2];
				}
				tab.add(hira2);
				System.out.println(i );
				this.hira.setImage(hira2);
				this.roma.setText(Hm2.roma2);
				}
				
				if(i == 6 ){
				Hm2.hira3 = bdConnect.getHiraganaNiveau(n3)[l3];
				Hm2.roma3 = bdConnect.getRomaji(n3)[l3];
				while(tab.contains(hira3) || Hm2.roma3 == null){
					l3 = Hm2.getRandomNumberInRange(0, 9);
					n3 = Hm2.getRandomNumberInRange(0, 5);
					Hm2.hira3 = bdConnect.getHiraganaNiveau(n3)[l3];
					Hm2.roma3 = bdConnect.getRomaji(n3)[l3];
				}
				tab.add(hira3);
				System.out.println(i);
				this.hira.setImage(hira3);	
				this.roma.setText(Hm2.roma3);
				}
				
				if(i == 9 ){
				Hm2.hira4 = bdConnect.getHiraganaNiveau(n4)[l4];
				Hm2.roma4 = bdConnect.getRomaji(n4)[l4];
				while(tab.contains(hira4) || Hm2.roma4 == null){
					l4 = Hm2.getRandomNumberInRange(0, 9);
					n4 = Hm2.getRandomNumberInRange(0, 5);
					Hm2.hira4 = bdConnect.getHiraganaNiveau(n4)[l4];
					Hm2.roma4 = bdConnect.getRomaji(n4)[l4];
				}
				tab.add(hira4);
				System.out.println(i);
				this.hira.setImage(hira4);	
				this.roma.setText(Hm2.roma4);
				}	
				
				if(i == 12 ){
				Hm2.hira5 = bdConnect.getHiraganaNiveau(n5)[l5];
				Hm2.roma5 = bdConnect.getRomaji(n5)[l5];
				while(tab.contains(hira5) || Hm2.roma5 == null){
					l1 = Hm2.getRandomNumberInRange(0, 9);
					n1 = Hm2.getRandomNumberInRange(0, 5);
					Hm2.hira5 = bdConnect.getHiraganaNiveau(n5)[l5];
					Hm2.roma5 = bdConnect.getRomaji(n5)[l5];
				}
				tab.add(hira1);
				System.out.println(i);
				this.hira.setImage(hira5);
				this.roma.setText(Hm2.roma5);
				}	
				
				if(i == 15){
				robot.keyRelease(KeyEvent.VK_A);
				this.suivant.setVisible(true);
				this.text1.setVisible(true);
				this.hira.setVisible(false);
				this.roma.setVisible(false);
				this.chrono.resetChrono();
				this.tab.clear();
				}
			}
}


		
		
	
		@FXML
		public void finExo() throws IOException {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("hm3.fxml"));
			rootPane.getChildren().setAll(pane);
			this.chrono.resetChrono();
			this.robot.keyRelease(KeyEvent.VK_A);
		}
		

		@FXML
		public void imageUpdate() throws AWTException, InterruptedException, IOException{
		this.update.setVisible(false);
		this.deffilement();
		}
		
	
	

		static int getRandomNumberInRange(int min, int max) {

			if (min >= max) {
				throw new IllegalArgumentException("max must be greater than min");
			}

			Random r = new Random();
			return r.nextInt((max - min) + 1) + min;
		}
}
		


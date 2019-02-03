package application;

import java.io.IOException;

import javafx.scene.image.Image;

public class LigneRequete {
	private Image[] tabImageBD;
	private Image ligne1;
	private Image ligne2;
	private Image ligne3;
	private Image ligne4;
	private Image ligne5;
	private Image ligne6;
	private Image ligne7;
	private Image ligne8;
	private Image ligne9;
	private Image ligne10;
	
	private static LigneRequete ir = new LigneRequete();
	
	public static LigneRequete getInstance(){
		return ir;
	}
	
	public void ajouterLigne() {
		this.ligne1 = bdConnect.getLigneNiveau(1)[0];
		this.ligne2 = bdConnect.getLigneNiveau(1)[1];
		this.ligne3 = bdConnect.getLigneNiveau(2)[0];
		this.ligne4 = bdConnect.getLigneNiveau(2)[1];
		this.ligne5 = bdConnect.getLigneNiveau(3)[0];
		this.ligne6 = bdConnect.getLigneNiveau(3)[1];
		this.ligne7 = bdConnect.getLigneNiveau(4)[0];
		this.ligne8 = bdConnect.getLigneNiveau(4)[1];
		this.ligne9 = bdConnect.getLigneNiveau(5)[0];
		this.ligne10 = bdConnect.getLigneNiveau(5)[1];
	}
	
	public void remplirTableau() {
		this.ajouterLigne();
		this.tabImageBD = new Image[]{this.ligne1, this.ligne2, 
				this.ligne3, this.ligne4, this.ligne5, this.ligne6
				,this.ligne7,this.ligne8, this.ligne9, this.ligne10 };
	}
	
	public Image getImage(int numLigne) {
		this.remplirTableau();
		return this.tabImageBD[numLigne-1];
	}
}

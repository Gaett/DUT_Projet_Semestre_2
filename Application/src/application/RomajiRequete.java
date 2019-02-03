package application;

public class RomajiRequete {
	private String[] tabRomaji;
	
	private static RomajiRequete rr;
	
	private RomajiRequete(){
		this.tabRomaji = null;
	}
	
	public static RomajiRequete getInstance(){
		rr = new RomajiRequete();
		return rr;
	}
	
	public void ajouterParNiveau(int niv){
		if(niv == 1)this.tabRomaji = bdConnect.getRomaji(1);
		else if(niv == 2)this.tabRomaji = bdConnect.getRomaji(2);
		else if(niv == 3)this.tabRomaji = bdConnect.getRomaji(3);
		else if(niv == 4)this.tabRomaji = bdConnect.getRomaji(4);
		else if(niv == 5)this.tabRomaji = bdConnect.getRomaji(5);
	}
	
	public String[] getTableauRomaji(){
		return this.tabRomaji;
	}
}

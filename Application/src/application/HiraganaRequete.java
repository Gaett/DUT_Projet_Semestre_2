package application;
import javafx.scene.image.Image;

public class HiraganaRequete {
	private Image[] tabHira;
	
	private static HiraganaRequete hr = new HiraganaRequete();
	
	public static HiraganaRequete getInstance(){
		return hr;
	}
	
	public void ajouterHiraParNiveau(int niv){
		if(niv== 1)this.tabHira = bdConnect.getHiraganaNiveau(1);
		else if(niv == 2)this.tabHira = bdConnect.getHiraganaNiveau(2);
		else if(niv == 3)this.tabHira = bdConnect.getHiraganaNiveau(3);
		else if(niv == 4)this.tabHira = bdConnect.getHiraganaNiveau(4);
		else if(niv == 5)this.tabHira = bdConnect.getHiraganaNiveau(5);
	}
	
	public Image[] getTabHiragana(){
		return this.tabHira;
	}
}

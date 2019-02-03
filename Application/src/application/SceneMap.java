package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class SceneMap {
	public Scene[] scenes;
    public Parent[] parents;
    
    Scene scene1,scene2, scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10,scene11,scene12,scene13,scene14;
    AnchorPane root1, root2, root3,root4,root5,root6,root7,root8,root9,root10,root11,root12,root13,root14;
    
    private SceneMap(){
        try{
        	this.scenes = new Scene[14];
            this.parents = new Parent[14];
            
            AnchorPane root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("connexion.fxml"));
			Scene scene1 = new Scene(root1,1280,720);

			AnchorPane root2 = (AnchorPane)FXMLLoader.load(getClass().getResource("creation.fxml"));
			Scene scene2 = new Scene(root2,1280,720);
			
			AnchorPane root3 = (AnchorPane)FXMLLoader.load(getClass().getResource("carte.fxml"));
			Scene scene3 = new Scene(root3,1280,720);   

			AnchorPane root4 = (AnchorPane)FXMLLoader.load(getClass().getResource("niveau.fxml"));
			Scene scene4 = new Scene(root4,1280,720);   
			
			AnchorPane root5 = (AnchorPane)FXMLLoader.load(getClass().getResource("difficulte.fxml"));
			Scene scene5 = new Scene(root5,1280,720);   
			
			AnchorPane root6 = (AnchorPane)FXMLLoader.load(getClass().getResource("ligne.fxml"));
			Scene scene6 = new Scene(root6,1280,720);   
			
			AnchorPane root7 = (AnchorPane)FXMLLoader.load(getClass().getResource("llt1.fxml"));
			Scene scene7 = new Scene(root7,1280,720);   
			
			AnchorPane root8 = (AnchorPane)FXMLLoader.load(getClass().getResource("llt2.fxml"));
			Scene scene8 = new Scene(root8,1280,720);   
			
			AnchorPane root9 = (AnchorPane)FXMLLoader.load(getClass().getResource("hm1.fxml"));
			Scene scene9 = new Scene(root9,1280,720);   
			
			AnchorPane root10 = (AnchorPane)FXMLLoader.load(getClass().getResource("hm2.fxml"));
			Scene scene10 = new Scene(root10,1280,720);   
			
			AnchorPane root11 = (AnchorPane)FXMLLoader.load(getClass().getResource("hm3.fxml"));
			Scene scene11 = new Scene(root11,1280,720);
			
			AnchorPane root12 = (AnchorPane)FXMLLoader.load(getClass().getResource("svar1.fxml"));
			Scene scene12 = new Scene(root12,1280,720);   
			
			AnchorPane root13 = (AnchorPane)FXMLLoader.load(getClass().getResource("svar2.fxml"));
			Scene scene13 = new Scene(root13,1280,720);   
			
			AnchorPane root14 = (AnchorPane)FXMLLoader.load(getClass().getResource("testfinal.fxml"));
			Scene scene14 = new Scene(root14,1280,720);   
			
			

            Scene sc[] = {scene1,scene2, scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10,scene11,scene12,scene13,scene14};
            Parent p[] = {root1, root2, root3,root4,root5,root6,root7,root8,root9,root10,root11,root12,root13,root14};
            
            for(int i = 0; i<=13; i++) {
            	this.scenes[i] = sc[i];
                this.parents[i] = p[i];
            }
           
       
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    private static SceneMap s = new SceneMap();
    
    public static SceneMap getInstance(){
        return s;
    }
    
    public Scene[] getScene() {
    	return this.scenes;
    }
    
    
}

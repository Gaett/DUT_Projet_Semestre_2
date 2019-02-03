package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Execute extends Application{
	Stage window;
    
    public static void main (String [] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        
        try {
            SceneMap s = SceneMap.getInstance();   
            Scene sc[] = s.getScene();
            window.setScene(sc[0]);
            
            /*AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("interfacetest.fxml"));
			Scene scene = new Scene(root,1280,720);  
            window.setScene(scene);*/
            window.show();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    @Override
    public void stop() throws Exception {
        System.exit(0);
    }

}

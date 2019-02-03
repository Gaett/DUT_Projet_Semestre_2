package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Hm1 {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Button boutonRetourCarte;
	@FXML
	private Button continuer;
	
	
	@FXML
	public void quitter() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void continuer() throws IOException{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("hm2.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
}

package application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
public class interfacetest {
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Button connexion;
	@FXML
	private Button creation;
	@FXML
	private Button carte;
	@FXML
	private Button niveau;
	@FXML
	private Button llt1;
	@FXML
	private Button llt2;
	@FXML
	private Button hm1;
	@FXML
	private Button hm2;
	@FXML
	private Button hm3;
	@FXML
	private Button svar1;
	@FXML
	private Button svar2;
	@FXML
	private Button testfinal;
	@FXML
	private Button ligne;
	@FXML
	private Button difficulte;
	
	@FXML
	public void connect() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("connexion.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void create() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("creation.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void carte() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("carte.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void lvl() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("niveau.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void llt1() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("llt1.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void llt2() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("llt2.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void hm1() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("hm1.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void hm2() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("hm2.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void hm3() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("hm3.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void svar1() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("svar1.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void svar2() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("svar2.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void testfinal() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("testfinal.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void ligne() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("ligne.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void difficulte() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("difficulte.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	
}

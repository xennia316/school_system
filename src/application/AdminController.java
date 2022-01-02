package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AdminController {
	private Parent root;
	private Scene scene;
	private Stage stage;
	
	@FXML
	private Rectangle loginBtn;
	@FXML
	private Button regBtn;
	@FXML
	private Button reportBtn;
	@FXML
	private Button logouttBn;

	//switch to register students page
	@FXML
	public void getRegisterPage(ActionEvent event) throws IOException {
		System.out.println("done");
		root  = FXMLLoader.load(getClass().getResource("RegisterStudent.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on Button[#reportBtn].onAction
	@FXML
	public void getReportsPage(ActionEvent event) throws IOException {
		root  = FXMLLoader.load(getClass().getResource("CreateReports.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	// Event Listener on Button[#logouttBn].onAction
	@FXML
	public void logout(ActionEvent event) {
		// TODO Autogenerated
	}
}

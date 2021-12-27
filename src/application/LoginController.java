package application;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;


public class LoginController {
	private Scene scene;
	private Stage stage;
	private Parent root;
	@FXML
	private Button loginButton;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Label usernameErr;
	@FXML
	private Label passwordErr;


	public void loginButton(ActionEvent e) {
		if(usernameField.getText().isEmpty()) {
			usernameErr.setText("username must not be empty");
		}else {
			usernameErr.setText("");
		}
		if(passwordField.getText().isEmpty()) {
			passwordErr.setText("passwordmust not be empty");
		}else {
			passwordErr.setText("");
		}
		if(!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
			validate(e);
		}
	}
	
	public void switchToSignUp(ActionEvent e)throws IOException {
		root  = FXMLLoader.load(getClass().getResource("Sign.fxml"));
		stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToStudPanel(ActionEvent e) throws IOException{
		root  = FXMLLoader.load(getClass().getResource("Registration.fxml"));
		RegistrationController reg = new RegistrationController();
		reg.getUser(usernameField.getText());
		stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToAdminPanel(ActionEvent e) throws IOException{
		root  = FXMLLoader.load(getClass().getResource("Registration.fxml"));
		stage =(Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void validate(ActionEvent e) {
		
		DatabaseConnection connection = new DatabaseConnection();
		Connection connect = connection.getConnection();
		String query = "SELECT * FROM users where username = '"+usernameField.getText()+"' and passwords = '"+passwordField.getText()+"'";
		try {
		Statement ps = connect.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while(rs.next()) {
		if(rs.getInt(1)==1) {
			if(rs.getString("Role").contentEquals("Student")) {
				switchToStudPanel(e);
			}else {
				switchToAdminPanel(e);
			}
			
		}else {
			System.out.println("not success");
		}
		}
			}catch(Exception err) {
			err.printStackTrace();
		}
	}
}

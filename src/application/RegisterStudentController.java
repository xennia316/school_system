package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegisterStudentController implements Initializable {
	private CheckBox box;
	@FXML 
	private TableView<TableModel> table;
	@FXML
	private TableColumn<TableModel, CheckBox> checkBox;
	@FXML
	private TableColumn<TableModel, Integer> number;
	@FXML
	private TableColumn<TableModel, String> name;
	@FXML
	private TableColumn<TableModel, String> cycleId;
	@FXML
	private TableColumn<TableModel, byte[]> Qualification;
	@FXML
	private TableColumn<TableModel, Button> register;
	@FXML
	private TableColumn<TableModel, Button> unregister;
	
	ObservableList<TableModel> rows = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			DatabaseConnection con = new DatabaseConnection();
			Connection connect = con.getConnection();
			ResultSet rs = connect.createStatement().executeQuery("Select * from student");
			
			while(rs.next()) {
		
				rows.add(new TableModel(rs.getInt("studId"), rs.getString("studName"), rs.getString("cycleId"), box , null, null, null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkBox.setCellValueFactory(new PropertyValueFactory<>("check"));
		number.setCellValueFactory(new PropertyValueFactory<>("sn"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		cycleId.setCellValueFactory(new PropertyValueFactory<>("cycleId"));
		Qualification.setCellValueFactory(new PropertyValueFactory<>("file"));
		register.setCellValueFactory(new PropertyValueFactory<>("register"));
		unregister.setCellValueFactory(new PropertyValueFactory<>("unregister"));
		table.setItems(rows);
		System.out.println("hi");
	}


}

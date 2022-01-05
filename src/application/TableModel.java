package application;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class TableModel {
	
	
    int sn;
	String Name,cycleId;
	CheckBox check;
	Button register, unregister;
	byte[] file;
	
	public TableModel(int sn, String name, String cycleId, CheckBox check, Button register, Button unregister,
			byte[] file) {
		super();
		this.sn = sn;
		Name = name;
		this.cycleId = cycleId;
		this.check = check;
		 this.register = register;
		this.unregister = unregister;
		this.file = file;
		
		//register.setText("Register");
	//	unregister.setText("unregister");
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCycleId() {
		return cycleId;
	}

	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
	}

	public CheckBox getCheck() {
		return check;
	}

	public void setCheck(CheckBox check) {
		this.check = check;
	}

	public Button getRegister() {
		return register;
	}

	public void setRegister(Button register) {
		this.register = register;
	}

	public Button getUnregister() {
		return unregister;
	}

	public void setUnregister(Button unregister) {
		this.unregister = unregister;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}


	
}

package dad.javafx.IniciarSesion;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class IniciarSesionModelo {

	private StringProperty user = new SimpleStringProperty();
	private StringProperty pass = new SimpleStringProperty();

	public StringProperty userProperty() {
		return this.user;
	}

	public String getUser() {
		return this.userProperty().get();
	}

	public void setUser(final String user) {
		this.userProperty().set(user);
	}

	public StringProperty passProperty() {
		return this.pass;
	}

	public String getPass() {
		return this.passProperty().get();
	}

	public void setPass(final String pass) {
		this.passProperty().set(pass);
	}

}

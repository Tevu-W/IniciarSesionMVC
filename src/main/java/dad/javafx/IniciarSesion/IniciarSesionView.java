package dad.javafx.IniciarSesion;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class IniciarSesionView extends VBox {

	private Label UserLabel, passLabel;
	private TextField UserText;
	private PasswordField passField;
	private Button login, cancel;

	public IniciarSesionView() {

		UserLabel = new Label("Usuario:");
		UserLabel.setPrefWidth(90);

		passLabel = new Label("Contraseña:");
		passLabel.setPrefWidth(90);

		UserText = new TextField();
		UserText.setPromptText("Usuario");
		UserText.setPrefColumnCount(10);

		passField = new PasswordField();
		passField.setPromptText("Contraseña");
		passField.setPrefColumnCount(10);

		login = new Button("Acceder");
		login.setDefaultButton(true);

		cancel = new Button("Cancelar");
		

		HBox userBox = new HBox(20, UserLabel, UserText);
		userBox.setFillHeight(false);
		UserLabel.setAlignment(Pos.BASELINE_LEFT);
		
		HBox passBox = new HBox(20, passLabel, passField);
		passBox.setFillHeight(false);
		passBox.setAlignment(Pos.BASELINE_LEFT);
		
		HBox botones = new HBox(5, login, cancel);
		botones.setFillHeight(false);
		botones.setAlignment(Pos.BASELINE_CENTER);
		
		getChildren().addAll(userBox, passBox, botones);
		setAlignment(Pos.CENTER);
		setSpacing(10);
		setFillWidth(false);

	}
	
	public TextField getUserText() {
		return UserText;
	}

	public PasswordField getpassField() {
		return passField;
	}

	public Button getlogin() {
		return login;
	}

	public Button getcancel() {
		return cancel;
	}

}

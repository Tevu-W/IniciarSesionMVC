package dad.javafx.IniciarSesion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class IniciarSesionController {

	private final String Usuarios = "usuarios.csv";

	private IniciarSesionModelo modelo;
	private IniciarSesionView vista;

	public IniciarSesionController() {

		modelo = new IniciarSesionModelo();

		vista = new IniciarSesionView();

		modelo.userProperty().bindBidirectional(vista.getUserText().textProperty());
		modelo.passProperty().bindBidirectional(vista.getpassField().textProperty());

		vista.getlogin().setOnAction(e -> OnLoginButton(e));
		vista.getcancel().setOnAction(e -> Platform.exit());

	}

	private void OnPlatform(ActionEvent e) {

	}

	private void OnLoginButton(ActionEvent e) {

		String user = modelo.getUser();
		String pass = modelo.getPass();

		if (user.isEmpty() || pass.isEmpty() || !isUserValid(user, pass)) {
			launchLoginError();
			modelo.setPass("");
		} else {
			launchLoginOk();
			Platform.exit();
		}

	}

	private boolean isUserValid(String user, String pass) {

		FileInputStream FIS = null;
		InputStreamReader ISR = null;
		BufferedReader BR = null;

		try {

			FIS = new FileInputStream(Usuarios);
			ISR = new InputStreamReader(FIS, StandardCharsets.UTF_8);
			BR = new BufferedReader(ISR);

			String linea;

			while ((linea = BR.readLine()) != null) {
				String[] datos = linea.split(",");
				if (user.equals(datos[0]) && transformar(pass).equals(datos[1])) {
					return true;
				}
			}

		} catch (IOException e) {

		} finally {

			try {
				if (BR != null) {
					BR.close();
				}

				if (ISR != null) {
					ISR.close();
				}

				if (FIS != null) {
					FIS.close();
				}
			} catch (IOException e) {
			}
		}

		return false;
	}

	private Object transformar(String text) {
		return DigestUtils.md5Hex(text).toUpperCase();
	}

	private void launchLoginOk() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Acceso permitido");
		alert.setContentText("Las credenciales de acceso son correctas");
		alert.showAndWait();

	}

	private void launchLoginError() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Acceso denegado");
		alert.setContentText("El usuario y/o la contraseña no son válidos");
		alert.showAndWait();

	}
	
	
	public IniciarSesionView getView() {
		return vista;
	}

}

package dad.javafx.IniciarSesion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IniciarSesionApp extends Application{

	private IniciarSesionController controlador;	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		controlador = new IniciarSesionController();
		
		Scene scene = new Scene(controlador.getView(), 320, 200);
		
		primaryStage.setTitle("Inicio sesión");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

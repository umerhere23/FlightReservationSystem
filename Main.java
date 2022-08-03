package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Mysql";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "Pass123";

	@Override
	public void start(Stage primaryStage) {

		try {
			primaryStage.setTitle("Flights");;
			Parent root = FXMLLoader.load(getClass().getResource("Search.fxml"));
			setScene(new Scene(root));
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//Goes to the next page
	private static Scene scene;
	
	public void changeScene(String sceneToChangeTo)
	{
	    try 
	    {   
	        Main.getScene().setRoot(FXMLLoader.load(getClass().getResource(sceneToChangeTo + ".fxml")));
	    } 
	    catch (IOException e1) 
	    {
	        e1.printStackTrace();
	    }
	}
	
	public static Scene getScene() 
	{
		return scene;
	}

	public static void setScene(Scene scene) 
	{
		Main.scene = scene;
	}
	
	public static void main(String[] args) 
	{
		launch(args);
		
	}
}
	
	

package main;

import model.Model;
import controller.ModelController;
<<<<<<< HEAD
=======
import controller.ViewController;
import view.GUIManager;
>>>>>>> 6c62361ce188290de4ca9c7beead8c3950f0c717
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SLogo extends Application {
<<<<<<< HEAD
	ModelController myController;

=======
	
>>>>>>> 6c62361ce188290de4ca9c7beead8c3950f0c717
	@Override
	public void start(Stage stage) {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
		stage.setResizable(false);
<<<<<<< HEAD

		myController = new ModelController(stage);

=======
		
		Model model = new Model();
		ViewController myViewController = new ViewController(model);
		ModelController myModelController = new ModelController();
		new GUIManager(stage, myModelController, myViewController);
>>>>>>> 6c62361ce188290de4ca9c7beead8c3950f0c717
	}

	public static void main(String[] args) {
		launch(args);
	}
}
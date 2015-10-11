package main;

import model.Model;
import controller.ModelController;
import controller.ViewController;
import view.GUIManager;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SLogo extends Application {
	
	@Override
	public void start(Stage stage) {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
		stage.setResizable(false);
		
		Model model = new Model();
		ViewController myViewController = new ViewController(model);
		ModelController myModelController = new ModelController();
		new GUIManager(stage, myModelController, myViewController);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
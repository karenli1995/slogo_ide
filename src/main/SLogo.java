package main;

import view.GUIManager;
import model.Data;
import controller.ModelController;
import controller.ViewController;
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

		Data model = new Data();
		ViewController myViewController = new ViewController(model);
		ModelController myModelController = new ModelController(stage);
		new GUIManager(stage, myModelController, myViewController);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
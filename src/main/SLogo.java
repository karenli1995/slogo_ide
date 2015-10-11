package main;

import controller.Controller;
import view.GUIManager;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SLogo extends Application {
	Controller myController;
	
	@Override
	public void start(Stage stage) {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
		stage.setResizable(false);
		
		myController = new Controller();
		new GUIManager(stage, myController);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
package view.settings;

import javafx.stage.Screen;

public class SlogoProperties {
	private static final double SCENE_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();
	private static final double SCENE_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();

	public static double getSceneWidth() {
		return SCENE_WIDTH;
	}

	public static double getSceneHeight() {
		return SCENE_HEIGHT;
	}
}

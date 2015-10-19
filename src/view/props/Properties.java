package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import view.GUIManager;
import view.scene.TurtleScene;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Properties extends TabPane {

	private List<Tab> allTabs = new ArrayList<Tab>();
	TurtleProps myTurtProps;
	SceneProps mySceneProps;
	PenProps myPenProps;

	public Properties(Scene scene, TurtleScene turtScene, GUIManager gui, ResourceBundle resource, Stage stage) {
		myTurtProps = new TurtleProps(turtScene, resource, stage);
		mySceneProps = new SceneProps(turtScene, gui, resource);
		myPenProps = new PenProps(turtScene, resource, stage);
		allTabs.add(myTurtProps);
		allTabs.add(mySceneProps);
		allTabs.add(myPenProps);
		this.getTabs().addAll(allTabs);
		this.setPrefWidth(scene.getWidth() * 2 / 7);

	}

}

package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import view.GUIManager;
import view.TurtleScene;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Properties extends TabPane{
	
	private List<Tab> allTabs = new ArrayList<Tab>();

	public Properties(Scene scene, TurtleScene turtScene, GUIManager gui, ResourceBundle resource){
		TurtleProps myTurtProps = new TurtleProps(turtScene, resource);
		SceneProps mySceneProps = new SceneProps(turtScene, gui, resource);
		allTabs.add(myTurtProps);
		allTabs.add(mySceneProps);
		this.getTabs().addAll(allTabs);	
		this.setPrefWidth(scene.getWidth()*2/7);
		
	}

}

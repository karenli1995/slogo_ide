package view.props;

import java.util.ArrayList;
import java.util.List;

import view.TurtleScene;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Properties extends TabPane{
	
	private List<Tab> allTabs = new ArrayList<Tab>();

	public Properties(Scene scene, TurtleScene turtScene){
		TurtleProps myTurtProps = new TurtleProps(turtScene);
		SceneProps mySceneProps = new SceneProps();
		allTabs.add(myTurtProps);
		allTabs.add(mySceneProps);
		this.getTabs().addAll(allTabs);	
		this.setPrefWidth(scene.getWidth()*2/7);
		
	}

}

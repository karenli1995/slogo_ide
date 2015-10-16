package view.props;

import java.util.ArrayList;
import java.util.List;

import view.TurtleScene;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Properties extends TabPane{
	
	private List<Tab> allTabs = new ArrayList<Tab>();
	private int myTabPaneWidth = 400;
	private int myTabPaneHeight = 400;

	public Properties(Scene scene, TurtleScene turtScene){
		TurtleProps myTurtProps = new TurtleProps(turtScene);
		SceneProps mySceneProps = new SceneProps();
		allTabs.add(myTurtProps);
		allTabs.add(mySceneProps);
		this.getTabs().addAll(allTabs);	
		this.setPrefWidth(scene.getWidth()*2/7);
		
	}

}

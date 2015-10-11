package view.props;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Properties extends TabPane{
	
	private List<Tab> allTabs = new ArrayList<Tab>();
	private int myTabPaneWidth = 400;
	private int myTabPaneHeight = 400;

	public Properties(){
		TurtleProps myTurtProps = new TurtleProps();
		SceneProps mySceneProps = new SceneProps();
		allTabs.add(myTurtProps);
		allTabs.add(mySceneProps);
		this.getTabs().addAll(allTabs);	
		this.setMinSize(myTabPaneWidth, myTabPaneHeight);
		
	}

}

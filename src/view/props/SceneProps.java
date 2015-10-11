package view.props;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Tab;

public class SceneProps extends Tab{
	private static final int OFFSET_SPACE = 10;
    private Insets myInset = new Insets(OFFSET_SPACE);
	
	private List<Node> allElements;
	
	private int myTextAreaWidth = 100;
	private int myTextAreaHeight = 10;
	
	SceneProps(){
		allElements = new ArrayList<Node>();
		createSceneTab();
	}

	private void createSceneTab() {
		
	}
}

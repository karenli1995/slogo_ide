package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TurtleProps extends BorderPane{
    private static final int OFFSET_SPACE = 20;
    private Insets myInset = new Insets(OFFSET_SPACE);
	
	private TabPane myTabPane;
	private List<Node> allElements;
	
	private int myTabPaneWidth = 400;
	private int myTabPaneHeight = 400;
	
	private int myTextAreaWidth = 100;
	private int myTextAreaHeight = 10;
	
	TurtleProps(){
		allElements = new ArrayList<Node>();
		myTabPane = new TabPane();
		myTabPane.setMinSize(myTabPaneWidth, myTabPaneHeight);
		
		createTurtleTab();
		
		this.setCenter(myTabPane);
	}
	
	private void createTurtleTab() {
		Tab turtleTab = new Tab();
		turtleTab.setText("Turtle");
		VBox vb = new VBox();
		
		HBox hb1 = new HBox();
		Label numTurtles = new Label("Number of Turtles");
		ObservableList<String> numTurtlesOptions = 
			    FXCollections.observableArrayList(
			        "1",
			        "2",
			        "3"
			    );
		final ComboBox cbNumTurtles = new ComboBox(numTurtlesOptions);
		hb1.getChildren().addAll(numTurtles, cbNumTurtles);
		
		HBox hb2 = new HBox();
		Label turtlePosX = new Label("Turtle X Position");
		TextArea inputPosX = new TextArea();
		inputPosX.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		Button setPosX = new Button("Set");
		hb2.getChildren().addAll(turtlePosX, inputPosX, setPosX);
		
		HBox hb3 = new HBox();
		Label turtlePosY = new Label("Turtle Y Position");
		TextArea inputPosY = new TextArea();
		inputPosY.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		Button setPosY = new Button("Set");
		hb3.getChildren().addAll(turtlePosY, inputPosY, setPosY);
		
		HBox hb4 = new HBox();
		Label turtleShape = new Label("Turtle Shape");
		ObservableList<String> shapeOptions = 
			    FXCollections.observableArrayList(
			        "Turtle",
			        "Dolphin",
			        "Dog"
			    );
		final ComboBox cbTurtShapes = new ComboBox(shapeOptions);
		hb4.getChildren().addAll(turtleShape, cbTurtShapes);
		
		
		allElements.add((Node) numTurtles);
		allElements.add((Node) cbNumTurtles);
		allElements.add((Node) turtlePosX);
		allElements.add((Node) turtlePosY);
		allElements.add((Node) inputPosX);
		allElements.add((Node) inputPosY);
		allElements.add((Node) setPosX);
		allElements.add((Node) setPosY);
		allElements.add((Node) turtleShape);
		allElements.add((Node) cbTurtShapes);
		setAllMargins(allElements);
		
//		HBox.setMargin(numTurtles, myInset);
//		HBox.setMargin(turtlePosX, myInset);
//		HBox.setMargin(turtlePosY, myInset);
//		HBox.setMargin(inputPosX, myInset);
//		HBox.setMargin(inputPosY, myInset);

		
		vb.getChildren().addAll(hb1, hb2, hb3, hb4);
		
		turtleTab.setContent(vb);
		myTabPane.getTabs().add(turtleTab);
	}
	
	
	private void setAllMargins(List<Node> nodes){
		for (Node n : nodes) HBox.setMargin(n, myInset);
	}
	
}

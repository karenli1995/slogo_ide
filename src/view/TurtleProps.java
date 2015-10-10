package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	TabPane myTabPane;
	
	private int myTabPaneWidth = 600;
	private int myTabPaneHeight = 600;
	
	private int myTextAreaWidth = 100;
	private int myTextAreaHeight = 10;
	
	TurtleProps(){
		myTabPane = new TabPane();
		myTabPane.setMinSize(myTabPaneWidth, myTabPaneHeight);
		
		createTurtleTab();
		
//		this.setWidth(myTabPaneWidth);
//		this.setHeight(myTabPaneHeight);
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
		
		vb.getChildren().addAll(hb1, hb2, hb3);
		
		turtleTab.setContent(vb);
		myTabPane.getTabs().add(turtleTab);
	}
	
}

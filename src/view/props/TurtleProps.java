package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import view.TurtleScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class TurtleProps extends Tab{
    private static final int OFFSET_SPACE = 10;
    private Insets myInset = new Insets(OFFSET_SPACE);
	
	private List<Node> allElements;
	
	private int myTextAreaWidth = 100;
	private int myTextAreaHeight = 10;
	private ResourceBundle myResource;
	
	TurtleScene myTurtleScene;
	TabPane myTabPane;
	Tab myTab;
	
	public TurtleProps(TurtleScene scene, ResourceBundle resource){
		myResource = resource;
		myTurtleScene = scene;
		allElements = new ArrayList<Node>();
		createTurtleTab();
	}
	
	private void createTurtleTab() {
		this.setText(myResource.getString("TURTLE"));
		VBox vb = new VBox();
		
		HBox hb1 = addNumTurtLabel();
		HBox hb2 = addTurtXLabel();
		HBox hb3 = addTurtYLabel();
		HBox hb4 = addTurtShapeLabel();
		HBox hb5 = addTurtVisibleLable();
		HBox hb6 = addPenColorLabel();
		
		setAllMargins(allElements);
		
		vb.getChildren().addAll(hb1, hb2, hb3, hb4, hb5, hb6);
		
		this.setContent(vb);
	}
	
	private HBox addNumTurtLabel(){
		HBox hb1 = new HBox();
		Label numTurtles = new Label(myResource.getString("NUMTURT"));
		ObservableList<String> numTurtlesOptions = 
			    FXCollections.observableArrayList(
			        "1",
			        "2",
			        "3"
			    );
		final ComboBox cbNumTurtles = new ComboBox(numTurtlesOptions);
		hb1.getChildren().addAll(numTurtles, cbNumTurtles);
		
		allElements.add((Node) numTurtles);
		allElements.add((Node) cbNumTurtles);
		
		return hb1;
	}
	
	private HBox addTurtXLabel(){
		HBox hb2 = new HBox();
		Label turtlePosX = new Label(myResource.getString("TURTX"));
		TextArea inputPosX = new TextArea();
		inputPosX.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		Button setPosX = new Button("Set");
		hb2.getChildren().addAll(turtlePosX, inputPosX, setPosX);
		
		allElements.add((Node) turtlePosX);
		allElements.add((Node) inputPosX);
		allElements.add((Node) setPosX);
		
		return hb2;
	}
	
	private HBox addTurtYLabel(){
		HBox hb3 = new HBox();
		Label turtlePosY = new Label(myResource.getString("TURTY"));
		TextArea inputPosY = new TextArea();
		inputPosY.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		Button setPosY = new Button("Set");
		hb3.getChildren().addAll(turtlePosY, inputPosY, setPosY);
		
		allElements.add((Node) turtlePosY);
		allElements.add((Node) inputPosY);
		allElements.add((Node) setPosY);
		
		return hb3;
	}
	
	private HBox addTurtShapeLabel(){
		HBox hb4 = new HBox();
		Label turtleShape = new Label(myResource.getString("TURTSHAPE"));
		ObservableList<String> shapeOptions = 
			    FXCollections.observableArrayList(
			        "Turtle",
			        "Dolphin",
			        "Dog"
			    );
		final ComboBox cbTurtShapes = new ComboBox(shapeOptions);
		hb4.getChildren().addAll(turtleShape, cbTurtShapes);
		
		allElements.add((Node) turtleShape);
		allElements.add((Node) cbTurtShapes);
		
		return hb4;
	}
	
	private HBox addTurtVisibleLable(){
		HBox hb5 = new HBox();
		Label turtVisible = new Label(myResource.getString("TURTVIS"));
		ObservableList<String> visibleOptions = 
			    FXCollections.observableArrayList(
			        "Visible",
			        "Invisible"
			    );
		final ComboBox cbTurtVisible = new ComboBox(visibleOptions);
		hb5.getChildren().addAll(turtVisible, cbTurtVisible);
		
		allElements.add((Node) turtVisible);
		allElements.add((Node) cbTurtVisible);
		
		return hb5;
	}
	
	private HBox addPenColorLabel(){
		HBox hb6 = new HBox();
		Label penColor = new Label(myResource.getString("PENC"));
		ObservableList<String> colors = 
			    FXCollections.observableArrayList(
			        "Red",
			        "Blue"
			    );
		final ComboBox cbColors = new ComboBox(colors);
		hb6.getChildren().addAll(penColor, cbColors);
		
		allElements.add((Node) penColor);
		allElements.add((Node) cbColors);
		
		return hb6;
	}
	
	private void setAllMargins(List<Node> nodes){
		for (Node n : nodes) HBox.setMargin(n, myInset);
	}
	
}

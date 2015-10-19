package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import view.scene.TurtleScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class PenProps extends Tab{
	private static final int OFFSET_SPACE = 10;
	private Insets myInset = new Insets(OFFSET_SPACE);

	private List<Node> allElements;
	private ResourceBundle myResource;
	private Stage myStage;
	private TurtleScene myTurtleScene;

	PenProps(TurtleScene scene, ResourceBundle resource, Stage stage){
		allElements = new ArrayList<Node>();
		myStage = stage;
		myResource = resource;
		myTurtleScene = scene;
		
		createPenTab();
	}
	
	private void createPenTab(){
		this.setText(myResource.getString("PENPROPTITLE"));
		VBox vb = new VBox();
		HBox hb1 = addPenColorLabel();
		HBox hb2 = addPenThicknessLabel();
		HBox hb3 = addPenPosLabel();
		HBox hb4 = addPenShapeLabel();
		
		setAllMargins(allElements);
		
		vb.getChildren().addAll(hb1, hb2, hb3, hb4);
		this.setContent(vb);
	}
	
	private HBox addPenColorLabel() {
		HBox hb6 = new HBox();
		Label penColor = new Label(myResource.getString("PENC"));
		final ComboBox<Color> cbColors = new ColorComboBox();
		hb6.getChildren().addAll(penColor, cbColors);
		cbColors.setOnAction((event) -> {
			Color chosenColor = cbColors.getSelectionModel().getSelectedItem();
			myTurtleScene.getController().getData().getTurtle(0).getPen().setColor(chosenColor);

		});

		allElements.add(penColor);
		allElements.add(cbColors);

		return hb6;
	}

	private HBox addPenThicknessLabel() {
		HBox hb8 = new HBox();
		Label thickLabel = new Label("Pen Thickness");
		ObservableList<Integer> thicks = FXCollections.observableArrayList(1, 2, 3, 4, 5);
		ComboBox<Integer> thicknesses = new ComboBox<Integer>(thicks);
		thicknesses.setOnAction((e) -> {
			Integer thick = thicknesses.getSelectionModel().getSelectedItem();
			myTurtleScene.getController().getData().getTurtle(0).getPen().setThickness(thick);
		});
		hb8.getChildren().addAll(thickLabel, thicknesses);

		allElements.add(thickLabel);
		allElements.add(thicknesses);

		return hb8;
	}
	
	private HBox addPenPosLabel() {
		HBox hb8 = new HBox();
		Label penPosLabel = new Label("Pen Position");
		ObservableList<String> pos = FXCollections.observableArrayList("Up","Down");
		ComboBox<String> positions = new ComboBox<String>(pos);
		positions.setOnAction((e) -> {
			String chosenPos = positions.getSelectionModel().getSelectedItem();
			if (chosenPos == "Up") myTurtleScene.getController().getData().getTurtle(0).getPen().setPenDown(0.0);
			if (chosenPos == "Down") myTurtleScene.getController().getData().getTurtle(0).getPen().setPenDown(1.0);
		});
		hb8.getChildren().addAll(penPosLabel, positions);

		allElements.add(penPosLabel);
		allElements.add(positions);

		return hb8;
	}
	
	private HBox addPenShapeLabel() {
		HBox hb8 = new HBox();
		Label penShapeLabel = new Label("Pen Shape");
		ObservableList<String> shape = FXCollections.observableArrayList("Solid","Dashed", "Dotted");
		ComboBox<String> shapes = new ComboBox<String>(shape);
		shapes.setOnAction((e) -> {
			String chosenShape = shapes.getSelectionModel().getSelectedItem();
			if (chosenShape == "Solid"){
				Line recentLine = (Line) myTurtleScene.getCurrTab().getRecentShape();
				recentLine.setStrokeDashOffset(0);
			}
			if (chosenShape == "Dashed"){
				Line recentLine = (Line) myTurtleScene.getCurrTab().getRecentShape();
				recentLine.setStrokeDashOffset(50);
			}
			//if (chosenShape == "Dotted") ;
		});
		hb8.getChildren().addAll(penShapeLabel, shapes);

		allElements.add(penShapeLabel);
		allElements.add(shapes);

		return hb8;
	}
	
	private void setAllMargins(List<Node> nodes) {
		for (Node n : nodes)
			HBox.setMargin(n, myInset);
	}
}

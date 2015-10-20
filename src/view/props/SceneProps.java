package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.GUIManager;
import view.scene.TurtleScene;

public class SceneProps extends Tab {
	private static final int OFFSET_SPACE = 10;
	private Insets myInset = new Insets(OFFSET_SPACE);
	private ResourceBundle myResource;
	private ModelController myController;
	private TurtleScene myTurtScene;

	private List<Node> allElements;

	public SceneProps(TurtleScene turtscene, ResourceBundle resource,  ModelController controller) {
		myTurtScene = turtscene;
		myResource = resource;
		myController = controller;
		allElements = new ArrayList<Node>();
		createSceneTab();
	}

	private void createSceneTab() {
		this.setText(myResource.getString("SCENE"));
		VBox vb = new VBox();
		HBox hb2 = addBGColorLabel();

		setAllMargins(allElements);

		vb.getChildren().addAll(hb2);

		this.setContent(vb);
	}

	private HBox addBGColorLabel() {
		HBox hb7 = new HBox();
		Label background = new Label(myResource.getString("BACKGROUNDC"));

		ComboBox<Color> cmbColors = new ColorComboBox();

		cmbColors.setOnAction((event) -> {
			Color chosenColor = cmbColors.getSelectionModel().getSelectedItem();
			Canvas currCanvas = (Canvas) myTurtScene.getSelectionModel().getSelectedItem().getContent();
			
			myTurtScene.getCurrTab().setBackgroundColor(currCanvas.getGraphicsContext2D(), currCanvas, chosenColor);
			myController.getData().setMyColor(chosenColor);
			System.out.println("ComboBox Action (selected: " + chosenColor.toString().toUpperCase() + ")");
		});

		hb7.getChildren().addAll(background, cmbColors);

		allElements.add(background);
		allElements.add(cmbColors);

		return hb7;
	}

	private void setAllMargins(List<Node> nodes) {
		for (Node n : nodes)
			HBox.setMargin(n, myInset);
	}
}

package view.props;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TurtleProps extends Tab {
	private static final int OFFSET_SPACE = 10;
	private Insets myInset = new Insets(OFFSET_SPACE);

	private List<Node> allElements;

	private int myTextAreaWidth = 100;
	private int myTextAreaHeight = 10;
	private ResourceBundle myResource;
	private Stage myStage;

	TurtleScene myTurtleScene;
	TabPane myTabPane;
	Tab myTab;

	public TurtleProps(TurtleScene scene, ResourceBundle resource, Stage stage) {
		myStage = stage;
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
		HBox hb7 = addPenThicknessLabel();
		HBox hb8 = drawTester();

		setAllMargins(allElements);

		vb.getChildren().addAll(hb1, hb2, hb3, hb4, hb5, hb6, hb7, hb8);

		this.setContent(vb);
	}

	private HBox addNumTurtLabel() {
		HBox hb1 = new HBox();
		Label numTurtles = new Label(myResource.getString("NUMTURT"));
		ObservableList<String> numTurtlesOptions = FXCollections.observableArrayList("1", "2", "3");
		final ComboBox cbNumTurtles = new ComboBox(numTurtlesOptions);
		hb1.getChildren().addAll(numTurtles, cbNumTurtles);

		allElements.add((Node) numTurtles);
		allElements.add((Node) cbNumTurtles);

		return hb1;
	}

	private HBox addTurtXLabel() {
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

	private HBox addTurtYLabel() {
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

	private HBox addTurtShapeLabel() {
		HBox hb4 = new HBox();
		Label turtleShape = new Label(myResource.getString("TURTSHAPE"));
		Button chooseShape = new Button("Choose Shape");
		chooseShape.setOnAction((e) -> {
			openImage();
		});
		hb4.getChildren().addAll(turtleShape, chooseShape);

		allElements.add((Node) turtleShape);
		allElements.add((Node) chooseShape);

		return hb4;
	}

	private void openImage() {
		FileChooser chooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Image files (*.png), (*.jpg), (*.bmp)", "*.png","*.jpg","*.bmp");
		chooser.getExtensionFilters().add(extensionFilter);
		File userDirectory = getDataDirectory();
		if (userDirectory.canRead()) {
			chooser.setInitialDirectory(userDirectory);
		}
		File file = chooser.showOpenDialog(myStage);
		try {
			if (file != null) {
				FileInputStream stream = new FileInputStream(file);
				Image img = new Image(stream);
				ImageView newTurt = new ImageView(img);
				myTurtleScene.getCurrTab().setTurtImage(newTurt, 0);
				myTurtleScene.changeTurtImage(newTurt);
			}
		} catch (Exception e) {
			//showError("Error!","Failed to load "+file.getName(),e);
		}
	}

	private HBox addTurtVisibleLable() {
		HBox hb5 = new HBox();
		Label turtVisible = new Label(myResource.getString("TURTVIS"));
		ObservableList<String> visibleOptions = FXCollections.observableArrayList("Visible", "Invisible");
		final ComboBox cbTurtVisible = new ComboBox(visibleOptions);
		hb5.getChildren().addAll(turtVisible, cbTurtVisible);

		allElements.add((Node) turtVisible);
		allElements.add((Node) cbTurtVisible);

		return hb5;
	}

	private HBox addPenColorLabel() {
		HBox hb6 = new HBox();
		Label penColor = new Label(myResource.getString("PENC"));
		final ComboBox<Color> cbColors = new ColorComboBox();
		hb6.getChildren().addAll(penColor, cbColors);
		cbColors.setOnAction((event)->
		{
		    Color chosenColor = (Color) cbColors.getSelectionModel().getSelectedItem();
		    myTurtleScene.getController().getData().getTurtle(0).getLocation().getPen().setColor(chosenColor);

		});

		allElements.add((Node) penColor);
		allElements.add((Node) cbColors);

		return hb6;
	}
	
	private HBox addPenThicknessLabel() {
		HBox hb8 = new HBox();
		Label thickLabel = new Label("Pen Thickness");
		ObservableList<Integer> thicks = FXCollections.observableArrayList(1,2,3,4,5);
		ComboBox<Integer> thicknesses = new ComboBox<Integer>(thicks);
		thicknesses.setOnAction((e) -> {
			Integer thick = (Integer) thicknesses.getSelectionModel().getSelectedItem();
			myTurtleScene.getController().getData().getTurtle(0).getLocation().getPen().setThickness(thick);
		});
		hb8.getChildren().addAll(thickLabel, thicknesses);

		allElements.add((Node) thickLabel);
		allElements.add((Node) thicknesses);

		return hb8;
	}
	
	private HBox drawTester() {
		HBox hb7 = new HBox();
		Label drawer = new Label("drawing test");
		Button draw = new Button("Draw");
		draw.setOnAction((e) -> {
			drawTrail();
		});
		hb7.getChildren().addAll(drawer, draw);

		allElements.add((Node) drawer);
		allElements.add((Node) draw);

		return hb7;
	}
	
	private void drawTrail(){
		myTurtleScene.getCurrTab().drawTrail();
	}

	private void setAllMargins(List<Node> nodes) {
		for (Node n : nodes)
			HBox.setMargin(n, myInset);
	}
	private File getDataDirectory(){
		File file = new File(System.getProperty("user.dir")+File.separator+"data");
		if(!file.exists()){
			file.mkdirs();
		}
		return file;
	}
}

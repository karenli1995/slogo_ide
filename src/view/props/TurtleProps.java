package view.props;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;

public class TurtleProps extends Tab {
	private static final int OFFSET_SPACE = 10;
	private Insets myInset = new Insets(OFFSET_SPACE);

	private List<Node> allElements;

	private int myTextAreaWidth = 100;
	private int myTextAreaHeight = 10;
	private ResourceBundle myResource;
	private Stage myStage;

	private TurtleScene myTurtleScene;

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
		HBox hb4 = addTurtShapeLabel();
		HBox hb5 = addTurtVisibleLable();

		setAllMargins(allElements);

		vb.getChildren().addAll(hb1, hb4, hb5);

		this.setContent(vb);
	}

	private HBox addNumTurtLabel() {
		HBox hb1 = new HBox();
		Label numTurtles = new Label(myResource.getString("NUMTURT"));
		ObservableList<String> numTurtlesOptions = FXCollections.observableArrayList("1", "2", "3");
		final ComboBox cbNumTurtles = new ComboBox(numTurtlesOptions);
		hb1.getChildren().addAll(numTurtles, cbNumTurtles);

		allElements.add(numTurtles);
		allElements.add(cbNumTurtles);

		return hb1;
	}

	private HBox addTurtShapeLabel() {
		HBox hb4 = new HBox();
		Label turtleShape = new Label(myResource.getString("TURTSHAPE"));
		Button chooseShape = new Button("Choose Shape");
		chooseShape.setOnAction((e) -> {
			openImage();
		});
		hb4.getChildren().addAll(turtleShape, chooseShape);

		allElements.add(turtleShape);
		allElements.add(chooseShape);

		return hb4;
	}

	private void openImage() {
		FileChooser chooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
				"Image files (*.png), (*.jpg), (*.bmp)", "*.png", "*.jpg", "*.bmp");
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

				TurtleSceneTab currTab = myTurtleScene.getCurrTab();
				int sceneId = myTurtleScene.getIdOfTab();
				currTab.setTurtImage(newTurt, 0);
				currTab.getSlogoImage().changeTurtImage(newTurt);

				myTurtleScene.updateMyTabs(sceneId, currTab);
			}
		} catch (Exception e) {
			// showError("Error!","Failed to load "+file.getName(),e);
		}
	}

	private HBox addTurtVisibleLable() {
		HBox hb5 = new HBox();
		Label turtVisible = new Label(myResource.getString("TURTVIS"));
		ObservableList<String> visibleOptions = FXCollections.observableArrayList("Visible", "Invisible");
		final ComboBox cbTurtVisible = new ComboBox(visibleOptions);
		hb5.getChildren().addAll(turtVisible, cbTurtVisible);

		allElements.add(turtVisible);
		allElements.add(cbTurtVisible);

		return hb5;
	}

	private void setAllMargins(List<Node> nodes) {
		for (Node n : nodes)
			HBox.setMargin(n, myInset);
	}

	private File getDataDirectory() {
		File file = new File(System.getProperty("user.dir") + File.separator + "data");
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}
}

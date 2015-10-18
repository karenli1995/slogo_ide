package view.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import view.settings.SlogoProperties;

public class TurtleScene extends TabPane {

	private ImageView myImage;
	private TurtleSceneTab myDefaultSceneTab;
	private List<TurtleSceneTab> myTabs = new ArrayList<TurtleSceneTab>();
	private ModelController myController;
	private ResourceBundle myResource;

	private double myCanvasWidth = SlogoProperties.getSceneWidth() * 3 / 7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight() * 5 / 7;

	public TurtleScene(ModelController controller, ResourceBundle resource) {
		myResource = resource;
		myController = controller;
		myDefaultSceneTab = new TurtleSceneTab(this, myController);
		myTabs.add(myDefaultSceneTab);
		myImage = getCurrTab().getTurtImage();

		this.getChildren().add(myImage);
	}

	public TurtleSceneTab getCurrTab() {
		return (TurtleSceneTab) this.getSelectionModel().getSelectedItem();
	}

	public void addChildren(Line line) {
		this.getChildren().add(line);
	}
	
	//use
	public void removeChildren(Line line) {
		this.getChildren().remove(line);
	}

	public double getX() {
		return this.getTranslateX();
	}

	public double getY() {
		return this.getTranslateY();
	}

	public double getMyCanvasWidth() {
		return myCanvasWidth;
	}

	public double getMyCanvasHeight() {
		return myCanvasHeight;
	}

	public ModelController getController() {
		return myController;
	}

	public void changeTurtImage(ImageView image) {
		image.setFitHeight(40);
		image.setFitWidth(40);
		this.getChildren().remove(myImage);
		myImage = image;
		this.getChildren().add(myImage);
	}
}

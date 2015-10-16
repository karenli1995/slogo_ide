package view;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import model.Turtle;
import controller.ModelController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class TurtleScene extends TabPane{
	
	private ImageView myImage;
	private TurtleSceneTab myDefaultSceneTab;
	private List<TurtleSceneTab> myTabs = new ArrayList<TurtleSceneTab>();
	private ModelController myController;
	private ResourceBundle myResource;
	
	private double myCanvasWidth = SlogoProperties.getSceneWidth()*3/7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight()*5/7;

	public TurtleScene(ModelController controller, ResourceBundle resource) {
		myResource = resource;
		myController = controller;
		myDefaultSceneTab = new TurtleSceneTab(this, myController);
		myTabs.add(myDefaultSceneTab);
		myImage = getCurrTab().getTurtImage();
		this.getChildren().add(myImage);

	}
	
	public TurtleSceneTab getCurrTab(){
		return (TurtleSceneTab) this.getSelectionModel().getSelectedItem();
	}
	
	public double getX(){
		return this.getTranslateX();
	}
	
	public double getY(){
		return this.getTranslateY();
	}

	public double getMyCanvasWidth(){
		return myCanvasWidth;
	}
	
	public double getMyCanvasHeight(){
		return myCanvasHeight;
	}
}

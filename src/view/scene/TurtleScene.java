package view.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.scene.Node;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import view.settings.SlogoProperties;

public class TurtleScene extends TabPane {

//	private ImageView myImage;
	private TurtleSceneTab myCurrentSceneTab;
	private List<TurtleSceneTab> myTabs = new ArrayList<TurtleSceneTab>();
	private ModelController myController;
	private ResourceBundle myResource;

	private double myCanvasWidth = SlogoProperties.getSceneWidth() * 3 / 7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight() * 5 / 7;

	public TurtleScene(ModelController controller, ResourceBundle resource) {
		myResource = resource;
		myController = controller;
		TurtleSceneTab newTab = new TurtleSceneTab(this, myController);
		myCurrentSceneTab = newTab;
		myTabs.add(newTab);
		ImageView myImage = getCurrTab().getSlogoImage().getMyImage();

		this.getChildren().add(myImage);
	}
	
	public void updateMyTabs(int id, TurtleSceneTab tab){
		myTabs.add(id, tab);
	}
	
	public List<TurtleSceneTab> getMyTabs() {
		return myTabs;
	}
	
//	public void setCurrentSceneTab(TurtleSceneTab scene){
//		this.getSelectionModel().
////		myCurrentSceneTab = scene;
//	}
	
//	public TurtleSceneTab getCurrentSceneTab(){
//		return myCurrentSceneTab;
//	}
	
//	public TurtleSceneTab getTabById(int id) {
//		return myTabs.get(id);
//	}
//	
	public int getIdOfTab(){
		TurtleSceneTab sceneTab = (TurtleSceneTab) this.getSelectionModel().getSelectedItem();
		return myTabs.indexOf(sceneTab);
	}

	public TurtleSceneTab getCurrTab() {
		return (TurtleSceneTab) this.getSelectionModel().getSelectedItem();
	}

	public void addChildren(Node node) {
		this.getChildren().add(node);
	}
	
	//use
	public void removeChildren(Node node) {
		this.getChildren().remove(node);
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

//	public void changeTurtImage(ImageView image) {
//		image.setFitHeight(40);
//		image.setFitWidth(40);
//		this.getChildren().remove(myImage);
//		myImage = image;
//		this.getChildren().add(myImage);
//	}
}

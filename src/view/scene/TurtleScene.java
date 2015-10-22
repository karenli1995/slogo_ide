package view.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import model.SlogoScene;
import controller.ModelController;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.settings.SlogoProperties;

public class TurtleScene extends TabPane implements Observer{

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
//		myTabs.add(newTab);
		ImageView myImage = getCurrTab().getSlogoImage().getMyImage();

		this.getChildren().add(myImage);
	}
	
	public void addTab(TurtleSceneTab tab){
		myTabs.add(tab);
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
//		TurtleSceneTab sceneTab = (TurtleSceneTab) this.getSelectionModel().getSelectedItem();
//		System.out.println(myTabs.indexOf(sceneTab));
//		return myTabs.indexOf(sceneTab);
		System.out.println(this.getSelectionModel().getSelectedIndex() + " karen ");
		return this.getSelectionModel().getSelectedIndex();
	}

	public TurtleSceneTab getCurrTab() {
		int ind = this.getSelectionModel().getSelectedIndex();
		System.out.println(ind + " jenny");
		return myTabs.get(ind);
//		return (TurtleSceneTab) this.getSelectionModel().getSelectedItem();
	}
	
	public TurtleSceneTab createNewTab(ModelController newController) {
		TurtleSceneTab newTab = new TurtleSceneTab(this, newController);
		myTabs.add(newTab);
		return newTab;
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

	@Override
	public void update(Observable o, Object arg) {
		SlogoScene otherSlogoObj = (SlogoScene) o;
		
		int tabId = this.getIdOfTab();
		TurtleSceneTab tab = this.getCurrTab();
		System.out.println(tabId + " katring");
		
		//when setClear() changes
		if(otherSlogoObj.getData(tabId).getTurtle(0).getClearTrail() == true){
			List<Object> currLines = tab.getShape().getAllShapes();
			for (Object line : currLines) this.removeChildren((Node) line);
		}
		
		// check if pen down or up
		//when pendown() changes
		List<Point2D> currTrailList = otherSlogoObj.getData(tabId).getTurtle(0).getTrail().getPathCoordinates();
		if (otherSlogoObj.getData(tabId).getTurtle(0).getPen().isDown() == 1.0) {
			Node currLine = (Node) tab.getShape().drawShape(currTrailList);
			tab.getShape().addShape(currLine);
			this.addChildren(currLine);
		}
		
		//when setRotationAngle() changes and setTrail() changes
		double newRotAngle = otherSlogoObj.getData(tabId).getTurtle(0).getRotationAngle();
		double newLocX = otherSlogoObj.getData(tabId).getTurtle(0).getTrail().getX();
		double newLocY = otherSlogoObj.getData(tabId).getTurtle(0).getTrail().getY();
		tab.getSlogoImage().setScreenLoc(newLocX, newLocY);
		tab.getSlogoImage().setRotation(newRotAngle);
		
		//when setScene() changes
		Color newColor = otherSlogoObj.getData(tabId).getMyColor();
		GraphicsContext gc = tab.getCanvas().getGraphicsContext2D();
		gc.setFill(newColor);
		gc.fillRect(0, 0, tab.getCanvas().getWidth(), tab.getCanvas().getHeight());
		
	}

}

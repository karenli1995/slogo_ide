package view.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import model.SlogoObjects;
import model.SlogoScene;
import controller.ModelController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import view.settings.SlogoProperties;
import view.turtles.SlogoImage;

public class TurtleScene extends TabPane implements Observer{
	private List<TurtleSceneTab> myTabs = new ArrayList<TurtleSceneTab>();
	private ModelController myController;
	private ResourceBundle myResource;

	private double myCanvasWidth = SlogoProperties.getSceneWidth() * 3 / 7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight() * 5 / 7;

	public TurtleScene(ModelController controller, ResourceBundle resource) {
		myResource = resource;
		myController = controller;
		TurtleSceneTab newTab = new TurtleSceneTab(this, myController);
		
		//check
		List<SlogoImage> allSlogoImages = newTab.getAllSlogoImages();
		for (SlogoImage slogoImage : allSlogoImages){
			ImageView image = slogoImage.getMyImage();
			image.setX(0);
			image.setY(0);
			this.setScreenLoc(image, image.getX(), image.getY());
			this.addChildren(image);
		}
		
		addListener();
//		addListener2();
//		myTabs.add(newTab);
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
	
	public TurtleSceneTab getTabById(int id) {
		return myTabs.get(id);
	}
	
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
	
	//maybe here
	public TurtleSceneTab createNewTab(ModelController newController) {
		TurtleSceneTab newTab = new TurtleSceneTab(this, newController);
		updateMyTabs(myTabs.size(), newTab);
//		addListener();
		
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
	
	/**
	 * translates coordinates to a point on the canvas TurtleScene
	 * 
	 * @param x
	 * @param y
	 */
	public void setScreenLoc(ImageView imageView, double x, double y) {
		TurtleSceneTab currTab = this.getCurrTab();
		int id = this.getIdOfTab();		
		System.out.println(id + " bob");
		
		// should check for bounds as well
		double newLocX = x + this.getX() + currTab.getMyCanvasWidth() / 2;
		double newLocY = this.getY() + currTab.getMyCanvasHeight() / 2 - y;
		if (checkBounds(newLocX, newLocY)) {
			imageView.setLayoutX(newLocX);
			imageView.setLayoutY(newLocY);
		}
		
		this.updateMyTabs(id, currTab);
	}

	private boolean checkBounds(double x, double y) {
		TurtleSceneTab currTab = this.getCurrTab();
		int id = this.getIdOfTab();
		
		if (x < this.getX() || x > this.getX() + currTab.getMyCanvasWidth()
				|| y < this.getY() || y > this.getY() + currTab.getMyCanvasHeight()) {
			return false;
		} else {
			return true;
		}
	}
	
//	public void addListener2(){
//		this.getSelectionModel().selectedItemProperty().addListener(
//			    new ChangeListener<Tab>() {
//			        @Override
//			        public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
//			        	oldTab(t);
//				    	newTab(t1);
//			        }
//			        
//			        private void oldTab(Tab olderTab) {
//						int tabId = (int) myTabs.indexOf((TurtleSceneTab) olderTab);
//						System.out.println(tabId + " bye");
//
//						TurtleSceneTab oldTab = myTabs.get(tabId);
//				    	
//				    	List<Object> oldLines = oldTab.getShape().getAllShapes();
//						for (Object line : oldLines) oldTab.getTurtScene().removeChildren((Node) line);
//						
//						List<SlogoImage> oldTurts = oldTab.getAllSlogoImages();
//						for (SlogoImage slogoImage : oldTurts){
//							ImageView image = slogoImage.getMyImage();
//							oldTab.getTurtScene().removeChildren(image);				
//						}
//						
//						oldTab.getTurtScene().updateMyTabs((int) tabId, oldTab);
//					}
//			        
//			        private void newTab(Tab newerTab) {
//						int tabId = (int) myTabs.indexOf((TurtleSceneTab) newerTab);
//						System.out.println(tabId + " hi");
//						TurtleSceneTab newTab = myTabs.get(tabId);
//						
//						List<SlogoImage> newTurts = newTab.getAllSlogoImages();
//						for (SlogoImage slogoImage : newTurts){
//							ImageView image = slogoImage.getMyImage();
//							newTab.getTurtScene().addChildren(image);
//							newTab.getTurtScene().setScreenLoc(image, image.getX(), image.getY());
//						}
//
//						newTab.getTurtScene().updateMyTabs((int) tabId, newTab);
//					}
//			        
//			    }
//			);
//	}
	
	
	public void addListener(){
		this.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
		    	oldTab(oldValue);
		    	newTab(newValue);
		    }

			private void newTab(Number newValue) {
				int tabId = (int) newValue;
				System.out.println(newValue + " hi");
				TurtleSceneTab newTab = myTabs.get(tabId);
				
				List<SlogoImage> newTurts = newTab.getAllSlogoImages();
				for (SlogoImage slogoImage : newTurts){
					ImageView image = slogoImage.getMyImage();
					newTab.getTurtScene().addChildren(image);
					newTab.getTurtScene().setScreenLoc(image, image.getX(), image.getY());
				}

				newTab.getTurtScene().updateMyTabs((int) newValue, newTab);
			}

			private void oldTab(Number oldValue) {
				int tabId = (int) oldValue;
				System.out.println(oldValue + " bye");

				TurtleSceneTab oldTab = myTabs.get(tabId);
		    	
		    	List<Object> oldLines = oldTab.getShape().getAllShapes();
				for (Object line : oldLines) oldTab.getTurtScene().removeChildren((Node) line);
				
				List<SlogoImage> oldTurts = oldTab.getAllSlogoImages();
				for (SlogoImage slogoImage : oldTurts){
					ImageView image = slogoImage.getMyImage();
					oldTab.getTurtScene().removeChildren(image);				
				}
			}
		}); 
	}
	

	@Override
	public void update(Observable o, Object arg) {
		SlogoScene otherSlogoObj = (SlogoScene) o;
		
		int tabId = this.getIdOfTab();
		TurtleSceneTab tab = this.getCurrTab();
		
		//when setClear() changes
		if(otherSlogoObj.getTurtleData(tabId).getTurtle(0).getClearTrail() == true){
			List<Object> currLines = tab.getShape().getAllShapes();
			for (Object line : currLines) this.removeChildren((Node) line);
		}
		
		// check if pen down or up
		//when pendown() changes
		List<Point2D> currTrailList = otherSlogoObj.getTurtleData(tabId).getTurtle(0).getTrail().getPathCoordinates();
		if (otherSlogoObj.getTurtleData(tabId).getTurtle(0).getPen().isDown() == 1.0) {
			Node currLine = (Node) tab.getShape().drawShape(currTrailList);
			tab.getShape().addShape(currLine);
			this.addChildren(currLine);
		}
		
		//when setRotationAngle() changes and setTrail() changes
		List<SlogoObjects> turts = otherSlogoObj.getTurtleData(tabId).getAllTurtles();
		for (int i=0; i<turts.size(); i++){
			SlogoObjects slogoObject = turts.get(i);
			double newRotAngle = slogoObject.getRotationAngle();
			double newLocX = slogoObject.getTrail().getX();
			double newLocY = slogoObject.getTrail().getY();
//			slogoObject.getTrail().setPoint(point);
			SlogoImage currSlogoImage = tab.getSlogoImage(i);
			currSlogoImage.setX(newLocX);
			currSlogoImage.setY(newLocY);
			currSlogoImage.setRotation(newRotAngle);
			this.setScreenLoc(currSlogoImage.getMyImage(), currSlogoImage.getX(), currSlogoImage.getY());
			tab.setSlogoImage(i, currSlogoImage);
		}
		
		//when setScene() changes
		Color newColor = otherSlogoObj.ColorData(tabId).getMyColor();
		GraphicsContext gc = tab.getCanvas().getGraphicsContext2D();
		gc.setFill(newColor);
		gc.fillRect(0, 0, tab.getCanvas().getWidth(), tab.getCanvas().getHeight());
		
		this.updateMyTabs(tabId, tab);
		
	}

}
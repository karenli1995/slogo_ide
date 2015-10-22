package view.turtles;

import java.util.List;

import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;
import model.SlogoObjects;
import controller.ModelController;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SlogoImage {
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myImageView = new ImageView(myImage);

	private TurtleScene myTurtScene;
	
	private double myX;
	private double myY;

	public SlogoImage(TurtleScene turtlescene) {
		myTurtScene = turtlescene;
		setMyImage(myImageView); 
		myX = 0;
		myY = 0;
//		setScreenLoc(myX, myY);
	}
	
	public double setX(double x){
		myX = x;
		return myX;
	}
	
	public double getX(){
		return myX;
	}
	
	public double setY(double y){
		myY = y;
		return myY;
	}
	
	public double getY(){
		return myY;
	}

	public ImageView getMyImage() {
		return myImageView;
	}

	public void setMyImage(ImageView image) {
		myImageView = image;
		myImageView.setFitWidth(40);
		myImageView.setFitHeight(40);
		myTurtScene.addChildren(myImageView);
	}
	
	public void changeTurtImage(ImageView image) {
		myTurtScene.removeChildren((Node) myImageView);
		image.setFitHeight(40);
		image.setFitWidth(40);
		myImageView=image;
		myTurtScene.addChildren((Node) image);
	}

//	/**
//	 * translates coordinates to a point on the canvas TurtleScene
//	 * 
//	 * @param x
//	 * @param y
//	 */
//	public void setScreenLoc(double x, double y) {
//		TurtleSceneTab currTab = myTurtScene.getCurrTab();
//		int id = myTurtScene.getIdOfTab();		
//		System.out.println(id + " bob");
//		
//		// should check for bounds as well
//		double newLocX = x + myTurtScene.getX() + currTab.getMyCanvasWidth() / 2;
//		double newLocY = myTurtScene.getY() + currTab.getMyCanvasHeight() / 2 - y;
//		if (checkBounds(newLocX, newLocY)) {
//			myImageView.setLayoutX(newLocX);
//			myImageView.setLayoutY(newLocY);
//		}
//		
//		myTurtScene.updateMyTabs(id, currTab);
//	}
//
//	private boolean checkBounds(double x, double y) {
//		TurtleSceneTab currTab = myTurtScene.getCurrTab();
//		int id = myTurtScene.getIdOfTab();
//		
//		if (x < myTurtScene.getX() || x > myTurtScene.getX() + currTab.getMyCanvasWidth()
//				|| y < myTurtScene.getY() || y > myTurtScene.getY() + currTab.getMyCanvasHeight()) {
//			return false;
//		} else {
//			return true;
//		}
//	}

	public void setRotation(double angle) {
		this.getMyImage().setRotate(angle);
	}

	public void showSlogoObject() {
		this.getMyImage().setVisible(true);
	}

	public void hideSlogoObject() {
		this.getMyImage().setVisible(false);
	}
}

package view;

import java.util.List;

import model.SlogoObjects;
import controller.ModelController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SlogoImage{
	private final Image myImage = new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
	private ImageView myImageView = new ImageView(myImage);
	
	private TurtleScene myTurtScene;
	private ModelController myController; 
	private List<SlogoObjects> allMyObjects;
	private SlogoObjects myObject;
	
	public SlogoImage(TurtleScene turtlescene, ModelController controller, int id) {
		myTurtScene = turtlescene;
		myController = controller;
		myObject = myController.getData().getTurtle(id);
		//allMyObjects = myController.getData().getAllTurtles();
		
		myImageView.setFitWidth(40);
		myImageView.setFitHeight(40);
	}
	
//	public void getAllObjects(){
//		allMyObjects = myController.getData().getAllTurtles();
//	}
	
	public SlogoObjects getMyObject(){
		return myObject;
	}
	
	public ImageView getMyImage() {
		return myImageView;
	}
	
	public Image getImage(){
		return myImage;
	}
	
	/**
	 * translates coordinates to a point on the canvas TurtleScene
	 * @param x
	 * @param y
	 */
	public void setScreenLoc(double x, double y) {
		//should check for bounds as well
		myImageView.setLayoutX(x + myTurtScene.getX() + myTurtScene.getMyCanvasWidth()/2);
		myImageView.setLayoutY(y + myTurtScene.getY() + myTurtScene.getMyCanvasHeight()/2);
	}
	
	
	public void setRotation(int angle) {
		this.getMyImage().setRotate(angle);
	}
	
	public void showSlogoObject() {
		this.getMyImage().setVisible(true);
	}

	public void hideSlogoObject() {
		this.getMyImage().setVisible(false);
	}
}

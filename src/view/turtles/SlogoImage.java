package view.turtles;

import java.util.List;

import view.scene.TurtleScene;
import model.SlogoObjects;
import controller.ModelController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SlogoImage {
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
		// allMyObjects = myController.getData().getAllTurtles();
		myImageView.setFitWidth(40);
		myImageView.setFitHeight(40);
	}

	public SlogoImage(TurtleScene turtlescene, ModelController controller, int id, ImageView image) {
		myTurtScene = turtlescene;
		myController = controller;
		myObject = myController.getData().getTurtle(id);
		// allMyObjects = myController.getData().getAllTurtles();
		myImageView = image;
		myImageView.setFitWidth(40);
		myImageView.setFitHeight(40);
	}

	// public void getAllObjects(){
	// allMyObjects = myController.getData().getAllTurtles();
	// }

	public SlogoObjects getMyObject() {
		return myObject;
	}

	public ImageView getMyImage() {
		return myImageView;
	}

	public void setMyImage(ImageView image) {
		myImageView = image;
		myImageView.setFitWidth(40);
		myImageView.setFitHeight(40);
	}

	public Image getImage() {
		return myImage;
	}

	/**
	 * translates coordinates to a point on the canvas TurtleScene
	 * 
	 * @param x
	 * @param y
	 */
	public void setScreenLoc(double x, double y) {
		// should check for bounds as well
		double newLocX = x + myTurtScene.getX() + myTurtScene.getCurrTab().getMyCanvasWidth() / 2;
		double newLocY = myTurtScene.getY() + myTurtScene.getCurrTab().getMyCanvasHeight() / 2 - y;
		if (checkBounds(newLocX, newLocY)) {
			myImageView.setLayoutX(newLocX);
			myImageView.setLayoutY(newLocY);
		}
	}

	private boolean checkBounds(double x, double y) {
		if (x < myTurtScene.getX() || x > myTurtScene.getX() + myTurtScene.getCurrTab().getMyCanvasWidth()
				|| y < myTurtScene.getY() || y > myTurtScene.getY() + myTurtScene.getCurrTab().getMyCanvasHeight()) {
			return false;
		} else {
			return true;
		}
	}

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
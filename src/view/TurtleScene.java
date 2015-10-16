package view;

import java.util.ArrayList;
import java.util.List;
import model.Turtle;
import controller.ModelController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class TurtleScene extends TabPane {
	
	private ImageView myImage;
	private TurtleSceneTab myDefaultSceneTab;
	private List<TurtleSceneTab> myTabs = new ArrayList<TurtleSceneTab>();
	private ModelController myController;

	public TurtleScene(ModelController controller) {
		myController = controller;
		myDefaultSceneTab = new TurtleSceneTab(this, myController);
		myTabs.add(myDefaultSceneTab);
		myImage = getCurrTab().getTurtImage();
		this.getChildren().add(myImage);

	}
	
	public TurtleSceneTab getCurrTab(){
		return (TurtleSceneTab) this.getSelectionModel().getSelectedItem();
	}
	
//	public ModelController getController(){
//		return myController;
//	}
//	
//	public void setController(ModelController controller){
//		myController = controller;
//	}
	
	public double getX(){
		return this.getTranslateX();
	}
	
	public double getY(){
		return this.getTranslateY();
	}
	
//	private void setTurtle(int id) {
//		Turtle currTurt = (Turtle) myController.getData().getTurtle(id);
//		double currTurtLocX = currTurt.getLocation().getX();
//		double currTurtLocY = currTurt.getLocation().getY();
//		
//		SlogoImage currTurtView = new SlogoImage(this, myController, id);
//		ImageView currTurtImage = currTurtView.getMyImage();
//		currTurtView.setScreenLoc(currTurtLocX, currTurtLocY);
//		
//		this.getChildren().add(currTurtImage);
//	}
	
}

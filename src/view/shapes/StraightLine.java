package view.shapes;

import java.util.Observable;
import java.util.Observer;

import model.SlogoObjects;
import controller.ModelController;
import view.TurtleScene;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

public class StraightLine{
	private Line myLine;
	private ModelController myModelController;
	
	public StraightLine(TurtleScene turtlescene, ModelController controller){
		myLine = new Line();
	}
	
//	public void drawLine(){
//		if(myModelController.getData().getTurtle(0).getTrail().getPen().isDown()==1){
//			Point2D point1 = translateForCanvas(myModelController.getData().getTurtle(0).getTrail().getPathCoordinates().get(trailIndex-1));
//			Point2D point2 = translateForCanvas(myModelController.getData().getTurtle(0).getTrail().getPathCoordinates().get(trailIndex));
//	 		GraphicsContext gc = myCanvas.getGraphicsContext2D();
//	 		gc.setStroke(myModelController.getData().getTurtle(0).getTrail().getPen().getColor());
//	 		gc.setLineWidth(myModelController.getData().getTurtle(0).getTrail().getPen().getThickness());
//	 		gc.strokeLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
//	 		trailIndex++;
//		}
//	}
//	
	public void drawLine(){
		if(myModelController.getData().getTurtle(0).getTrail().getPen().isDown()==1){
			Point2D point1 = translateForCanvas(myModelController.getData().getTurtle(0).getTrail().getPathCoordinates().get(trailIndex-1));
			Point2D point2 = translateForCanvas(myModelController.getData().getTurtle(0).getTrail().getPathCoordinates().get(trailIndex));
	 		GraphicsContext gc = myCanvas.getGraphicsContext2D();
	 		gc.setStroke(myModelController.getData().getTurtle(0).getTrail().getPen().getColor());
	 		gc.setLineWidth(myModelController.getData().getTurtle(0).getTrail().getPen().getThickness());
	 		gc.strokeLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
	 		trailIndex++;
		}
	}
}

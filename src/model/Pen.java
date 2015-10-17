package model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Pen extends AbstractPen { // class with properties of the path


	public Pen() {
		super(Color.BLACK, 1, 0);
	}

	public Pen(AbstractPen pen) {
		super(pen.myColor, pen.myThickness, pen.myDashSparsity);
	}

//	public void updateTrail(Point2D current) {
//		super.updateTrail(current);
//	}

}